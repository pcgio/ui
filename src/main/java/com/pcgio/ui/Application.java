package com.pcgio.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@SpringBootApplication
@EnableCaching
@Controller
public class Application {

	Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    public ModelAndView getMAV(String title, Principal principal, String view) {
        ModelAndView mav = new ModelAndView(view);
        mav.addObject("title", title);
        logger.info("Generate view {} for {}", title, principal);
        return mav;
    }

    public ModelAndView getCustomErrorMAV(String code, String msg){
		ModelAndView mav = new ModelAndView("customError");
		mav.addObject("title", "Error Page");
		mav.addObject("code", code);
		mav.addObject("msg", msg);
		return mav;
	}

	@RequestMapping("/")
	public ModelAndView getHomePage(Principal principal){
		return getMAV("PCGIO", principal, "index");
	}

	@RequestMapping("/404")
	public ModelAndView getNotFoundPage(){
		return this.getCustomErrorMAV("404","Can't find the page.");
	}

	@RequestMapping("/403")
	public ModelAndView getForbiddenPage(){
		return this.getCustomErrorMAV("403","No permission.");
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){

		return container -> {
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
            container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403"));
        };
	}
}
