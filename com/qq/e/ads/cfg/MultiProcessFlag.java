package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes7.dex */
public class MultiProcessFlag {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f38859a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f38860b;

    public static boolean isMultiProcess() {
        return f38859a;
    }

    public static void setMultiProcess(boolean z) {
        if (f38860b) {
            GDTLogger.w("MultiProcessFlag has already be setted,reset will not take any effect");
            return;
        }
        f38860b = true;
        f38859a = z;
    }
}
