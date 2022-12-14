package kr.co.softcampus.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class TestBean01 {

	private int data01;
	private DataBean01 data02;
	
	// 자동주입을 변수에 설정.
	// 자동으로 setter method가 추가되며, 이를 통해 자동주입이 실행된다.
	// 단, Autowired를 설정하면, 반드시 해당 bean이 정의되어 있어야 한다.(at BeansConfigClass)
	// 아 거기 없으면 걍 그 속성은 주입하지마!: required 속성을 false로 설정한다.
	@Autowired
	private DataBean01 data03;
	
	@Autowired
	@Qualifier("obj04")
	private DataBean02 data04;

	@Autowired
	@Qualifier("obj05")
	private DataBean02 data05;
	
	@Autowired(required = false)
	@Qualifier("obj06")
	private DataBean02 data06;
	
	// GETTERS & SETTERS
	public int getData01() {
		return data01;
	}

	// 필수 주입 property를 의미하는 @Required는 Spring 5.1 버전 이후부터 무시된다.
	@Required
	public void setData01(int data01) {
		this.data01 = data01;
	}

	public DataBean01 getData02() {
		return data02;
	}	
	
	// @Autowired를 이용한 자동주입: byType
	@Autowired
	public void setData02(DataBean01 data02) {
		this.data02 = data02;
	}

	public DataBean01 getData03() {
		return data03;
	}

	public DataBean02 getData04() {
		return data04;
	}

	public DataBean02 getData05() {
		return data05;
	}

	public DataBean02 getData06() {
		return data06;
	} 
		
}
