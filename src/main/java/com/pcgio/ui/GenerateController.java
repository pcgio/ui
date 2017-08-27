package com.pcgio.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class GenerateController {

	Logger logger = LoggerFactory.getLogger(GenerateController.class);

    public ModelAndView getMAV(String title, Principal principal, String view) {
        ModelAndView mav = new ModelAndView(view);
        mav.addObject("title", title);
        logger.info("Generate view {} for {}", title, principal);
        return mav;
    }

	@RequestMapping("/generate")
	public String doGenerate(Principal principal){
        return "redirect:/generate/222";
	}

	@RequestMapping("/generate/{genId}")
	public ModelAndView showGenerateResult(Principal principal){
		return getMAV("PCGIO", principal, "contents");
	}
}
