package com.google.android.exoplayer2;

import java.util.HashSet;
/* loaded from: classes6.dex */
public final class l {
    private static final HashSet<String> lZw = new HashSet<>();
    private static String lZx = "goog.exo.core";

    public static synchronized String dtx() {
        String str;
        synchronized (l.class) {
            str = lZx;
        }
        return str;
    }

    public static synchronized void Pl(String str) {
        synchronized (l.class) {
            if (lZw.add(str)) {
                lZx += ", " + str;
            }
        }
    }
}
