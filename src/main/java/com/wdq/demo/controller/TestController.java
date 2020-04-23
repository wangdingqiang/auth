/**
 * 
 */
package com.wdq.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b> 
 * 
 * <b>Author:</b> wangdingqiang
 * <b>Date:</b> 2020年4月21日 下午1:54:46
 * <b>Copyright:</b> Copyright &copy;2020-2030 wdq Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2020年4月21日 下午1:54:46   wangdingqiang
 *         new file.
 * </pre>
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/hello")
	public String hello() {
		try {
			return "Hello Word test";
		} catch (Exception e) {
			log.error("", e);
			return "test/hello 异常";
		}
	}
}
