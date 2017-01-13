package com.mengyanxin.utils.date;

import com.mengyanxin.utils.date.config.DateConfig;
import com.mengyanxin.utils.object.ObjectUtils;
import com.mengyanxin.utils.string.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mengyanxin on 2017/1/12.
 */
public class DateUtils {

    private static SimpleDateFormat  simpleDateFormat = null;

    /**
     * 得到现在指定格式的日期时间
     * @param format 日期格式
     * @return
     */
    public static String getNowDateTime(String format) {
        if (StringUtils.isNull(format)) {
            format = DateConfig.DATE_TIME_FORMAT;
        }
        simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 得到现在默认格式的日期时间
     * @return
     */
    public static String getNowDateTime() {
        return getNowDateTime(null);
    }

    /**
     * 将时间字符串转换为指定的格式的Date类型
     * @param date
     * @param format
     * @return
     * @throws Exception
     */
    public static Date getDate(String date,String format) throws Exception{
        if(StringUtils.isNull(date)){
            return null;
        }
        if (StringUtils.isNull(format)) {
            format = DateConfig.DATE_TIME_FORMAT;
        }
        simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(date);
    }

    /**
     * 将时间字符串转换为默认的格式的Date类型
     * @param date
     * @return
     * @throws Exception
     */
    public static Date getDate(String date) throws Exception{
        return getDate(date,null);
    }

    /**
     * 将Date类型对象转换为指定时间格式字符串
     * @param date
     * @param format
     * @return
     */
    public static String getDateToString(Date date,String format){
        if(ObjectUtils.isNull(date)){
            return null;
        }
        if (StringUtils.isNull(format)) {
            format = DateConfig.DATE_TIME_FORMAT;
        }
        return simpleDateFormat.format(date);
    }

    /**
     * 将Date类型对象转换为默认时间格式字符串
     * @param date
     * @return
     */
    public static String getDateToString(Date date){
        return getDateToString(date,null);
    }

}
