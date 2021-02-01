package com.qq.e.comm.plugin.util;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.baidu.webkit.internal.ETAG;
import com.qq.e.comm.util.StringUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
/* loaded from: classes15.dex */
public class az {

    /* loaded from: classes15.dex */
    public enum a {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");
        
        private String e;

        a(String str) {
            this.e = str;
        }

        public String a() {
            return this.e;
        }
    }

    public static String a(Uri uri) {
        if (uri == null) {
            return "";
        }
        String path = uri.getPath();
        if (StringUtil.isEmpty(path)) {
            return "";
        }
        int lastIndexOf = path.lastIndexOf("/0");
        if (lastIndexOf > 0) {
            path = path.substring(0, lastIndexOf);
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(path);
        return !TextUtils.isEmpty(fileExtensionFromUrl) ? fileExtensionFromUrl.toLowerCase() : "";
    }

    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Matcher matcher = Pattern.compile("[\\?&#]" + str2 + "=([^&#]*)").matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return null;
    }

    public static String a(String str, String str2, String str3) {
        if (StringUtil.isEmpty(str2) || StringUtil.isEmpty(str3) || StringUtil.isEmpty(str)) {
            return str;
        }
        return str + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + str2 + "=" + str3;
    }

    public static boolean a(String str) {
        return b(Uri.parse(str));
    }

    public static Pair<Boolean, String> b(String str, String str2, String str3) {
        String str4 = str2 + "=" + str3;
        Matcher matcher = Pattern.compile("(\\?|&|#)" + str2 + "=([^&#]*)").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, matcher.group(1) + str4);
            z = true;
        }
        matcher.appendTail(stringBuffer);
        return new Pair<>(Boolean.valueOf(z), stringBuffer.toString());
    }

    private static boolean b(Uri uri) {
        return (uri == null || uri.getScheme() == null || (!uri.getScheme().equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) && !uri.getScheme().equalsIgnoreCase("https"))) ? false : true;
    }

    public static boolean b(String str) {
        return (TextUtils.isEmpty(str) || a(str)) ? false : true;
    }

    public static a c(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.toLowerCase();
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 3401:
                if (str.equals("js")) {
                    c = 1;
                    break;
                }
                break;
            case 97669:
                if (str.equals("bmp")) {
                    c = 6;
                    break;
                }
                break;
            case 98819:
                if (str.equals("css")) {
                    c = 0;
                    break;
                }
                break;
            case 102340:
                if (str.equals("gif")) {
                    c = 7;
                    break;
                }
                break;
            case 105441:
                if (str.equals("jpg")) {
                    c = 2;
                    break;
                }
                break;
            case 111145:
                if (str.equals("png")) {
                    c = 4;
                    break;
                }
                break;
            case 3213227:
                if (str.equals("html")) {
                    c = '\b';
                    break;
                }
                break;
            case 3268712:
                if (str.equals("jpeg")) {
                    c = 3;
                    break;
                }
                break;
            case 3645340:
                if (str.equals("webp")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return a.CSS;
            case 1:
                return a.JS;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return a.IMAGE;
            default:
                return a.HTML;
        }
    }

    public static String c(String str, String str2, String str3) {
        Pair<Boolean, String> b2 = b(str, str2, str3);
        return ((Boolean) b2.first).booleanValue() ? (String) b2.second : a(str, str2, str3);
    }

    public static boolean d(String str, String str2, String str3) {
        URL url;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                url = new URL(str);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                url = null;
            }
            if (url != null) {
                String query = url.getQuery();
                if (!TextUtils.isEmpty(query)) {
                    return Pattern.compile("(^|&)" + str2 + "=" + str3 + "(&|$)").matcher(query).find();
                }
            }
        }
        return false;
    }
}
