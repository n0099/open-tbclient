package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes4.dex */
public class MultiProcessFlag {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f11738a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f11739b;

    public static boolean isMultiProcess() {
        return f11738a;
    }

    public static void setMultiProcess(boolean z) {
        if (f11739b) {
            GDTLogger.w("MultiProcessFlag has already be setted,reset will not take any effect");
            return;
        }
        f11739b = true;
        f11738a = z;
    }
}
