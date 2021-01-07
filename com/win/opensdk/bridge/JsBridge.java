package com.win.opensdk.bridge;

import com.win.opensdk.bridge.core.NativeMethodInjectHelper;
/* loaded from: classes4.dex */
public class JsBridge {
    private static volatile JsBridge qeI;

    private JsBridge() {
    }

    public static JsBridge eKF() {
        JsBridge jsBridge = qeI;
        if (jsBridge == null) {
            synchronized (JsBridge.class) {
                jsBridge = qeI;
                if (jsBridge == null) {
                    jsBridge = new JsBridge();
                    qeI = jsBridge;
                }
            }
        }
        return jsBridge;
    }

    public NativeMethodInjectHelper E(Class<?> cls) {
        return NativeMethodInjectHelper.eKH().E(cls);
    }
}
