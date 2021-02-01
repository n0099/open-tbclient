package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes15.dex */
public class MultiProcessFlag {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f11440a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f11441b;

    public static boolean isMultiProcess() {
        return f11440a;
    }

    public static void setMultiProcess(boolean z) {
        if (f11441b) {
            GDTLogger.w("MultiProcessFlag has already be setted,reset will not take any effect");
            return;
        }
        f11441b = true;
        f11440a = z;
    }
}
