package com.win.opensdk;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes14.dex */
public class j {
    public static j qki;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f8167a = new ConcurrentHashMap();

    public static String a(String str, String str2, String str3) {
        if (str.length() > 16) {
            str = str.substring(0, 16);
        }
        return str + str2 + str3;
    }

    public static j eIX() {
        if (qki == null) {
            synchronized (j.class) {
                if (qki == null) {
                    qki = new j();
                }
            }
        }
        return qki;
    }

    public void a(String str, fe feVar) {
        synchronized (j.class) {
            this.f8167a.put(str, feVar);
        }
    }

    public fe abV(String str) {
        fe feVar;
        synchronized (j.class) {
            feVar = (fe) this.f8167a.remove(str);
        }
        return feVar;
    }
}
