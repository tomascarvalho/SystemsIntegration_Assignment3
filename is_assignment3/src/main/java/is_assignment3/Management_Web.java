package is_assignment3;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Management_Web {
	@WebMethod
	public String addFollower(String email, String brand, int priceMin, int priceMax, String token) {
		return "";
	}
	@WebMethod
	public String listFollowers() {
		return "";
	}
	@WebMethod
	public String removeFollower(String email, String brand) {
		return "";
	}
	@WebMethod
	public String listUsersProject2() {
		return "";
	}
	@WebMethod
	public String listCarsProject2() {
		return "";
	}
}
