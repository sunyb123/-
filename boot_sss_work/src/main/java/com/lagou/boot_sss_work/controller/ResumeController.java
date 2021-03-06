package com.lagou.boot_sss_work.controller;

import com.lagou.boot_sss_work.pojo.Resume;
import com.lagou.boot_sss_work.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resume")
public class ResumeController {


    @Autowired
    private ResumeService resumeService;

    @RequestMapping("resumeList")
    public String queryResumeList(Model model) throws Exception {
        model.addAttribute("resumeList",resumeService.queryResumeList());
        return "resumeList";
    }

    @RequestMapping("resumeEdit")
    public String itemEdit(Integer id, Model model) {
        Resume resume = null;
        if(id==null) {
            resume = new Resume();
        }else{
            resume = resumeService.queryResumeById(id);
        }

        model.addAttribute("resume",resume);
        return "resumeEdit";
    }

    @RequestMapping("updateResume")
    public String updateResume(Resume resume) {
        resumeService.updateResumeById(resume);
        return "redirect:resumeList";
    }


    @RequestMapping("resumeDelete")
    public String resumeDelete(Integer id) {
        resumeService.deleteResumeById(id.longValue());
        return "redirect:resumeList";
    }


}
