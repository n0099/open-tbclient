package com.google.android.exoplayer2;

import java.util.HashSet;
/* loaded from: classes6.dex */
public final class l {
    private static final HashSet<String> lZH = new HashSet<>();
    private static String lZI = "goog.exo.core";

    public static synchronized String dty() {
        String str;
        synchronized (l.class) {
            str = lZI;
        }
        return str;
    }

    public static synchronized void Pm(String str) {
        synchronized (l.class) {
            if (lZH.add(str)) {
                lZI += ", " + str;
            }
        }
    }
}
