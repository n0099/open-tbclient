package com.google.android.exoplayer2;

import java.util.HashSet;
/* loaded from: classes6.dex */
public final class l {
    private static final HashSet<String> lZu = new HashSet<>();
    private static String lZv = "goog.exo.core";

    public static synchronized String dtv() {
        String str;
        synchronized (l.class) {
            str = lZv;
        }
        return str;
    }

    public static synchronized void Pl(String str) {
        synchronized (l.class) {
            if (lZu.add(str)) {
                lZv += ", " + str;
            }
        }
    }
}
