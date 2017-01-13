package com.mengyanxin.utils.object;

/**
 * Created by mengyanxin on 2017/1/12.
 */
public class ObjectUtils {

    /**
     * 判断对象是否为空，为空时返回true
     * @param object
     * @return
     */
    public static boolean isNull(Object object){
        if (object != null && !"".equals(object.toString()) && !"null".equals(object.toString())){
            return false;
        }
        return true;
    }
}
