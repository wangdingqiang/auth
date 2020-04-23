/**
 * 
 */
package com.wdq.demo.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b> 
 * 
 * <b>Author:</b> wangdingqiang
 * <b>Date:</b> 2020年4月21日 上午10:03:55
 * <b>Copyright:</b> Copyright &copy;2020-2030 wdq Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2020年4月21日 上午10:03:55   wangdingqiang
 *         new file.
 * </pre>
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/hello")
	public String hello(Principal principal) {
		try {
			return "Hello Word user";
		} catch (Exception e) {
			log.error("", e);
			return "異常";
		}
	}
}
