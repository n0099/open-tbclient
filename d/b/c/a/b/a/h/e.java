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
    public final boolean f65312e;

    /* renamed from: f  reason: collision with root package name */
    public final i f65313f;

    /* renamed from: h  reason: collision with root package name */
    public final String f65315h;

    /* renamed from: i  reason: collision with root package name */
    public int f65316i;
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
    public final Map<Integer, d.b.c.a.b.a.h.g> f65314g = new LinkedHashMap();
    public long o = 0;
    public l q = new l();
    public final l r = new l();
    public boolean s = false;
    public final Set<Integer> w = new LinkedHashSet();

    /* loaded from: classes6.dex */
    public class a extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f65317f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sdk.a.b.a.e.b f65318g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Object[] objArr, int i2, com.bytedance.sdk.a.b.a.e.b bVar) {
            super(str, objArr);
            this.f65317f = i2;
            this.f65318g = bVar;
        }

        @Override // d.b.c.a.b.a.d
        public void i() {
            try {
                e.this.D(this.f65317f, this.f65318g);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f65320f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f65321g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Object[] objArr, int i2, long j) {
            super(str, objArr);
            this.f65320f = i2;
            this.f65321g = j;
        }

        @Override // d.b.c.a.b.a.d
        public void i() {
            try {
                e.this.u.r(this.f65320f, this.f65321g);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f65323f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f65324g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f65325h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.b.c.a.b.a.h.j f65326i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Object[] objArr, boolean z, int i2, int i3, d.b.c.a.b.a.h.j jVar) {
            super(str, objArr);
            this.f65323f = z;
            this.f65324g = i2;
            this.f65325h = i3;
            this.f65326i = jVar;
        }

        @Override // d.b.c.a.b.a.d
        public void i() {
            try {
                e.this.E(this.f65323f, this.f65324g, this.f65325h, this.f65326i);
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f65327f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f65328g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Object[] objArr, int i2, List list) {
            super(str, objArr);
            this.f65327f = i2;
            this.f65328g = list;
        }

        @Override // d.b.c.a.b.a.d
        public void i() {
            if (e.this.n.a(this.f65327f, this.f65328g)) {
                try {
                    e.this.u.s(this.f65327f, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                    synchronized (e.this) {
                        e.this.w.remove(Integer.valueOf(this.f65327f));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* renamed from: d.b.c.a.b.a.h.e$e  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1825e extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f65330f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f65331g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f65332h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1825e(String str, Object[] objArr, int i2, List list, boolean z) {
            super(str, objArr);
            this.f65330f = i2;
            this.f65331g = list;
            this.f65332h = z;
        }

        @Override // d.b.c.a.b.a.d
        public void i() {
            boolean c2 = e.this.n.c(this.f65330f, this.f65331g, this.f65332h);
            if (c2) {
                try {
                    e.this.u.s(this.f65330f, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (c2 || this.f65332h) {
                synchronized (e.this) {
                    e.this.w.remove(Integer.valueOf(this.f65330f));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f65334f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.c.a.a.c f65335g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f65336h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f65337i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Object[] objArr, int i2, d.b.c.a.a.c cVar, int i3, boolean z) {
            super(str, objArr);
            this.f65334f = i2;
            this.f65335g = cVar;
            this.f65336h = i3;
            this.f65337i = z;
        }

        @Override // d.b.c.a.b.a.d
        public void i() {
            try {
                boolean b2 = e.this.n.b(this.f65334f, this.f65335g, this.f65336h, this.f65337i);
                if (b2) {
                    e.this.u.s(this.f65334f, com.bytedance.sdk.a.b.a.e.b.CANCEL);
                }
                if (b2 || this.f65337i) {
                    synchronized (e.this) {
                        e.this.w.remove(Integer.valueOf(this.f65334f));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f65338f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sdk.a.b.a.e.b f65339g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, Object[] objArr, int i2, com.bytedance.sdk.a.b.a.e.b bVar) {
            super(str, objArr);
            this.f65338f = i2;
            this.f65339g = bVar;
        }

        @Override // d.b.c.a.b.a.d
        public void i() {
            e.this.n.a(this.f65338f, this.f65339g);
            synchronized (e.this) {
                e.this.w.remove(Integer.valueOf(this.f65338f));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public Socket f65341a;

        /* renamed from: b  reason: collision with root package name */
        public String f65342b;

        /* renamed from: c  reason: collision with root package name */
        public d.b.c.a.a.e f65343c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.c.a.a.d f65344d;

        /* renamed from: e  reason: collision with root package name */
        public i f65345e = i.f65348a;

        /* renamed from: f  reason: collision with root package name */
        public k f65346f = k.f65400a;

        /* renamed from: g  reason: collision with root package name */
        public boolean f65347g;

        public h(boolean z) {
            this.f65347g = z;
        }

        public h a(i iVar) {
            this.f65345e = iVar;
            return this;
        }

        public h b(Socket socket, String str, d.b.c.a.a.e eVar, d.b.c.a.a.d dVar) {
            this.f65341a = socket;
            this.f65342b = str;
            this.f65343c = eVar;
            this.f65344d = dVar;
            return this;
        }

        public e c() {
            return new e(this);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class i {

        /* renamed from: a  reason: collision with root package name */
        public static final i f65348a = new a();

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
        this.n = hVar.f65346f;
        boolean z = hVar.f65347g;
        this.f65312e = z;
        this.f65313f = hVar.f65345e;
        int i2 = z ? 1 : 2;
        this.j = i2;
        if (hVar.f65347g) {
            this.j = i2 + 2;
        }
        boolean z2 = hVar.f65347g;
        if (hVar.f65347g) {
            this.q.a(7, 16777216);
        }
        this.f65315h = hVar.f65342b;
        this.l = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), d.b.c.a.b.a.e.o(d.b.c.a.b.a.e.j("OkHttp %s Push Observer", this.f65315h), true));
        this.r.a(7, 65535);
        this.r.a(5, 16384);
        this.p = this.r.i();
        this.t = hVar.f65341a;
        this.u = new d.b.c.a.b.a.h.h(hVar.f65344d, this.f65312e);
        this.v = new j(new d.b.c.a.b.a.h.f(hVar.f65343c, this.f65312e));
    }

    public synchronized d.b.c.a.b.a.h.g A(int i2) {
        d.b.c.a.b.a.h.g remove;
        remove = this.f65314g.remove(Integer.valueOf(i2));
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
                    if (z && this.p != 0 && gVar.f65367b != 0) {
                        z2 = false;
                        if (gVar.g()) {
                            this.f65314g.put(Integer.valueOf(i3), gVar);
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
            } else if (!this.f65312e) {
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
        this.l.execute(new g("OkHttp %s Push Reset[%s]", new Object[]{this.f65315h, Integer.valueOf(i2)}, i2, bVar));
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
        return this.f65314g.get(Integer.valueOf(i2));
    }

    public d.b.c.a.b.a.h.g p(List<d.b.c.a.b.a.h.a> list, boolean z) throws IOException {
        return B(0, list, z);
    }

    public void q(int i2, long j2) {
        x.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f65315h, Integer.valueOf(i2)}, i2, j2));
    }

    public void r(int i2, d.b.c.a.a.e eVar, int i3, boolean z) throws IOException {
        d.b.c.a.a.c cVar = new d.b.c.a.a.c();
        long j2 = i3;
        eVar.a(j2);
        eVar.a(cVar, j2);
        if (cVar.v() == j2) {
            this.l.execute(new f("OkHttp %s Push Data[%s]", new Object[]{this.f65315h, Integer.valueOf(i2)}, i2, cVar, i3, z));
            return;
        }
        throw new IOException(cVar.v() + " != " + i3);
    }

    public void s(int i2, com.bytedance.sdk.a.b.a.e.b bVar) {
        x.execute(new a("OkHttp %s stream %d", new Object[]{this.f65315h, Integer.valueOf(i2)}, i2, bVar));
    }

    public void t(int i2, List<d.b.c.a.b.a.h.a> list) {
        synchronized (this) {
            if (this.w.contains(Integer.valueOf(i2))) {
                s(i2, com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
                return;
            }
            this.w.add(Integer.valueOf(i2));
            this.l.execute(new d("OkHttp %s Push Request[%s]", new Object[]{this.f65315h, Integer.valueOf(i2)}, i2, list));
        }
    }

    public void u(int i2, List<d.b.c.a.b.a.h.a> list, boolean z) {
        this.l.execute(new C1825e("OkHttp %s Push Headers[%s]", new Object[]{this.f65315h, Integer.valueOf(i2)}, i2, list, z));
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
                        if (this.f65314g.containsKey(Integer.valueOf(i2))) {
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
                this.u.t(this.f65316i, bVar, d.b.c.a.b.a.e.f65211a);
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
            if (this.f65314g.isEmpty()) {
                gVarArr = null;
            } else {
                gVarArr = (d.b.c.a.b.a.h.g[]) this.f65314g.values().toArray(new d.b.c.a.b.a.h.g[this.f65314g.size()]);
                this.f65314g.clear();
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
        x.execute(new c("OkHttp %s ping %08x%08x", new Object[]{this.f65315h, Integer.valueOf(i2), Integer.valueOf(i3)}, z, i2, i3, jVar));
    }

    /* loaded from: classes6.dex */
    public class j extends d.b.c.a.b.a.d implements f.b {

        /* renamed from: f  reason: collision with root package name */
        public final d.b.c.a.b.a.h.f f65349f;

        /* loaded from: classes6.dex */
        public class a extends d.b.c.a.b.a.d {

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.b.c.a.b.a.h.g f65351f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, Object[] objArr, d.b.c.a.b.a.h.g gVar) {
                super(str, objArr);
                this.f65351f = gVar;
            }

            @Override // d.b.c.a.b.a.d
            public void i() {
                try {
                    e.this.f65313f.b(this.f65351f);
                } catch (IOException e2) {
                    d.b.c.a.b.a.i.e j = d.b.c.a.b.a.i.e.j();
                    j.f(4, "Http2Connection.Listener failure for " + e.this.f65315h, e2);
                    try {
                        this.f65351f.d(com.bytedance.sdk.a.b.a.e.b.PROTOCOL_ERROR);
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
                eVar.f65313f.a(eVar);
            }
        }

        /* loaded from: classes6.dex */
        public class c extends d.b.c.a.b.a.d {

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f65354f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, Object[] objArr, l lVar) {
                super(str, objArr);
                this.f65354f = lVar;
            }

            @Override // d.b.c.a.b.a.d
            public void i() {
                try {
                    e.this.u.v(this.f65354f);
                } catch (IOException unused) {
                }
            }
        }

        public j(d.b.c.a.b.a.h.f fVar) {
            super("OkHttp %s", e.this.f65315h);
            this.f65349f = fVar;
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
                    if (i2 <= e.this.f65316i) {
                        return;
                    }
                    if (i2 % 2 == e.this.j % 2) {
                        return;
                    }
                    d.b.c.a.b.a.h.g gVar = new d.b.c.a.b.a.h.g(i2, e.this, false, z, list);
                    e.this.f65316i = i2;
                    e.this.f65314g.put(Integer.valueOf(i2), gVar);
                    e.x.execute(new a("OkHttp %s stream %d", new Object[]{e.this.f65315h, Integer.valueOf(i2)}, gVar));
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
                gVarArr = (d.b.c.a.b.a.h.g[]) e.this.f65314g.values().toArray(new d.b.c.a.b.a.h.g[e.this.f65314g.size()]);
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
                    if (!e.this.f65314g.isEmpty()) {
                        gVarArr = (d.b.c.a.b.a.h.g[]) e.this.f65314g.values().toArray(new d.b.c.a.b.a.h.g[e.this.f65314g.size()]);
                    }
                }
                e.x.execute(new b("OkHttp %s settings", e.this.f65315h));
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
                    this.f65349f.l(this);
                    while (this.f65349f.o(false, this)) {
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
                    d.b.c.a.b.a.e.q(this.f65349f);
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                try {
                    e.this.x(bVar, bVar2);
                } catch (IOException unused4) {
                }
                d.b.c.a.b.a.e.q(this.f65349f);
                throw th;
            }
            eVar.x(bVar, bVar2);
            d.b.c.a.b.a.e.q(this.f65349f);
        }

        public final void j(l lVar) {
            e.x.execute(new c("OkHttp %s ACK Settings", new Object[]{e.this.f65315h}, lVar));
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
