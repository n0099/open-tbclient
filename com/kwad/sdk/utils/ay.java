package com.kwad.sdk.utils;
/* loaded from: classes3.dex */
public class ay {
    public static volatile ay l;
    public volatile boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f57915b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f57916c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f57917d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f57918e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f57919f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f57920g = 0;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f57921h = 0;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f57922i = 0;

    /* renamed from: j  reason: collision with root package name */
    public volatile long f57923j = -1;
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
        this.f57923j = j2;
    }

    public boolean b() {
        return this.f57919f;
    }
}
