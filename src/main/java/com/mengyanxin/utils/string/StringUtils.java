package com.mengyanxin.utils.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mengyanxin on 2017/1/12.
 */
public class StringUtils {

    /**
     * 判断字符串是否为空，为空时返回true
     * @param str
     * @return
     */
    public static boolean isNull(String str){
        if(str == null || "".equals(str.trim())){
            return true;
        }
        return false;
    }

    /**
     * 是否为数字
     *
     * @param text 要验证的文本
     * @return boolean true-是 false-否
     */
    public static boolean isNumber(String text){
        if (isNull(text)){
            return false;
        }
        String numberStr = "0123456789";
        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if (numberStr.indexOf(String.valueOf(c)) == -1){
                return false;
            }
        }
        return true;
    }

    /**
     * 是否符合电子邮件地址格式
     *
     * @param email 电子邮件地址
     * @return boolean true-是 false-否
     */
    public static boolean isEmail(String email){
        boolean isEmail = false;
        Pattern p = Pattern.compile("([\\w[.-]]+)(@)([\\w[.-]]+\\.[\\w[.-]]+)");
        Matcher m = p.matcher(email);
        if (m.matches()){
            isEmail = true;
        }
        return isEmail;
    }

    /**
     * 是否符合手机号码格式
     *
     * @param mobile 手机号码
     * @return boolean true-是 false-否
     */
    public static boolean isMobile(String mobile){
        boolean isMobile = false;
        Pattern p = Pattern.compile("((\\()?(\\+)?(86)?1[3|5|8][0-9]{9}(\\))?$)|((\\()?(\\+)?(86)?01[3|5|8][0-9]{9}(\\))?$)");
        Matcher m = p.matcher(mobile);
        if (m.matches()){
            isMobile = true;
        }
        return isMobile;
    }

    /**
     * 电话号码格式简单校验，格式为：数字-数字
     *
     * @param phone 电话号码
     * @return boolean true-是 false-否
     */
    public static boolean isPhone(String phone){
        if(isNull(phone)){
            return false;
        }
        boolean isPhone = false;
        int index = phone.indexOf("-");
        if (index > 0 && index != phone.length() - 1){
            String phoneNum = phone.substring(0, index) + phone.substring(index + 1);
            if (isNumber(phoneNum)){
                isPhone = true;
            }
        }
        return isPhone;
    }

    /**
     * 是否为密码，允许大小写字母、数字以及下划线，长度为4-16位
     *
     * @param pwd 密码
     * @return boolean true-是 false-否
     */
    public static boolean isPassword(String pwd){
        boolean ifPwd = false;
        Pattern p = Pattern.compile("([A-Za-z0-9_]{4,16})");
        Matcher m = p.matcher(pwd);
        if (m.matches()){
            ifPwd = true;
        }
        return ifPwd;
    }

    /**
     * 文本是否都有字母组成
     *
     * @param text 待验证的文本
     * @return boolean true-是 false-否
     */
    public static boolean isLetter(String text){
        if (text != null){
            Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
            Matcher matcher = pattern.matcher(text);
            if (matcher.matches()){
                return true;
            }
        }
        return false;
    }

    /**
     * 是否URL地址
     *
     * @param url URL
     * @return boolean true-是 false-否
     */
    public static boolean isUrl(String url){
        return validByRegex("(http://|https://)?([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?", url);
    }

    /**
     * 检验字符串是否匹配指定的正则表达式
     *
     * @param regex 正则表达式
     * @param input 字符串
     * @return boolean true-匹配 false-不匹配
     */
    public static boolean validByRegex(String regex, String input)
    {
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher regexMatcher = p.matcher(input);
        return regexMatcher.find();
    }
}
