package com.win.opensdk.bridge;

import com.win.opensdk.bridge.core.NativeMethodInjectHelper;
/* loaded from: classes3.dex */
public class JsBridge {
    private static volatile JsBridge qai;

    private JsBridge() {
    }

    public static JsBridge eGP() {
        JsBridge jsBridge = qai;
        if (jsBridge == null) {
            synchronized (JsBridge.class) {
                jsBridge = qai;
                if (jsBridge == null) {
                    jsBridge = new JsBridge();
                    qai = jsBridge;
                }
            }
        }
        return jsBridge;
    }

    public NativeMethodInjectHelper E(Class<?> cls) {
        return NativeMethodInjectHelper.eGR().E(cls);
    }
}
