package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes6.dex */
public class MultiProcessFlag {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f38343a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f38344b;

    public static boolean isMultiProcess() {
        return f38343a;
    }

    public static void setMultiProcess(boolean z) {
        if (f38344b) {
            GDTLogger.w("MultiProcessFlag has already be setted,reset will not take any effect");
            return;
        }
        f38344b = true;
        f38343a = z;
    }
}
