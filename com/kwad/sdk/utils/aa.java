package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import java.util.Map;
/* loaded from: classes6.dex */
public final class aa {
    public static String a(@NonNull String str, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : map.keySet()) {
            if (map.get(str2) != null) {
                sb.append(str2);
                sb.append("=");
                sb.append(map.get(str2));
                sb.append("&");
            }
        }
        String sb2 = sb.toString();
        String substring = sb2.substring(0, sb2.length() - 1);
        if (str.contains("?")) {
            return str + "&" + substring;
        }
        return str + "?" + substring;
    }
}
