package com.kwad.sdk.utils;
/* loaded from: classes7.dex */
public class ay {
    public static volatile ay l;
    public volatile boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f41366b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f41367c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f41368d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f41369e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f41370f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f41371g = 0;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f41372h = 0;
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
        return this.f41370f;
    }
}
