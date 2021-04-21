package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes6.dex */
public class MultiProcessFlag {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f38438a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f38439b;

    public static boolean isMultiProcess() {
        return f38438a;
    }

    public static void setMultiProcess(boolean z) {
        if (f38439b) {
            GDTLogger.w("MultiProcessFlag has already be setted,reset will not take any effect");
            return;
        }
        f38439b = true;
        f38438a = z;
    }
}
