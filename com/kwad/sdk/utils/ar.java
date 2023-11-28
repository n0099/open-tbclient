package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes10.dex */
public final class ar {
    public static String appendUrl(@NonNull String str, Map<String, String> map) {
        String str2;
        if (map != null && map.size() > 0) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = map.keySet().iterator();
            while (true) {
                str2 = "&";
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (map.get(next) != null) {
                    sb.append(next);
                    sb.append("=");
                    sb.append(map.get(next));
                    sb.append("&");
                }
            }
            String sb2 = sb.toString();
            String substring = sb2.substring(0, sb2.length() - 1);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            if (!str.contains("?")) {
                str2 = "?";
            }
            sb3.append(str2);
            String sb4 = sb3.toString();
            return sb4 + substring;
        }
        return str;
    }
}
