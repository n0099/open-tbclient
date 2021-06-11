package com.bytedance.sdk.openadsdk.preload.b;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public abstract class d<IN, OUT> {

    /* renamed from: d  reason: collision with root package name */
    public static AtomicLong f30029d = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    public d f30030a;

    /* renamed from: b  reason: collision with root package name */
    public IN f30031b;

    /* renamed from: c  reason: collision with root package name */
    public OUT f30032c;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f30033e;

    /* renamed from: f  reason: collision with root package name */
    public b f30034f;

    /* renamed from: g  reason: collision with root package name */
    public long f30035g;

    public final void a(b bVar, d dVar, IN in, com.bytedance.sdk.openadsdk.preload.b.b.a aVar, Object[] objArr) {
        this.f30034f = new m(bVar);
        this.f30030a = dVar;
        this.f30031b = in;
        this.f30033e = aVar;
        a();
        a(objArr);
    }

    public void a(Object... objArr) {
    }

    public abstract Object a_(b<OUT> bVar, IN in) throws Throwable;

    public final void b(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30033e;
        if (aVar == null) {
            return;
        }
        aVar.c(this.f30034f, this, th);
    }

    public long c() {
        return this.f30035g;
    }

    public final void d() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30033e;
        if (aVar == null) {
            return;
        }
        aVar.d(this.f30034f, this);
    }

    public final void e() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30033e;
        if (aVar == null) {
            return;
        }
        aVar.f(this.f30034f, this);
    }

    public final void f() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30033e;
        if (aVar == null) {
            return;
        }
        aVar.e(this.f30034f, this);
    }

    public final void c(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30033e;
        if (aVar == null) {
            return;
        }
        aVar.e(this.f30034f, this, th);
    }

    public final void d(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30033e;
        if (aVar == null) {
            return;
        }
        aVar.d(this.f30034f, this, th);
    }

    private void a() {
        d dVar = this.f30030a;
        if (dVar != null) {
            this.f30035g = dVar.f30035g;
            return;
        }
        long andIncrement = f30029d.getAndIncrement();
        this.f30035g = andIncrement;
        if (andIncrement < 0) {
            throw new RuntimeException("Pipeline ID use up!");
        }
    }
}
