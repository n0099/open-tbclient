package com.bytedance.sdk.openadsdk.preload.b;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public abstract class d<IN, OUT> {

    /* renamed from: d  reason: collision with root package name */
    public static AtomicLong f29997d = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    public d f29998a;

    /* renamed from: b  reason: collision with root package name */
    public IN f29999b;

    /* renamed from: c  reason: collision with root package name */
    public OUT f30000c;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f30001e;

    /* renamed from: f  reason: collision with root package name */
    public b f30002f;

    /* renamed from: g  reason: collision with root package name */
    public long f30003g;

    public final void a(b bVar, d dVar, IN in, com.bytedance.sdk.openadsdk.preload.b.b.a aVar, Object[] objArr) {
        this.f30002f = new m(bVar);
        this.f29998a = dVar;
        this.f29999b = in;
        this.f30001e = aVar;
        a();
        a(objArr);
    }

    public void a(Object... objArr) {
    }

    public abstract Object a_(b<OUT> bVar, IN in) throws Throwable;

    public final void b(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30001e;
        if (aVar == null) {
            return;
        }
        aVar.c(this.f30002f, this, th);
    }

    public long c() {
        return this.f30003g;
    }

    public final void d() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30001e;
        if (aVar == null) {
            return;
        }
        aVar.d(this.f30002f, this);
    }

    public final void e() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30001e;
        if (aVar == null) {
            return;
        }
        aVar.f(this.f30002f, this);
    }

    public final void f() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30001e;
        if (aVar == null) {
            return;
        }
        aVar.e(this.f30002f, this);
    }

    public final void c(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30001e;
        if (aVar == null) {
            return;
        }
        aVar.e(this.f30002f, this, th);
    }

    public final void d(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f30001e;
        if (aVar == null) {
            return;
        }
        aVar.d(this.f30002f, this, th);
    }

    private void a() {
        d dVar = this.f29998a;
        if (dVar != null) {
            this.f30003g = dVar.f30003g;
            return;
        }
        long andIncrement = f29997d.getAndIncrement();
        this.f30003g = andIncrement;
        if (andIncrement < 0) {
            throw new RuntimeException("Pipeline ID use up!");
        }
    }
}
