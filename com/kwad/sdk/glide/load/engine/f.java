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
/* loaded from: classes7.dex */
public final class f<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    public final List<n.a<?>> f36308a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<com.kwad.sdk.glide.load.c> f36309b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.glide.e f36310c;

    /* renamed from: d  reason: collision with root package name */
    public Object f36311d;

    /* renamed from: e  reason: collision with root package name */
    public int f36312e;

    /* renamed from: f  reason: collision with root package name */
    public int f36313f;

    /* renamed from: g  reason: collision with root package name */
    public Class<?> f36314g;

    /* renamed from: h  reason: collision with root package name */
    public DecodeJob.d f36315h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.glide.load.e f36316i;
    public Map<Class<?>, com.kwad.sdk.glide.load.h<?>> j;
    public Class<Transcode> k;
    public boolean l;
    public boolean m;
    public com.kwad.sdk.glide.load.c n;
    public Priority o;
    public h p;
    public boolean q;
    public boolean r;

    public <X> com.kwad.sdk.glide.load.a<X> a(X x) {
        return this.f36310c.d().a((Registry) x);
    }

    public List<com.kwad.sdk.glide.load.b.n<File, ?>> a(File file) {
        return this.f36310c.d().c(file);
    }

    public void a() {
        this.f36310c = null;
        this.f36311d = null;
        this.n = null;
        this.f36314g = null;
        this.k = null;
        this.f36316i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.f36308a.clear();
        this.l = false;
        this.f36309b.clear();
        this.m = false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.lang.Class<R> */
    /* JADX WARN: Multi-variable type inference failed */
    public <R> void a(com.kwad.sdk.glide.e eVar, Object obj, com.kwad.sdk.glide.load.c cVar, int i2, int i3, h hVar, Class<?> cls, Class<R> cls2, Priority priority, com.kwad.sdk.glide.load.e eVar2, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, boolean z, boolean z2, DecodeJob.d dVar) {
        this.f36310c = eVar;
        this.f36311d = obj;
        this.n = cVar;
        this.f36312e = i2;
        this.f36313f = i3;
        this.p = hVar;
        this.f36314g = cls;
        this.f36315h = dVar;
        this.k = cls2;
        this.o = priority;
        this.f36316i = eVar2;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    public boolean a(com.kwad.sdk.glide.load.c cVar) {
        List<n.a<?>> n = n();
        int size = n.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (n.get(i2).f36115a.equals(cVar)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(s<?> sVar) {
        return this.f36310c.d().a(sVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(Class<?> cls) {
        return b(cls) != null;
    }

    public com.kwad.sdk.glide.load.engine.a.a b() {
        return this.f36315h.a();
    }

    public <Data> q<Data, ?, Transcode> b(Class<Data> cls) {
        return this.f36310c.d().a(cls, this.f36314g, this.k);
    }

    public <Z> com.kwad.sdk.glide.load.g<Z> b(s<Z> sVar) {
        return this.f36310c.d().b((s) sVar);
    }

    public h c() {
        return this.p;
    }

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

    public Priority d() {
        return this.o;
    }

    public com.kwad.sdk.glide.load.e e() {
        return this.f36316i;
    }

    public com.kwad.sdk.glide.load.c f() {
        return this.n;
    }

    public int g() {
        return this.f36312e;
    }

    public int h() {
        return this.f36313f;
    }

    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b i() {
        return this.f36310c.f();
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.Class<Transcode>, java.lang.Class<?> */
    public Class<?> j() {
        return (Class<Transcode>) this.k;
    }

    public Class<?> k() {
        return this.f36311d.getClass();
    }

    public List<Class<?>> l() {
        return this.f36310c.d().b(this.f36311d.getClass(), this.f36314g, this.k);
    }

    public boolean m() {
        return this.r;
    }

    public List<n.a<?>> n() {
        if (!this.l) {
            this.l = true;
            this.f36308a.clear();
            List c2 = this.f36310c.d().c(this.f36311d);
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a<?> a2 = ((com.kwad.sdk.glide.load.b.n) c2.get(i2)).a(this.f36311d, this.f36312e, this.f36313f, this.f36316i);
                if (a2 != null) {
                    this.f36308a.add(a2);
                }
            }
        }
        return this.f36308a;
    }

    public List<com.kwad.sdk.glide.load.c> o() {
        if (!this.m) {
            this.m = true;
            this.f36309b.clear();
            List<n.a<?>> n = n();
            int size = n.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a<?> aVar = n.get(i2);
                if (!this.f36309b.contains(aVar.f36115a)) {
                    this.f36309b.add(aVar.f36115a);
                }
                for (int i3 = 0; i3 < aVar.f36116b.size(); i3++) {
                    if (!this.f36309b.contains(aVar.f36116b.get(i3))) {
                        this.f36309b.add(aVar.f36116b.get(i3));
                    }
                }
            }
        }
        return this.f36309b;
    }
}
