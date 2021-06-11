package d.b.c.a.b.a.h;

import com.bytedance.sdk.a.b.a.e.o;
import d.b.c.a.a.p;
import d.b.c.a.a.q;
import d.b.c.a.a.r;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class g {
    public static final /* synthetic */ boolean l = !g.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public long f69141b;

    /* renamed from: c  reason: collision with root package name */
    public final int f69142c;

    /* renamed from: d  reason: collision with root package name */
    public final e f69143d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.c.a.b.a.h.a> f69144e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f69145f;

    /* renamed from: g  reason: collision with root package name */
    public final b f69146g;

    /* renamed from: h  reason: collision with root package name */
    public final a f69147h;

    /* renamed from: a  reason: collision with root package name */
    public long f69140a = 0;

    /* renamed from: i  reason: collision with root package name */
    public final c f69148i = new c();
    public final c j = new c();
    public com.bytedance.sdk.a.b.a.e.b k = null;

    /* loaded from: classes6.dex */
    public final class a implements p {

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ boolean f69149i = !g.class.desiredAssertionStatus();

        /* renamed from: e  reason: collision with root package name */
        public final d.b.c.a.a.c f69150e = new d.b.c.a.a.c();

        /* renamed from: f  reason: collision with root package name */
        public boolean f69151f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f69152g;

        public a() {
        }

        @Override // d.b.c.a.a.p
        public r a() {
            return g.this.j;
        }

        @Override // d.b.c.a.a.p
        public void b(d.b.c.a.a.c cVar, long j) throws IOException {
            if (!f69149i && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            this.f69150e.b(cVar, j);
            while (this.f69150e.v() >= 16384) {
                c(false);
            }
        }

        public final void c(boolean z) throws IOException {
            long min;
            synchronized (g.this) {
                g.this.j.l();
                while (g.this.f69141b <= 0 && !this.f69152g && !this.f69151f && g.this.k == null) {
                    g.this.s();
                }
                g.this.j.u();
                g.this.r();
                min = Math.min(g.this.f69141b, this.f69150e.v());
                g.this.f69141b -= min;
            }
            g.this.j.l();
            try {
                g.this.f69143d.v(g.this.f69142c, z && min == this.f69150e.v(), this.f69150e, min);
            } finally {
                g.this.j.u();
            }
        }

        @Override // d.b.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f69149i && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            synchronized (g.this) {
                if (this.f69151f) {
                    return;
                }
                if (!g.this.f69147h.f69152g) {
                    if (this.f69150e.v() > 0) {
                        while (this.f69150e.v() > 0) {
                            c(true);
                        }
                    } else {
                        g gVar = g.this;
                        gVar.f69143d.v(gVar.f69142c, true, null, 0L);
                    }
                }
                synchronized (g.this) {
                    this.f69151f = true;
                }
                g.this.f69143d.C();
                g.this.q();
            }
        }

        @Override // d.b.c.a.a.p, java.io.Flushable
        public void flush() throws IOException {
            if (!f69149i && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            synchronized (g.this) {
                g.this.r();
            }
            while (this.f69150e.v() > 0) {
                c(false);
                g.this.f69143d.C();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends d.b.c.a.a.a {
        public c() {
        }

        @Override // d.b.c.a.a.a
        public void p() {
            g.this.f(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        }

        @Override // d.b.c.a.a.a
        public IOException r(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void u() throws IOException {
            if (s()) {
                throw r(null);
            }
        }
    }

    public g(int i2, e eVar, boolean z, boolean z2, List<d.b.c.a.b.a.h.a> list) {
        if (eVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list != null) {
            this.f69142c = i2;
            this.f69143d = eVar;
            this.f69141b = eVar.r.i();
            this.f69146g = new b(eVar.q.i());
            a aVar = new a();
            this.f69147h = aVar;
            this.f69146g.f69158i = z2;
            aVar.f69152g = z;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    public int a() {
        return this.f69142c;
    }

    public void b(long j) {
        this.f69141b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void c(d.b.c.a.a.e eVar, int i2) throws IOException {
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f69146g.c(eVar, i2);
    }

    public void d(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        if (k(bVar)) {
            this.f69143d.D(this.f69142c, bVar);
        }
    }

    public void e(List<d.b.c.a.b.a.h.a> list) {
        boolean z;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = true;
            this.f69145f = true;
            if (this.f69144e == null) {
                this.f69144e = list;
                z = g();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f69144e);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f69144e = arrayList;
            }
        }
        if (z) {
            return;
        }
        this.f69143d.A(this.f69142c);
    }

    public void f(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (k(bVar)) {
            this.f69143d.s(this.f69142c, bVar);
        }
    }

    public synchronized boolean g() {
        if (this.k != null) {
            return false;
        }
        if ((this.f69146g.f69158i || this.f69146g.f69157h) && (this.f69147h.f69152g || this.f69147h.f69151f)) {
            if (this.f69145f) {
                return false;
            }
        }
        return true;
    }

    public synchronized void h(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (this.k == null) {
            this.k = bVar;
            notifyAll();
        }
    }

    public boolean i() {
        return this.f69143d.f69086e == ((this.f69142c & 1) == 1);
    }

    public synchronized List<d.b.c.a.b.a.h.a> j() throws IOException {
        List<d.b.c.a.b.a.h.a> list;
        if (i()) {
            this.f69148i.l();
            while (this.f69144e == null && this.k == null) {
                s();
            }
            this.f69148i.u();
            list = this.f69144e;
            if (list != null) {
                this.f69144e = null;
            } else {
                throw new o(this.k);
            }
        } else {
            throw new IllegalStateException("servers cannot read response headers");
        }
        return list;
    }

    public final boolean k(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (l || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.k != null) {
                    return false;
                }
                if (this.f69146g.f69158i && this.f69147h.f69152g) {
                    return false;
                }
                this.k = bVar;
                notifyAll();
                this.f69143d.A(this.f69142c);
                return true;
            }
        }
        throw new AssertionError();
    }

    public r l() {
        return this.f69148i;
    }

    public r m() {
        return this.j;
    }

    public q n() {
        return this.f69146g;
    }

    public p o() {
        synchronized (this) {
            if (!this.f69145f && !i()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f69147h;
    }

    public void p() {
        boolean g2;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f69146g.f69158i = true;
            g2 = g();
            notifyAll();
        }
        if (g2) {
            return;
        }
        this.f69143d.A(this.f69142c);
    }

    public void q() throws IOException {
        boolean z;
        boolean g2;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.f69146g.f69158i && this.f69146g.f69157h && (this.f69147h.f69152g || this.f69147h.f69151f);
            g2 = g();
        }
        if (z) {
            d(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        } else if (g2) {
        } else {
            this.f69143d.A(this.f69142c);
        }
    }

    public void r() throws IOException {
        a aVar = this.f69147h;
        if (!aVar.f69151f) {
            if (!aVar.f69152g) {
                if (this.k != null) {
                    throw new o(this.k);
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    public void s() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    /* loaded from: classes6.dex */
    public final class b implements q {
        public static final /* synthetic */ boolean k = !g.class.desiredAssertionStatus();

        /* renamed from: e  reason: collision with root package name */
        public final d.b.c.a.a.c f69154e = new d.b.c.a.a.c();

        /* renamed from: f  reason: collision with root package name */
        public final d.b.c.a.a.c f69155f = new d.b.c.a.a.c();

        /* renamed from: g  reason: collision with root package name */
        public final long f69156g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f69157h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f69158i;

        public b(long j) {
            this.f69156g = j;
        }

        @Override // d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            if (j >= 0) {
                synchronized (g.this) {
                    n();
                    o();
                    if (this.f69155f.v() == 0) {
                        return -1L;
                    }
                    long a2 = this.f69155f.a(cVar, Math.min(j, this.f69155f.v()));
                    g.this.f69140a += a2;
                    if (g.this.f69140a >= g.this.f69143d.q.i() / 2) {
                        g.this.f69143d.q(g.this.f69142c, g.this.f69140a);
                        g.this.f69140a = 0L;
                    }
                    synchronized (g.this.f69143d) {
                        g.this.f69143d.o += a2;
                        if (g.this.f69143d.o >= g.this.f69143d.q.i() / 2) {
                            g.this.f69143d.q(0, g.this.f69143d.o);
                            g.this.f69143d.o = 0L;
                        }
                    }
                    return a2;
                }
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        public void c(d.b.c.a.a.e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (!k && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (g.this) {
                    z = this.f69158i;
                    z2 = true;
                    z3 = this.f69155f.v() + j > this.f69156g;
                }
                if (z3) {
                    eVar.g(j);
                    g.this.f(com.bytedance.sdk.a.b.a.e.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.g(j);
                    return;
                } else {
                    long a2 = eVar.a(this.f69154e, j);
                    if (a2 != -1) {
                        j -= a2;
                        synchronized (g.this) {
                            if (this.f69155f.v() != 0) {
                                z2 = false;
                            }
                            this.f69155f.l(this.f69154e);
                            if (z2) {
                                g.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (g.this) {
                this.f69157h = true;
                this.f69155f.L();
                g.this.notifyAll();
            }
            g.this.q();
        }

        public final void n() throws IOException {
            g.this.f69148i.l();
            while (this.f69155f.v() == 0 && !this.f69158i && !this.f69157h && g.this.k == null) {
                try {
                    g.this.s();
                } finally {
                    g.this.f69148i.u();
                }
            }
        }

        public final void o() throws IOException {
            if (!this.f69157h) {
                if (g.this.k != null) {
                    throw new o(g.this.k);
                }
                return;
            }
            throw new IOException("stream closed");
        }

        @Override // d.b.c.a.a.q
        public r a() {
            return g.this.f69148i;
        }
    }
}
