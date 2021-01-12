package com.win.opensdk.bridge;

import com.win.opensdk.bridge.core.NativeMethodInjectHelper;
/* loaded from: classes3.dex */
public class JsBridge {
    private static volatile JsBridge qah;

    private JsBridge() {
    }

    public static JsBridge eGP() {
        JsBridge jsBridge = qah;
        if (jsBridge == null) {
            synchronized (JsBridge.class) {
                jsBridge = qah;
                if (jsBridge == null) {
                    jsBridge = new JsBridge();
                    qah = jsBridge;
                }
            }
        }
        return jsBridge;
    }

    public NativeMethodInjectHelper E(Class<?> cls) {
        return NativeMethodInjectHelper.eGR().E(cls);
    }
}
