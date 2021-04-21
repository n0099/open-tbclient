package d.c.c.a.b.a.h;

import android.os.SystemClock;
import d.c.c.a.b.a.h.f;
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
/* loaded from: classes5.dex */
public final class e implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f66251e;

    /* renamed from: f  reason: collision with root package name */
    public final i f66252f;

    /* renamed from: h  reason: collision with root package name */
    public final String f66254h;
    public int i;
    public int j;
    public boolean k;
    public final ExecutorService l;
    public Map<Integer, d.c.c.a.b.a.h.j> m;
    public final k n;
    public long p;
    public final Socket t;
    public final d.c.c.a.b.a.h.h u;
    public final j v;
    public static final /* synthetic */ boolean y = !e.class.desiredAssertionStatus();
    public static final ExecutorService x = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), d.c.c.a.b.a.e.o("OkHttp Http2Connection", true));

    /* renamed from: g  reason: collision with root package name */
    public final Map<Integer, d.c.c.a.b.a.h.g> f66253g = new LinkedHashMap();
    public long o = 0;
    public l q = new l();
    public final l r = new l();
    public boolean s = false;
    public final Set<Integer> w = new LinkedHashSet();

    /* loaded from: classes5.dex */
    public class a extends d.c.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f66255f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sdk.a.b.a.e.b f66256g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Object[] objArr, int i, com.bytedance.sdk.a.b.a.e.b bVar) {
            super(str, objArr);
            this.f66255f = i;
            this.f66256g = bVar;
        }

        @Override // d.c.c.a.b.a.d
        public void i() {
            try {
                e.this.D(this.f66255f, this.f66256g);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.c.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f66258f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f66259g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Object[] objArr, int i, long j) {
            super(str, objArr);
            this.f66258f = i;
            this.f66259g = j;
        }

        @Override // d.c.c.a.b.a.d
        public void i() {
            try {
                e.this.u.r(this.f66258f, this.f66259g);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.c.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f66261f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f66262g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f66263h;
        public final /* synthetic */ d.c.c.a.b.a.h.j i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Object[] objArr, boolean z, int i, int i2, d.c.c.a.b.a.h.j jVar) {
            super(str, objArr);
            this.f66261f = z;
            this.f66262g = i;
            this.f66263h = i2;
            this.i = jVar;
        }

        @Override // d.c.c.a.b.a.d
        public void i() {
            try {
                e.this.E(this.f66261f, this.f66262g, this.f66263h, this.i);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends d.c.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f66264f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f66265g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Object[] objArr, int i, List list) {
            super(str, objArr);
            this.f66264f = i;
            this.f66265g = list;
        }

        @Override // d.c.c.a.b.a.d
        public void i() {
            if (e.this.n.a(this.f66264f, this.f66265g)) {
                try {
                    e.this.u.s(this.f66264f, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                    synchronized (e.this) {
                        e.this.w.remove(Integer.valueOf(this.f66264f));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* renamed from: d.c.c.a.b.a.h.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1821e extends d.c.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f66267f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f66268g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f66269h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1821e(String str, Object[] objArr, int i, List list, boolean z) {
            super(str, objArr);
            this.f66267f = i;
            this.f66268g = list;
            this.f66269h = z;
        }

        @Override // d.c.c.a.b.a.d
        public void i() {
            boolean c2 = e.this.n.c(this.f66267f, this.f66268g, this.f66269h);
            if (c2) {
                try {
                    e.this.u.s(this.f66267f, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (c2 || this.f66269h) {
                synchronized (e.this) {
                    e.this.w.remove(Integer.valueOf(this.f66267f));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends d.c.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f66270f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.c.c.a.a.c f66271g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f66272h;
        public final /* synthetic */ boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Object[] objArr, int i, d.c.c.a.a.c cVar, int i2, boolean z) {
            super(str, objArr);
            this.f66270f = i;
            this.f66271g = cVar;
            this.f66272h = i2;
            this.i = z;
        }

        @Override // d.c.c.a.b.a.d
        public void i() {
            try {
                boolean b2 = e.this.n.b(this.f66270f, this.f66271g, this.f66272h, this.i);
                if (b2) {
                    e.this.u.s(this.f66270f, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                }
                if (b2 || this.i) {
                    synchronized (e.this) {
                        e.this.w.remove(Integer.valueOf(this.f66270f));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends d.c.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f66273f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sdk.a.b.a.e.b f66274g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, Object[] objArr, int i, com.bytedance.sdk.a.b.a.e.b bVar) {
            super(str, objArr);
            this.f66273f = i;
            this.f66274g = bVar;
        }

        @Override // d.c.c.a.b.a.d
        public void i() {
            e.this.n.a(this.f66273f, this.f66274g);
            synchronized (e.this) {
                e.this.w.remove(Integer.valueOf(this.f66273f));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public Socket f66276a;

        /* renamed from: b  reason: collision with root package name */
        public String f66277b;

        /* renamed from: c  reason: collision with root package name */
        public d.c.c.a.a.e f66278c;

        /* renamed from: d  reason: collision with root package name */
        public d.c.c.a.a.d f66279d;

        /* renamed from: e  reason: collision with root package name */
        public i f66280e = i.f66283a;

        /* renamed from: f  reason: collision with root package name */
        public k f66281f = k.f66329a;

        /* renamed from: g  reason: collision with root package name */
        public boolean f66282g;

        public h(boolean z) {
            this.f66282g = z;
        }

        public h a(i iVar) {
            this.f66280e = iVar;
            return this;
        }

        public h b(Socket socket, String str, d.c.c.a.a.e eVar, d.c.c.a.a.d dVar) {
            this.f66276a = socket;
            this.f66277b = str;
            this.f66278c = eVar;
            this.f66279d = dVar;
            return this;
        }

        public e c() {
            return new e(this);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class i {

        /* renamed from: a  reason: collision with root package name */
        public static final i f66283a = new a();

        /* loaded from: classes5.dex */
        public static class a extends i {
            @Override // d.c.c.a.b.a.h.e.i
            public void b(d.c.c.a.b.a.h.g gVar) throws IOException {
                gVar.d(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
            }
        }

        public void a(e eVar) {
        }

        public abstract void b(d.c.c.a.b.a.h.g gVar) throws IOException;
    }

    public e(h hVar) {
        this.n = hVar.f66281f;
        boolean z = hVar.f66282g;
        this.f66251e = z;
        this.f66252f = hVar.f66280e;
        int i2 = z ? 1 : 2;
        this.j = i2;
        if (hVar.f66282g) {
            this.j = i2 + 2;
        }
        boolean z2 = hVar.f66282g;
        if (hVar.f66282g) {
            this.q.a(7, 16777216);
        }
        this.f66254h = hVar.f66277b;
        this.l = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), d.c.c.a.b.a.e.o(d.c.c.a.b.a.e.j("OkHttp %s Push Observer", this.f66254h), true));
        this.r.a(7, 65535);
        this.r.a(5, 16384);
        this.p = this.r.i();
        this.t = hVar.f66276a;
        this.u = new d.c.c.a.b.a.h.h(hVar.f66279d, this.f66251e);
        this.v = new j(new d.c.c.a.b.a.h.f(hVar.f66278c, this.f66251e));
    }

    public synchronized d.c.c.a.b.a.h.g A(int i2) {
        d.c.c.a.b.a.h.g remove;
        remove = this.f66253g.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037 A[Catch: all -> 0x0069, TryCatch #1 {, blocks: (B:4:0x0006, B:21:0x0043, B:25:0x0052, B:22:0x0049, B:24:0x004d, B:29:0x005b, B:30:0x0062, B:5:0x0007, B:7:0x000b, B:9:0x001f, B:11:0x0027, B:16:0x0031, B:18:0x0037, B:19:0x0040, B:31:0x0063, B:32:0x0068), top: B:39:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d.c.c.a.b.a.h.g B(int i2, List<d.c.c.a.b.a.h.a> list, boolean z) throws IOException {
        int i3;
        d.c.c.a.b.a.h.g gVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.u) {
            synchronized (this) {
                if (!this.k) {
                    i3 = this.j;
                    this.j += 2;
                    gVar = new d.c.c.a.b.a.h.g(i3, this, z3, false, list);
                    if (z && this.p != 0 && gVar.f66300b != 0) {
                        z2 = false;
                        if (gVar.g()) {
                            this.f66253g.put(Integer.valueOf(i3), gVar);
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
            } else if (!this.f66251e) {
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

    public void E(boolean z, int i2, int i3, d.c.c.a.b.a.h.j jVar) throws IOException {
        synchronized (this.u) {
            if (jVar != null) {
                jVar.a();
            }
            this.u.w(z, i2, i3);
        }
    }

    public synchronized d.c.c.a.b.a.h.j F(int i2) {
        return this.m != null ? this.m.remove(Integer.valueOf(i2)) : null;
    }

    public void G() throws IOException {
        y(true);
    }

    public void H(int i2, com.bytedance.sdk.a.b.a.e.b bVar) {
        this.l.execute(new g("OkHttp %s Push Reset[%s]", new Object[]{this.f66254h, Integer.valueOf(i2)}, i2, bVar));
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

    public synchronized d.c.c.a.b.a.h.g o(int i2) {
        return this.f66253g.get(Integer.valueOf(i2));
    }

    public d.c.c.a.b.a.h.g p(List<d.c.c.a.b.a.h.a> list, boolean z) throws IOException {
        return B(0, list, z);
    }

    public void q(int i2, long j2) {
        x.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f66254h, Integer.valueOf(i2)}, i2, j2));
    }

    public void r(int i2, d.c.c.a.a.e eVar, int i3, boolean z) throws IOException {
        d.c.c.a.a.c cVar = new d.c.c.a.a.c();
        long j2 = i3;
        eVar.a(j2);
        eVar.a(cVar, j2);
        if (cVar.v() == j2) {
            this.l.execute(new f("OkHttp %s Push Data[%s]", new Object[]{this.f66254h, Integer.valueOf(i2)}, i2, cVar, i3, z));
            return;
        }
        throw new IOException(cVar.v() + " != " + i3);
    }

    public void s(int i2, com.bytedance.sdk.a.b.a.e.b bVar) {
        x.execute(new a("OkHttp %s stream %d", new Object[]{this.f66254h, Integer.valueOf(i2)}, i2, bVar));
    }

    public void t(int i2, List<d.c.c.a.b.a.h.a> list) {
        synchronized (this) {
            if (this.w.contains(Integer.valueOf(i2))) {
                s(i2, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                return;
            }
            this.w.add(Integer.valueOf(i2));
            this.l.execute(new d("OkHttp %s Push Request[%s]", new Object[]{this.f66254h, Integer.valueOf(i2)}, i2, list));
        }
    }

    public void u(int i2, List<d.c.c.a.b.a.h.a> list, boolean z) {
        this.l.execute(new C1821e("OkHttp %s Push Headers[%s]", new Object[]{this.f66254h, Integer.valueOf(i2)}, i2, list, z));
    }

    public void v(int i2, boolean z, d.c.c.a.a.c cVar, long j2) throws IOException {
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
                        if (this.f66253g.containsKey(Integer.valueOf(i2))) {
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
                this.u.t(this.i, bVar, d.c.c.a.b.a.e.f66158a);
            }
        }
    }

    public void x(com.bytedance.sdk.a.b.a.e.b bVar, com.bytedance.sdk.a.b.a.e.b bVar2) throws IOException {
        d.c.c.a.b.a.h.g[] gVarArr;
        if (!y && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        d.c.c.a.b.a.h.j[] jVarArr = null;
        try {
            w(bVar);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (this.f66253g.isEmpty()) {
                gVarArr = null;
            } else {
                gVarArr = (d.c.c.a.b.a.h.g[]) this.f66253g.values().toArray(new d.c.c.a.b.a.h.g[this.f66253g.size()]);
                this.f66253g.clear();
            }
            if (this.m != null) {
                this.m = null;
                jVarArr = (d.c.c.a.b.a.h.j[]) this.m.values().toArray(new d.c.c.a.b.a.h.j[this.m.size()]);
            }
        }
        if (gVarArr != null) {
            for (d.c.c.a.b.a.h.g gVar : gVarArr) {
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
            for (d.c.c.a.b.a.h.j jVar : jVarArr) {
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

    public void z(boolean z, int i2, int i3, d.c.c.a.b.a.h.j jVar) {
        x.execute(new c("OkHttp %s ping %08x%08x", new Object[]{this.f66254h, Integer.valueOf(i2), Integer.valueOf(i3)}, z, i2, i3, jVar));
    }

    /* loaded from: classes5.dex */
    public class j extends d.c.c.a.b.a.d implements f.b {

        /* renamed from: f  reason: collision with root package name */
        public final d.c.c.a.b.a.h.f f66284f;

        /* loaded from: classes5.dex */
        public class a extends d.c.c.a.b.a.d {

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.c.c.a.b.a.h.g f66286f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, Object[] objArr, d.c.c.a.b.a.h.g gVar) {
                super(str, objArr);
                this.f66286f = gVar;
            }

            @Override // d.c.c.a.b.a.d
            public void i() {
                try {
                    e.this.f66252f.b(this.f66286f);
                } catch (IOException e2) {
                    d.c.c.a.b.a.i.e j = d.c.c.a.b.a.i.e.j();
                    j.f(4, "Http2Connection.Listener failure for " + e.this.f66254h, e2);
                    try {
                        this.f66286f.d(com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b extends d.c.c.a.b.a.d {
            public b(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // d.c.c.a.b.a.d
            public void i() {
                e eVar = e.this;
                eVar.f66252f.a(eVar);
            }
        }

        /* loaded from: classes5.dex */
        public class c extends d.c.c.a.b.a.d {

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f66289f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, Object[] objArr, l lVar) {
                super(str, objArr);
                this.f66289f = lVar;
            }

            @Override // d.c.c.a.b.a.d
            public void i() {
                try {
                    e.this.u.v(this.f66289f);
                } catch (IOException unused) {
                }
            }
        }

        public j(d.c.c.a.b.a.h.f fVar) {
            super("OkHttp %s", e.this.f66254h);
            this.f66284f = fVar;
        }

        @Override // d.c.c.a.b.a.h.f.b
        public void a() {
        }

        @Override // d.c.c.a.b.a.h.f.b
        public void a(int i, com.bytedance.sdk.a.b.a.e.b bVar) {
            if (e.this.J(i)) {
                e.this.H(i, bVar);
                return;
            }
            d.c.c.a.b.a.h.g A = e.this.A(i);
            if (A != null) {
                A.h(bVar);
            }
        }

        @Override // d.c.c.a.b.a.h.f.b
        public void b(boolean z, int i, int i2) {
            if (z) {
                d.c.c.a.b.a.h.j F = e.this.F(i);
                if (F != null) {
                    F.b();
                    return;
                }
                return;
            }
            e.this.z(true, i, i2, null);
        }

        @Override // d.c.c.a.b.a.h.f.b
        public void c(int i, int i2, List<d.c.c.a.b.a.h.a> list) {
            e.this.t(i2, list);
        }

        @Override // d.c.c.a.b.a.h.f.b
        public void d(int i, com.bytedance.sdk.a.b.a.e.b bVar, com.bytedance.sdk.a.a.f fVar) {
            d.c.c.a.b.a.h.g[] gVarArr;
            fVar.g();
            synchronized (e.this) {
                gVarArr = (d.c.c.a.b.a.h.g[]) e.this.f66253g.values().toArray(new d.c.c.a.b.a.h.g[e.this.f66253g.size()]);
                e.this.k = true;
            }
            for (d.c.c.a.b.a.h.g gVar : gVarArr) {
                if (gVar.a() > i && gVar.i()) {
                    gVar.h(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
                    e.this.A(gVar.a());
                }
            }
        }

        @Override // d.c.c.a.b.a.h.f.b
        public void e(boolean z, int i, int i2, List<d.c.c.a.b.a.h.a> list) {
            if (e.this.J(i)) {
                e.this.u(i, list, z);
                return;
            }
            synchronized (e.this) {
                d.c.c.a.b.a.h.g o = e.this.o(i);
                if (o == null) {
                    if (e.this.k) {
                        return;
                    }
                    if (i <= e.this.i) {
                        return;
                    }
                    if (i % 2 == e.this.j % 2) {
                        return;
                    }
                    d.c.c.a.b.a.h.g gVar = new d.c.c.a.b.a.h.g(i, e.this, false, z, list);
                    e.this.i = i;
                    e.this.f66253g.put(Integer.valueOf(i), gVar);
                    e.x.execute(new a("OkHttp %s stream %d", new Object[]{e.this.f66254h, Integer.valueOf(i)}, gVar));
                    return;
                }
                o.e(list);
                if (z) {
                    o.p();
                }
            }
        }

        @Override // d.c.c.a.b.a.h.f.b
        public void f(int i, int i2, int i3, boolean z) {
        }

        @Override // d.c.c.a.b.a.h.f.b
        public void g(boolean z, int i, d.c.c.a.a.e eVar, int i2) throws IOException {
            if (e.this.J(i)) {
                e.this.r(i, eVar, i2, z);
                return;
            }
            d.c.c.a.b.a.h.g o = e.this.o(i);
            if (o == null) {
                e.this.s(i, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                eVar.g(i2);
                return;
            }
            o.c(eVar, i2);
            if (z) {
                o.p();
            }
        }

        @Override // d.c.c.a.b.a.h.f.b
        public void h(boolean z, l lVar) {
            d.c.c.a.b.a.h.g[] gVarArr;
            long j;
            int i;
            synchronized (e.this) {
                int i2 = e.this.r.i();
                if (z) {
                    e.this.r.b();
                }
                e.this.r.c(lVar);
                j(lVar);
                int i3 = e.this.r.i();
                gVarArr = null;
                if (i3 == -1 || i3 == i2) {
                    j = 0;
                } else {
                    j = i3 - i2;
                    if (!e.this.s) {
                        e.this.a(j);
                        e.this.s = true;
                    }
                    if (!e.this.f66253g.isEmpty()) {
                        gVarArr = (d.c.c.a.b.a.h.g[]) e.this.f66253g.values().toArray(new d.c.c.a.b.a.h.g[e.this.f66253g.size()]);
                    }
                }
                e.x.execute(new b("OkHttp %s settings", e.this.f66254h));
            }
            if (gVarArr == null || j == 0) {
                return;
            }
            for (d.c.c.a.b.a.h.g gVar : gVarArr) {
                synchronized (gVar) {
                    gVar.b(j);
                }
            }
        }

        @Override // d.c.c.a.b.a.d
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
                    this.f66284f.l(this);
                    while (this.f66284f.o(false, this)) {
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
                    d.c.c.a.b.a.e.q(this.f66284f);
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                try {
                    e.this.x(bVar, bVar2);
                } catch (IOException unused4) {
                }
                d.c.c.a.b.a.e.q(this.f66284f);
                throw th;
            }
            eVar.x(bVar, bVar2);
            d.c.c.a.b.a.e.q(this.f66284f);
        }

        public final void j(l lVar) {
            e.x.execute(new c("OkHttp %s ACK Settings", new Object[]{e.this.f66254h}, lVar));
        }

        @Override // d.c.c.a.b.a.h.f.b
        public void a(int i, long j) {
            if (i == 0) {
                synchronized (e.this) {
                    e.this.p += j;
                    e.this.notifyAll();
                }
                return;
            }
            d.c.c.a.b.a.h.g o = e.this.o(i);
            if (o != null) {
                synchronized (o) {
                    o.b(j);
                }
            }
        }
    }
}
