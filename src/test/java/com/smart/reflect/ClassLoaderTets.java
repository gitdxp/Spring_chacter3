package com.smart.reflect;

public class ClassLoaderTets
{
	public static void main(String[] args){
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		System.out.println("current loader:"+loader);
		System.out.println("parent loader:"+loader);
		System.out.println("grandparent loader:"+loader.getParent().getParent());
	}
}
