package com.kwad.sdk.utils;
/* loaded from: classes5.dex */
public class ay {
    public static volatile ay l;
    public volatile boolean a = false;
    public volatile boolean b = false;
    public volatile boolean c = false;
    public volatile boolean d = false;
    public volatile boolean e = false;
    public volatile boolean f = false;
    public volatile long g = 0;
    public volatile long h = 0;
    public volatile long i = 0;
    public volatile long j = -1;
    public volatile boolean k = false;

    public static ay a() {
        if (l == null) {
            synchronized (ay.class) {
                if (l == null) {
                    l = new ay();
                }
            }
        }
        return l;
    }

    public void a(long j) {
        this.j = j;
    }

    public boolean b() {
        return this.f;
    }
}
