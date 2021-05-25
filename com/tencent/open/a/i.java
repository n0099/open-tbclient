package com.tencent.open.a;

import com.tencent.open.a.d;
/* loaded from: classes7.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public volatile int f36378a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f36379b;

    /* renamed from: c  reason: collision with root package name */
    public h f36380c;

    public i() {
        this(c.f36358a, true, h.f36377a);
    }

    public void a(int i2) {
        this.f36378a = i2;
    }

    public abstract void a(int i2, Thread thread, long j, String str, String str2, Throwable th);

    public void b(int i2, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f36378a, i2)) {
            a(i2, thread, j, str, str2, th);
        }
    }

    public boolean d() {
        return this.f36379b;
    }

    public h e() {
        return this.f36380c;
    }

    public i(int i2, boolean z, h hVar) {
        this.f36378a = c.f36358a;
        this.f36379b = true;
        this.f36380c = h.f36377a;
        a(i2);
        a(z);
        a(hVar);
    }

    public void a(boolean z) {
        this.f36379b = z;
    }

    public void a(h hVar) {
        this.f36380c = hVar;
    }
}
