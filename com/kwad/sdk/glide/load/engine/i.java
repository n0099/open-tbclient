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
/* loaded from: classes6.dex */
public class i implements h.a, k, n.a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f35830a = Log.isLoggable(Engine.TAG, 2);

    /* renamed from: b  reason: collision with root package name */
    public final p f35831b;

    /* renamed from: c  reason: collision with root package name */
    public final m f35832c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.a.h f35833d;

    /* renamed from: e  reason: collision with root package name */
    public final b f35834e;

    /* renamed from: f  reason: collision with root package name */
    public final v f35835f;

    /* renamed from: g  reason: collision with root package name */
    public final c f35836g;

    /* renamed from: h  reason: collision with root package name */
    public final a f35837h;
    public final com.kwad.sdk.glide.load.engine.a i;

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final DecodeJob.d f35838a;

        /* renamed from: b  reason: collision with root package name */
        public final Pools.Pool<DecodeJob<?>> f35839b = com.kwad.sdk.glide.g.a.a.a(150, new a.InterfaceC0424a<DecodeJob<?>>() { // from class: com.kwad.sdk.glide.load.engine.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.g.a.a.InterfaceC0424a
            /* renamed from: a */
            public DecodeJob<?> b() {
                a aVar = a.this;
                return new DecodeJob<>(aVar.f35838a, aVar.f35839b);
            }
        });

        /* renamed from: c  reason: collision with root package name */
        public int f35840c;

        public a(DecodeJob.d dVar) {
            this.f35838a = dVar;
        }

        public <R> DecodeJob<R> a(com.kwad.sdk.glide.e eVar, Object obj, l lVar, com.kwad.sdk.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, boolean z, boolean z2, boolean z3, com.kwad.sdk.glide.load.e eVar2, DecodeJob.a<R> aVar) {
            DecodeJob decodeJob = (DecodeJob) com.kwad.sdk.glide.g.j.a(this.f35839b.acquire());
            int i3 = this.f35840c;
            this.f35840c = i3 + 1;
            return decodeJob.a(eVar, obj, lVar, cVar, i, i2, cls, cls2, priority, hVar, map, z, z2, z3, eVar2, aVar, i3);
        }
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.engine.b.a f35842a;

        /* renamed from: b  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.engine.b.a f35843b;

        /* renamed from: c  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.engine.b.a f35844c;

        /* renamed from: d  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.engine.b.a f35845d;

        /* renamed from: e  reason: collision with root package name */
        public final k f35846e;

        /* renamed from: f  reason: collision with root package name */
        public final Pools.Pool<j<?>> f35847f = com.kwad.sdk.glide.g.a.a.a(150, new a.InterfaceC0424a<j<?>>() { // from class: com.kwad.sdk.glide.load.engine.i.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.g.a.a.InterfaceC0424a
            /* renamed from: a */
            public j<?> b() {
                b bVar = b.this;
                return new j<>(bVar.f35842a, bVar.f35843b, bVar.f35844c, bVar.f35845d, bVar.f35846e, bVar.f35847f);
            }
        });

        public b(com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, k kVar) {
            this.f35842a = aVar;
            this.f35843b = aVar2;
            this.f35844c = aVar3;
            this.f35845d = aVar4;
            this.f35846e = kVar;
        }

        public <R> j<R> a(com.kwad.sdk.glide.load.c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((j) com.kwad.sdk.glide.g.j.a(this.f35847f.acquire())).a(cVar, z, z2, z3, z4);
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements DecodeJob.d {

        /* renamed from: a  reason: collision with root package name */
        public final a.InterfaceC0431a f35849a;

        /* renamed from: b  reason: collision with root package name */
        public volatile com.kwad.sdk.glide.load.engine.a.a f35850b;

        public c(a.InterfaceC0431a interfaceC0431a) {
            this.f35849a = interfaceC0431a;
        }

        @Override // com.kwad.sdk.glide.load.engine.DecodeJob.d
        public com.kwad.sdk.glide.load.engine.a.a a() {
            if (this.f35850b == null) {
                synchronized (this) {
                    if (this.f35850b == null) {
                        this.f35850b = this.f35849a.a();
                    }
                    if (this.f35850b == null) {
                        this.f35850b = new com.kwad.sdk.glide.load.engine.a.b();
                    }
                }
            }
            return this.f35850b;
        }
    }

    /* loaded from: classes6.dex */
    public class d {

        /* renamed from: b  reason: collision with root package name */
        public final j<?> f35852b;

        /* renamed from: c  reason: collision with root package name */
        public final com.kwad.sdk.glide.request.g f35853c;

        public d(com.kwad.sdk.glide.request.g gVar, j<?> jVar) {
            this.f35853c = gVar;
            this.f35852b = jVar;
        }

        public void a() {
            synchronized (i.this) {
                this.f35852b.c(this.f35853c);
            }
        }
    }

    @VisibleForTesting
    public i(com.kwad.sdk.glide.load.engine.a.h hVar, a.InterfaceC0431a interfaceC0431a, com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, p pVar, m mVar, com.kwad.sdk.glide.load.engine.a aVar5, b bVar, a aVar6, v vVar, boolean z) {
        this.f35833d = hVar;
        this.f35836g = new c(interfaceC0431a);
        com.kwad.sdk.glide.load.engine.a aVar7 = aVar5 == null ? new com.kwad.sdk.glide.load.engine.a(z) : aVar5;
        this.i = aVar7;
        aVar7.a(this);
        this.f35832c = mVar == null ? new m() : mVar;
        this.f35831b = pVar == null ? new p() : pVar;
        this.f35834e = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this) : bVar;
        this.f35837h = aVar6 == null ? new a(this.f35836g) : aVar6;
        this.f35835f = vVar == null ? new v() : vVar;
        hVar.a(this);
    }

    public i(com.kwad.sdk.glide.load.engine.a.h hVar, a.InterfaceC0431a interfaceC0431a, com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, boolean z) {
        this(hVar, interfaceC0431a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z);
    }

    private n<?> a(com.kwad.sdk.glide.load.c cVar) {
        s<?> a2 = this.f35833d.a(cVar);
        if (a2 == null) {
            return null;
        }
        return a2 instanceof n ? (n) a2 : new n<>(a2, true, true);
    }

    @Nullable
    private n<?> a(com.kwad.sdk.glide.load.c cVar, boolean z) {
        if (z) {
            n<?> b2 = this.i.b(cVar);
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
                this.i.a(cVar, a2);
            }
            return a2;
        }
        return null;
    }

    public synchronized <R> d a(com.kwad.sdk.glide.e eVar, Object obj, com.kwad.sdk.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, boolean z, boolean z2, com.kwad.sdk.glide.load.e eVar2, boolean z3, boolean z4, boolean z5, boolean z6, com.kwad.sdk.glide.request.g gVar, Executor executor) {
        long a2 = f35830a ? com.kwad.sdk.glide.g.f.a() : 0L;
        l a3 = this.f35832c.a(obj, cVar, i, i2, map, cls, cls2, eVar2);
        n<?> a4 = a(a3, z3);
        if (a4 != null) {
            gVar.a(a4, DataSource.MEMORY_CACHE);
            if (f35830a) {
                a("Loaded resource from active resources", a2, a3);
            }
            return null;
        }
        n<?> b2 = b(a3, z3);
        if (b2 != null) {
            gVar.a(b2, DataSource.MEMORY_CACHE);
            if (f35830a) {
                a("Loaded resource from cache", a2, a3);
            }
            return null;
        }
        j<?> a5 = this.f35831b.a(a3, z6);
        if (a5 != null) {
            a5.a(gVar, executor);
            if (f35830a) {
                a("Added to existing load", a2, a3);
            }
            return new d(gVar, a5);
        }
        j<R> a6 = this.f35834e.a(a3, z3, z4, z5, z6);
        DecodeJob<R> a7 = this.f35837h.a(eVar, obj, a3, cVar, i, i2, cls, cls2, priority, hVar, map, z, z2, z6, eVar2, a6);
        this.f35831b.a((com.kwad.sdk.glide.load.c) a3, (j<?>) a6);
        a6.a(gVar, executor);
        a6.b(a7);
        if (f35830a) {
            a("Started new load", a2, a3);
        }
        return new d(gVar, a6);
    }

    @Override // com.kwad.sdk.glide.load.engine.n.a
    public synchronized void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        this.i.a(cVar);
        if (nVar.f()) {
            this.f35833d.b(cVar, nVar);
        } else {
            this.f35835f.a(nVar);
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.k
    public synchronized void a(j<?> jVar, com.kwad.sdk.glide.load.c cVar) {
        this.f35831b.b(cVar, jVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.k
    public synchronized void a(j<?> jVar, com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        if (nVar != null) {
            nVar.a(cVar, this);
            if (nVar.f()) {
                this.i.a(cVar, nVar);
            }
        }
        this.f35831b.b(cVar, jVar);
    }

    public void a(s<?> sVar) {
        if (!(sVar instanceof n)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((n) sVar).h();
    }

    @Override // com.kwad.sdk.glide.load.engine.a.h.a
    public void b(@NonNull s<?> sVar) {
        this.f35835f.a(sVar);
    }
}
