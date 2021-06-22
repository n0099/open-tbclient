package com.win.opensdk;

import java.io.File;
/* loaded from: classes7.dex */
public class r1 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f40892a;

    public static boolean a() {
        String str;
        boolean z = f40892a;
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
        f40892a = z2;
        return z2;
    }
}
