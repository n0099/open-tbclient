package com.win.opensdk;

import java.io.File;
/* loaded from: classes4.dex */
public class ay {
    public static final String java = ay.class.getSimpleName();
    private static boolean qbE;

    public static boolean java() {
        String[] split;
        String str;
        if (qbE) {
            return qbE;
        }
        int length = System.getenv("PATH").split(":").length;
        int i = 0;
        while (true) {
            if (i < length) {
                str = split[i] + "/su";
                if (new File(str).exists()) {
                    break;
                }
                i++;
            } else {
                str = null;
                break;
            }
        }
        boolean z = str != null;
        qbE = z;
        return z;
    }
}
