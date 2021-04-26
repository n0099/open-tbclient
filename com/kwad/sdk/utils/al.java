package com.kwad.sdk.utils;
/* loaded from: classes6.dex */
public class al {
    public static volatile al l;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f34861a = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f34862b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f34863c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f34864d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f34865e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f34866f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f34867g = 0;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f34868h = 0;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f34869i = 0;
    public volatile long j = -1;
    public volatile boolean k = false;

    public static al a() {
        if (l == null) {
            synchronized (al.class) {
                if (l == null) {
                    l = new al();
                }
            }
        }
        return l;
    }

    public void a(long j) {
        this.j = j;
    }

    public boolean b() {
        return this.f34866f;
    }
}
