package com.win.opensdk.bridge.core;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class NativeMethodInjectHelper {

    /* renamed from: c  reason: collision with root package name */
    public static volatile NativeMethodInjectHelper f37845c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayMap f37846a = new ArrayMap();

    /* renamed from: b  reason: collision with root package name */
    public List f37847b = new ArrayList();

    public static NativeMethodInjectHelper getInstance() {
        NativeMethodInjectHelper nativeMethodInjectHelper = f37845c;
        if (nativeMethodInjectHelper == null) {
            synchronized (NativeMethodInjectHelper.class) {
                nativeMethodInjectHelper = f37845c;
                if (nativeMethodInjectHelper == null) {
                    nativeMethodInjectHelper = new NativeMethodInjectHelper();
                    f37845c = nativeMethodInjectHelper;
                }
            }
        }
        return nativeMethodInjectHelper;
    }

    public NativeMethodInjectHelper clazz(Class cls) {
        if (cls != null) {
            this.f37847b.add(cls);
            return this;
        }
        throw new NullPointerException("NativeMethodInjectHelper:The clazz can not be null!");
    }

    public Method findMethod(String str, String str2) {
        ArrayMap arrayMap;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !this.f37846a.containsKey(str) || (arrayMap = (ArrayMap) this.f37846a.get(str)) == null || !arrayMap.containsKey(str2)) {
            return null;
        }
        return (Method) arrayMap.get(str2);
    }

    public void inject() {
        Method[] declaredMethods;
        Class<?>[] parameterTypes;
        int size = this.f37847b.size();
        if (size != 0) {
            this.f37846a.clear();
            for (int i2 = 0; i2 < size; i2++) {
                Class cls = (Class) this.f37847b.get(i2);
                if (cls != null) {
                    ArrayMap arrayMap = new ArrayMap();
                    for (Method method : cls.getDeclaredMethods()) {
                        int modifiers = method.getModifiers();
                        if ((modifiers & 1) != 0 && (modifiers & 8) != 0 && method.getReturnType() == Void.TYPE && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length == 3 && WebView.class == parameterTypes[0] && JSONObject.class == parameterTypes[1] && JsCallback.class == parameterTypes[2]) {
                            arrayMap.put(method.getName(), method);
                        }
                    }
                    this.f37846a.put(cls.getSimpleName(), arrayMap);
                }
            }
            this.f37847b.clear();
        }
    }
}
