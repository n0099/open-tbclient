package com.bytedance.sdk.openadsdk.preload.b;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public abstract class d<IN, OUT> {

    /* renamed from: d  reason: collision with root package name */
    public static AtomicLong f29831d = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    public d f29832a;

    /* renamed from: b  reason: collision with root package name */
    public IN f29833b;

    /* renamed from: c  reason: collision with root package name */
    public OUT f29834c;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f29835e;

    /* renamed from: f  reason: collision with root package name */
    public b f29836f;

    /* renamed from: g  reason: collision with root package name */
    public long f29837g;

    public final void a(b bVar, d dVar, IN in, com.bytedance.sdk.openadsdk.preload.b.b.a aVar, Object[] objArr) {
        this.f29836f = new m(bVar);
        this.f29832a = dVar;
        this.f29833b = in;
        this.f29835e = aVar;
        a();
        a(objArr);
    }

    public void a(Object... objArr) {
    }

    public abstract Object a_(b<OUT> bVar, IN in) throws Throwable;

    public final void b(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29835e;
        if (aVar == null) {
            return;
        }
        aVar.c(this.f29836f, this, th);
    }

    public long c() {
        return this.f29837g;
    }

    public final void d() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29835e;
        if (aVar == null) {
            return;
        }
        aVar.d(this.f29836f, this);
    }

    public final void e() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29835e;
        if (aVar == null) {
            return;
        }
        aVar.f(this.f29836f, this);
    }

    public final void f() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29835e;
        if (aVar == null) {
            return;
        }
        aVar.e(this.f29836f, this);
    }

    public final void c(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29835e;
        if (aVar == null) {
            return;
        }
        aVar.e(this.f29836f, this, th);
    }

    public final void d(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29835e;
        if (aVar == null) {
            return;
        }
        aVar.d(this.f29836f, this, th);
    }

    private void a() {
        d dVar = this.f29832a;
        if (dVar != null) {
            this.f29837g = dVar.f29837g;
            return;
        }
        long andIncrement = f29831d.getAndIncrement();
        this.f29837g = andIncrement;
        if (andIncrement < 0) {
            throw new RuntimeException("Pipeline ID use up!");
        }
    }
}
