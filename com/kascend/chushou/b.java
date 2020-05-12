package com.kascend.chushou;

import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {
    private static volatile b mnl;
    public boolean a = false;
    public boolean b = false;
    public HashMap<String, String> c = new HashMap<>();
    public int d = -1;
    public boolean e = false;

    private b() {
    }

    public static b dwB() {
        if (mnl == null) {
            synchronized (b.class) {
                mnl = new b();
            }
        }
        return mnl;
    }
}
