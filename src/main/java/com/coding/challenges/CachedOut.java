package com.coding.challenges;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * This Class is utility class to implement a cache in which we can do CRUD operations
 */
public class CachedOut {

    //Create a stringCache Set , which will contain input strings
    public static List<String> stringCache = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        // Here , the input is of type
        // "Add|Dog Get|Dog Remove|Dog Has|Dog"
        String command = scanner.nextLine();
        // Split the input string by space to get all the operations
        String[] strArray = command.split(" ");
        // Iterate over the array to do all the operations
        for (String str : strArray) {
            String opr = str;
            String obj = "";
            if(str.contains("|")) {
                //Split the first combination of operation and input string by pipe
                // Pipe is a special metacharacter in Java , to convert it into string we use
                // "\\|"
                String[] arr = str.split("\\|");
                opr = arr[0];
                obj = arr[1];
            }
            switch (opr){
                case "Add":
                    System.out.println(addStringToCache(obj));
                    break;
                case "Get":
                    System.out.println(getStringFromCache(obj));
                    break;
                case "Has":
                    System.out.println(hasStringInCache(obj));
                    break;
                case "Remove":
                    System.out.println(deleteStringFromCache(obj));
                    break;
                default:
                    System.out.println(resetCache());
                    break;
            }
        }


    }

    /**
     * This method adds element to stringCache when it is not present
     * and return true ,
     * else return false
     * @param input
     * @return true/false
     */
    static Boolean addStringToCache(String input){
        /*Add element to stringCache , if it is already present
         */
        if(stringCache.contains(input)){
            return false;
        }else{
            return stringCache.add(input);
        }
    }

    /**
     * This method gets string from the string cache by iterating it .
     * @param input
     * @return string got from the cache.
     */
    static String getStringFromCache(String input){
        Iterator<String> iterator = stringCache.listIterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            if(input.equals(str))
                return str;
        }
        return null;
    }

    /**
     * This method checks whether a input string already exist in stringCache or not.
     * @param input
     * @return boolean true/false
     */
    static boolean hasStringInCache(String input){
        return stringCache.contains(input);
    }

    /**
     * This method returns the size of cache and clears it.
     * @return int
     */
    static int resetCache(){
        int size = stringCache.size();
        stringCache.clear();
        return size;
    }

    /**
     * This method deletes input string from the cache if it is present , return true
     * else returns false
     * @param input
     * @return
     */
    static boolean deleteStringFromCache(String input){
        if(stringCache.contains(input))
            return stringCache.remove(input);
        else
            return false;
    }
}
