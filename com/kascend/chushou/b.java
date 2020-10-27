package com.kascend.chushou;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {
    private static volatile b oXV;

    /* renamed from: a  reason: collision with root package name */
    public boolean f4064a = false;
    public boolean b = false;
    public HashMap<String, String> c = new HashMap<>();
    public int d = -1;
    public boolean e = false;

    private b() {
    }

    public static b eqb() {
        if (oXV == null) {
            synchronized (b.class) {
                oXV = new b();
            }
        }
        return oXV;
    }
}
