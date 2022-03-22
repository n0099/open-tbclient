package com.ss.android.downloadlib.g;

import java.lang.ref.SoftReference;
/* loaded from: classes7.dex */
public class c<P, R> implements Runnable {
    public P a;

    /* renamed from: b  reason: collision with root package name */
    public R f42972b;

    /* renamed from: c  reason: collision with root package name */
    public int f42973c;

    /* renamed from: d  reason: collision with root package name */
    public SoftReference<a<P, R>> f42974d;

    /* renamed from: e  reason: collision with root package name */
    public c<?, P> f42975e;

    /* renamed from: f  reason: collision with root package name */
    public c<R, ?> f42976f;

    /* loaded from: classes7.dex */
    public interface a<PARAM, RESULT> {
        RESULT a(PARAM param);
    }

    public c(int i, a<P, R> aVar, P p) {
        this.f42973c = i;
        this.f42974d = new SoftReference<>(aVar);
        this.a = p;
    }

    public static <P, R> c<P, R> a(a<P, R> aVar, P p) {
        return new c<>(2, aVar, p);
    }

    private R b() {
        return this.f42972b;
    }

    @Override // java.lang.Runnable
    public void run() {
        c<?, P> cVar;
        if (this.f42973c == 0 && !l.a()) {
            com.ss.android.downloadlib.f.a().b().post(this);
        } else if (this.f42973c == 1 && l.a()) {
            com.ss.android.downloadlib.d.a().a(this);
        } else if (this.f42973c == 2 && l.a()) {
            com.ss.android.downloadlib.d.a().b(this);
        } else {
            if (this.a == null && (cVar = this.f42975e) != null) {
                this.a = cVar.b();
            }
            a<P, R> aVar = this.f42974d.get();
            if (aVar == null) {
                return;
            }
            this.f42972b = aVar.a(this.a);
            c<R, ?> cVar2 = this.f42976f;
            if (cVar2 != null) {
                cVar2.run();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.ss.android.downloadlib.g.c<P, R> */
    /* JADX WARN: Multi-variable type inference failed */
    public <NR> c<R, NR> a(int i, a<R, NR> aVar) {
        c cVar = (c<R, ?>) new c(i, aVar, null);
        this.f42976f = cVar;
        cVar.f42975e = this;
        return cVar;
    }

    public <NR> c<R, NR> a(a<R, NR> aVar) {
        return a(0, aVar);
    }

    public void a() {
        c<?, P> cVar = this.f42975e;
        if (cVar != null) {
            cVar.a();
        } else {
            run();
        }
    }
}
