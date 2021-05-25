package d.a.l0.f.i.r;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public final class f {
    public static String a(String str, String str2, String str3) {
        StringBuilder sb;
        StringBuilder sb2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str4 = str2 + "=";
        int indexOf = str.indexOf("?");
        String str5 = null;
        if (indexOf < 0) {
            int indexOf2 = str.indexOf("#");
            if (indexOf2 < 0) {
                sb2 = new StringBuilder(str);
            } else {
                str5 = str.substring(indexOf2);
                sb2 = new StringBuilder(str.substring(0, indexOf2));
            }
            sb2.append("?");
            sb2.append(str4);
            sb2.append(str3);
            if (str5 != null) {
                sb2.append(str5);
            }
            return sb2.toString();
        }
        if (str.indexOf("&" + str4, indexOf) < 0) {
            if (str.indexOf("?" + str4, indexOf) < 0) {
                int indexOf3 = str.indexOf("#");
                if (indexOf3 < 0) {
                    sb = new StringBuilder(str);
                } else {
                    str5 = str.substring(indexOf3);
                    str = str.substring(0, indexOf3);
                    sb = new StringBuilder(str);
                }
                if (!str.endsWith("&") && !str.endsWith("?")) {
                    sb.append("&");
                }
                sb.append(str4);
                sb.append(str3);
                if (str5 != null) {
                    sb.append(str5);
                }
                return sb.toString();
            }
            return str;
        }
        return str;
    }

    public static String b(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String e2 = e(map);
        if (TextUtils.isEmpty(e2)) {
            return str;
        }
        return str + "&" + e2;
    }

    public static String c(String str, Set<String> set) {
        if (TextUtils.isEmpty(str) || !str.startsWith("http") || set == null || set.size() == 0) {
            return str;
        }
        String str2 = null;
        try {
            str2 = new URL(str).getQuery();
        } catch (MalformedURLException unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        CharSequence d2 = d(str2, set);
        return TextUtils.isEmpty(d2) ? str : str.replace(str2, d2);
    }

    public static String d(String str, Set<String> set) {
        String[] split;
        if (TextUtils.isEmpty(str) || set == null || (split = str.split("&")) == null || split.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            String[] split2 = str2.split("=");
            if (split2.length > 0 && !set.contains(split2[0])) {
                sb.append(str2);
                sb.append("&");
            }
        }
        int length = sb.length();
        if (length > 0) {
            int i2 = length - 1;
            if (sb.charAt(i2) == '&') {
                sb.deleteCharAt(i2);
            }
        }
        return sb.toString();
    }

    public static String e(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            try {
                sb.append(entry.getKey() != null ? URLEncoder.encode(entry.getKey(), "UTF-8") : "");
                sb.append("=");
                sb.append(entry.getValue() != null ? URLEncoder.encode(entry.getValue(), "UTF-8") : "");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return sb.toString();
    }
}
