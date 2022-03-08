package com.kwad.sdk.utils;
/* loaded from: classes8.dex */
public class ay {
    public static volatile ay l;
    public volatile boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f56477b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f56478c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f56479d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f56480e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f56481f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f56482g = 0;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f56483h = 0;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f56484i = 0;

    /* renamed from: j  reason: collision with root package name */
    public volatile long f56485j = -1;
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
        this.f56485j = j2;
    }

    public boolean b() {
        return this.f56481f;
    }
}
