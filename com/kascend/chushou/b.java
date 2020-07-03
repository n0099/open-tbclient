package com.kascend.chushou;

import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {
    private static volatile b nev;
    public boolean a = false;
    public boolean b = false;
    public HashMap<String, String> c = new HashMap<>();
    public int d = -1;
    public boolean e = false;

    private b() {
    }

    public static b dII() {
        if (nev == null) {
            synchronized (b.class) {
                nev = new b();
            }
        }
        return nev;
    }
}
