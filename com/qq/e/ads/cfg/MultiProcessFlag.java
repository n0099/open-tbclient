package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes7.dex */
public class MultiProcessFlag {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f35180a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f35181b;

    public static boolean isMultiProcess() {
        return f35180a;
    }

    public static void setMultiProcess(boolean z) {
        if (f35181b) {
            GDTLogger.w("MultiProcessFlag has already be setted,reset will not take any effect");
            return;
        }
        f35181b = true;
        f35180a = z;
    }
}
