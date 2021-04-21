package com.bytedance.sdk.openadsdk.preload.b;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public abstract class d<IN, OUT> {

    /* renamed from: d  reason: collision with root package name */
    public static AtomicLong f29839d = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    public d f29840a;

    /* renamed from: b  reason: collision with root package name */
    public IN f29841b;

    /* renamed from: c  reason: collision with root package name */
    public OUT f29842c;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f29843e;

    /* renamed from: f  reason: collision with root package name */
    public b f29844f;

    /* renamed from: g  reason: collision with root package name */
    public long f29845g;

    public final void a(b bVar, d dVar, IN in, com.bytedance.sdk.openadsdk.preload.b.b.a aVar, Object[] objArr) {
        this.f29844f = new m(bVar);
        this.f29840a = dVar;
        this.f29841b = in;
        this.f29843e = aVar;
        a();
        a(objArr);
    }

    public void a(Object... objArr) {
    }

    public abstract Object a_(b<OUT> bVar, IN in) throws Throwable;

    public final void b(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29843e;
        if (aVar == null) {
            return;
        }
        aVar.c(this.f29844f, this, th);
    }

    public long c() {
        return this.f29845g;
    }

    public final void d() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29843e;
        if (aVar == null) {
            return;
        }
        aVar.d(this.f29844f, this);
    }

    public final void e() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29843e;
        if (aVar == null) {
            return;
        }
        aVar.f(this.f29844f, this);
    }

    public final void f() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29843e;
        if (aVar == null) {
            return;
        }
        aVar.e(this.f29844f, this);
    }

    public final void c(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29843e;
        if (aVar == null) {
            return;
        }
        aVar.e(this.f29844f, this, th);
    }

    public final void d(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar = this.f29843e;
        if (aVar == null) {
            return;
        }
        aVar.d(this.f29844f, this, th);
    }

    private void a() {
        d dVar = this.f29840a;
        if (dVar != null) {
            this.f29845g = dVar.f29845g;
            return;
        }
        long andIncrement = f29839d.getAndIncrement();
        this.f29845g = andIncrement;
        if (andIncrement < 0) {
            throw new RuntimeException("Pipeline ID use up!");
        }
    }
}
