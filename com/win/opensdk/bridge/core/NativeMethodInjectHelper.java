package com.win.opensdk.bridge.core;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class NativeMethodInjectHelper {
    public static volatile NativeMethodInjectHelper c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayMap f8129a = new ArrayMap();
    public List b = new ArrayList();

    public static NativeMethodInjectHelper eJh() {
        NativeMethodInjectHelper nativeMethodInjectHelper = c;
        if (nativeMethodInjectHelper == null) {
            synchronized (NativeMethodInjectHelper.class) {
                nativeMethodInjectHelper = c;
                if (nativeMethodInjectHelper == null) {
                    nativeMethodInjectHelper = new NativeMethodInjectHelper();
                    c = nativeMethodInjectHelper;
                }
            }
        }
        return nativeMethodInjectHelper;
    }

    public NativeMethodInjectHelper E(Class cls) {
        if (cls != null) {
            this.b.add(cls);
            return this;
        }
        throw new NullPointerException("NativeMethodInjectHelper:The clazz can not be null!");
    }

    public void eJi() {
        Method[] declaredMethods;
        Class<?>[] parameterTypes;
        int size = this.b.size();
        if (size != 0) {
            this.f8129a.clear();
            for (int i = 0; i < size; i++) {
                Class cls = (Class) this.b.get(i);
                if (cls != null) {
                    ArrayMap arrayMap = new ArrayMap();
                    for (Method method : cls.getDeclaredMethods()) {
                        int modifiers = method.getModifiers();
                        if ((modifiers & 1) != 0 && (modifiers & 8) != 0 && method.getReturnType() == Void.TYPE && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length == 3 && WebView.class == parameterTypes[0] && JSONObject.class == parameterTypes[1] && JsCallback.class == parameterTypes[2]) {
                            arrayMap.put(method.getName(), method);
                        }
                    }
                    this.f8129a.put(cls.getSimpleName(), arrayMap);
                }
            }
            this.b.clear();
        }
    }

    public Method hE(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (this.f8129a.containsKey(str)) {
            ArrayMap arrayMap = (ArrayMap) this.f8129a.get(str);
            if (arrayMap == null) {
                return null;
            }
            if (arrayMap.containsKey(str2)) {
                return (Method) arrayMap.get(str2);
            }
        }
        return null;
    }
}
