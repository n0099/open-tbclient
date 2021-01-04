package com.win.opensdk.bridge;

import com.win.opensdk.bridge.core.NativeMethodInjectHelper;
/* loaded from: classes4.dex */
public class JsBridge {
    private static volatile JsBridge qda;

    private JsBridge() {
    }

    public static JsBridge eKb() {
        JsBridge jsBridge = qda;
        if (jsBridge == null) {
            synchronized (JsBridge.class) {
                jsBridge = qda;
                if (jsBridge == null) {
                    jsBridge = new JsBridge();
                    qda = jsBridge;
                }
            }
        }
        return jsBridge;
    }

    public NativeMethodInjectHelper E(Class<?> cls) {
        return NativeMethodInjectHelper.eKd().E(cls);
    }
}
