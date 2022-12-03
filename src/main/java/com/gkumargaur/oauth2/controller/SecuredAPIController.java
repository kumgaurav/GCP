package com.gkumargaur.oauth2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredAPIController {
	private static final Logger log = LoggerFactory.getLogger(SecuredAPIController.class);
    @RequestMapping(value = "/secure")
    public Response secure() {
    	log.info("===============/secure");
        return new Response("example");
    }

    public static class Response {
        private String str;

        public Response(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }
}