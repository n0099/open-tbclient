package com.win.opensdk.bridge.core;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class NativeMethodInjectHelper {
    private static volatile NativeMethodInjectHelper qeO;
    private ArrayMap<String, ArrayMap<String, Method>> qeP = new ArrayMap<>();
    private List<Class<?>> qen = new ArrayList();

    public static NativeMethodInjectHelper eKH() {
        NativeMethodInjectHelper nativeMethodInjectHelper = qeO;
        if (nativeMethodInjectHelper == null) {
            synchronized (NativeMethodInjectHelper.class) {
                nativeMethodInjectHelper = qeO;
                if (nativeMethodInjectHelper == null) {
                    nativeMethodInjectHelper = new NativeMethodInjectHelper();
                    qeO = nativeMethodInjectHelper;
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
        this.qen.add(cls);
        return this;
    }

    public void eKI() {
        Method[] declaredMethods;
        Class<?>[] parameterTypes;
        int size = this.qen.size();
        if (size != 0) {
            this.qeP.clear();
            for (int i = 0; i < size; i++) {
                Class<?> cls = this.qen.get(i);
                if (cls != null) {
                    ArrayMap<String, Method> arrayMap = new ArrayMap<>();
                    for (Method method : cls.getDeclaredMethods()) {
                        int modifiers = method.getModifiers();
                        if ((modifiers & 1) != 0 && (modifiers & 8) != 0 && method.getReturnType() == Void.TYPE && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length == 3 && WebView.class == parameterTypes[0] && JSONObject.class == parameterTypes[1] && JsCallback.class == parameterTypes[2]) {
                            arrayMap.put(method.getName(), method);
                        }
                    }
                    this.qeP.put(cls.getSimpleName(), arrayMap);
                }
            }
            this.qen.clear();
        }
    }

    public Method hx(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (this.qeP.containsKey(str)) {
            ArrayMap<String, Method> arrayMap = this.qeP.get(str);
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
