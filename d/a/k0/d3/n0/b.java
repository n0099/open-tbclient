package d.a.k0.d3.n0;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class b {
    public static String a(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(":")) == null) {
            return null;
        }
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2) && str2.contains("TBCGameID=")) {
                int indexOf = str2.indexOf("=") + 1;
                return indexOf < str2.length() ? str2.substring(indexOf, str2.length()) : "";
            }
        }
        return "";
    }
}
