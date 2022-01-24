package com.kwad.sdk.utils;
/* loaded from: classes3.dex */
public class ay {
    public static volatile ay l;
    public volatile boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f57960b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f57961c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f57962d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f57963e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f57964f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f57965g = 0;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f57966h = 0;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f57967i = 0;

    /* renamed from: j  reason: collision with root package name */
    public volatile long f57968j = -1;
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
        this.f57968j = j2;
    }

    public boolean b() {
        return this.f57964f;
    }
}
