package com.kwad.sdk.glide.load.engine;

import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.Registry;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.engine.DecodeJob;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n.a<?>> f6753a = new ArrayList();
    private final List<com.kwad.sdk.glide.load.c> b = new ArrayList();
    private com.kwad.sdk.glide.e c;
    private Object d;
    private int e;
    private int f;
    private Class<?> g;
    private DecodeJob.d h;
    private com.kwad.sdk.glide.load.e i;
    private Map<Class<?>, com.kwad.sdk.glide.load.h<?>> j;
    private Class<Transcode> k;
    private boolean l;
    private boolean m;
    private com.kwad.sdk.glide.load.c n;
    private Priority o;
    private h p;
    private boolean q;
    private boolean r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public <X> com.kwad.sdk.glide.load.a<X> a(X x) {
        return this.c.d().a((Registry) x);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.kwad.sdk.glide.load.b.n<File, ?>> a(File file) {
        return this.c.d().c(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.c = null;
        this.d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.f6753a.clear();
        this.l = false;
        this.b.clear();
        this.m = false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.lang.Class<R> */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <R> void a(com.kwad.sdk.glide.e eVar, Object obj, com.kwad.sdk.glide.load.c cVar, int i, int i2, h hVar, Class<?> cls, Class<R> cls2, Priority priority, com.kwad.sdk.glide.load.e eVar2, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, boolean z, boolean z2, DecodeJob.d dVar) {
        this.c = eVar;
        this.d = obj;
        this.n = cVar;
        this.e = i;
        this.f = i2;
        this.p = hVar;
        this.g = cls;
        this.h = dVar;
        this.k = cls2;
        this.o = priority;
        this.i = eVar2;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(com.kwad.sdk.glide.load.c cVar) {
        List<n.a<?>> n = n();
        int size = n.size();
        for (int i = 0; i < size; i++) {
            if (n.get(i).f6686a.equals(cVar)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(s<?> sVar) {
        return this.c.d().a(sVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Class<?> */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(Class<?> cls) {
        return b(cls) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.kwad.sdk.glide.load.engine.a.a b() {
        return this.h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Data> q<Data, ?, Transcode> b(Class<Data> cls) {
        return this.c.d().a(cls, this.g, this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> com.kwad.sdk.glide.load.g<Z> b(s<Z> sVar) {
        return this.c.d().b((s) sVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h c() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> com.kwad.sdk.glide.load.h<Z> c(Class<Z> cls) {
        com.kwad.sdk.glide.load.h<Z> hVar = (com.kwad.sdk.glide.load.h<Z>) this.j.get(cls);
        if (hVar == null) {
            Iterator<Map.Entry<Class<?>, com.kwad.sdk.glide.load.h<?>>> it = this.j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, com.kwad.sdk.glide.load.h<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    hVar = (com.kwad.sdk.glide.load.h<Z>) next.getValue();
                    break;
                }
            }
        }
        if (hVar == null) {
            if (this.j.isEmpty() && this.q) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return com.kwad.sdk.glide.load.resource.b.a();
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Priority d() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.kwad.sdk.glide.load.e e() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.kwad.sdk.glide.load.c f() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b i() {
        return this.c.f();
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.Class<Transcode>, java.lang.Class<?> */
    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> j() {
        return (Class<Transcode>) this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> k() {
        return this.d.getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Class<?>> l() {
        return this.c.d().b(this.d.getClass(), this.g, this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<n.a<?>> n() {
        if (!this.l) {
            this.l = true;
            this.f6753a.clear();
            List c = this.c.d().c(this.d);
            int size = c.size();
            for (int i = 0; i < size; i++) {
                n.a<?> a2 = ((com.kwad.sdk.glide.load.b.n) c.get(i)).a(this.d, this.e, this.f, this.i);
                if (a2 != null) {
                    this.f6753a.add(a2);
                }
            }
        }
        return this.f6753a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.kwad.sdk.glide.load.c> o() {
        if (!this.m) {
            this.m = true;
            this.b.clear();
            List<n.a<?>> n = n();
            int size = n.size();
            for (int i = 0; i < size; i++) {
                n.a<?> aVar = n.get(i);
                if (!this.b.contains(aVar.f6686a)) {
                    this.b.add(aVar.f6686a);
                }
                for (int i2 = 0; i2 < aVar.b.size(); i2++) {
                    if (!this.b.contains(aVar.b.get(i2))) {
                        this.b.add(aVar.b.get(i2));
                    }
                }
            }
        }
        return this.b;
    }
}
