package com.kascend.chushou;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {
    private static volatile b nRo;
    public boolean a = false;
    public boolean b = false;
    public HashMap<String, String> c = new HashMap<>();
    public int d = -1;
    public boolean e = false;

    private b() {
    }

    public static b ecq() {
        if (nRo == null) {
            synchronized (b.class) {
                nRo = new b();
            }
        }
        return nRo;
    }
}
