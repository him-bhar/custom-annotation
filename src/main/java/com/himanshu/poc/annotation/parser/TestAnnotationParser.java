/*
 * Copyright 2013 Himanshu Bhardwaj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.himanshu.poc.annotation.parser;

import java.lang.reflect.Method;

import com.himanshu.poc.annotation.custom.TestAnnotation;

public class TestAnnotationParser {
	public void parse(Class clazz) throws Exception {
		Method[] methods = clazz.getMethods();

		for (Method method : methods) {
			System.out.println("Scanning method "+method.getName());
			if (method.isAnnotationPresent(TestAnnotation.class)) {
				TestAnnotation test = method.getAnnotation(TestAnnotation.class);
				String info = test.info();
				String user = test.username();
				if ("admin".equalsIgnoreCase(user)) {
					System.out.println("info is "+info+" as info is :"+info+" as username is: "+user);
					// try to invoke the method with param
					method.invoke(clazz.newInstance(), info);	//Same info is used as argument to function.
				} else {
					System.out.println("XXXXXXXXXXXXXX Sorry cannot execute "+method.getName()+" as info is :"+info+" as username is: "+user);
				}
			}
			System.out.println("END: Scanned method "+method.getName());
			System.out.println();
		}
	}
}