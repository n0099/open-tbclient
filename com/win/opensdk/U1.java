package com.win.opensdk;

import java.io.File;
/* loaded from: classes7.dex */
public class U1 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f39818a;

    public static boolean a() {
        String str;
        boolean z = f39818a;
        if (z) {
            return z;
        }
        String[] split = System.getenv("PATH").split(":");
        int length = split.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = null;
                break;
            }
            str = split[i] + "/su";
            if (new File(str).exists()) {
                break;
            }
            i++;
        }
        boolean z2 = str != null;
        f39818a = z2;
        return z2;
    }
}
