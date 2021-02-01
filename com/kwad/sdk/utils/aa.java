package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import com.baidu.webkit.internal.ETAG;
import java.util.Map;
/* loaded from: classes3.dex */
public final class aa {
    public static String a(@NonNull String str, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : map.keySet()) {
            if (map.get(str2) != null) {
                sb.append(str2).append("=").append(map.get(str2)).append(ETAG.ITEM_SEPARATOR);
            }
        }
        String sb2 = sb.toString();
        String substring = sb2.substring(0, sb2.length() - 1);
        return str.contains("?") ? str + ETAG.ITEM_SEPARATOR + substring : str + "?" + substring;
    }
}
