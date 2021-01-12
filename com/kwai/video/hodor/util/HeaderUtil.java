package com.kwai.video.hodor.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Map;
/* loaded from: classes4.dex */
public class HeaderUtil {
    public static String parseHeaderMapToFlatString(@Nullable Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(": ");
            if (!TextUtils.isEmpty(entry.getValue())) {
                sb.append(entry.getValue());
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }
}
