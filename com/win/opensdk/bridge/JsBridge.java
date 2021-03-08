package com.win.opensdk.bridge;

import com.win.opensdk.bridge.core.NativeMethodInjectHelper;
/* loaded from: classes14.dex */
public class JsBridge {

    /* renamed from: a  reason: collision with root package name */
    public static volatile JsBridge f8123a;

    public static JsBridge eJf() {
        JsBridge jsBridge = f8123a;
        if (jsBridge == null) {
            synchronized (JsBridge.class) {
                jsBridge = f8123a;
                if (jsBridge == null) {
                    jsBridge = new JsBridge();
                    f8123a = jsBridge;
                }
            }
        }
        return jsBridge;
    }

    public NativeMethodInjectHelper E(Class cls) {
        return NativeMethodInjectHelper.eJh().E(cls);
    }
}
