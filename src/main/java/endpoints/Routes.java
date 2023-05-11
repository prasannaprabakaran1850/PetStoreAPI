package endpoints;

public class Routes {

	public static String base_url="https://petstore.swagger.io/v2";
	
	//User module	
	public static String create_user_url=base_url+"/user";
	public static String get_user_url=base_url+"/user/{username}";
	public static String update_user_url=base_url+"/user/{username}";
	public static String delete_user_url=base_url+"/user/{username}";
	public static String login_user_url=base_url+"/user/login";
	public static String logout_user_url=base_url+"/user/logout";



}
