package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes6.dex */
public class MultiProcessFlag {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f36006a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f36007b;

    public static boolean isMultiProcess() {
        return f36006a;
    }

    public static void setMultiProcess(boolean z) {
        if (f36007b) {
            GDTLogger.w("MultiProcessFlag has already be setted,reset will not take any effect");
            return;
        }
        f36007b = true;
        f36006a = z;
    }
}
