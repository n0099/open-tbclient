package com.kwad.sdk.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.baidu.android.common.others.lang.StringUtil;
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
/* loaded from: classes6.dex */
public class DecodeJob<R> implements a.c, e.a, Comparable<DecodeJob<?>>, Runnable {
    public DataSource A;
    public com.kwad.sdk.glide.load.a.d<?> B;
    public volatile com.kwad.sdk.glide.load.engine.e C;
    public volatile boolean D;
    public volatile boolean E;

    /* renamed from: d  reason: collision with root package name */
    public final d f35771d;

    /* renamed from: e  reason: collision with root package name */
    public final Pools.Pool<DecodeJob<?>> f35772e;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.glide.e f35775h;
    public com.kwad.sdk.glide.load.c i;
    public Priority j;
    public l k;
    public int l;
    public int m;
    public h n;
    public com.kwad.sdk.glide.load.e o;
    public a<R> p;
    public int q;
    public Stage r;
    public RunReason s;
    public long t;
    public boolean u;
    public Object v;
    public Thread w;
    public com.kwad.sdk.glide.load.c x;
    public com.kwad.sdk.glide.load.c y;
    public Object z;

    /* renamed from: a  reason: collision with root package name */
    public final f<R> f35768a = new f<>();

    /* renamed from: b  reason: collision with root package name */
    public final List<Throwable> f35769b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.g.a.c f35770c = com.kwad.sdk.glide.g.a.c.a();

    /* renamed from: f  reason: collision with root package name */
    public final c<?> f35773f = new c<>();

    /* renamed from: g  reason: collision with root package name */
    public final e f35774g = new e();

    /* renamed from: com.kwad.sdk.glide.load.engine.DecodeJob$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35776a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f35777b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f35778c;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            f35778c = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35778c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Stage.values().length];
            f35777b = iArr2;
            try {
                iArr2[Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35777b[Stage.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35777b[Stage.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35777b[Stage.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35777b[Stage.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[RunReason.values().length];
            f35776a = iArr3;
            try {
                iArr3[RunReason.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35776a[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35776a[RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* loaded from: classes6.dex */
    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* loaded from: classes6.dex */
    public interface a<R> {
        void a(DecodeJob<?> decodeJob);

        void a(GlideException glideException);

        void a(s<R> sVar, DataSource dataSource);
    }

    /* loaded from: classes6.dex */
    public final class b<Z> implements g.a<Z> {

        /* renamed from: b  reason: collision with root package name */
        public final DataSource f35780b;

        public b(DataSource dataSource) {
            this.f35780b = dataSource;
        }

        @Override // com.kwad.sdk.glide.load.engine.g.a
        @NonNull
        public s<Z> a(@NonNull s<Z> sVar) {
            return DecodeJob.this.a(this.f35780b, sVar);
        }
    }

    /* loaded from: classes6.dex */
    public static class c<Z> {

        /* renamed from: a  reason: collision with root package name */
        public com.kwad.sdk.glide.load.c f35781a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwad.sdk.glide.load.g<Z> f35782b;

        /* renamed from: c  reason: collision with root package name */
        public r<Z> f35783c;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.kwad.sdk.glide.load.g<X> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.kwad.sdk.glide.load.engine.r<X> */
        /* JADX WARN: Multi-variable type inference failed */
        public <X> void a(com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.g<X> gVar, r<X> rVar) {
            this.f35781a = cVar;
            this.f35782b = gVar;
            this.f35783c = rVar;
        }

        public void a(d dVar, com.kwad.sdk.glide.load.e eVar) {
            com.kwad.sdk.glide.g.a.b.a("DecodeJob.encode");
            try {
                dVar.a().a(this.f35781a, new com.kwad.sdk.glide.load.engine.d(this.f35782b, this.f35783c, eVar));
            } finally {
                this.f35783c.b();
                com.kwad.sdk.glide.g.a.b.a();
            }
        }

        public boolean a() {
            return this.f35783c != null;
        }

        public void b() {
            this.f35781a = null;
            this.f35782b = null;
            this.f35783c = null;
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        com.kwad.sdk.glide.load.engine.a.a a();
    }

