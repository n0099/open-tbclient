package d.a.q.f.a;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes2.dex */
public class q {
    public static String a(Map<String, String> map) {
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

    public static String b(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a2 = a(map);
        if (TextUtils.isEmpty(a2)) {
            return str;
        }
        if (!str.contains("?")) {
            return str + "?" + a2;
        }
        if (str.lastIndexOf("?") == str.length() - 1) {
            return str + a2;
        }
        return str + "&" + a2;
    }
}
