package com.win.opensdk;

import java.io.File;
/* loaded from: classes14.dex */
public class bn {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8120a;

    public static boolean a() {
        String[] split;
        String str;
        boolean z = f8120a;
        if (z) {
            return z;
        }
        int length = System.getenv("PATH").split(":").length;
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
        f8120a = str != null;
        return f8120a;
    }
}
