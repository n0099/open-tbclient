package com.kwad.sdk.utils;
/* loaded from: classes4.dex */
public class ay {
    public static volatile ay l;
    public volatile boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f58127b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f58128c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f58129d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f58130e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f58131f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f58132g = 0;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f58133h = 0;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f58134i = 0;

    /* renamed from: j  reason: collision with root package name */
    public volatile long f58135j = -1;
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

    public void a(long j2) {
        this.f58135j = j2;
    }

    public boolean b() {
        return this.f58131f;
    }
}
