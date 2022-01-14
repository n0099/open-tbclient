package com.ss.android.downloadlib.g;

import java.lang.ref.SoftReference;
/* loaded from: classes3.dex */
public class c<P, R> implements Runnable {
    public P a;

    /* renamed from: b  reason: collision with root package name */
    public R f59670b;

    /* renamed from: c  reason: collision with root package name */
    public int f59671c;

    /* renamed from: d  reason: collision with root package name */
    public SoftReference<a<P, R>> f59672d;

    /* renamed from: e  reason: collision with root package name */
    public c<?, P> f59673e;

    /* renamed from: f  reason: collision with root package name */
    public c<R, ?> f59674f;

    /* loaded from: classes3.dex */
    public interface a<PARAM, RESULT> {
        RESULT a(PARAM param);
    }

    public c(int i2, a<P, R> aVar, P p) {
        this.f59671c = i2;
        this.f59672d = new SoftReference<>(aVar);
        this.a = p;
    }

    public static <P, R> c<P, R> a(a<P, R> aVar, P p) {
        return new c<>(2, aVar, p);
    }

    private R b() {
        return this.f59670b;
    }

    @Override // java.lang.Runnable
    public void run() {
        c<?, P> cVar;
        if (this.f59671c == 0 && !l.a()) {
            com.ss.android.downloadlib.f.a().b().post(this);
        } else if (this.f59671c == 1 && l.a()) {
            com.ss.android.downloadlib.d.a().a(this);
        } else if (this.f59671c == 2 && l.a()) {
            com.ss.android.downloadlib.d.a().b(this);
        } else {
            if (this.a == null && (cVar = this.f59673e) != null) {
                this.a = cVar.b();
            }
            a<P, R> aVar = this.f59672d.get();
            if (aVar == null) {
                return;
            }
            this.f59670b = aVar.a(this.a);
            c<R, ?> cVar2 = this.f59674f;
            if (cVar2 != null) {
                cVar2.run();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.ss.android.downloadlib.g.c<P, R> */
    /* JADX WARN: Multi-variable type inference failed */
    public <NR> c<R, NR> a(int i2, a<R, NR> aVar) {
        c cVar = (c<R, ?>) new c(i2, aVar, null);
        this.f59674f = cVar;
        cVar.f59673e = this;
        return cVar;
    }

    public <NR> c<R, NR> a(a<R, NR> aVar) {
        return a(0, aVar);
    }

    public void a() {
        c<?, P> cVar = this.f59673e;
        if (cVar != null) {
            cVar.a();
        } else {
            run();
        }
    }
}
