package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes7.dex */
public class MultiProcessFlag {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f38957a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f38958b;

    public static boolean isMultiProcess() {
        return f38957a;
    }

    public static void setMultiProcess(boolean z) {
        if (f38958b) {
            GDTLogger.w("MultiProcessFlag has already be setted,reset will not take any effect");
            return;
        }
        f38958b = true;
        f38957a = z;
    }
}
