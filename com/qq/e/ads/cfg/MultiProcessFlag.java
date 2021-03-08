package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes4.dex */
public class MultiProcessFlag {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7502a;
    private static boolean b;

    public static boolean isMultiProcess() {
        return f7502a;
    }

    public static void setMultiProcess(boolean z) {
        if (b) {
            GDTLogger.w("MultiProcessFlag has already be setted,reset will not take any effect");
            return;
        }
        b = true;
        f7502a = z;
    }
}
