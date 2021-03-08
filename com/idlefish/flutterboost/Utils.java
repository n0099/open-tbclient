package com.idlefish.flutterboost;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.alibaba.fastjson.JSON;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class Utils {
    public static void assertCallOnMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Debuger.exception("must call method on main thread");
        }
    }

    public static void fixInputMethodManagerLeak(Context context) {
        InputMethodManager inputMethodManager;
        int i = 0;
        if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        String[] strArr = {"mLastSrvView", "mServedView", "mNextServedView"};
        while (true) {
            int i2 = i;
            if (i2 < strArr.length) {
                try {
                    Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i2]);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(inputMethodManager);
                    if (obj != null && (obj instanceof View)) {
                        if (((View) obj).getContext() == context) {
                            declaredField.set(inputMethodManager, null);
                        } else {
                            return;
                        }
                    }
                } catch (Throwable th) {
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public static String assembleUrl(String str, Map<String, Object> map) {
        String str2;
        StringBuilder sb = new StringBuilder(str);
        if (map != null && !map.isEmpty()) {
            if (!sb.toString().contains("?")) {
                sb.append("?");
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() instanceof Map) {
                    for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                        String str3 = (String) entry2.getKey();
                        if ((entry2.getValue() instanceof Map) || (entry2.getValue() instanceof List)) {
                            try {
                                str2 = URLEncoder.encode(JSON.toJSONString(entry2.getValue()), "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                                str2 = null;
                            }
                        } else {
                            str2 = entry2.getValue() == null ? null : URLEncoder.encode(String.valueOf(entry2.getValue()));
                        }
                        if (str2 != null) {
                            if (sb.toString().endsWith("?")) {
                                sb.append(str3).append("=").append(str2);
                            } else {
                                sb.append(ETAG.ITEM_SEPARATOR).append(str3).append("=").append(str2);
                            }
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
}
