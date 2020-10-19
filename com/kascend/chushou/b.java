package com.kascend.chushou;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {
    private static volatile b ogG;

    /* renamed from: a  reason: collision with root package name */
    public boolean f4066a = false;
    public boolean b = false;
    public HashMap<String, String> c = new HashMap<>();
    public int d = -1;
    public boolean e = false;

    private b() {
    }

    public static b egb() {
        if (ogG == null) {
            synchronized (b.class) {
                ogG = new b();
            }
        }
        return ogG;
    }
}
