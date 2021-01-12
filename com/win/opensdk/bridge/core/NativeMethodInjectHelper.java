package com.win.opensdk.bridge.core;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NativeMethodInjectHelper {
    private static volatile NativeMethodInjectHelper qan;
    private ArrayMap<String, ArrayMap<String, Method>> qao = new ArrayMap<>();
    private List<Class<?>> pZM = new ArrayList();

    public static NativeMethodInjectHelper eGR() {
        NativeMethodInjectHelper nativeMethodInjectHelper = qan;
        if (nativeMethodInjectHelper == null) {
            synchronized (NativeMethodInjectHelper.class) {
                nativeMethodInjectHelper = qan;
                if (nativeMethodInjectHelper == null) {
                    nativeMethodInjectHelper = new NativeMethodInjectHelper();
                    qan = nativeMethodInjectHelper;
                }
            }
        }
        return nativeMethodInjectHelper;
    }

    private NativeMethodInjectHelper() {
    }

    public NativeMethodInjectHelper E(Class<?> cls) {
        if (cls == null) {
            throw new NullPointerException("NativeMethodInjectHelper:The clazz can not be null!");
        }
        this.pZM.add(cls);
        return this;
    }

    public void eGS() {
        Method[] declaredMethods;
        Class<?>[] parameterTypes;
        int size = this.pZM.size();
        if (size != 0) {
            this.qao.clear();
            for (int i = 0; i < size; i++) {
                Class<?> cls = this.pZM.get(i);
                if (cls != null) {
                    ArrayMap<String, Method> arrayMap = new ArrayMap<>();
                    for (Method method : cls.getDeclaredMethods()) {
                        int modifiers = method.getModifiers();
                        if ((modifiers & 1) != 0 && (modifiers & 8) != 0 && method.getReturnType() == Void.TYPE && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length == 3 && WebView.class == parameterTypes[0] && JSONObject.class == parameterTypes[1] && JsCallback.class == parameterTypes[2]) {
                            arrayMap.put(method.getName(), method);
                        }
                    }
                    this.qao.put(cls.getSimpleName(), arrayMap);
                }
            }
            this.pZM.clear();
        }
    }

    public Method hw(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (this.qao.containsKey(str)) {
            ArrayMap<String, Method> arrayMap = this.qao.get(str);
            if (arrayMap == null) {
                return null;
            }
            if (arrayMap.containsKey(str2)) {
                return arrayMap.get(str2);
            }
        }
        return null;
    }
}
