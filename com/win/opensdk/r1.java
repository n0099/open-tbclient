package com.win.opensdk;

import java.io.File;
/* loaded from: classes6.dex */
public class r1 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f37936a;

    public static boolean a() {
        String str;
        boolean z = f37936a;
        if (z) {
            return z;
        }
        String[] split = System.getenv("PATH").split(":");
        int length = split.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str = null;
                break;
            }
            str = split[i2] + "/su";
            if (new File(str).exists()) {
                break;
            }
            i2++;
        }
        boolean z2 = str != null;
        f37936a = z2;
        return z2;
    }
}
