package com.bytedance.sdk.openadsdk.preload.b;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public abstract class d<IN, OUT> {

    /* renamed from: d  reason: collision with root package name */
    public static AtomicLong f29926d = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    public d f29927a;

    /* renamed from: b  reason: collision with root package name */
    public IN f29928b;

    /* renamed from: c  reason: collision with root package name */
    public OUT f29929c;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f29930e;

    /* renamed from: f  reason: collision with root package name */
    public b f29931f;

    /* renamed from: g  reason: collision with root package name */
    public long f29932g;

    public final void a(b bVar, d dVar, IN in, com.bytedance.sdk.openadsdk.preload.b.b.a aVar, Object[] objArr) {
        this.f29931f = new m(bVar);
        this.f29927a = dVar;
        this.f29928b = in;
        this.f29930e = aVar;
        a();
        a(objArr);
    }

    public void a(Object... objArr) {
    }

    public abstract Object a_(b<OUT> bVar, IN in) throws Throwable;

    public final void b(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29930e;
        if (aVar == null) {
            return;
        }
        aVar.c(this.f29931f, this, th);
    }

    public long c() {
        return this.f29932g;
    }

    public final void d() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29930e;
        if (aVar == null) {
            return;
        }
        aVar.d(this.f29931f, this);
    }

    public final void e() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29930e;
        if (aVar == null) {
            return;
        }
        aVar.f(this.f29931f, this);
    }

    public final void f() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29930e;
        if (aVar == null) {
            return;
        }
        aVar.e(this.f29931f, this);
    }

    public final void c(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29930e;
        if (aVar == null) {
            return;
        }
        aVar.e(this.f29931f, this, th);
    }

    public final void d(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29930e;
        if (aVar == null) {
            return;
        }
        aVar.d(this.f29931f, this, th);
    }

    private void a() {
        d dVar = this.f29927a;
        if (dVar != null) {
            this.f29932g = dVar.f29932g;
            return;
        }
        long andIncrement = f29926d.getAndIncrement();
        this.f29932g = andIncrement;
        if (andIncrement < 0) {
            throw new RuntimeException("Pipeline ID use up!");
        }
    }
}
