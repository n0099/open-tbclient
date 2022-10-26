package com.ss.android.downloadlib.g;

import java.lang.ref.SoftReference;
/* loaded from: classes8.dex */
public class c implements Runnable {
    public Object a;
    public Object b;
    public int c;
    public SoftReference d;
    public c e;
    public c f;

    /* loaded from: classes8.dex */
    public interface a {
        Object a(Object obj);
    }

    public c(int i, a aVar, Object obj) {
        this.c = i;
        this.d = new SoftReference(aVar);
        this.a = obj;
    }

    public static c a(a aVar, Object obj) {
        return new c(2, aVar, obj);
    }

    private Object b() {
        return this.b;
    }

    public void a() {
        c cVar = this.e;
        if (cVar != null) {
            cVar.a();
        } else {
            run();
        }
    }

    public c a(int i, a aVar) {
        c cVar = new c(i, aVar, null);
        this.f = cVar;
        cVar.e = this;
        return cVar;
    }

    public c a(a aVar) {
        return a(0, aVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        if (this.c == 0 && !l.a()) {
            com.ss.android.downloadlib.f.a().b().post(this);
        } else if (this.c == 1 && l.a()) {
            com.ss.android.downloadlib.d.a().a(this);
        } else if (this.c == 2 && l.a()) {
            com.ss.android.downloadlib.d.a().b(this);
        } else {
            if (this.a == null && (cVar = this.e) != null) {
                this.a = cVar.b();
            }
            a aVar = (a) this.d.get();
            if (aVar == null) {
                return;
            }
            this.b = aVar.a(this.a);
            c cVar2 = this.f;
            if (cVar2 != null) {
                cVar2.run();
            }
        }
    }
}
