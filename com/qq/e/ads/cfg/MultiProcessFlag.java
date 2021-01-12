package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes3.dex */
public class MultiProcessFlag {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f11438a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f11439b;

    public static boolean isMultiProcess() {
        return f11438a;
    }

    public static void setMultiProcess(boolean z) {
        if (f11439b) {
            GDTLogger.w("MultiProcessFlag has already be setted,reset will not take any effect");
            return;
        }
        f11439b = true;
        f11438a = z;
    }
}
