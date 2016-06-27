package keyword;

import java.lang.reflect.Method;

import wrappers.LinkedInWrapper;


public class LearnReflection {

	public static void main(String[] args) {

		Class<LinkedInWrapper> wrapper = LinkedInWrapper.class;

		Method[] meth = wrapper.getDeclaredMethods();

		for (Method method : meth) {

			System.out.println(method.getName());
		}

	}

}
