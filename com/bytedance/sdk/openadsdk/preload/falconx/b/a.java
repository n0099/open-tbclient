package com.bytedance.sdk.openadsdk.preload.falconx.b;

import android.net.http.Headers;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    public static WebResourceResponse a(InputStream inputStream, Map<String, String> map) {
        Map<String, String> hashMap;
        if (inputStream != null) {
            if (map == null) {
                try {
                    hashMap = new HashMap<>();
                } catch (Throwable th) {
                    Log.e("WebResourceUtils", "getResponseWithHeaders error", th);
                }
            } else {
                hashMap = map;
            }
            String str = hashMap.get(Headers.CONTENT_TYPE);
            String str2 = TextUtils.isEmpty(str) ? hashMap.get("Content-Type") : str;
            boolean z = false;
            if (str2 != null) {
                z = str2.contains("font/ttf");
            }
            if (Build.VERSION.SDK_INT >= 21 && z) {
                return new WebResourceResponse(null, null, 200, "OK", hashMap, inputStream);
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(null, null, inputStream);
            if (Build.VERSION.SDK_INT >= 21) {
                webResourceResponse.setResponseHeaders(hashMap);
                return webResourceResponse;
            }
            Field field = webResourceResponse.getClass().getField("mResponseHeaders");
            field.setAccessible(true);
            field.set(webResourceResponse, hashMap);
            return webResourceResponse;
        }
        return null;
    }
}
