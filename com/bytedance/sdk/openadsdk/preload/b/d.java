package com.bytedance.sdk.openadsdk.preload.b;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public abstract class d<IN, OUT> {

    /* renamed from: d  reason: collision with root package name */
    public static AtomicLong f30146d = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    public d f30147a;

    /* renamed from: b  reason: collision with root package name */
    public IN f30148b;

    /* renamed from: c  reason: collision with root package name */
    public OUT f30149c;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f30150e;

    /* renamed from: f  reason: collision with root package name */
    public b f30151f;

    /* renamed from: g  reason: collision with root package name */
    public long f30152g;

    public final void a(b bVar, d dVar, IN in, com.bytedance.sdk.openadsdk.preload.b.b.a aVar, Object[] objArr) {
        this.f30151f = new m(bVar);
        this.f30147a = dVar;
        this.f30148b = in;
        this.f30150e = aVar;
        a();
        a(objArr);
    }

    public void a(Object... objArr) {
    }

    public abstract Object a_(b<OUT> bVar, IN in) throws Throwable;

    public final void b(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30150e;
        if (aVar == null) {
            return;
        }
        aVar.c(this.f30151f, this, th);
    }

    public long c() {
        return this.f30152g;
    }

    public final void d() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30150e;
        if (aVar == null) {
            return;
        }
        aVar.d(this.f30151f, this);
    }

    public final void e() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30150e;
        if (aVar == null) {
            return;
        }
        aVar.f(this.f30151f, this);
    }

    public final void f() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30150e;
        if (aVar == null) {
            return;
        }
        aVar.e(this.f30151f, this);
    }

    public final void c(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30150e;
        if (aVar == null) {
            return;
        }
        aVar.e(this.f30151f, this, th);
    }

    public final void d(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30150e;
        if (aVar == null) {
            return;
        }
        aVar.d(this.f30151f, this, th);
    }

    private void a() {
        d dVar = this.f30147a;
        if (dVar != null) {
            this.f30152g = dVar.f30152g;
            return;
        }
        long andIncrement = f30146d.getAndIncrement();
        this.f30152g = andIncrement;
        if (andIncrement < 0) {
            throw new RuntimeException("Pipeline ID use up!");
        }
    }
}
