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
    private static volatile NativeMethodInjectHelper qao;
    private ArrayMap<String, ArrayMap<String, Method>> qap = new ArrayMap<>();
    private List<Class<?>> pZN = new ArrayList();

    public static NativeMethodInjectHelper eGR() {
        NativeMethodInjectHelper nativeMethodInjectHelper = qao;
        if (nativeMethodInjectHelper == null) {
            synchronized (NativeMethodInjectHelper.class) {
                nativeMethodInjectHelper = qao;
                if (nativeMethodInjectHelper == null) {
                    nativeMethodInjectHelper = new NativeMethodInjectHelper();
                    qao = nativeMethodInjectHelper;
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
        this.pZN.add(cls);
        return this;
    }

    public void eGS() {
        Method[] declaredMethods;
        Class<?>[] parameterTypes;
        int size = this.pZN.size();
        if (size != 0) {
            this.qap.clear();
            for (int i = 0; i < size; i++) {
                Class<?> cls = this.pZN.get(i);
                if (cls != null) {
                    ArrayMap<String, Method> arrayMap = new ArrayMap<>();
                    for (Method method : cls.getDeclaredMethods()) {
                        int modifiers = method.getModifiers();
                        if ((modifiers & 1) != 0 && (modifiers & 8) != 0 && method.getReturnType() == Void.TYPE && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length == 3 && WebView.class == parameterTypes[0] && JSONObject.class == parameterTypes[1] && JsCallback.class == parameterTypes[2]) {
                            arrayMap.put(method.getName(), method);
                        }
                    }
                    this.qap.put(cls.getSimpleName(), arrayMap);
                }
            }
            this.pZN.clear();
        }
    }

    public Method hw(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (this.qap.containsKey(str)) {
            ArrayMap<String, Method> arrayMap = this.qap.get(str);
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
