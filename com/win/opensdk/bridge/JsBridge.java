package com.win.opensdk.bridge;

import com.win.opensdk.bridge.core.NativeMethodInjectHelper;
/* loaded from: classes3.dex */
public class JsBridge {
    private static volatile JsBridge qkM;

    private JsBridge() {
    }

    public static JsBridge eJn() {
        JsBridge jsBridge = qkM;
        if (jsBridge == null) {
            synchronized (JsBridge.class) {
                jsBridge = qkM;
                if (jsBridge == null) {
                    jsBridge = new JsBridge();
                    qkM = jsBridge;
                }
            }
        }
        return jsBridge;
    }

    public NativeMethodInjectHelper E(Class<?> cls) {
        return NativeMethodInjectHelper.eJp().E(cls);
    }
}
