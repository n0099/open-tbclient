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
    public final boolean f65310e;

    /* renamed from: f  reason: collision with root package name */
    public final i f65311f;

    /* renamed from: h  reason: collision with root package name */
    public final String f65313h;
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
    public final Map<Integer, d.c.c.a.b.a.h.g> f65312g = new LinkedHashMap();
    public long o = 0;
    public l q = new l();
    public final l r = new l();
    public boolean s = false;
    public final Set<Integer> w = new LinkedHashSet();

    /* loaded from: classes5.dex */
    public class a extends d.c.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f65314f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sdk.a.b.a.e.b f65315g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Object[] objArr, int i, com.bytedance.sdk.a.b.a.e.b bVar) {
            super(str, objArr);
            this.f65314f = i;
            this.f65315g = bVar;
        }

        @Override // d.c.c.a.b.a.d
        public void i() {
            try {
                e.this.D(this.f65314f, this.f65315g);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.c.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f65317f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f65318g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Object[] objArr, int i, long j) {
            super(str, objArr);
            this.f65317f = i;
            this.f65318g = j;
        }

        @Override // d.c.c.a.b.a.d
        public void i() {
            try {
                e.this.u.r(this.f65317f, this.f65318g);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.c.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f65320f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f65321g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f65322h;
        public final /* synthetic */ d.c.c.a.b.a.h.j i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Object[] objArr, boolean z, int i, int i2, d.c.c.a.b.a.h.j jVar) {
            super(str, objArr);
            this.f65320f = z;
            this.f65321g = i;
            this.f65322h = i2;
            this.i = jVar;
        }

        @Override // d.c.c.a.b.a.d
        public void i() {
            try {
                e.this.E(this.f65320f, this.f65321g, this.f65322h, this.i);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends d.c.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f65323f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f65324g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Object[] objArr, int i, List list) {
            super(str, objArr);
            this.f65323f = i;
            this.f65324g = list;
        }

        @Override // d.c.c.a.b.a.d
        public void i() {
            if (e.this.n.a(this.f65323f, this.f65324g)) {
                try {
                    e.this.u.s(this.f65323f, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                    synchronized (e.this) {
                        e.this.w.remove(Integer.valueOf(this.f65323f));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* renamed from: d.c.c.a.b.a.h.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1789e extends d.c.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f65326f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f65327g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f65328h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1789e(String str, Object[] objArr, int i, List list, boolean z) {
            super(str, objArr);
            this.f65326f = i;
            this.f65327g = list;
            this.f65328h = z;
        }

        @Override // d.c.c.a.b.a.d
        public void i() {
            boolean c2 = e.this.n.c(this.f65326f, this.f65327g, this.f65328h);
            if (c2) {
                try {
                    e.this.u.s(this.f65326f, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (c2 || this.f65328h) {
                synchronized (e.this) {
                    e.this.w.remove(Integer.valueOf(this.f65326f));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends d.c.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f65329f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.c.c.a.a.c f65330g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f65331h;
        public final /* synthetic */ boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Object[] objArr, int i, d.c.c.a.a.c cVar, int i2, boolean z) {
            super(str, objArr);
            this.f65329f = i;
            this.f65330g = cVar;
            this.f65331h = i2;
            this.i = z;
        }

        @Override // d.c.c.a.b.a.d
        public void i() {
            try {
                boolean b2 = e.this.n.b(this.f65329f, this.f65330g, this.f65331h, this.i);
                if (b2) {
                    e.this.u.s(this.f65329f, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                }
                if (b2 || this.i) {
                    synchronized (e.this) {
                        e.this.w.remove(Integer.valueOf(this.f65329f));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends d.c.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f65332f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sdk.a.b.a.e.b f65333g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, Object[] objArr, int i, com.bytedance.sdk.a.b.a.e.b bVar) {
            super(str, objArr);
            this.f65332f = i;
            this.f65333g = bVar;
        }

        @Override // d.c.c.a.b.a.d
        public void i() {
            e.this.n.a(this.f65332f, this.f65333g);
            synchronized (e.this) {
                e.this.w.remove(Integer.valueOf(this.f65332f));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public Socket f65335a;

        /* renamed from: b  reason: collision with root package name */
        public String f65336b;

        /* renamed from: c  reason: collision with root package name */
        public d.c.c.a.a.e f65337c;

        /* renamed from: d  reason: collision with root package name */
        public d.c.c.a.a.d f65338d;

        /* renamed from: e  reason: collision with root package name */
        public i f65339e = i.f65342a;

        /* renamed from: f  reason: collision with root package name */
        public k f65340f = k.f65388a;

        /* renamed from: g  reason: collision with root package name */
        public boolean f65341g;

        public h(boolean z) {
            this.f65341g = z;
        }

        public h a(i iVar) {
            this.f65339e = iVar;
            return this;
        }

        public h b(Socket socket, String str, d.c.c.a.a.e eVar, d.c.c.a.a.d dVar) {
            this.f65335a = socket;
            this.f65336b = str;
            this.f65337c = eVar;
            this.f65338d = dVar;
            return this;
        }

        public e c() {
            return new e(this);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class i {

        /* renamed from: a  reason: collision with root package name */
        public static final i f65342a = new a();

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
        this.n = hVar.f65340f;
        boolean z = hVar.f65341g;
        this.f65310e = z;
        this.f65311f = hVar.f65339e;
        int i2 = z ? 1 : 2;
        this.j = i2;
        if (hVar.f65341g) {
            this.j = i2 + 2;
        }
        boolean z2 = hVar.f65341g;
        if (hVar.f65341g) {
            this.q.a(7, 16777216);
        }
        this.f65313h = hVar.f65336b;
        this.l = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), d.c.c.a.b.a.e.o(d.c.c.a.b.a.e.j("OkHttp %s Push Observer", this.f65313h), true));
        this.r.a(7, 65535);
        this.r.a(5, 16384);
        this.p = this.r.i();
        this.t = hVar.f65335a;
        this.u = new d.c.c.a.b.a.h.h(hVar.f65338d, this.f65310e);
        this.v = new j(new d.c.c.a.b.a.h.f(hVar.f65337c, this.f65310e));
    }

    public synchronized d.c.c.a.b.a.h.g A(int i2) {
        d.c.c.a.b.a.h.g remove;
        remove = this.f65312g.remove(Integer.valueOf(i2));
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
                    if (z && this.p != 0 && gVar.f65359b != 0) {
                        z2 = false;
                        if (gVar.g()) {
                            this.f65312g.put(Integer.valueOf(i3), gVar);
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
            } else if (!this.f65310e) {
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
        this.l.execute(new g("OkHttp %s Push Reset[%s]", new Object[]{this.f65313h, Integer.valueOf(i2)}, i2, bVar));
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
        return this.f65312g.get(Integer.valueOf(i2));
    }

    public d.c.c.a.b.a.h.g p(List<d.c.c.a.b.a.h.a> list, boolean z) throws IOException {
        return B(0, list, z);
    }

    public void q(int i2, long j2) {
        x.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f65313h, Integer.valueOf(i2)}, i2, j2));
    }

    public void r(int i2, d.c.c.a.a.e eVar, int i3, boolean z) throws IOException {
        d.c.c.a.a.c cVar = new d.c.c.a.a.c();
        long j2 = i3;
        eVar.a(j2);
        eVar.a(cVar, j2);
        if (cVar.v() == j2) {
            this.l.execute(new f("OkHttp %s Push Data[%s]", new Object[]{this.f65313h, Integer.valueOf(i2)}, i2, cVar, i3, z));
            return;
        }
        throw new IOException(cVar.v() + " != " + i3);
    }

    public void s(int i2, com.bytedance.sdk.a.b.a.e.b bVar) {
        x.execute(new a("OkHttp %s stream %d", new Object[]{this.f65313h, Integer.valueOf(i2)}, i2, bVar));
    }

    public void t(int i2, List<d.c.c.a.b.a.h.a> list) {
        synchronized (this) {
            if (this.w.contains(Integer.valueOf(i2))) {
                s(i2, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                return;
            }
            this.w.add(Integer.valueOf(i2));
            this.l.execute(new d("OkHttp %s Push Request[%s]", new Object[]{this.f65313h, Integer.valueOf(i2)}, i2, list));
        }
    }

    public void u(int i2, List<d.c.c.a.b.a.h.a> list, boolean z) {
        this.l.execute(new C1789e("OkHttp %s Push Headers[%s]", new Object[]{this.f65313h, Integer.valueOf(i2)}, i2, list, z));
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
                        if (this.f65312g.containsKey(Integer.valueOf(i2))) {
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
                this.u.t(this.i, bVar, d.c.c.a.b.a.e.f65217a);
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
            if (this.f65312g.isEmpty()) {
                gVarArr = null;
            } else {
                gVarArr = (d.c.c.a.b.a.h.g[]) this.f65312g.values().toArray(new d.c.c.a.b.a.h.g[this.f65312g.size()]);
                this.f65312g.clear();
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
        x.execute(new c("OkHttp %s ping %08x%08x", new Object[]{this.f65313h, Integer.valueOf(i2), Integer.valueOf(i3)}, z, i2, i3, jVar));
    }

    /* loaded from: classes5.dex */
    public class j extends d.c.c.a.b.a.d implements f.b {

        /* renamed from: f  reason: collision with root package name */
        public final d.c.c.a.b.a.h.f f65343f;

        /* loaded from: classes5.dex */
        public class a extends d.c.c.a.b.a.d {

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.c.c.a.b.a.h.g f65345f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, Object[] objArr, d.c.c.a.b.a.h.g gVar) {
                super(str, objArr);
                this.f65345f = gVar;
            }

            @Override // d.c.c.a.b.a.d
            public void i() {
                try {
                    e.this.f65311f.b(this.f65345f);
                } catch (IOException e2) {
                    d.c.c.a.b.a.i.e j = d.c.c.a.b.a.i.e.j();
                    j.f(4, "Http2Connection.Listener failure for " + e.this.f65313h, e2);
                    try {
                        this.f65345f.d(com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
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
                eVar.f65311f.a(eVar);
            }
        }

        /* loaded from: classes5.dex */
        public class c extends d.c.c.a.b.a.d {

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f65348f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, Object[] objArr, l lVar) {
                super(str, objArr);
                this.f65348f = lVar;
            }

            @Override // d.c.c.a.b.a.d
            public void i() {
                try {
                    e.this.u.v(this.f65348f);
                } catch (IOException unused) {
                }
            }
        }

        public j(d.c.c.a.b.a.h.f fVar) {
            super("OkHttp %s", e.this.f65313h);
            this.f65343f = fVar;
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
                gVarArr = (d.c.c.a.b.a.h.g[]) e.this.f65312g.values().toArray(new d.c.c.a.b.a.h.g[e.this.f65312g.size()]);
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
                    e.this.f65312g.put(Integer.valueOf(i), gVar);
                    e.x.execute(new a("OkHttp %s stream %d", new Object[]{e.this.f65313h, Integer.valueOf(i)}, gVar));
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
                    if (!e.this.f65312g.isEmpty()) {
                        gVarArr = (d.c.c.a.b.a.h.g[]) e.this.f65312g.values().toArray(new d.c.c.a.b.a.h.g[e.this.f65312g.size()]);
                    }
                }
                e.x.execute(new b("OkHttp %s settings", e.this.f65313h));
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
                    this.f65343f.l(this);
                    while (this.f65343f.o(false, this)) {
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
                    d.c.c.a.b.a.e.q(this.f65343f);
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                try {
                    e.this.x(bVar, bVar2);
                } catch (IOException unused4) {
                }
                d.c.c.a.b.a.e.q(this.f65343f);
                throw th;
            }
            eVar.x(bVar, bVar2);
            d.c.c.a.b.a.e.q(this.f65343f);
        }

        public final void j(l lVar) {
            e.x.execute(new c("OkHttp %s ACK Settings", new Object[]{e.this.f65313h}, lVar));
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
