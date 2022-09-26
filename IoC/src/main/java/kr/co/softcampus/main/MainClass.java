package kr.co.softcampus.main;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import kr.co.softcampus.beans.TestBean;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test1();
//		test2();
//		test3();
		test4();
	}
	// BeanFactory 사용하기(version 4 이후에는 deprecated)
	// 패키지 내부에 있을 때
	public static void test1() {
		ClassPathResource res = new ClassPathResource("kr/co/softcampus/config/beans.xml");
		// XmlBeanFactory의 경우, 자동으로 객체를 생성하지 않는다.
		// 객체를 생성했다면 
		// test1()을 호출했을 때 System.out.println() 함수가 작동했어야 했지만 콘솔에 아무 것도 나오지 않는다.
		XmlBeanFactory factory = new XmlBeanFactory(res);
		
		// factory에서 bean을 꺼내 써야 한다.
		// .getBean의 첫 번째 파라미터는 xml에 명시된 클래스의 id, 두 번째 파라미터는 실행할 메서드(해당 클래스에 정의된 메서드)
		TestBean t1 = factory.getBean("t1", TestBean.class);
		// 위 한 줄의 코드를 통해 객체가 생성되기 때문에, 생성자가 실행되고, 명시해둔 System.out.println() 함수도 실행된다.
		
		// printf 뭐임?
		System.out.printf("t1: %s\n", t1);
		
		TestBean t2 = factory.getBean("t1", TestBean.class);
		System.out.printf("t1: %s\n", t2);
		
		// id가 t1인 객체를 가져올 때, 이미 객체가 생성되어 있다면 그 주소를 받아서 그대로 사용한다 
	}
	
	// 마찬가지로 얘도 deprecated
	// 패키지 바깥에 있을 때 
	public static void test2() {
		FileSystemResource res = new FileSystemResource("beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);
		
		TestBean t1 = factory.getBean("t2", TestBean.class);
		System.out.printf("t1 : %s\n", t1);
		
		TestBean t2 = factory.getBean("t2", TestBean.class);
		System.out.printf("t2 : %s\n", t2);
	}
	
	// ApplicationContext: 패키지 내부 
	public static void test3() {
		// 얘는 기본적으로 new로 할당할 때 객체가 생성된다(생성자 호출되는 걸 확인할 수 있다)
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/softcampus/config/beans.xml");
		
		TestBean t1 = ctx.getBean("t1", TestBean.class);
		System.out.printf("t1: %s\n", t1);
		
		TestBean t2 = ctx.getBean("t1", TestBean.class);
		System.out.printf("t2: %s\n", t2);
		
		// 얘는 닫아줘야 한다
		ctx.close();
	}
	// ApplicationContext: 패키지 외부 	
	public static void test4() {
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		
		TestBean t1 = ctx.getBean("t2", TestBean.class);
		System.out.printf("t1 : %s\n", t1);
		
		TestBean t2 = ctx.getBean("t2", TestBean.class);
		System.out.printf("t1 : %s\n", t2);
		
		ctx.close();
	}
}
