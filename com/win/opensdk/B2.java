package com.win.opensdk;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class B2 {

    /* renamed from: b  reason: collision with root package name */
    public static B2 f39632b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f39633a = new ConcurrentHashMap();

    public static B2 a() {
        if (f39632b == null) {
            synchronized (B2.class) {
                if (f39632b == null) {
                    f39632b = new B2();
                }
            }
        }
        return f39632b;
    }

    public static String a(String str, String str2, String str3) {
        if (str.length() > 16) {
            str = str.substring(0, 16);
        }
        return str + str2 + str3;
    }

    public z2 a(String str) {
        z2 z2Var;
        synchronized (B2.class) {
            z2Var = (z2) this.f39633a.remove(str);
        }
        return z2Var;
    }

    public void a(String str, z2 z2Var) {
        synchronized (B2.class) {
            this.f39633a.put(str, z2Var);
        }
    }
}
