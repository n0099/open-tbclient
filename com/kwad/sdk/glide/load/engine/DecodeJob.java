package com.kwad.sdk.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.Registry;
import com.kwad.sdk.glide.g.a.a;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.EncodeStrategy;
import com.kwad.sdk.glide.load.engine.e;
import com.kwad.sdk.glide.load.engine.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
class DecodeJob<R> implements a.c, e.a, Comparable<DecodeJob<?>>, Runnable {
    private DataSource A;
    private com.kwad.sdk.glide.load.a.d<?> B;
    private volatile com.kwad.sdk.glide.load.engine.e C;
    private volatile boolean D;
    private volatile boolean E;
    private final d d;
    private final Pools.Pool<DecodeJob<?>> e;
    private com.kwad.sdk.glide.e h;
    private com.kwad.sdk.glide.load.c i;
    private Priority j;
    private l k;
    private int l;
    private int m;
    private h n;
    private com.kwad.sdk.glide.load.e o;
    private a<R> p;
    private int q;
    private Stage r;
    private RunReason s;
    private long t;
    private boolean u;
    private Object v;
    private Thread w;
    private com.kwad.sdk.glide.load.c x;
    private com.kwad.sdk.glide.load.c y;
    private Object z;

    /* renamed from: a  reason: collision with root package name */
    private final f<R> f10435a = new f<>();

