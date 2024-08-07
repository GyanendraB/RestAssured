package api.endpoints;

//https://petstore.swagger.io/v2/user

public class Routes {
    //User Model

    public static String baseUrl="https://petstore.swagger.io/v2";


    public  static  String post_url= baseUrl+"/user";
    public  static  String get_url= baseUrl+"/user/{username}";
    public  static  String update_url= baseUrl+"/user/{username}";
    public  static  String delete_url= baseUrl+"/user/{username}";

}
