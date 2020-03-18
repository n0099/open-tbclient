package com.google.android.exoplayer2;

import java.util.HashSet;
/* loaded from: classes6.dex */
public final class l {
    private static final HashSet<String> mbq = new HashSet<>();
    private static String mbr = "goog.exo.core";

    public static synchronized String dtV() {
        String str;
        synchronized (l.class) {
            str = mbr;
        }
        return str;
    }

    public static synchronized void Pl(String str) {
        synchronized (l.class) {
            if (mbq.add(str)) {
                mbr += ", " + str;
            }
        }
    }
}
