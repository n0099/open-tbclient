package com.kascend.chushou;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {
    private static volatile b phq;

    /* renamed from: a  reason: collision with root package name */
    public boolean f4066a = false;
    public boolean b = false;
    public HashMap<String, String> c = new HashMap<>();
    public int d = -1;
    public boolean e = false;

    private b() {
    }

    public static b etQ() {
        if (phq == null) {
            synchronized (b.class) {
                phq = new b();
            }
        }
        return phq;
    }
}
