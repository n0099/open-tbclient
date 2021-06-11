package d.b.c.a.b.a.h;

import android.os.SystemClock;
import d.b.c.a.b.a.h.f;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class e implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f69086e;

    /* renamed from: f  reason: collision with root package name */
    public final i f69087f;

    /* renamed from: h  reason: collision with root package name */
    public final String f69089h;

    /* renamed from: i  reason: collision with root package name */
    public int f69090i;
    public int j;
    public boolean k;
    public final ExecutorService l;
    public Map<Integer, d.b.c.a.b.a.h.j> m;
    public final k n;
    public long p;
    public final Socket t;
    public final d.b.c.a.b.a.h.h u;
    public final j v;
    public static final /* synthetic */ boolean y = !e.class.desiredAssertionStatus();
    public static final ExecutorService x = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), d.b.c.a.b.a.e.o("OkHttp Http2Connection", true));

    /* renamed from: g  reason: collision with root package name */
    public final Map<Integer, d.b.c.a.b.a.h.g> f69088g = new LinkedHashMap();
    public long o = 0;
    public l q = new l();
    public final l r = new l();
    public boolean s = false;
    public final Set<Integer> w = new LinkedHashSet();

    /* loaded from: classes6.dex */
    public class a extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f69091f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sdk.a.b.a.e.b f69092g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Object[] objArr, int i2, com.bytedance.sdk.a.b.a.e.b bVar) {
            super(str, objArr);
            this.f69091f = i2;
            this.f69092g = bVar;
        }

        @Override // d.b.c.a.b.a.d
        public void i() {
            try {
                e.this.D(this.f69091f, this.f69092g);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f69094f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f69095g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Object[] objArr, int i2, long j) {
            super(str, objArr);
            this.f69094f = i2;
            this.f69095g = j;
        }

        @Override // d.b.c.a.b.a.d
        public void i() {
            try {
                e.this.u.r(this.f69094f, this.f69095g);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f69097f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f69098g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f69099h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.b.c.a.b.a.h.j f69100i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Object[] objArr, boolean z, int i2, int i3, d.b.c.a.b.a.h.j jVar) {
            super(str, objArr);
            this.f69097f = z;
            this.f69098g = i2;
            this.f69099h = i3;
            this.f69100i = jVar;
        }

        @Override // d.b.c.a.b.a.d
        public void i() {
            try {
                e.this.E(this.f69097f, this.f69098g, this.f69099h, this.f69100i);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f69101f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f69102g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Object[] objArr, int i2, List list) {
            super(str, objArr);
            this.f69101f = i2;
            this.f69102g = list;
        }

        @Override // d.b.c.a.b.a.d
        public void i() {
            if (e.this.n.a(this.f69101f, this.f69102g)) {
                try {
                    e.this.u.s(this.f69101f, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                    synchronized (e.this) {
                        e.this.w.remove(Integer.valueOf(this.f69101f));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* renamed from: d.b.c.a.b.a.h.e$e  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1888e extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f69104f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f69105g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f69106h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1888e(String str, Object[] objArr, int i2, List list, boolean z) {
            super(str, objArr);
            this.f69104f = i2;
            this.f69105g = list;
            this.f69106h = z;
        }

        @Override // d.b.c.a.b.a.d
        public void i() {
            boolean c2 = e.this.n.c(this.f69104f, this.f69105g, this.f69106h);
            if (c2) {
                try {
                    e.this.u.s(this.f69104f, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (c2 || this.f69106h) {
                synchronized (e.this) {
                    e.this.w.remove(Integer.valueOf(this.f69104f));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f69108f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.c.a.a.c f69109g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f69110h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f69111i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Object[] objArr, int i2, d.b.c.a.a.c cVar, int i3, boolean z) {
            super(str, objArr);
            this.f69108f = i2;
            this.f69109g = cVar;
            this.f69110h = i3;
            this.f69111i = z;
        }

        @Override // d.b.c.a.b.a.d
        public void i() {
            try {
                boolean b2 = e.this.n.b(this.f69108f, this.f69109g, this.f69110h, this.f69111i);
                if (b2) {
                    e.this.u.s(this.f69108f, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                }
                if (b2 || this.f69111i) {
                    synchronized (e.this) {
                        e.this.w.remove(Integer.valueOf(this.f69108f));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f69112f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sdk.a.b.a.e.b f69113g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, Object[] objArr, int i2, com.bytedance.sdk.a.b.a.e.b bVar) {
            super(str, objArr);
            this.f69112f = i2;
            this.f69113g = bVar;
        }

        @Override // d.b.c.a.b.a.d
        public void i() {
            e.this.n.a(this.f69112f, this.f69113g);
            synchronized (e.this) {
                e.this.w.remove(Integer.valueOf(this.f69112f));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public Socket f69115a;

        /* renamed from: b  reason: collision with root package name */
        public String f69116b;

        /* renamed from: c  reason: collision with root package name */
        public d.b.c.a.a.e f69117c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.c.a.a.d f69118d;

        /* renamed from: e  reason: collision with root package name */
        public i f69119e = i.f69122a;

        /* renamed from: f  reason: collision with root package name */
        public k f69120f = k.f69174a;

        /* renamed from: g  reason: collision with root package name */
        public boolean f69121g;

        public h(boolean z) {
            this.f69121g = z;
        }

        public h a(i iVar) {
            this.f69119e = iVar;
            return this;
        }

        public h b(Socket socket, String str, d.b.c.a.a.e eVar, d.b.c.a.a.d dVar) {
            this.f69115a = socket;
            this.f69116b = str;
            this.f69117c = eVar;
            this.f69118d = dVar;
            return this;
        }

        public e c() {
            return new e(this);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class i {

        /* renamed from: a  reason: collision with root package name */
        public static final i f69122a = new a();

        /* loaded from: classes6.dex */
        public static class a extends i {
            @Override // d.b.c.a.b.a.h.e.i
            public void b(d.b.c.a.b.a.h.g gVar) throws IOException {
                gVar.d(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
            }
        }

        public void a(e eVar) {
        }

        public abstract void b(d.b.c.a.b.a.h.g gVar) throws IOException;
    }

    public e(h hVar) {
        this.n = hVar.f69120f;
        boolean z = hVar.f69121g;
        this.f69086e = z;
        this.f69087f = hVar.f69119e;
        int i2 = z ? 1 : 2;
        this.j = i2;
        if (hVar.f69121g) {
            this.j = i2 + 2;
        }
        boolean z2 = hVar.f69121g;
        if (hVar.f69121g) {
            this.q.a(7, 16777216);
        }
        this.f69089h = hVar.f69116b;
        this.l = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), d.b.c.a.b.a.e.o(d.b.c.a.b.a.e.j("OkHttp %s Push Observer", this.f69089h), true));
        this.r.a(7, 65535);
        this.r.a(5, 16384);
        this.p = this.r.i();
        this.t = hVar.f69115a;
        this.u = new d.b.c.a.b.a.h.h(hVar.f69118d, this.f69086e);
        this.v = new j(new d.b.c.a.b.a.h.f(hVar.f69117c, this.f69086e));
    }

    public synchronized d.b.c.a.b.a.h.g A(int i2) {
        d.b.c.a.b.a.h.g remove;
        remove = this.f69088g.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037 A[Catch: all -> 0x0069, TryCatch #1 {, blocks: (B:4:0x0006, B:21:0x0043, B:25:0x0052, B:22:0x0049, B:24:0x004d, B:29:0x005b, B:30:0x0062, B:5:0x0007, B:7:0x000b, B:9:0x001f, B:11:0x0027, B:16:0x0031, B:18:0x0037, B:19:0x0040, B:31:0x0063, B:32:0x0068), top: B:39:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d.b.c.a.b.a.h.g B(int i2, List<d.b.c.a.b.a.h.a> list, boolean z) throws IOException {
        int i3;
        d.b.c.a.b.a.h.g gVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.u) {
            synchronized (this) {
                if (!this.k) {
                    i3 = this.j;
                    this.j += 2;
                    gVar = new d.b.c.a.b.a.h.g(i3, this, z3, false, list);
                    if (z && this.p != 0 && gVar.f69141b != 0) {
                        z2 = false;
                        if (gVar.g()) {
                            this.f69088g.put(Integer.valueOf(i3), gVar);
                        }
                    }
                    z2 = true;
                    if (gVar.g()) {
                    }
                } else {
                    throw new com.bytedance.sdk.a.b.a.e.a();
                }
            }
            if (i2 == 0) {
                this.u.x(z3, i3, i2, list);
            } else if (!this.f69086e) {
                this.u.q(i2, i3, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (z2) {
            this.u.A();
        }
        return gVar;
    }

    public void C() throws IOException {
        this.u.A();
    }

    public void D(int i2, com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        this.u.s(i2, bVar);
    }

    public void E(boolean z, int i2, int i3, d.b.c.a.b.a.h.j jVar) throws IOException {
        synchronized (this.u) {
            if (jVar != null) {
                jVar.a();
            }
            this.u.w(z, i2, i3);
        }
    }

    public synchronized d.b.c.a.b.a.h.j F(int i2) {
        return this.m != null ? this.m.remove(Integer.valueOf(i2)) : null;
    }

    public void G() throws IOException {
        y(true);
    }

    public void H(int i2, com.bytedance.sdk.a.b.a.e.b bVar) {
        this.l.execute(new g("OkHttp %s Push Reset[%s]", new Object[]{this.f69089h, Integer.valueOf(i2)}, i2, bVar));
    }

    public synchronized boolean I() {
        return this.k;
    }

    public boolean J(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    public void a(long j2) {
        this.p += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        x(com.bytedance.sdk.a.b.a.e.b.NO_ERROR, com.bytedance.sdk.a.b.a.e.b.CANCEL);
    }

    public synchronized int n() {
        return this.r.h(Integer.MAX_VALUE);
    }

    public synchronized d.b.c.a.b.a.h.g o(int i2) {
        return this.f69088g.get(Integer.valueOf(i2));
    }

    public d.b.c.a.b.a.h.g p(List<d.b.c.a.b.a.h.a> list, boolean z) throws IOException {
        return B(0, list, z);
    }

    public void q(int i2, long j2) {
        x.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f69089h, Integer.valueOf(i2)}, i2, j2));
    }

    public void r(int i2, d.b.c.a.a.e eVar, int i3, boolean z) throws IOException {
        d.b.c.a.a.c cVar = new d.b.c.a.a.c();
        long j2 = i3;
        eVar.a(j2);
        eVar.a(cVar, j2);
        if (cVar.v() == j2) {
            this.l.execute(new f("OkHttp %s Push Data[%s]", new Object[]{this.f69089h, Integer.valueOf(i2)}, i2, cVar, i3, z));
            return;
        }
        throw new IOException(cVar.v() + " != " + i3);
    }

    public void s(int i2, com.bytedance.sdk.a.b.a.e.b bVar) {
        x.execute(new a("OkHttp %s stream %d", new Object[]{this.f69089h, Integer.valueOf(i2)}, i2, bVar));
    }

    public void t(int i2, List<d.b.c.a.b.a.h.a> list) {
        synchronized (this) {
            if (this.w.contains(Integer.valueOf(i2))) {
                s(i2, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                return;
            }
            this.w.add(Integer.valueOf(i2));
            this.l.execute(new d("OkHttp %s Push Request[%s]", new Object[]{this.f69089h, Integer.valueOf(i2)}, i2, list));
        }
    }

    public void u(int i2, List<d.b.c.a.b.a.h.a> list, boolean z) {
        this.l.execute(new C1888e("OkHttp %s Push Headers[%s]", new Object[]{this.f69089h, Integer.valueOf(i2)}, i2, list, z));
    }

    public void v(int i2, boolean z, d.b.c.a.a.c cVar, long j2) throws IOException {
        int min;
        long j3;
        if (j2 == 0) {
            this.u.y(z, i2, cVar, 0);
            return;
        }
        while (j2 > 0) {
            synchronized (this) {
                while (this.p <= 0) {
                    try {
                        if (this.f69088g.containsKey(Integer.valueOf(i2))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j2, this.p), this.u.D());
                j3 = min;
                this.p -= j3;
            }
            j2 -= j3;
            this.u.y(z && j2 == 0, i2, cVar, min);
        }
    }

    public void w(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        synchronized (this.u) {
            synchronized (this) {
                if (this.k) {
                    return;
                }
                this.k = true;
                this.u.t(this.f69090i, bVar, d.b.c.a.b.a.e.f68985a);
            }
        }
    }

    public void x(com.bytedance.sdk.a.b.a.e.b bVar, com.bytedance.sdk.a.b.a.e.b bVar2) throws IOException {
        d.b.c.a.b.a.h.g[] gVarArr;
        if (!y && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        d.b.c.a.b.a.h.j[] jVarArr = null;
        try {
            w(bVar);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (this.f69088g.isEmpty()) {
                gVarArr = null;
            } else {
                gVarArr = (d.b.c.a.b.a.h.g[]) this.f69088g.values().toArray(new d.b.c.a.b.a.h.g[this.f69088g.size()]);
                this.f69088g.clear();
            }
            if (this.m != null) {
                this.m = null;
                jVarArr = (d.b.c.a.b.a.h.j[]) this.m.values().toArray(new d.b.c.a.b.a.h.j[this.m.size()]);
            }
        }
        if (gVarArr != null) {
            for (d.b.c.a.b.a.h.g gVar : gVarArr) {
                try {
                    gVar.d(bVar2);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        if (jVarArr != null) {
            for (d.b.c.a.b.a.h.j jVar : jVarArr) {
                jVar.c();
            }
        }
        try {
            this.u.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.t.close();
        } catch (IOException e5) {
            e = e5;
        }
        if (e != null) {
            throw e;
        }
    }

    public void y(boolean z) throws IOException {
        if (z) {
            this.u.n();
            this.u.C(this.q);
            int i2 = this.q.i();
            if (i2 != 65535) {
                this.u.r(0, i2 - 65535);
            }
        }
        Thread thread = new Thread(this.v);
        thread.setName("tt_pangle_thread_http2_connection" + SystemClock.uptimeMillis());
        thread.start();
    }

    public void z(boolean z, int i2, int i3, d.b.c.a.b.a.h.j jVar) {
        x.execute(new c("OkHttp %s ping %08x%08x", new Object[]{this.f69089h, Integer.valueOf(i2), Integer.valueOf(i3)}, z, i2, i3, jVar));
    }

    /* loaded from: classes6.dex */
    public class j extends d.b.c.a.b.a.d implements f.b {

        /* renamed from: f  reason: collision with root package name */
        public final d.b.c.a.b.a.h.f f69123f;

        /* loaded from: classes6.dex */
        public class a extends d.b.c.a.b.a.d {

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.b.c.a.b.a.h.g f69125f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, Object[] objArr, d.b.c.a.b.a.h.g gVar) {
                super(str, objArr);
                this.f69125f = gVar;
            }

            @Override // d.b.c.a.b.a.d
            public void i() {
                try {
                    e.this.f69087f.b(this.f69125f);
                } catch (IOException e2) {
                    d.b.c.a.b.a.i.e j = d.b.c.a.b.a.i.e.j();
                    j.f(4, "Http2Connection.Listener failure for " + e.this.f69089h, e2);
                    try {
                        this.f69125f.d(com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b extends d.b.c.a.b.a.d {
            public b(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // d.b.c.a.b.a.d
            public void i() {
                e eVar = e.this;
                eVar.f69087f.a(eVar);
            }
        }

        /* loaded from: classes6.dex */
        public class c extends d.b.c.a.b.a.d {

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f69128f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, Object[] objArr, l lVar) {
                super(str, objArr);
                this.f69128f = lVar;
            }

            @Override // d.b.c.a.b.a.d
            public void i() {
                try {
                    e.this.u.v(this.f69128f);
                } catch (IOException unused) {
                }
            }
        }

        public j(d.b.c.a.b.a.h.f fVar) {
            super("OkHttp %s", e.this.f69089h);
            this.f69123f = fVar;
        }

        @Override // d.b.c.a.b.a.h.f.b
        public void a() {
        }

        @Override // d.b.c.a.b.a.h.f.b
        public void a(int i2, com.bytedance.sdk.a.b.a.e.b bVar) {
            if (e.this.J(i2)) {
                e.this.H(i2, bVar);
                return;
            }
            d.b.c.a.b.a.h.g A = e.this.A(i2);
            if (A != null) {
                A.h(bVar);
            }
        }

        @Override // d.b.c.a.b.a.h.f.b
        public void b(boolean z, int i2, int i3) {
            if (z) {
                d.b.c.a.b.a.h.j F = e.this.F(i2);
                if (F != null) {
                    F.b();
                    return;
                }
                return;
            }
            e.this.z(true, i2, i3, null);
        }

        @Override // d.b.c.a.b.a.h.f.b
        public void c(int i2, int i3, List<d.b.c.a.b.a.h.a> list) {
            e.this.t(i3, list);
        }

        @Override // d.b.c.a.b.a.h.f.b
        public void d(boolean z, int i2, int i3, List<d.b.c.a.b.a.h.a> list) {
            if (e.this.J(i2)) {
                e.this.u(i2, list, z);
                return;
            }
            synchronized (e.this) {
                d.b.c.a.b.a.h.g o = e.this.o(i2);
                if (o == null) {
                    if (e.this.k) {
                        return;
                    }
                    if (i2 <= e.this.f69090i) {
                        return;
                    }
                    if (i2 % 2 == e.this.j % 2) {
                        return;
                    }
                    d.b.c.a.b.a.h.g gVar = new d.b.c.a.b.a.h.g(i2, e.this, false, z, list);
                    e.this.f69090i = i2;
                    e.this.f69088g.put(Integer.valueOf(i2), gVar);
                    e.x.execute(new a("OkHttp %s stream %d", new Object[]{e.this.f69089h, Integer.valueOf(i2)}, gVar));
                    return;
                }
                o.e(list);
                if (z) {
                    o.p();
                }
            }
        }

        @Override // d.b.c.a.b.a.h.f.b
        public void e(int i2, int i3, int i4, boolean z) {
        }

        @Override // d.b.c.a.b.a.h.f.b
        public void f(int i2, com.bytedance.sdk.a.b.a.e.b bVar, com.bytedance.sdk.a.a.f fVar) {
            d.b.c.a.b.a.h.g[] gVarArr;
            fVar.g();
            synchronized (e.this) {
                gVarArr = (d.b.c.a.b.a.h.g[]) e.this.f69088g.values().toArray(new d.b.c.a.b.a.h.g[e.this.f69088g.size()]);
                e.this.k = true;
            }
            for (d.b.c.a.b.a.h.g gVar : gVarArr) {
                if (gVar.a() > i2 && gVar.i()) {
                    gVar.h(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
                    e.this.A(gVar.a());
                }
            }
        }

        @Override // d.b.c.a.b.a.h.f.b
        public void g(boolean z, int i2, d.b.c.a.a.e eVar, int i3) throws IOException {
            if (e.this.J(i2)) {
                e.this.r(i2, eVar, i3, z);
                return;
            }
            d.b.c.a.b.a.h.g o = e.this.o(i2);
            if (o == null) {
                e.this.s(i2, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                eVar.g(i3);
                return;
            }
            o.c(eVar, i3);
            if (z) {
                o.p();
            }
        }

        @Override // d.b.c.a.b.a.h.f.b
        public void h(boolean z, l lVar) {
            d.b.c.a.b.a.h.g[] gVarArr;
            long j;
            int i2;
            synchronized (e.this) {
                int i3 = e.this.r.i();
                if (z) {
                    e.this.r.b();
                }
                e.this.r.c(lVar);
                j(lVar);
                int i4 = e.this.r.i();
                gVarArr = null;
                if (i4 == -1 || i4 == i3) {
                    j = 0;
                } else {
                    j = i4 - i3;
                    if (!e.this.s) {
                        e.this.a(j);
                        e.this.s = true;
                    }
                    if (!e.this.f69088g.isEmpty()) {
                        gVarArr = (d.b.c.a.b.a.h.g[]) e.this.f69088g.values().toArray(new d.b.c.a.b.a.h.g[e.this.f69088g.size()]);
                    }
                }
                e.x.execute(new b("OkHttp %s settings", e.this.f69089h));
            }
            if (gVarArr == null || j == 0) {
                return;
            }
            for (d.b.c.a.b.a.h.g gVar : gVarArr) {
                synchronized (gVar) {
                    gVar.b(j);
                }
            }
        }

        @Override // d.b.c.a.b.a.d
        public void i() {
            com.bytedance.sdk.a.b.a.e.b bVar;
            e eVar;
            com.bytedance.sdk.a.b.a.e.b bVar2 = com.bytedance.sdk.a.b.a.e.b.INTERNAL_ERROR;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    this.f69123f.l(this);
                    while (this.f69123f.o(false, this)) {
                    }
                    bVar = com.bytedance.sdk.a.b.a.e.b.NO_ERROR;
                } catch (IOException unused) {
                }
                try {
                    bVar2 = com.bytedance.sdk.a.b.a.e.b.CANCEL;
                    eVar = e.this;
                } catch (IOException unused2) {
                    bVar = com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR;
                    bVar2 = com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR;
                    eVar = e.this;
                    eVar.x(bVar, bVar2);
                    d.b.c.a.b.a.e.q(this.f69123f);
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                try {
                    e.this.x(bVar, bVar2);
                } catch (IOException unused4) {
                }
                d.b.c.a.b.a.e.q(this.f69123f);
                throw th;
            }
            eVar.x(bVar, bVar2);
            d.b.c.a.b.a.e.q(this.f69123f);
        }

        public final void j(l lVar) {
            e.x.execute(new c("OkHttp %s ACK Settings", new Object[]{e.this.f69089h}, lVar));
        }

        @Override // d.b.c.a.b.a.h.f.b
        public void a(int i2, long j) {
            if (i2 == 0) {
                synchronized (e.this) {
                    e.this.p += j;
                    e.this.notifyAll();
                }
                return;
            }
            d.b.c.a.b.a.h.g o = e.this.o(i2);
            if (o != null) {
                synchronized (o) {
                    o.b(j);
                }
            }
        }
    }
}
