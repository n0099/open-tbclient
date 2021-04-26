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
/* loaded from: classes5.dex */
public final class g {
    public static final /* synthetic */ boolean l = !g.class.desiredAssertionStatus();

    /* renamed from: b  reason: collision with root package name */
    public long f64681b;

    /* renamed from: c  reason: collision with root package name */
    public final int f64682c;

    /* renamed from: d  reason: collision with root package name */
    public final e f64683d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.c.a.b.a.h.a> f64684e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64685f;

    /* renamed from: g  reason: collision with root package name */
    public final b f64686g;

    /* renamed from: h  reason: collision with root package name */
    public final a f64687h;

    /* renamed from: a  reason: collision with root package name */
    public long f64680a = 0;

    /* renamed from: i  reason: collision with root package name */
    public final c f64688i = new c();
    public final c j = new c();
    public com.bytedance.sdk.a.b.a.e.b k = null;

    /* loaded from: classes5.dex */
    public final class a implements p {

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ boolean f64689i = !g.class.desiredAssertionStatus();

        /* renamed from: e  reason: collision with root package name */
        public final d.b.c.a.a.c f64690e = new d.b.c.a.a.c();

        /* renamed from: f  reason: collision with root package name */
        public boolean f64691f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f64692g;

        public a() {
        }

        @Override // d.b.c.a.a.p
        public r a() {
            return g.this.j;
        }

        @Override // d.b.c.a.a.p
        public void b(d.b.c.a.a.c cVar, long j) throws IOException {
            if (!f64689i && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            this.f64690e.b(cVar, j);
            while (this.f64690e.v() >= 16384) {
                c(false);
            }
        }

        public final void c(boolean z) throws IOException {
            long min;
            synchronized (g.this) {
                g.this.j.l();
                while (g.this.f64681b <= 0 && !this.f64692g && !this.f64691f && g.this.k == null) {
                    g.this.s();
                }
                g.this.j.u();
                g.this.r();
                min = Math.min(g.this.f64681b, this.f64690e.v());
                g.this.f64681b -= min;
            }
            g.this.j.l();
            try {
                g.this.f64683d.v(g.this.f64682c, z && min == this.f64690e.v(), this.f64690e, min);
            } finally {
                g.this.j.u();
            }
        }

        @Override // d.b.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f64689i && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            synchronized (g.this) {
                if (this.f64691f) {
                    return;
                }
                if (!g.this.f64687h.f64692g) {
                    if (this.f64690e.v() > 0) {
                        while (this.f64690e.v() > 0) {
                            c(true);
                        }
                    } else {
                        g gVar = g.this;
                        gVar.f64683d.v(gVar.f64682c, true, null, 0L);
                    }
                }
                synchronized (g.this) {
                    this.f64691f = true;
                }
                g.this.f64683d.C();
                g.this.q();
            }
        }