    /* loaded from: classes6.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public boolean f35784a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f35785b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f35786c;

        private boolean b(boolean z) {
            return (this.f35786c || z || this.f35785b) && this.f35784a;
        }

        public synchronized boolean a() {
            this.f35785b = true;
            return b(false);
        }

        public synchronized boolean a(boolean z) {
            this.f35784a = true;
            return b(z);
        }

        public synchronized boolean b() {
            this.f35786c = true;
            return b(false);
        }

        public synchronized void c() {
            this.f35785b = false;
            this.f35784a = false;
            this.f35786c = false;
        }
    }

    public DecodeJob(d dVar, Pools.Pool<DecodeJob<?>> pool) {
        this.f35771d = dVar;
        this.f35772e = pool;
    }

    @NonNull
    private com.kwad.sdk.glide.load.e a(DataSource dataSource) {
        com.kwad.sdk.glide.load.e eVar = this.o;
        if (Build.VERSION.SDK_INT < 26) {
            return eVar;
        }
        boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f35768a.m();
        Boolean bool = (Boolean) eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.f36055d);
        if (bool == null || (bool.booleanValue() && !z)) {
            com.kwad.sdk.glide.load.e eVar2 = new com.kwad.sdk.glide.load.e();
            eVar2.a(this.o);
            eVar2.a(com.kwad.sdk.glide.load.resource.bitmap.k.f36055d, Boolean.valueOf(z));
            return eVar2;
        }
        return eVar;
    }

    private Stage a(Stage stage) {
        int i = AnonymousClass1.f35777b[stage.ordinal()];
        if (i == 1) {
            return this.n.b() ? Stage.DATA_CACHE : a(Stage.DATA_CACHE);
        } else if (i == 2) {
            return this.u ? Stage.FINISHED : Stage.SOURCE;
        } else if (i == 3 || i == 4) {
            return Stage.FINISHED;
        } else {
            if (i == 5) {
                return this.n.a() ? Stage.RESOURCE_CACHE : a(Stage.RESOURCE_CACHE);
            }
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
            if (Log.isLoggable(com.bumptech.glide.load.engine.DecodeJob.TAG, 2)) {
                a("Decoded result " + a3, a2);
            }
            return a3;
        } finally {
            dVar.b();
        }
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.kwad.sdk.glide.load.engine.q<Data, ?, R>, com.kwad.sdk.glide.load.engine.q<Data, ResourceType, R> */
    private <Data> s<R> a(Data data, DataSource dataSource) {
        return a((DecodeJob<R>) data, dataSource, (q<DecodeJob<R>, ResourceType, R>) ((q<Data, ?, R>) this.f35768a.b(data.getClass())));
    }

    private <Data, ResourceType> s<R> a(Data data, DataSource dataSource, q<Data, ResourceType, R> qVar) {
        com.kwad.sdk.glide.load.e a2 = a(dataSource);
        com.kwad.sdk.glide.load.a.e<Data> b2 = this.f35775h.d().b((Registry) data);
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
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.kwad.sdk.glide.g.f.a(j));
        sb.append(", load key: ");
        sb.append(this.k);
        if (str2 != null) {
            str3 = StringUtil.ARRAY_ELEMENT_SEPARATOR + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v(com.bumptech.glide.load.engine.DecodeJob.TAG, sb.toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.kwad.sdk.glide.load.engine.r */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.kwad.sdk.glide.load.engine.r */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.kwad.sdk.glide.load.engine.r */
    /* JADX WARN: Multi-variable type inference failed */
    private void b(s<R> sVar, DataSource dataSource) {
        if (sVar instanceof o) {
            ((o) sVar).b();
        }
        r rVar = 0;
        if (this.f35773f.a()) {
            sVar = r.a(sVar);
            rVar = sVar;
        }
        a((s) sVar, dataSource);
        this.r = Stage.ENCODE;
        try {
            if (this.f35773f.a()) {
                this.f35773f.a(this.f35771d, this.o);
            }
            e();
        } finally {
            if (rVar != 0) {
                rVar.b();
            }
        }
    }

    private void e() {
        if (this.f35774g.a()) {
            g();
        }
    }

    private void f() {
        if (this.f35774g.b()) {
            g();
        }
    }

    private void g() {
        this.f35774g.c();
        this.f35773f.b();
        this.f35768a.a();
        this.D = false;
        this.f35775h = null;
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
        this.f35769b.clear();
        this.f35772e.release(this);
    }

    private int h() {
        return this.j.ordinal();
    }

    private void i() {
        int i = AnonymousClass1.f35776a[this.s.ordinal()];
        if (i == 1) {
            this.r = a(Stage.INITIALIZE);
            this.C = j();
        } else if (i != 2) {
            if (i == 3) {
                n();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.s);
        }
        k();
    }

    private com.kwad.sdk.glide.load.engine.e j() {
        int i = AnonymousClass1.f35777b[this.r.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return null;
                    }
                    throw new IllegalStateException("Unrecognized stage: " + this.r);
                }
                return new w(this.f35768a, this);
            }
            return new com.kwad.sdk.glide.load.engine.b(this.f35768a, this);
        }
        return new t(this.f35768a, this);
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
        this.p.a(new GlideException("Failed to load resource", new ArrayList(this.f35769b)));
        f();
    }

