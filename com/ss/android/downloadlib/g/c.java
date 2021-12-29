package com.ss.android.downloadlib.g;

import java.lang.ref.SoftReference;
/* loaded from: classes3.dex */
public class c<P, R> implements Runnable {
    public P a;

    /* renamed from: b  reason: collision with root package name */
    public R f62013b;

    /* renamed from: c  reason: collision with root package name */
    public int f62014c;

    /* renamed from: d  reason: collision with root package name */
    public SoftReference<a<P, R>> f62015d;

    /* renamed from: e  reason: collision with root package name */
    public c<?, P> f62016e;

    /* renamed from: f  reason: collision with root package name */
    public c<R, ?> f62017f;

    /* loaded from: classes3.dex */
    public interface a<PARAM, RESULT> {
        RESULT a(PARAM param);
    }

    public c(int i2, a<P, R> aVar, P p) {
        this.f62014c = i2;
        this.f62015d = new SoftReference<>(aVar);
        this.a = p;
    }

    public static <P, R> c<P, R> a(a<P, R> aVar, P p) {
        return new c<>(2, aVar, p);
    }

    private R b() {
        return this.f62013b;
    }

    @Override // java.lang.Runnable
    public void run() {
        c<?, P> cVar;
        if (this.f62014c == 0 && !l.a()) {
            com.ss.android.downloadlib.f.a().b().post(this);
        } else if (this.f62014c == 1 && l.a()) {
            com.ss.android.downloadlib.d.a().a(this);
        } else if (this.f62014c == 2 && l.a()) {
            com.ss.android.downloadlib.d.a().b(this);
        } else {
            if (this.a == null && (cVar = this.f62016e) != null) {
                this.a = cVar.b();
            }
            a<P, R> aVar = this.f62015d.get();
            if (aVar == null) {
                return;
            }
            this.f62013b = aVar.a(this.a);
            c<R, ?> cVar2 = this.f62017f;
            if (cVar2 != null) {
                cVar2.run();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.ss.android.downloadlib.g.c<P, R> */
    /* JADX WARN: Multi-variable type inference failed */
    public <NR> c<R, NR> a(int i2, a<R, NR> aVar) {
        c cVar = (c<R, ?>) new c(i2, aVar, null);
        this.f62017f = cVar;
        cVar.f62016e = this;
        return cVar;
    }

    public <NR> c<R, NR> a(a<R, NR> aVar) {
        return a(0, aVar);
    }

    public void a() {
        c<?, P> cVar = this.f62016e;
        if (cVar != null) {
            cVar.a();
        } else {
            run();
        }
    }
}
