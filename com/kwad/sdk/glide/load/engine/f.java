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
/* loaded from: classes6.dex */
public final class f<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    public final List<n.a<?>> f35522a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<com.kwad.sdk.glide.load.c> f35523b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.glide.e f35524c;

    /* renamed from: d  reason: collision with root package name */
    public Object f35525d;

    /* renamed from: e  reason: collision with root package name */
    public int f35526e;

    /* renamed from: f  reason: collision with root package name */
    public int f35527f;

    /* renamed from: g  reason: collision with root package name */
    public Class<?> f35528g;

    /* renamed from: h  reason: collision with root package name */
    public DecodeJob.d f35529h;
    public com.kwad.sdk.glide.load.e i;
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
        return this.f35524c.d().a((Registry) x);
    }

    public List<com.kwad.sdk.glide.load.b.n<File, ?>> a(File file) {
        return this.f35524c.d().c(file);
    }

    public void a() {
        this.f35524c = null;
        this.f35525d = null;
        this.n = null;
        this.f35528g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.f35522a.clear();
        this.l = false;
        this.f35523b.clear();
        this.m = false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.lang.Class<R> */
    /* JADX WARN: Multi-variable type inference failed */
    public <R> void a(com.kwad.sdk.glide.e eVar, Object obj, com.kwad.sdk.glide.load.c cVar, int i, int i2, h hVar, Class<?> cls, Class<R> cls2, Priority priority, com.kwad.sdk.glide.load.e eVar2, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, boolean z, boolean z2, DecodeJob.d dVar) {
        this.f35524c = eVar;
        this.f35525d = obj;
        this.n = cVar;
        this.f35526e = i;
        this.f35527f = i2;
        this.p = hVar;
        this.f35528g = cls;
        this.f35529h = dVar;
        this.k = cls2;
        this.o = priority;
        this.i = eVar2;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    public boolean a(com.kwad.sdk.glide.load.c cVar) {
        List<n.a<?>> n = n();
        int size = n.size();
        for (int i = 0; i < size; i++) {
            if (n.get(i).f35333a.equals(cVar)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(s<?> sVar) {
        return this.f35524c.d().a(sVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(Class<?> cls) {
        return b(cls) != null;
    }

    public com.kwad.sdk.glide.load.engine.a.a b() {
        return this.f35529h.a();
    }

    public <Data> q<Data, ?, Transcode> b(Class<Data> cls) {
        return this.f35524c.d().a(cls, this.f35528g, this.k);
    }

    public <Z> com.kwad.sdk.glide.load.g<Z> b(s<Z> sVar) {
        return this.f35524c.d().b((s) sVar);
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
        return this.i;
    }

    public com.kwad.sdk.glide.load.c f() {
        return this.n;
    }

    public int g() {
        return this.f35526e;
    }

    public int h() {
        return this.f35527f;
    }

    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b i() {
        return this.f35524c.f();
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.Class<Transcode>, java.lang.Class<?> */
    public Class<?> j() {
        return (Class<Transcode>) this.k;
    }

    public Class<?> k() {
        return this.f35525d.getClass();
    }

    public List<Class<?>> l() {
        return this.f35524c.d().b(this.f35525d.getClass(), this.f35528g, this.k);
    }

    public boolean m() {
        return this.r;
    }

    public List<n.a<?>> n() {
        if (!this.l) {
            this.l = true;
            this.f35522a.clear();
            List c2 = this.f35524c.d().c(this.f35525d);
            int size = c2.size();
            for (int i = 0; i < size; i++) {
                n.a<?> a2 = ((com.kwad.sdk.glide.load.b.n) c2.get(i)).a(this.f35525d, this.f35526e, this.f35527f, this.i);
                if (a2 != null) {
                    this.f35522a.add(a2);
                }
            }
        }
        return this.f35522a;
    }

    public List<com.kwad.sdk.glide.load.c> o() {
        if (!this.m) {
            this.m = true;
            this.f35523b.clear();
            List<n.a<?>> n = n();
            int size = n.size();
            for (int i = 0; i < size; i++) {
                n.a<?> aVar = n.get(i);
                if (!this.f35523b.contains(aVar.f35333a)) {
                    this.f35523b.add(aVar.f35333a);
                }
                for (int i2 = 0; i2 < aVar.f35334b.size(); i2++) {
                    if (!this.f35523b.contains(aVar.f35334b.get(i2))) {
                        this.f35523b.add(aVar.f35334b.get(i2));
                    }
                }
            }
        }
        return this.f35523b;
    }
}