    private void m() {
        Throwable th;
        this.f35770c.b();
        if (!this.D) {
            this.D = true;
            return;
        }
        if (this.f35769b.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.f35769b;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    private void n() {
        if (Log.isLoggable(com.bumptech.glide.load.engine.DecodeJob.TAG, 2)) {
            long j = this.t;
            a("Retrieved data", j, "data: " + this.z + ", cache key: " + this.x + ", fetcher: " + this.B);
        }
        s<R> sVar = null;
        try {
            sVar = a(this.B, (com.kwad.sdk.glide.load.a.d<?>) this.z, this.A);
        } catch (GlideException e2) {
            e2.setLoggingDetails(this.y, this.A);
            this.f35769b.add(e2);
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
        int h2 = h() - decodeJob.h();
        return h2 == 0 ? this.q - decodeJob.q : h2;
    }

    public DecodeJob<R> a(com.kwad.sdk.glide.e eVar, Object obj, l lVar, com.kwad.sdk.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, boolean z, boolean z2, boolean z3, com.kwad.sdk.glide.load.e eVar2, a<R> aVar, int i3) {
        this.f35768a.a(eVar, obj, cVar, i, i2, hVar, cls, cls2, priority, eVar2, map, z, z2, this.f35771d);
        this.f35775h = eVar;
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

    @NonNull
    public <Z> s<Z> a(DataSource dataSource, @NonNull s<Z> sVar) {
        s<Z> sVar2;
        com.kwad.sdk.glide.load.h<Z> hVar;
        EncodeStrategy encodeStrategy;
        com.kwad.sdk.glide.load.c cVar;
        Class<?> cls = sVar.e().getClass();
        com.kwad.sdk.glide.load.g<Z> gVar = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            com.kwad.sdk.glide.load.h<Z> c2 = this.f35768a.c(cls);
            hVar = c2;
            sVar2 = c2.a(this.f35775h, sVar, this.l, this.m);
        } else {
            sVar2 = sVar;
            hVar = null;
        }
        if (!sVar.equals(sVar2)) {
            sVar.d_();
        }
        if (this.f35768a.a((s<?>) sVar2)) {
            gVar = this.f35768a.b(sVar2);
            encodeStrategy = gVar.a(this.o);
        } else {
            encodeStrategy = EncodeStrategy.NONE;
        }
        com.kwad.sdk.glide.load.g gVar2 = gVar;
        if (this.n.a(!this.f35768a.a(this.x), dataSource, encodeStrategy)) {
            if (gVar2 != null) {
                int i = AnonymousClass1.f35778c[encodeStrategy.ordinal()];
                if (i == 1) {
                    cVar = new com.kwad.sdk.glide.load.engine.c(this.x, this.i);
                } else if (i != 2) {
                    throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
                } else {
                    cVar = new u(this.f35768a.i(), this.x, this.i, this.l, this.m, hVar, cls, this.o);
                }
                r a2 = r.a(sVar2);
                this.f35773f.a(cVar, gVar2, a2);
                return a2;
            }
            throw new Registry.NoResultEncoderAvailableException(sVar2.e().getClass());
        }
        return sVar2;
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Exception exc, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource) {
        dVar.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(cVar, dataSource, dVar.a());
        this.f35769b.add(glideException);
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

    public void a(boolean z) {
        if (this.f35774g.a(z)) {
            g();
        }
    }

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
        return this.f35770c;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.kwad.sdk.glide.g.a.b.a("DecodeJob#run(model=%s)", this.v);
        com.kwad.sdk.glide.load.a.d<?> dVar = this.B;
        try {
            try {
                if (this.E) {
                    l();
                    if (dVar != null) {
                        dVar.b();
                    }
                    com.kwad.sdk.glide.g.a.b.a();
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
        }
    }
}