        @Override // d.b.c.a.a.p, java.io.Flushable
        public void flush() throws IOException {
            if (!f64689i && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            synchronized (g.this) {
                g.this.r();
            }
            while (this.f64690e.v() > 0) {
                c(false);
                g.this.f64683d.C();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            this.f64682c = i2;
            this.f64683d = eVar;
            this.f64681b = eVar.r.i();
            this.f64686g = new b(eVar.q.i());
            a aVar = new a();
            this.f64687h = aVar;
            this.f64686g.f64698i = z2;
            aVar.f64692g = z;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    public int a() {
        return this.f64682c;
    }

    public void b(long j) {
        this.f64681b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void c(d.b.c.a.a.e eVar, int i2) throws IOException {
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f64686g.c(eVar, i2);
    }

    public void d(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        if (k(bVar)) {
            this.f64683d.D(this.f64682c, bVar);
        }
    }

    public void e(List<d.b.c.a.b.a.h.a> list) {
        boolean z;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = true;
            this.f64685f = true;
            if (this.f64684e == null) {
                this.f64684e = list;
                z = g();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f64684e);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f64684e = arrayList;
            }
        }
        if (z) {
            return;
        }
        this.f64683d.A(this.f64682c);
    }

    public void f(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (k(bVar)) {
            this.f64683d.s(this.f64682c, bVar);
        }
    }

    public synchronized boolean g() {
        if (this.k != null) {
            return false;
        }
        if ((this.f64686g.f64698i || this.f64686g.f64697h) && (this.f64687h.f64692g || this.f64687h.f64691f)) {
            if (this.f64685f) {
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
        return this.f64683d.f64626e == ((this.f64682c & 1) == 1);
    }

    public synchronized List<d.b.c.a.b.a.h.a> j() throws IOException {
        List<d.b.c.a.b.a.h.a> list;
        if (i()) {
            this.f64688i.l();
            while (this.f64684e == null && this.k == null) {
                s();
            }
            this.f64688i.u();
            list = this.f64684e;
            if (list != null) {
                this.f64684e = null;
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
                if (this.f64686g.f64698i && this.f64687h.f64692g) {
                    return false;
                }
                this.k = bVar;
                notifyAll();
                this.f64683d.A(this.f64682c);
                return true;
            }
        }
        throw new AssertionError();
    }

    public r l() {
        return this.f64688i;
    }

    public r m() {
        return this.j;
    }

    public q n() {
        return this.f64686g;
    }

    public p o() {
        synchronized (this) {
            if (!this.f64685f && !i()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f64687h;
    }

    public void p() {
        boolean g2;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f64686g.f64698i = true;
            g2 = g();
            notifyAll();
        }
        if (g2) {
            return;
        }
        this.f64683d.A(this.f64682c);
    }

    public void q() throws IOException {
        boolean z;
        boolean g2;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.f64686g.f64698i && this.f64686g.f64697h && (this.f64687h.f64692g || this.f64687h.f64691f);
            g2 = g();
        }
        if (z) {
            d(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        } else if (g2) {
        } else {
            this.f64683d.A(this.f64682c);
        }
    }

    public void r() throws IOException {
        a aVar = this.f64687h;
        if (!aVar.f64691f) {
            if (!aVar.f64692g) {
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

    /* loaded from: classes5.dex */
    public final class b implements q {
        public static final /* synthetic */ boolean k = !g.class.desiredAssertionStatus();

        /* renamed from: e  reason: collision with root package name */
        public final d.b.c.a.a.c f64694e = new d.b.c.a.a.c();

        /* renamed from: f  reason: collision with root package name */
        public final d.b.c.a.a.c f64695f = new d.b.c.a.a.c();

        /* renamed from: g  reason: collision with root package name */
        public final long f64696g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f64697h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f64698i;

        public b(long j) {
            this.f64696g = j;
        }

        @Override // d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            if (j >= 0) {
                synchronized (g.this) {
                    n();
                    o();
                    if (this.f64695f.v() == 0) {
                        return -1L;
                    }
                    long a2 = this.f64695f.a(cVar, Math.min(j, this.f64695f.v()));
                    g.this.f64680a += a2;
                    if (g.this.f64680a >= g.this.f64683d.q.i() / 2) {
                        g.this.f64683d.q(g.this.f64682c, g.this.f64680a);
                        g.this.f64680a = 0L;
                    }
                    synchronized (g.this.f64683d) {
                        g.this.f64683d.o += a2;
                        if (g.this.f64683d.o >= g.this.f64683d.q.i() / 2) {
                            g.this.f64683d.q(0, g.this.f64683d.o);
                            g.this.f64683d.o = 0L;
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
                    z = this.f64698i;
                    z2 = true;
                    z3 = this.f64695f.v() + j > this.f64696g;
                }
                if (z3) {
                    eVar.g(j);
                    g.this.f(com.bytedance.sdk.a.b.a.e.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.g(j);
                    return;
                } else {
                    long a2 = eVar.a(this.f64694e, j);
                    if (a2 != -1) {
                        j -= a2;
                        synchronized (g.this) {
                            if (this.f64695f.v() != 0) {
                                z2 = false;
                            }
                            this.f64695f.l(this.f64694e);
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
                this.f64697h = true;
                this.f64695f.L();
                g.this.notifyAll();
            }
            g.this.q();
        }

        public final void n() throws IOException {
            g.this.f64688i.l();
            while (this.f64695f.v() == 0 && !this.f64698i && !this.f64697h && g.this.k == null) {
                try {
                    g.this.s();
                } finally {
                    g.this.f64688i.u();
                }
            }
        }

        public final void o() throws IOException {
            if (!this.f64697h) {
                if (g.this.k != null) {
                    throw new o(g.this.k);
                }
                return;
            }
            throw new IOException("stream closed");
        }

        @Override // d.b.c.a.a.q
        public r a() {
            return g.this.f64688i;
        }
    }
}
