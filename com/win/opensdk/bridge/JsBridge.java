package com.win.opensdk.bridge;

import com.win.opensdk.bridge.core.NativeMethodInjectHelper;
/* loaded from: classes3.dex */
public class JsBridge {
    private static volatile JsBridge qkm;

    private JsBridge() {
    }

    public static JsBridge eJf() {
        JsBridge jsBridge = qkm;
        if (jsBridge == null) {
            synchronized (JsBridge.class) {
                jsBridge = qkm;
                if (jsBridge == null) {
                    jsBridge = new JsBridge();
                    qkm = jsBridge;
                }
            }
        }
        return jsBridge;
    }

    public NativeMethodInjectHelper E(Class<?> cls) {
        return NativeMethodInjectHelper.eJh().E(cls);
    }
}
