package com.tencent.open.a;

import com.tencent.open.a.d;
/* loaded from: classes7.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public volatile int f40057a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f40058b;

    /* renamed from: c  reason: collision with root package name */
    public h f40059c;

    public i() {
        this(c.f40037a, true, h.f40056a);
    }

    public void a(int i2) {
        this.f40057a = i2;
    }

    public abstract void a(int i2, Thread thread, long j, String str, String str2, Throwable th);

    public void b(int i2, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f40057a, i2)) {
            a(i2, thread, j, str, str2, th);
        }
    }

    public boolean d() {
        return this.f40058b;
    }

    public h e() {
        return this.f40059c;
    }

    public i(int i2, boolean z, h hVar) {
        this.f40057a = c.f40037a;
        this.f40058b = true;
        this.f40059c = h.f40056a;
        a(i2);
        a(z);
        a(hVar);
    }

    public void a(boolean z) {
        this.f40058b = z;
    }

    public void a(h hVar) {
        this.f40059c = hVar;
    }
}
