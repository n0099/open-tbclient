package d.a.h0.a.i2;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.wallet.core.Domains;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42735a = d.a.h0.a.k.f43101a;

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

    public static boolean b(String str, StringBuffer stringBuffer) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            try {
                URL url = new URL(str);
                String protocol = url.getProtocol();
                String host = url.getHost();
                if (!TextUtils.isEmpty(protocol) && !TextUtils.isEmpty(host)) {
                    z = ("http".equals(protocol) || "https".equals(protocol)) ? true : true;
                    stringBuffer.append(protocol);
                    stringBuffer.append("://");
                    stringBuffer.append(host);
                }
                stringBuffer.append(str);
            } catch (MalformedURLException unused) {
                stringBuffer.append(str);
            }
        }
        return z;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return str;
        }
    }

    public static String d(String str) {
        int indexOf;
        return (!TextUtils.isEmpty(str) && (indexOf = str.indexOf("?")) > 0) ? str.substring(0, indexOf) : str;
    }

    public static String e(String str) {
        return f(d(str));
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(File.separator)) {
            str = str.substring(1);
        }
        return str.endsWith(File.separator) ? str.substring(0, str.length() - 1) : str;
    }

    public static String g(String str, Set<String> set) {
        if (TextUtils.isEmpty(str) || !str.startsWith("http") || set == null || set.size() == 0) {
            return str;
        }
        String str2 = null;
        try {
            str2 = new URL(str).getQuery();
        } catch (MalformedURLException e2) {
            if (f42735a) {
                e2.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        CharSequence h2 = h(str2, set);
        return TextUtils.isEmpty(h2) ? str : str.replace(str2, h2);
    }

    public static String h(String str, Set<String> set) {
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

    public static String i(Uri uri) {
        if (uri == null) {
            return "";
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            return null;
        }
        return pathSegments.get(0);
    }

    public static String j(String str, String str2, String str3, long j) {
        return str2 + "=" + str3 + ";domain=" + str + ";path=/;max-age=" + j + ";";
    }

    public static String k(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(";");
            int length = split.length;
            for (int i2 = 0; i2 != length; i2++) {
                String trim = split[i2].trim();
                String[] split2 = trim.split("=");
                if (split2.length >= 2 && TextUtils.equals(str2, split2[0])) {
                    if (split2.length == 2) {
                        return split2[1];
                    }
                    return trim.substring(split2[0].length() + 1);
                }
            }
        }
        return null;
    }

    public static String l(Uri uri, Set<String> set) {
        if (uri == null) {
            return "";
        }
        if (set != null && set.size() != 0) {
            String uri2 = uri.toString();
            String query = uri.getQuery();
            if (TextUtils.isEmpty(query)) {
                return uri2;
            }
            String h2 = h(query, set);
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(uri.getScheme());
            builder.authority(uri.getAuthority());
            builder.path(uri.getPath());
            if (!TextUtils.isEmpty(h2)) {
                builder.query(h2);
            }
            return builder.build().toString();
        }
        return uri.toString();
    }

    public static String m(@NonNull String str, @NonNull Uri uri, boolean z) {
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        String substring = path.substring(str.length() + 1);
        if (substring.endsWith(File.separator)) {
            substring = substring.substring(0, substring.length() - 1);
        }
        String replaceAll = substring.replaceAll("/+", "/");
        return (z || !replaceAll.startsWith(File.separator)) ? replaceAll : replaceAll.substring(1);
    }

    public static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf("?");
        if (indexOf > 0) {
            return str.substring(indexOf + 1);
        }
        return null;
    }

    public static boolean o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        return host.endsWith(Domains.BAIDU) || host.equals("baidu.com");
    }

    public static boolean p(String str) {
        return Pattern.compile("(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;{]+[-A-Za-z0-9+&@#/%=~_|}]|(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).*").matcher(str).matches();
    }

    public static String q(Map<String, String> map) {
        String encode;
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            String str2 = map.get(str);
            if (str != null) {
                try {
                    encode = URLEncoder.encode(str, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e2);
                }
            } else {
                encode = "";
            }
            sb.append(encode);
            sb.append("=");
            sb.append(str2 != null ? URLEncoder.encode(str2, "UTF-8") : "");
        }
        return sb.toString();
    }

    public static Map<String, String> r(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("&")) {
            String[] split = str2.split("=");
            hashMap.put(c(split[0]), split.length > 1 ? c(split[1]) : "");
        }
        return hashMap;
    }

    public static String s(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errcode", str);
            jSONObject.put("errMsg", str2);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public static Uri t(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.fromFile(new File(str));
    }

    public static String u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.fromFile(new File(str)).toString();
    }
}
