package com.sadeny.style;


//this class all static variables string required in the application
//just to maintain the correct workflow, readability and easy maintenance
public class Static_Var {

    //this section is reserved URLs
    //////THIS SECTION IS FOR USER MANIPULATION URLs
    //update the following two lines according to the server
    public static String ROOT_URL="https://smwallet.herokuapp.com";
    //public static String ROOT_URL="https://192.168.43.223:8080";

    public static String LOGIN_URL=ROOT_URL+"/login";   //URL responsible for login call
    public static String REGISTER_URL=ROOT_URL+"/register";  //URL responsible for register call
    public static String UPDATE_USER_URL=ROOT_URL+"/update";    //URL responsible for update

    //THIS SECTION IS FOR PRODUCT MANIPULATION URLs
    public static String BUY_URL=ROOT_URL+"/order";          //URL to  make order
    public static String GET_ITEM_ALL=ROOT_URL+"getAllItem";   //URL to get all item details
    public static String GET_ITEM_ONE=ROOT_URL+"getOneItem";   //URL to get one item details
    public static String GET_ITEM_PRICE_ARRAY=ROOT_URL+"getItemArray";  //URL to get price list of one item

    //this section is reserved for data persistance
    public static String NAME_KEY="nameKey";      //
    public static String PASS_KEY="passKey";      //
    public static String TOKEN_KEY="tokenKey";    //
    public static String PHONE_KEY="phoneKey";    //

    //passingVariablesKeys
    public static boolean RET_BOOL;
}
