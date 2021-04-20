package com.win.opensdk.bridge;

import com.win.opensdk.bridge.core.NativeMethodInjectHelper;
/* loaded from: classes7.dex */
public class JsBridge {

    /* renamed from: a  reason: collision with root package name */
    public static volatile JsBridge f40179a;

    public static JsBridge getInstance() {
        JsBridge jsBridge = f40179a;
        if (jsBridge == null) {
            synchronized (JsBridge.class) {
                jsBridge = f40179a;
                if (jsBridge == null) {
                    jsBridge = new JsBridge();
                    f40179a = jsBridge;
                }
            }
        }
        return jsBridge;
    }

    public NativeMethodInjectHelper clazz(Class cls) {
        return NativeMethodInjectHelper.getInstance().clazz(cls);
    }
}
