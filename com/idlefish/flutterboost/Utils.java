package com.idlefish.flutterboost;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.alibaba.fastjson.JSON;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class Utils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String assembleUrl(String str, Map<String, Object> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, map)) == null) {
            StringBuilder sb = new StringBuilder(str);
            if (map != null && !map.isEmpty()) {
                if (!sb.toString().contains("?")) {
                    sb.append("?");
                }
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getValue() instanceof Map) {
                        for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                            String str2 = (String) entry2.getKey();
                            String str3 = null;
                            if (!(entry2.getValue() instanceof Map) && !(entry2.getValue() instanceof List)) {
                                if (entry2.getValue() != null) {
                                    str3 = URLEncoder.encode(String.valueOf(entry2.getValue()));
                                }
                            } else {
                                try {
                                    str3 = URLEncoder.encode(JSON.toJSONString(entry2.getValue()), "UTF-8");
                                } catch (UnsupportedEncodingException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (str3 != null) {
                                if (sb.toString().endsWith("?")) {
                                    sb.append(str2);
                                    sb.append("=");
                                    sb.append(str3);
                                } else {
                                    sb.append("&");
                                    sb.append(str2);
                                    sb.append("=");
                                    sb.append(str3);
                                }
                            }
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static void assertCallOnMainThread() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        Debuger.exception("must call method on main thread");
    }

    public static void fixInputMethodManagerLeak(Context context) {
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, context) == null) || context == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        String[] strArr = {"mLastSrvView", "mServedView", "mNextServedView"};
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i2]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if (obj != null && (obj instanceof View)) {
                    if (((View) obj).getContext() != context) {
                        return;
                    }
                    declaredField.set(inputMethodManager, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
