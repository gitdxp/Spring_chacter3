package com.smart.reflect;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class ReflectTest
{
	public static Car initByDefaultConst() throws Throwable{
		ClassLoader loader =  Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("com.smart.reflect.Car");

		Constructor cons = clazz.getDeclaredConstructor((Class[])null);
		Car car = (Car)cons.newInstance();

		Method setBrand = clazz.getMethod("setBrand",String.class);
		setBrand.invoke(car,"红旗CA72");
		Method setColor = clazz.getMethod("setColor",String.class);
		setColor.invoke(car,"黑色");
		Method setMaxSpeed = clazz.getMethod("setMaxSpeed",int.class);
		setMaxSpeed.invoke(car,200);
		return car;
	}
	public static void main(String[] args) throws Throwable{
		Car car = initByDefaultConst();
		car.introduce();
		//第4章 IOC 控制反转 中的java反射
	}
}
