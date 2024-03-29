package com.practice.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {


	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		 if(beanName.equals("car")){
			Car car=(Car)bean; 
			if(car.getColor()==null){
				System.out.println("调用BeanPostProcessor.postProcessBeforeInitialization(),color为空，设置为默认黑色.");
				car.setColor("黑色");
			}
		 }
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName)
	throws BeansException {
		
		 if(beanName.equals("car")){
			 Car car=(Car)bean;
			 if(car.getMaxSpeed()>=200){
				System.out.println("调用BeanPostProcessor.postProcessAfterInitialization(),将maxSpedd调整为200."); 
				car.setMaxSpeed(200);
			 }
		 }
      return bean;
}

}