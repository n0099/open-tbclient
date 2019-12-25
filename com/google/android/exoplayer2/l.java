package com.google.android.exoplayer2;

import java.util.HashSet;
/* loaded from: classes4.dex */
public final class l {
    private static final HashSet<String> lUS = new HashSet<>();
    private static String lUT = "goog.exo.core";

    public static synchronized String dqV() {
        String str;
        synchronized (l.class) {
            str = lUT;
        }
        return str;
    }

    public static synchronized void ON(String str) {
        synchronized (l.class) {
            if (lUS.add(str)) {
                lUT += ", " + str;
            }
        }
    }
}
