package com.bytedance.sdk.openadsdk.preload.falconx.b;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static WebResourceResponse a(InputStream inputStream, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, inputStream, map)) == null) {
            if (inputStream != null) {
                if (map == null) {
                    try {
                        map = new HashMap<>();
                    } catch (Throwable th) {
                        Log.e("WebResourceUtils", "getResponseWithHeaders error", th);
                    }
                }
                Map<String, String> map2 = map;
                String str = map2.get("content-type");
                if (TextUtils.isEmpty(str)) {
                    str = map2.get("Content-Type");
                }
                boolean contains = str != null ? str.contains("font/ttf") : false;
                if (Build.VERSION.SDK_INT >= 21 && contains) {
                    return new WebResourceResponse(null, null, 200, "OK", map2, inputStream);
                }
                WebResourceResponse webResourceResponse = new WebResourceResponse(null, null, inputStream);
                if (Build.VERSION.SDK_INT >= 21) {
                    webResourceResponse.setResponseHeaders(map2);
                    return webResourceResponse;
                }
                Field field = webResourceResponse.getClass().getField("mResponseHeaders");
                field.setAccessible(true);
                field.set(webResourceResponse, map2);
                return webResourceResponse;
            }
            return null;
        }
        return (WebResourceResponse) invokeLL.objValue;
    }
}
