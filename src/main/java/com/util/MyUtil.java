package com.util;

import java.util.Random;

/**
 * Created by ld on 2019/3/27.
 */
public class MyUtil {
    static final String CODES="abcdefghigmnoqrtyABCDEFGHGLMNQRTY3456789";
    static final int LEN=4;
    public static char[] getStr(){
        char[] array=new char[LEN];
        Random random=new Random();
        for(int i=0;i<LEN;i++){
            array[i]=CODES.charAt(random.nextInt(CODES.length()-1));
        }
        return  array;
    }
}
