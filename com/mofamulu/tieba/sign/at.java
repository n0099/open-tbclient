package com.mofamulu.tieba.sign;

import com.mofamulu.tieba.ch.bf;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class at {
    private static Pattern a = Pattern.compile("<a href=\"/f\\?kw=([^\"]+)\"[^>]*>(.*?)</a>", 2);
    private static Pattern b = Pattern.compile("#level_t_table'\\)\">(.*?)</span>", 2);
    private static Pattern c = Pattern.compile("<div class=\"like_badge_lv\">(.*?)</div>", 2);

    public static List a(String str) {
        Matcher matcher = a.matcher(str);
        LinkedList linkedList = new LinkedList();
        while (matcher.find()) {
            au auVar = new au();
            auVar.b = matcher.group(2);
            linkedList.addLast(auVar);
        }
        Matcher matcher2 = b.matcher(str);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            au auVar2 = (au) it.next();
            if (!matcher2.find()) {
                break;
            }
            auVar2.c = bf.a(matcher2.group(1), 0);
        }
        Matcher matcher3 = c.matcher(str);
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            au auVar3 = (au) it2.next();
            if (!matcher3.find()) {
                break;
            }
            auVar3.d = bf.a(matcher3.group(1), 0);
        }
        return linkedList;
    }

    public static String b(String str) {
        Matcher matcher = Pattern.compile("<a href=\"([^<>]*?)\">登录</a>").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static Map c(String str) {
        int indexOf;
        HashMap hashMap = new HashMap();
        int indexOf2 = str.indexOf("<form action=\"http://wappass.baidu.com/passport/\"");
        if (indexOf2 == -1) {
            indexOf2 = str.indexOf("<form action=\"/passport/login\"");
            hashMap.put("_PARAM_WAP_LOGIN_URL", "http://wappass.baidu.com/passport/login");
        } else {
            hashMap.put("_PARAM_WAP_LOGIN_URL", "http://wappass.baidu.com/passport/");
        }
        if (indexOf2 == -1 || (indexOf = str.indexOf("</form>", indexOf2)) == -1) {
            return null;
        }
        Matcher matcher = Pattern.compile("<input .*? name=\"([^\"]*?)\".*? value=\"([^\"]*?)\"/>").matcher(str.substring(indexOf2, indexOf).replace("+", "%2B"));
        while (matcher.find()) {
            hashMap.put(matcher.group(1), bf.b(URLDecoder.decode(matcher.group(2), "UTF-8"), "&amp;", "&"));
        }
        return hashMap;
    }

    public static Map d(String str) {
        int indexOf;
        HashMap hashMap = new HashMap();
        int indexOf2 = str.indexOf("<form action=\"http://wappass.baidu.com/passport/\"");
        if (indexOf2 == -1) {
            indexOf2 = str.indexOf("<form action=\"/passport/login\"");
            hashMap.put("_PARAM_WAP_LOGIN_URL", "http://wappass.baidu.com/passport/login");
        } else {
            hashMap.put("_PARAM_WAP_LOGIN_URL", "http://wappass.baidu.com/passport/login");
        }
        if (indexOf2 == -1 || (indexOf = str.indexOf("</form>", indexOf2)) == -1) {
            return null;
        }
        Matcher matcher = Pattern.compile("<input .*? name=\"([^\"]*?)\".*? value=\"([^\"]*?)\"/>").matcher(str.substring(indexOf2, indexOf).replace("+", "%2B"));
        while (matcher.find()) {
            try {
                hashMap.put(matcher.group(1), bf.b(URLDecoder.decode(matcher.group(2), "UTF-8"), "&amp;", "&"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    public static boolean e(String str) {
        return str.indexOf("<meta http-equiv=\"refresh\"") != -1;
    }

    public static String f(String str) {
        Matcher matcher = Pattern.compile("url=(.*?)\"/>").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static String g(String str) {
        Matcher matcher = Pattern.compile("<span class=\"highlight\">(.*?)</span>").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static String h(String str) {
        Matcher matcher = Pattern.compile("<a href=\"/([^<>]*?)/m\\?tn=bdFBW&amp;tab=favorite\">").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        Matcher matcher2 = Pattern.compile("/([^<>]*?)/i\\?un=").matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static List i(String str) {
        Matcher matcher = Pattern.compile("<a href=\"m\\?kw=([^\"]*)\">(.*?)</a>").matcher(str);
        LinkedList linkedList = new LinkedList();
        while (matcher.find()) {
            au auVar = new au();
            auVar.b = matcher.group(2);
            linkedList.addLast(auVar);
        }
        Matcher matcher2 = Pattern.compile("<td align=\"center\">经验值(.*?)</td>").matcher(str);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            au auVar2 = (au) it.next();
            if (!matcher2.find()) {
                break;
            }
            auVar2.c = bf.a(matcher2.group(1), 0);
        }
        Matcher matcher3 = Pattern.compile("<td align=\"center\">等级(.*?)</td>").matcher(str);
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            au auVar3 = (au) it2.next();
            if (!matcher3.find()) {
                break;
            }
            auVar3.d = bf.a(matcher3.group(1), 0);
        }
        return linkedList;
    }

    public static void a(as asVar, String str) {
        if (str.indexOf(">已签到</span>") != -1) {
            asVar.a(11);
            return;
        }
        Matcher matcher = Pattern.compile("<a href=\"([^<>]*?)\">签到</a>").matcher(str);
        if (matcher.find()) {
            asVar.a(0);
            asVar.c(matcher.group(1));
            return;
        }
        asVar.a(2);
    }

    public static void b(as asVar, String str) {
        int indexOf = str.indexOf("<span class=\"light\">");
        if (indexOf == -1) {
            asVar.a(1);
            asVar.b("格式错误，请到设置各种杂项设置中检查是否有新版更新！");
            return;
        }
        String a2 = bf.a(bf.a(str.substring(indexOf, str.indexOf("<br/>", indexOf)), "<span class=\"light\">", ""), "</span>", "");
        if (a2.indexOf("经验值上升") != -1) {
            asVar.a(10);
            asVar.b(String.valueOf(a2) + "点");
            return;
        }
        asVar.a(1);
        asVar.b(a2);
    }
}
