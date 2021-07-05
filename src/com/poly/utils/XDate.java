package com.poly.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class XDate {
    Date uDate = new Date();
//    java.sql.Date sql_date = convertDate(uDate);
//
//    private static java.sql.Date convertDate(java.util.Date date) {
//        java.sql.Date myDate = new java.sql.Date(date.getTime());
//        return myDate;
//    }

    static SimpleDateFormat formater = new SimpleDateFormat();
   

    /*SimpleDateFormat là class thuộc gói java.text.SimpleDateFormat giúp để đinh dạng
    lại thời gian như ngày tháng năm giờ phút giây
     
    /*
     * Chuyển đổi String sang Date
     *
     * @param date là String cần chuyển
     * @param pattern là định dạng thời gian
     * @return Date kết quả
     */
 /*
    String s = "01-09-1971"
    Date date = XDate.toDate(s,"dd-MM-yyy");
     */
    public static Date  toDate(String date, String pattern) {
        try {
            formater.applyPattern(pattern);
            java.util.Date date1 = formater.parse(date);
            java.sql.Date myDate = new java.sql.Date(date1.getTime());
            return myDate;
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
//        public static Date toDate(String date, String pattern) {
//        try {
//            formater.applyPattern(pattern);
//            return convertDate(formater.parse(date));
//        } catch (ParseException ex) {
//            throw new RuntimeException(ex);
//        }
//    }

    /*
     * Chuyển đổi từ Date sang String
     *
     * @param date là Date cần chuyển đổi
     * @param pattern là định dạng thời gian
     * @return String kết quả
     */
    public static String toString(Date date, String pattern) {
        formater.applyPattern(pattern);
        return formater.format(date);
    }

    /*
    Date now = new Date();
    String s = XDate.toString(now,"dd-MM-yyyy);
     */

 /*
     * Bổ sung số ngày vào thời gian
     *
     * @param date thời gian hiện có
     * @param days số ngày cần bổ sung váo date
     * @return Date kết quả
     */
    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }
    /*
    Bổ sung 10 ngày vào ngày hiện tại
    Date now = new Date();
    Date after = XDate.addDays(now,10);
     */
}
