package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes5.dex */
public class MultiProcessFlag {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f35251a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f35252b;

    public static boolean isMultiProcess() {
        return f35251a;
    }

    public static void setMultiProcess(boolean z) {
        if (f35252b) {
            GDTLogger.w("MultiProcessFlag has already be setted,reset will not take any effect");
            return;
        }
        f35252b = true;
        f35251a = z;
    }
}
