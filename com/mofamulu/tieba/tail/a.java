package com.mofamulu.tieba.tail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tieba.pb.WebActivity;
import com.baidu.tieba.pb.WebBdActivity;
import com.mofamulu.tieba.ch.bf;
import com.mofamulu.tieba.ch.bg;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class a {
    private static Pattern a = Pattern.compile("^http[s]?://[\\w_]*\\.?baidu\\.com");
    private static String b = "tbhp_broswer";
    private static boolean c = false;

    public static boolean a(Context context, String str, String str2, String str3) {
        if (str == null || str.startsWith("http://msg.baidu.com")) {
            return false;
        }
        if (!c) {
            return !a(str, str2, str3) || str.contains("&amp;");
        }
        c = false;
        return false;
    }

    public static void b(Context context, String str, String str2, String str3) {
        boolean a2 = a(str, str2, str3);
        int indexOf = str.indexOf("://");
        if (indexOf == -1 || indexOf > 6) {
            str = com.baidu.loginshare.e.f + str;
        }
        String a3 = bf.a(str, "&amp;", "&");
        if (a2) {
            c = true;
            WebBdActivity.a(context, a3, str2, str3);
            return;
        }
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(a3)));
    }

    public static boolean c(Context context, String str, String str2, String str3) {
        return a(context, str, str2, str3);
    }

    public static void d(Context context, String str, String str2, String str3) {
        boolean a2 = a(str, str2, str3);
        int indexOf = str.indexOf("://");
        if (indexOf == -1 || indexOf > 6) {
            str = com.baidu.loginshare.e.f + str;
        }
        String a3 = bf.a(str, "&amp;", "&");
        if (a2) {
            c = true;
            WebActivity.a(context, a3, str2, str3);
            return;
        }
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(a3)));
    }

    private static boolean a(String str, String str2, String str3) {
        int G = bg.c().G();
        if (G == 2) {
            return false;
        }
        if (G == 3) {
            return true;
        }
        int indexOf = str.indexOf("://");
        if (indexOf == -1 || indexOf > 6) {
            str = com.baidu.loginshare.e.f + str;
        }
        if (G == 1) {
            return str.startsWith("http://tieba.baidu.com") || str.startsWith("http://wapp.baidu.com") || str.startsWith("http://book.mofamulu.com/api/android/");
        } else if (str.startsWith("http://book.mofamulu.com/api/android/")) {
            return true;
        } else {
            return a.matcher(str).find();
        }
    }
}
