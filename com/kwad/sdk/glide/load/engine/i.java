package com.kwad.sdk.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.g.a.a;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.DecodeJob;
import com.kwad.sdk.glide.load.engine.a.a;
import com.kwad.sdk.glide.load.engine.a.h;
import com.kwad.sdk.glide.load.engine.n;
import java.util.Map;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public class i implements h.a, k, n.a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f10220a = Log.isLoggable("Engine", 2);

    /* renamed from: b  reason: collision with root package name */
    private final p f10221b;
    private final m c;
    private final com.kwad.sdk.glide.load.engine.a.h d;
    private final b e;
    private final v f;
    private final c g;
    private final a h;
    private final com.kwad.sdk.glide.load.engine.a i;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final DecodeJob.d f10222a;

        /* renamed from: b  reason: collision with root package name */
        final Pools.Pool<DecodeJob<?>> f10223b = com.kwad.sdk.glide.g.a.a.a(150, new a.InterfaceC1125a<DecodeJob<?>>() { // from class: com.kwad.sdk.glide.load.engine.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.g.a.a.InterfaceC1125a
            /* renamed from: a */
            public DecodeJob<?> b() {
                return new DecodeJob<>(a.this.f10222a, a.this.f10223b);
            }
        });
        private int c;

        a(DecodeJob.d dVar) {
            this.f10222a = dVar;
        }

        <R> DecodeJob<R> a(com.kwad.sdk.glide.e eVar, Object obj, l lVar, com.kwad.sdk.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, boolean z, boolean z2, boolean z3, com.kwad.sdk.glide.load.e eVar2, DecodeJob.a<R> aVar) {
            int i3 = this.c;
            this.c = i3 + 1;
            return ((DecodeJob) com.kwad.sdk.glide.g.j.a(this.f10223b.acquire())).a(eVar, obj, lVar, cVar, i, i2, cls, cls2, priority, hVar, map, z, z2, z3, eVar2, aVar, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final com.kwad.sdk.glide.load.engine.b.a f10225a;

        /* renamed from: b  reason: collision with root package name */
        final com.kwad.sdk.glide.load.engine.b.a f10226b;
        final com.kwad.sdk.glide.load.engine.b.a c;
        final com.kwad.sdk.glide.load.engine.b.a d;
        final k e;
        final Pools.Pool<j<?>> f = com.kwad.sdk.glide.g.a.a.a(150, new a.InterfaceC1125a<j<?>>() { // from class: com.kwad.sdk.glide.load.engine.i.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.g.a.a.InterfaceC1125a
            /* renamed from: a */
            public j<?> b() {
                return new j<>(b.this.f10225a, b.this.f10226b, b.this.c, b.this.d, b.this.e, b.this.f);
            }
        });

        b(com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, k kVar) {
            this.f10225a = aVar;
            this.f10226b = aVar2;
            this.c = aVar3;
            this.d = aVar4;
            this.e = kVar;
        }

        <R> j<R> a(com.kwad.sdk.glide.load.c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((j) com.kwad.sdk.glide.g.j.a(this.f.acquire())).a(cVar, z, z2, z3, z4);
        }
    }

    /* loaded from: classes3.dex */
    private static class c implements DecodeJob.d {

        /* renamed from: a  reason: collision with root package name */
        private final a.InterfaceC1132a f10228a;

        /* renamed from: b  reason: collision with root package name */
        private volatile com.kwad.sdk.glide.load.engine.a.a f10229b;

        c(a.InterfaceC1132a interfaceC1132a) {
            this.f10228a = interfaceC1132a;
        }

        @Override // com.kwad.sdk.glide.load.engine.DecodeJob.d
        public com.kwad.sdk.glide.load.engine.a.a a() {
            if (this.f10229b == null) {
                synchronized (this) {
                    if (this.f10229b == null) {
                        this.f10229b = this.f10228a.a();
                    }
                    if (this.f10229b == null) {
                        this.f10229b = new com.kwad.sdk.glide.load.engine.a.b();
                    }
                }
            }
            return this.f10229b;
        }
    }

    /* loaded from: classes3.dex */
    public class d {

        /* renamed from: b  reason: collision with root package name */
        private final j<?> f10231b;
        private final com.kwad.sdk.glide.request.g c;

        d(com.kwad.sdk.glide.request.g gVar, j<?> jVar) {
            this.c = gVar;
            this.f10231b = jVar;
        }

        public void a() {
            synchronized (i.this) {
                this.f10231b.c(this.c);
            }
        }
    }

    @VisibleForTesting
    i(com.kwad.sdk.glide.load.engine.a.h hVar, a.InterfaceC1132a interfaceC1132a, com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, p pVar, m mVar, com.kwad.sdk.glide.load.engine.a aVar5, b bVar, a aVar6, v vVar, boolean z) {
        this.d = hVar;
        this.g = new c(interfaceC1132a);
        aVar5 = aVar5 == null ? new com.kwad.sdk.glide.load.engine.a(z) : aVar5;
        this.i = aVar5;
        aVar5.a(this);
        this.c = mVar == null ? new m() : mVar;
        this.f10221b = pVar == null ? new p() : pVar;
        this.e = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this) : bVar;
        this.h = aVar6 == null ? new a(this.g) : aVar6;
        this.f = vVar == null ? new v() : vVar;
        hVar.a(this);
    }

    public i(com.kwad.sdk.glide.load.engine.a.h hVar, a.InterfaceC1132a interfaceC1132a, com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, boolean z) {
        this(hVar, interfaceC1132a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z);
    }

    private n<?> a(com.kwad.sdk.glide.load.c cVar) {
        s<?> a2 = this.d.a(cVar);
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
                return b2;
            }
            return b2;
        }
        return null;
    }

    private static void a(String str, long j, com.kwad.sdk.glide.load.c cVar) {
        Log.v("Engine", str + " in " + com.kwad.sdk.glide.g.f.a(j) + "ms, key: " + cVar);
    }

    private n<?> b(com.kwad.sdk.glide.load.c cVar, boolean z) {
        if (z) {
            n<?> a2 = a(cVar);
            if (a2 != null) {
                a2.g();
                this.i.a(cVar, a2);
                return a2;
            }
            return a2;
        }
        return null;
    }

    public synchronized <R> d a(com.kwad.sdk.glide.e eVar, Object obj, com.kwad.sdk.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, boolean z, boolean z2, com.kwad.sdk.glide.load.e eVar2, boolean z3, boolean z4, boolean z5, boolean z6, com.kwad.sdk.glide.request.g gVar, Executor executor) {
        d dVar;
        long a2 = f10220a ? com.kwad.sdk.glide.g.f.a() : 0L;
        l a3 = this.c.a(obj, cVar, i, i2, map, cls, cls2, eVar2);
        n<?> a4 = a(a3, z3);
        if (a4 != null) {
            gVar.a(a4, DataSource.MEMORY_CACHE);
            if (f10220a) {
                a("Loaded resource from active resources", a2, a3);
            }
            dVar = null;
        } else {
            n<?> b2 = b(a3, z3);
            if (b2 != null) {
                gVar.a(b2, DataSource.MEMORY_CACHE);
                if (f10220a) {
                    a("Loaded resource from cache", a2, a3);
                }
                dVar = null;
            } else {
                j<?> a5 = this.f10221b.a(a3, z6);
                if (a5 != null) {
                    a5.a(gVar, executor);
                    if (f10220a) {
                        a("Added to existing load", a2, a3);
                    }
                    dVar = new d(gVar, a5);
                } else {
                    j<R> a6 = this.e.a(a3, z3, z4, z5, z6);
                    DecodeJob<R> a7 = this.h.a(eVar, obj, a3, cVar, i, i2, cls, cls2, priority, hVar, map, z, z2, z6, eVar2, a6);
                    this.f10221b.a((com.kwad.sdk.glide.load.c) a3, (j<?>) a6);
                    a6.a(gVar, executor);
                    a6.b(a7);
                    if (f10220a) {
                        a("Started new load", a2, a3);
                    }
                    dVar = new d(gVar, a6);
                }
            }
        }
        return dVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.n.a
    public synchronized void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        this.i.a(cVar);
        if (nVar.f()) {
            this.d.b(cVar, nVar);
        } else {
            this.f.a(nVar);
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.k
    public synchronized void a(j<?> jVar, com.kwad.sdk.glide.load.c cVar) {
        this.f10221b.b(cVar, jVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.k
    public synchronized void a(j<?> jVar, com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        if (nVar != null) {
            nVar.a(cVar, this);
            if (nVar.f()) {
                this.i.a(cVar, nVar);
            }
        }
        this.f10221b.b(cVar, jVar);
    }

    public void a(s<?> sVar) {
        if (!(sVar instanceof n)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((n) sVar).h();
    }

    @Override // com.kwad.sdk.glide.load.engine.a.h.a
    public void b(@NonNull s<?> sVar) {
        this.f.a(sVar);
    }
}
