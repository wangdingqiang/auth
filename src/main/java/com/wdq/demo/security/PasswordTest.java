/**
 * 
 */
package com.wdq.demo.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b> 
 * 
 * <b>Author:</b> wangdingqiang
 * <b>Date:</b> 2020年4月22日 上午10:09:09
 * <b>Copyright:</b> Copyright &copy;2020-2030 wdq Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2020年4月22日 上午10:09:09   wangdingqiang
 *         new file.
 * </pre>
 */
public class PasswordTest {

	public static void main(String[] args) {
		String password = "111111";
		System.out.println(new BCryptPasswordEncoder().encode(password));
	}
}
