package com.google.android.exoplayer2;

import java.util.HashSet;
/* loaded from: classes5.dex */
public final class l {
    private static final HashSet<String> lYO = new HashSet<>();
    private static String lYP = "goog.exo.core";

    public static synchronized String dsj() {
        String str;
        synchronized (l.class) {
            str = lYP;
        }
        return str;
    }

    public static synchronized void OY(String str) {
        synchronized (l.class) {
            if (lYO.add(str)) {
                lYP += ", " + str;
            }
        }
    }
}