    /* renamed from: b  reason: collision with root package name */
    private final List<Throwable> f10436b = new ArrayList();
    private final com.kwad.sdk.glide.g.a.c c = com.kwad.sdk.glide.g.a.c.a();
    private final c<?> f = new c<>();
    private final e g = new e();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface a<R> {
        void a(DecodeJob<?> decodeJob);

        void a(GlideException glideException);

        void a(s<R> sVar, DataSource dataSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class b<Z> implements g.a<Z> {

        /* renamed from: b  reason: collision with root package name */
        private final DataSource f10440b;

        b(DataSource dataSource) {
            this.f10440b = dataSource;
        }

        @Override // com.kwad.sdk.glide.load.engine.g.a
        @NonNull
        public s<Z> a(@NonNull s<Z> sVar) {
            return DecodeJob.this.a(this.f10440b, sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class c<Z> {

        /* renamed from: a  reason: collision with root package name */
        private com.kwad.sdk.glide.load.c f10441a;

        /* renamed from: b  reason: collision with root package name */
        private com.kwad.sdk.glide.load.g<Z> f10442b;
        private r<Z> c;

        c() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.kwad.sdk.glide.load.g<X> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.kwad.sdk.glide.load.engine.r<X> */
        /* JADX WARN: Multi-variable type inference failed */
        <X> void a(com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.g<X> gVar, r<X> rVar) {
            this.f10441a = cVar;
            this.f10442b = gVar;
            this.c = rVar;
        }

        void a(d dVar, com.kwad.sdk.glide.load.e eVar) {
            com.kwad.sdk.glide.g.a.b.a("DecodeJob.encode");
            try {
                dVar.a().a(this.f10441a, new com.kwad.sdk.glide.load.engine.d(this.f10442b, this.c, eVar));
            } finally {
                this.c.b();
                com.kwad.sdk.glide.g.a.b.a();
            }
        }

        boolean a() {
            return this.c != null;
        }

        void b() {
            this.f10441a = null;
            this.f10442b = null;
            this.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface d {
        com.kwad.sdk.glide.load.engine.a.a a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private boolean f10443a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f10444b;
        private boolean c;

        e() {
        }

        private boolean b(boolean z) {
            return (this.c || z || this.f10444b) && this.f10443a;
        }

        synchronized boolean a() {
            this.f10444b = true;
            return b(false);
        }

        synchronized boolean a(boolean z) {
            this.f10443a = true;
            return b(z);
        }

        synchronized boolean b() {
            this.c = true;
            return b(false);
        }

        synchronized void c() {
            this.f10444b = false;
            this.f10443a = false;
            this.c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodeJob(d dVar, Pools.Pool<DecodeJob<?>> pool) {
        this.d = dVar;
        this.e = pool;
    }

    @NonNull
    private com.kwad.sdk.glide.load.e a(DataSource dataSource) {
        com.kwad.sdk.glide.load.e eVar = this.o;
        if (Build.VERSION.SDK_INT < 26) {
            return eVar;
        }
        boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f10435a.m();
        Boolean bool = (Boolean) eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.d);
        if (bool == null || (bool.booleanValue() && !z)) {
            com.kwad.sdk.glide.load.e eVar2 = new com.kwad.sdk.glide.load.e();
            eVar2.a(this.o);
            eVar2.a(com.kwad.sdk.glide.load.resource.bitmap.k.d, Boolean.valueOf(z));
            return eVar2;
        }
        return eVar;
    }

    private Stage a(Stage stage) {
        switch (stage) {
            case RESOURCE_CACHE:
                return this.n.b() ? Stage.DATA_CACHE : a(Stage.DATA_CACHE);
            case DATA_CACHE:
                return this.u ? Stage.FINISHED : Stage.SOURCE;
            case SOURCE:
            case FINISHED:
                return Stage.FINISHED;
            case INITIALIZE:
                return this.n.a() ? Stage.RESOURCE_CACHE : a(Stage.RESOURCE_CACHE);
            default:
                throw new IllegalArgumentException("Unrecognized stage: " + stage);
        }
    }

    private <Data> s<R> a(com.kwad.sdk.glide.load.a.d<?> dVar, Data data, DataSource dataSource) {
        if (data == null) {
            return null;
        }
        try {
            long a2 = com.kwad.sdk.glide.g.f.a();
            s<R> a3 = a((DecodeJob<R>) data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Decoded result " + a3, a2);
            }
            return a3;
        } finally {
            dVar.b();
        }
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.kwad.sdk.glide.load.engine.q<Data, ?, R>, com.kwad.sdk.glide.load.engine.q<Data, ResourceType, R> */
    private <Data> s<R> a(Data data, DataSource dataSource) {
        return a((DecodeJob<R>) data, dataSource, (q<DecodeJob<R>, ResourceType, R>) ((q<Data, ?, R>) this.f10435a.b(data.getClass())));
    }

    private <Data, ResourceType> s<R> a(Data data, DataSource dataSource, q<Data, ResourceType, R> qVar) {
        com.kwad.sdk.glide.load.e a2 = a(dataSource);
        com.kwad.sdk.glide.load.a.e<Data> b2 = this.h.d().b((Registry) data);
        try {
            return qVar.a(b2, a2, this.l, this.m, new b(dataSource));
        } finally {
            b2.b();
        }
    }

    private void a(s<R> sVar, DataSource dataSource) {
        m();
        this.p.a(sVar, dataSource);
    }

    private void a(String str, long j) {
        a(str, j, (String) null);
    }

    private void a(String str, long j, String str2) {
        Log.v("DecodeJob", str + " in " + com.kwad.sdk.glide.g.f.a(j) + ", load key: " + this.k + (str2 != null ? ", " + str2 : "") + ", thread: " + Thread.currentThread().getName());
    }

    private void b(s<R> sVar, DataSource dataSource) {
        if (sVar instanceof o) {
            ((o) sVar).b();
        }
        r rVar = null;
        if (this.f.a()) {
            r a2 = r.a(sVar);
            rVar = a2;
            sVar = a2;
        }
        a((s) sVar, dataSource);
        this.r = Stage.ENCODE;
        try {
            if (this.f.a()) {
                this.f.a(this.d, this.o);
            }
            e();
        } finally {
            if (rVar != null) {
                rVar.b();
            }
        }
    }

    private void e() {
        if (this.g.a()) {
            g();
        }
    }

    private void f() {
        if (this.g.b()) {
            g();
        }
    }

    private void g() {
        this.g.c();
        this.f.b();
        this.f10435a.a();
        this.D = false;
        this.h = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0L;
        this.E = false;
        this.v = null;
        this.f10436b.clear();
        this.e.release(this);
    }

    private int h() {
        return this.j.ordinal();
    }

    private void i() {
        switch (this.s) {
            case INITIALIZE:
                this.r = a(Stage.INITIALIZE);
                this.C = j();
                k();
                return;
            case SWITCH_TO_SOURCE_SERVICE:
                k();
                return;
            case DECODE_DATA:
                n();
                return;
            default:
                throw new IllegalStateException("Unrecognized run reason: " + this.s);
        }
    }

    private com.kwad.sdk.glide.load.engine.e j() {
        switch (this.r) {
            case RESOURCE_CACHE:
                return new t(this.f10435a, this);
            case DATA_CACHE:
                return new com.kwad.sdk.glide.load.engine.b(this.f10435a, this);
            case SOURCE:
                return new w(this.f10435a, this);
            case FINISHED:
                return null;
            default:
                throw new IllegalStateException("Unrecognized stage: " + this.r);
        }
    }

    private void k() {
        this.w = Thread.currentThread();
        this.t = com.kwad.sdk.glide.g.f.a();
        boolean z = false;
        while (!this.E && this.C != null && !(z = this.C.a())) {
            this.r = a(this.r);
            this.C = j();
            if (this.r == Stage.SOURCE) {
                c();
                return;
            }
        }
        if ((this.r == Stage.FINISHED || this.E) && !z) {
            l();
        }
    }

    private void l() {
        m();
        this.p.a(new GlideException("Failed to load resource", new ArrayList(this.f10436b)));
        f();
    }

    private void m() {
        this.c.b();
        if (this.D) {
            throw new IllegalStateException("Already notified", this.f10436b.isEmpty() ? null : this.f10436b.get(this.f10436b.size() - 1));
        }
        this.D = true;
    }

    private void n() {
        s<R> sVar;
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Retrieved data", this.t, "data: " + this.z + ", cache key: " + this.x + ", fetcher: " + this.B);
        }
        try {
            sVar = a(this.B, (com.kwad.sdk.glide.load.a.d<?>) this.z, this.A);
        } catch (GlideException e2) {
            e2.setLoggingDetails(this.y, this.A);
            this.f10436b.add(e2);
            sVar = null;
        }
        if (sVar != null) {
            b(sVar, this.A);
        } else {
            k();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        int h = h() - decodeJob.h();
        return h == 0 ? this.q - decodeJob.q : h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodeJob<R> a(com.kwad.sdk.glide.e eVar, Object obj, l lVar, com.kwad.sdk.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, boolean z, boolean z2, boolean z3, com.kwad.sdk.glide.load.e eVar2, a<R> aVar, int i3) {
        this.f10435a.a(eVar, obj, cVar, i, i2, hVar, cls, cls2, priority, eVar2, map, z, z2, this.d);
        this.h = eVar;
        this.i = cVar;
        this.j = priority;
        this.k = lVar;
        this.l = i;
        this.m = i2;
        this.n = hVar;
        this.u = z3;
        this.o = eVar2;
        this.p = aVar;
        this.q = i3;
        this.s = RunReason.INITIALIZE;
        this.v = obj;
        return this;
    }

    /* JADX DEBUG: Type inference failed for r10v0. Raw type applied. Possible types: com.kwad.sdk.glide.load.g<X> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    <Z> s<Z> a(DataSource dataSource, @NonNull s<Z> sVar) {
        s<Z> sVar2;
        com.kwad.sdk.glide.load.h<Z> hVar;
        EncodeStrategy encodeStrategy;
        com.kwad.sdk.glide.load.g gVar;
        com.kwad.sdk.glide.load.c uVar;
        Class<?> cls = sVar.e().getClass();
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            hVar = this.f10435a.c(cls);
            sVar2 = hVar.a(this.h, sVar, this.l, this.m);
        } else {
            sVar2 = sVar;
            hVar = null;
        }
        if (!sVar.equals(sVar2)) {
            sVar.d_();
        }
        if (this.f10435a.a((s<?>) sVar2)) {
            com.kwad.sdk.glide.load.g b2 = this.f10435a.b(sVar2);
            encodeStrategy = b2.a(this.o);
            gVar = b2;
        } else {
            encodeStrategy = EncodeStrategy.NONE;
            gVar = null;
        }
        if (this.n.a(!this.f10435a.a(this.x), dataSource, encodeStrategy)) {
            if (gVar == null) {
                throw new Registry.NoResultEncoderAvailableException(sVar2.e().getClass());
            }
            switch (encodeStrategy) {
                case SOURCE:
                    uVar = new com.kwad.sdk.glide.load.engine.c(this.x, this.i);
                    break;
                case TRANSFORMED:
                    uVar = new u(this.f10435a.i(), this.x, this.i, this.l, this.m, hVar, cls, this.o);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
            }
            r a2 = r.a(sVar2);
            this.f.a(uVar, gVar, a2);
            return a2;
        }
        return sVar2;
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Exception exc, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource) {
        dVar.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(cVar, dataSource, dVar.a());
        this.f10436b.add(glideException);
        if (Thread.currentThread() == this.w) {
            k();
            return;
        }
        this.s = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.p.a((DecodeJob<?>) this);
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Object obj, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource, com.kwad.sdk.glide.load.c cVar2) {
        this.x = cVar;
        this.z = obj;
        this.B = dVar;
        this.A = dataSource;
        this.y = cVar2;
        if (Thread.currentThread() != this.w) {
            this.s = RunReason.DECODE_DATA;
            this.p.a((DecodeJob<?>) this);
            return;
        }
        com.kwad.sdk.glide.g.a.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            n();
        } finally {
            com.kwad.sdk.glide.g.a.b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        if (this.g.a(z)) {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        Stage a2 = a(Stage.INITIALIZE);
        return a2 == Stage.RESOURCE_CACHE || a2 == Stage.DATA_CACHE;
    }

    public void b() {
        this.E = true;
        com.kwad.sdk.glide.load.engine.e eVar = this.C;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void c() {
        this.s = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.p.a((DecodeJob<?>) this);
    }

    @Override // com.kwad.sdk.glide.g.a.a.c
    @NonNull
    public com.kwad.sdk.glide.g.a.c d() {
        return this.c;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        com.kwad.sdk.glide.g.a.b.a("DecodeJob#run(model=%s)", this.v);
        com.kwad.sdk.glide.load.a.d<?> dVar = this.B;
        try {
            try {
                if (this.E) {
                    l();
                    return;
                }
                i();
                if (dVar != null) {
                    dVar.b();
                }
                com.kwad.sdk.glide.g.a.b.a();
            } catch (CallbackException e2) {
                throw e2;
            }
        } finally {
            if (dVar != null) {
                dVar.b();
            }
            com.kwad.sdk.glide.g.a.b.a();
        }
    }
}
