package com.google.android.exoplayer2;

import java.util.HashSet;
/* loaded from: classes5.dex */
public final class l {
    private static final HashSet<String> lYJ = new HashSet<>();
    private static String lYK = "goog.exo.core";

    public static synchronized String dsh() {
        String str;
        synchronized (l.class) {
            str = lYK;
        }
        return str;
    }

    public static synchronized void OY(String str) {
        synchronized (l.class) {
            if (lYJ.add(str)) {
                lYK += ", " + str;
            }
        }
    }
}
