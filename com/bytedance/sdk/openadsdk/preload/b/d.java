package com.bytedance.sdk.openadsdk.preload.b;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public abstract class d<IN, OUT> {
    private static AtomicLong d = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    d f5041a;
    IN b;
    OUT c;
    private com.bytedance.sdk.openadsdk.preload.b.b.a e;
    private b f;
    private long g;

    public abstract Object a_(b<OUT> bVar, IN in) throws Throwable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(b bVar, d dVar, IN in, com.bytedance.sdk.openadsdk.preload.b.b.a aVar, Object[] objArr) {
        this.f = new m(bVar);
        this.f5041a = dVar;
        this.b = in;
        this.e = aVar;
        a();
        a(objArr);
    }

    private void a() {
        if (this.f5041a != null) {
            this.g = this.f5041a.g;
            return;
        }
        this.g = d.getAndIncrement();
        if (this.g < 0) {
            throw new RuntimeException("Pipeline ID use up!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Object... objArr) {
    }

    public long c() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        if (this.e != null) {
            this.e.d(this.f, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        if (this.e != null) {
            this.e.f(this.f, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f() {
        if (this.e != null) {
            this.e.e(this.f, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Throwable th) {
        if (this.e != null) {
            this.e.c(this.f, this, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(Throwable th) {
        if (this.e != null) {
            this.e.e(this.f, this, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(Throwable th) {
        if (this.e != null) {
            this.e.d(this.f, this, th);
        }
    }
}
