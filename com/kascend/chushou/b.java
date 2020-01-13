package com.kascend.chushou;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class b {
    private static volatile b mNU;
    public boolean a = false;
    public boolean b = false;
    public HashMap<String, String> c = new HashMap<>();
    public int d = -1;
    public boolean e = false;

    private b() {
    }

    public static b dAD() {
        if (mNU == null) {
            synchronized (b.class) {
                mNU = new b();
            }
        }
        return mNU;
    }
}
