package com.ss.android.downloadlib.g;

import java.lang.ref.SoftReference;
/* loaded from: classes8.dex */
public class c<P, R> implements Runnable {
    public P a;

    /* renamed from: b  reason: collision with root package name */
    public R f58232b;

    /* renamed from: c  reason: collision with root package name */
    public int f58233c;

    /* renamed from: d  reason: collision with root package name */
    public SoftReference<a<P, R>> f58234d;

    /* renamed from: e  reason: collision with root package name */
    public c<?, P> f58235e;

    /* renamed from: f  reason: collision with root package name */
    public c<R, ?> f58236f;

    /* loaded from: classes8.dex */
    public interface a<PARAM, RESULT> {
        RESULT a(PARAM param);
    }

    public c(int i2, a<P, R> aVar, P p) {
        this.f58233c = i2;
        this.f58234d = new SoftReference<>(aVar);
        this.a = p;
    }

    public static <P, R> c<P, R> a(a<P, R> aVar, P p) {
        return new c<>(2, aVar, p);
    }

    private R b() {
        return this.f58232b;
    }

    @Override // java.lang.Runnable
    public void run() {
        c<?, P> cVar;
        if (this.f58233c == 0 && !l.a()) {
            com.ss.android.downloadlib.f.a().b().post(this);
        } else if (this.f58233c == 1 && l.a()) {
            com.ss.android.downloadlib.d.a().a(this);
        } else if (this.f58233c == 2 && l.a()) {
            com.ss.android.downloadlib.d.a().b(this);
        } else {
            if (this.a == null && (cVar = this.f58235e) != null) {
                this.a = cVar.b();
            }
            a<P, R> aVar = this.f58234d.get();
            if (aVar == null) {
                return;
            }
            this.f58232b = aVar.a(this.a);
            c<R, ?> cVar2 = this.f58236f;
            if (cVar2 != null) {
                cVar2.run();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.ss.android.downloadlib.g.c<P, R> */
    /* JADX WARN: Multi-variable type inference failed */
    public <NR> c<R, NR> a(int i2, a<R, NR> aVar) {
        c cVar = (c<R, ?>) new c(i2, aVar, null);
        this.f58236f = cVar;
        cVar.f58235e = this;
        return cVar;
    }

    public <NR> c<R, NR> a(a<R, NR> aVar) {
        return a(0, aVar);
    }

    public void a() {
        c<?, P> cVar = this.f58235e;
        if (cVar != null) {
            cVar.a();
        } else {
            run();
        }
    }
}
