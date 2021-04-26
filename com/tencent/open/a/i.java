package com.tencent.open.a;

import com.tencent.open.a.d;
/* loaded from: classes6.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public volatile int f37204a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f37205b;

    /* renamed from: c  reason: collision with root package name */
    public h f37206c;

    public i() {
        this(c.f37184a, true, h.f37203a);
    }

    public void a(int i2) {
        this.f37204a = i2;
    }

    public abstract void a(int i2, Thread thread, long j, String str, String str2, Throwable th);

    public void b(int i2, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f37204a, i2)) {
            a(i2, thread, j, str, str2, th);
        }
    }

    public boolean d() {
        return this.f37205b;
    }

    public h e() {
        return this.f37206c;
    }

    public i(int i2, boolean z, h hVar) {
        this.f37204a = c.f37184a;
        this.f37205b = true;
        this.f37206c = h.f37203a;
        a(i2);
        a(z);
        a(hVar);
    }

    public void a(boolean z) {
        this.f37205b = z;
    }

    public void a(h hVar) {
        this.f37206c = hVar;
    }
}
