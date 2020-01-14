package com.kascend.chushou;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {
    private static volatile b mNZ;
    public boolean a = false;
    public boolean b = false;
    public HashMap<String, String> c = new HashMap<>();
    public int d = -1;
    public boolean e = false;

    private b() {
    }

    public static b dAF() {
        if (mNZ == null) {
            synchronized (b.class) {
                mNZ = new b();
            }
        }
        return mNZ;
    }
}
