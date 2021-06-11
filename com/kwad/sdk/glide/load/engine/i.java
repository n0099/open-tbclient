package com.kwad.sdk.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.Engine;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.g.a.a;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.DecodeJob;
import com.kwad.sdk.glide.load.engine.a.a;
import com.kwad.sdk.glide.load.engine.a.h;
import com.kwad.sdk.glide.load.engine.n;
import java.util.Map;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public class i implements h.a, k, n.a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f36229a = Log.isLoggable(Engine.TAG, 2);

    /* renamed from: b  reason: collision with root package name */
    public final p f36230b;

    /* renamed from: c  reason: collision with root package name */
    public final m f36231c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.a.h f36232d;

    /* renamed from: e  reason: collision with root package name */
    public final b f36233e;

    /* renamed from: f  reason: collision with root package name */
    public final v f36234f;

    /* renamed from: g  reason: collision with root package name */
    public final c f36235g;

    /* renamed from: h  reason: collision with root package name */
    public final a f36236h;

    /* renamed from: i  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.a f36237i;

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final DecodeJob.d f36238a;

        /* renamed from: b  reason: collision with root package name */
        public final Pools.Pool<DecodeJob<?>> f36239b = com.kwad.sdk.glide.g.a.a.a(150, new a.InterfaceC0410a<DecodeJob<?>>() { // from class: com.kwad.sdk.glide.load.engine.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.g.a.a.InterfaceC0410a
            /* renamed from: a */
            public DecodeJob<?> b() {
                a aVar = a.this;
                return new DecodeJob<>(aVar.f36238a, aVar.f36239b);
            }
        });

        /* renamed from: c  reason: collision with root package name */
        public int f36240c;

        public a(DecodeJob.d dVar) {
            this.f36238a = dVar;
        }

        public <R> DecodeJob<R> a(com.kwad.sdk.glide.e eVar, Object obj, l lVar, com.kwad.sdk.glide.load.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, boolean z, boolean z2, boolean z3, com.kwad.sdk.glide.load.e eVar2, DecodeJob.a<R> aVar) {
            DecodeJob decodeJob = (DecodeJob) com.kwad.sdk.glide.g.j.a(this.f36239b.acquire());
            int i4 = this.f36240c;
            this.f36240c = i4 + 1;
            return decodeJob.a(eVar, obj, lVar, cVar, i2, i3, cls, cls2, priority, hVar, map, z, z2, z3, eVar2, aVar, i4);
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.engine.b.a f36242a;

        /* renamed from: b  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.engine.b.a f36243b;

        /* renamed from: c  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.engine.b.a f36244c;

        /* renamed from: d  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.engine.b.a f36245d;

        /* renamed from: e  reason: collision with root package name */
        public final k f36246e;

        /* renamed from: f  reason: collision with root package name */
        public final Pools.Pool<j<?>> f36247f = com.kwad.sdk.glide.g.a.a.a(150, new a.InterfaceC0410a<j<?>>() { // from class: com.kwad.sdk.glide.load.engine.i.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.g.a.a.InterfaceC0410a
            /* renamed from: a */
            public j<?> b() {
                b bVar = b.this;
                return new j<>(bVar.f36242a, bVar.f36243b, bVar.f36244c, bVar.f36245d, bVar.f36246e, bVar.f36247f);
            }
        });

        public b(com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, k kVar) {
            this.f36242a = aVar;
            this.f36243b = aVar2;
            this.f36244c = aVar3;
            this.f36245d = aVar4;
            this.f36246e = kVar;
        }

        public <R> j<R> a(com.kwad.sdk.glide.load.c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((j) com.kwad.sdk.glide.g.j.a(this.f36247f.acquire())).a(cVar, z, z2, z3, z4);
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements DecodeJob.d {

        /* renamed from: a  reason: collision with root package name */
        public final a.InterfaceC0417a f36249a;

        /* renamed from: b  reason: collision with root package name */
        public volatile com.kwad.sdk.glide.load.engine.a.a f36250b;

        public c(a.InterfaceC0417a interfaceC0417a) {
            this.f36249a = interfaceC0417a;
        }

        @Override // com.kwad.sdk.glide.load.engine.DecodeJob.d
        public com.kwad.sdk.glide.load.engine.a.a a() {
            if (this.f36250b == null) {
                synchronized (this) {
                    if (this.f36250b == null) {
                        this.f36250b = this.f36249a.a();
                    }
                    if (this.f36250b == null) {
                        this.f36250b = new com.kwad.sdk.glide.load.engine.a.b();
                    }
                }
            }
            return this.f36250b;
        }
    }

    /* loaded from: classes7.dex */
    public class d {

        /* renamed from: b  reason: collision with root package name */
        public final j<?> f36252b;

        /* renamed from: c  reason: collision with root package name */
        public final com.kwad.sdk.glide.request.g f36253c;

        public d(com.kwad.sdk.glide.request.g gVar, j<?> jVar) {
            this.f36253c = gVar;
            this.f36252b = jVar;
        }

        public void a() {
            synchronized (i.this) {
                this.f36252b.c(this.f36253c);
            }
        }
    }

    @VisibleForTesting
    public i(com.kwad.sdk.glide.load.engine.a.h hVar, a.InterfaceC0417a interfaceC0417a, com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, p pVar, m mVar, com.kwad.sdk.glide.load.engine.a aVar5, b bVar, a aVar6, v vVar, boolean z) {
        this.f36232d = hVar;
        this.f36235g = new c(interfaceC0417a);
        com.kwad.sdk.glide.load.engine.a aVar7 = aVar5 == null ? new com.kwad.sdk.glide.load.engine.a(z) : aVar5;
        this.f36237i = aVar7;
        aVar7.a(this);
        this.f36231c = mVar == null ? new m() : mVar;
        this.f36230b = pVar == null ? new p() : pVar;
        this.f36233e = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this) : bVar;
        this.f36236h = aVar6 == null ? new a(this.f36235g) : aVar6;
        this.f36234f = vVar == null ? new v() : vVar;
        hVar.a(this);
    }

    public i(com.kwad.sdk.glide.load.engine.a.h hVar, a.InterfaceC0417a interfaceC0417a, com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, boolean z) {
        this(hVar, interfaceC0417a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z);
    }

    private n<?> a(com.kwad.sdk.glide.load.c cVar) {
        s<?> a2 = this.f36232d.a(cVar);
        if (a2 == null) {
            return null;
        }
        return a2 instanceof n ? (n) a2 : new n<>(a2, true, true);
    }

    @Nullable
    private n<?> a(com.kwad.sdk.glide.load.c cVar, boolean z) {
        if (z) {
            n<?> b2 = this.f36237i.b(cVar);
            if (b2 != null) {
                b2.g();
            }
            return b2;
        }
        return null;
    }

    public static void a(String str, long j, com.kwad.sdk.glide.load.c cVar) {
        Log.v(Engine.TAG, str + " in " + com.kwad.sdk.glide.g.f.a(j) + "ms, key: " + cVar);
    }

    private n<?> b(com.kwad.sdk.glide.load.c cVar, boolean z) {
        if (z) {
            n<?> a2 = a(cVar);
            if (a2 != null) {
                a2.g();
                this.f36237i.a(cVar, a2);
            }
            return a2;
        }
        return null;
    }

    public synchronized <R> d a(com.kwad.sdk.glide.e eVar, Object obj, com.kwad.sdk.glide.load.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, boolean z, boolean z2, com.kwad.sdk.glide.load.e eVar2, boolean z3, boolean z4, boolean z5, boolean z6, com.kwad.sdk.glide.request.g gVar, Executor executor) {
        long a2 = f36229a ? com.kwad.sdk.glide.g.f.a() : 0L;
        l a3 = this.f36231c.a(obj, cVar, i2, i3, map, cls, cls2, eVar2);
        n<?> a4 = a(a3, z3);
        if (a4 != null) {
            gVar.a(a4, DataSource.MEMORY_CACHE);
            if (f36229a) {
                a("Loaded resource from active resources", a2, a3);
            }
            return null;
        }
        n<?> b2 = b(a3, z3);
        if (b2 != null) {
            gVar.a(b2, DataSource.MEMORY_CACHE);
            if (f36229a) {
                a("Loaded resource from cache", a2, a3);
            }
            return null;
        }
        j<?> a5 = this.f36230b.a(a3, z6);
        if (a5 != null) {
            a5.a(gVar, executor);
            if (f36229a) {
                a("Added to existing load", a2, a3);
            }
            return new d(gVar, a5);
        }
        j<R> a6 = this.f36233e.a(a3, z3, z4, z5, z6);
        DecodeJob<R> a7 = this.f36236h.a(eVar, obj, a3, cVar, i2, i3, cls, cls2, priority, hVar, map, z, z2, z6, eVar2, a6);
        this.f36230b.a((com.kwad.sdk.glide.load.c) a3, (j<?>) a6);
        a6.a(gVar, executor);
        a6.b(a7);
        if (f36229a) {
            a("Started new load", a2, a3);
        }
        return new d(gVar, a6);
    }

    @Override // com.kwad.sdk.glide.load.engine.n.a
    public synchronized void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        this.f36237i.a(cVar);
        if (nVar.f()) {
            this.f36232d.b(cVar, nVar);
        } else {
            this.f36234f.a(nVar);
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.k
    public synchronized void a(j<?> jVar, com.kwad.sdk.glide.load.c cVar) {
        this.f36230b.b(cVar, jVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.k
    public synchronized void a(j<?> jVar, com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        if (nVar != null) {
            nVar.a(cVar, this);
            if (nVar.f()) {
                this.f36237i.a(cVar, nVar);
            }
        }
        this.f36230b.b(cVar, jVar);
    }

    public void a(s<?> sVar) {
        if (!(sVar instanceof n)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((n) sVar).h();
    }

    @Override // com.kwad.sdk.glide.load.engine.a.h.a
    public void b(@NonNull s<?> sVar) {
        this.f36234f.a(sVar);
    }
}
