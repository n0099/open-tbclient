package com.win.opensdk;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class W1 {

    /* renamed from: b  reason: collision with root package name */
    public static W1 f40650b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f40651a = new ConcurrentHashMap();

    public static W1 a() {
        if (f40650b == null) {
            synchronized (W1.class) {
                if (f40650b == null) {
                    f40650b = new W1();
                }
            }
        }
        return f40650b;
    }

    public static String a(String str, String str2, String str3) {
        if (str.length() > 16) {
            str = str.substring(0, 16);
        }
        return str + str2 + str3;
    }

    public U1 a(String str) {
        U1 u1;
        synchronized (W1.class) {
            u1 = (U1) this.f40651a.remove(str);
        }
        return u1;
    }

    public void a(String str, U1 u1) {
        synchronized (W1.class) {
            this.f40651a.put(str, u1);
        }
    }
}
