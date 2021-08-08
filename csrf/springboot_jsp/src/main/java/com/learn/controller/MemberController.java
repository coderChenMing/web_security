package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.service.MemberService;

import lombok.extern.slf4j.Slf4j;

/**
 * 演示 springboot 异步调用技术<br>
 */
@RestController
@Slf4j
public class MemberController {
	@Autowired
	private MemberService memberService;
	// 初始化的时候
	@Value("${name}")
	private String name;
	@Value("${http_url}")
	private String httpUrl;

	@RequestMapping("/addMemberAndEmail")
	public String addMemberAndEmail() throws InterruptedException {
		// log.info("1");
		System.out.println("1");
		String result = memberService.addMemberAndEmail();
		// Thread.sleep(500);
		System.out.println("4");
		return "result:" + result;
	}

	@RequestMapping("/getName")
	public String getName() {
		return name;
	}

	@RequestMapping("/httpUrl")
	public String httpUrl() {
		return httpUrl;
	}

}
