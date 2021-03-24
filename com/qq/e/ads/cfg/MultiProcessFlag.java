package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes6.dex */
public class MultiProcessFlag {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f38053a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f38054b;

    public static boolean isMultiProcess() {
        return f38053a;
    }

    public static void setMultiProcess(boolean z) {
        if (f38054b) {
            GDTLogger.w("MultiProcessFlag has already be setted,reset will not take any effect");
            return;
        }
        f38054b = true;
        f38053a = z;
    }
}
