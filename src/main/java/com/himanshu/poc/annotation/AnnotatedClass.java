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
package com.himanshu.poc.annotation;

import com.himanshu.poc.annotation.custom.TestAnnotation;

public class AnnotatedClass {

	@TestAnnotation(info="Howdy partner", username="admin")
	public void printMe(String arg) {
		System.out.println("Inside printMe method :"+arg);
	}

	@TestAnnotation(info="No access", username="normal")
	public void doNotPrintMe(String arg, String invokedBy) {
		System.out.println("Inside doNotPrintMe method: "+arg+" Invoked by:"+invokedBy);
	}

	@TestAnnotation()
	public void doNotPrintMeWithBlankInfo(String arg, String invokedBy) {
		System.out.println("Inside doNotPrintMeWithBlankInfo method: "+arg+" Invoked by:"+invokedBy);
	}
}
