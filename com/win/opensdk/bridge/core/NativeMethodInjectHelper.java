package com.win.opensdk.bridge.core;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class NativeMethodInjectHelper {

    /* renamed from: c  reason: collision with root package name */
    public static volatile NativeMethodInjectHelper f40698c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayMap f40699a = new ArrayMap();

    /* renamed from: b  reason: collision with root package name */
    public List f40700b = new ArrayList();

    public static NativeMethodInjectHelper getInstance() {
        NativeMethodInjectHelper nativeMethodInjectHelper = f40698c;
        if (nativeMethodInjectHelper == null) {
            synchronized (NativeMethodInjectHelper.class) {
                nativeMethodInjectHelper = f40698c;
                if (nativeMethodInjectHelper == null) {
                    nativeMethodInjectHelper = new NativeMethodInjectHelper();
                    f40698c = nativeMethodInjectHelper;
                }
            }
        }
        return nativeMethodInjectHelper;
    }

    public NativeMethodInjectHelper clazz(Class cls) {
        if (cls != null) {
            this.f40700b.add(cls);
            return this;
        }
        throw new NullPointerException("NativeMethodInjectHelper:The clazz can not be null!");
    }

    public Method findMethod(String str, String str2) {
        ArrayMap arrayMap;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !this.f40699a.containsKey(str) || (arrayMap = (ArrayMap) this.f40699a.get(str)) == null || !arrayMap.containsKey(str2)) {
            return null;
        }
        return (Method) arrayMap.get(str2);
    }

    public void inject() {
        Method[] declaredMethods;
        Class<?>[] parameterTypes;
        int size = this.f40700b.size();
        if (size != 0) {
            this.f40699a.clear();
            for (int i2 = 0; i2 < size; i2++) {
                Class cls = (Class) this.f40700b.get(i2);
                if (cls != null) {
                    ArrayMap arrayMap = new ArrayMap();
                    for (Method method : cls.getDeclaredMethods()) {
                        int modifiers = method.getModifiers();
                        if ((modifiers & 1) != 0 && (modifiers & 8) != 0 && method.getReturnType() == Void.TYPE && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length == 3 && WebView.class == parameterTypes[0] && JSONObject.class == parameterTypes[1] && JsCallback.class == parameterTypes[2]) {
                            arrayMap.put(method.getName(), method);
                        }
                    }
                    this.f40699a.put(cls.getSimpleName(), arrayMap);
                }
            }
            this.f40700b.clear();
        }
    }
}
