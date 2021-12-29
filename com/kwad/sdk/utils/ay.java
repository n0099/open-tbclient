package com.kwad.sdk.utils;
/* loaded from: classes3.dex */
public class ay {
    public static volatile ay l;
    public volatile boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f60200b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f60201c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f60202d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f60203e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f60204f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f60205g = 0;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f60206h = 0;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f60207i = 0;

    /* renamed from: j  reason: collision with root package name */
    public volatile long f60208j = -1;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f60209k = false;

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
        this.f60208j = j2;
    }

    public boolean b() {
        return this.f60204f;
    }
}
