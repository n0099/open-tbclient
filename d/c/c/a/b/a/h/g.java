package d.c.c.a.b.a.h;

import com.bytedance.sdk.a.b.a.e.o;
import d.c.c.a.a.p;
import d.c.c.a.a.q;
import d.c.c.a.a.r;
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
    public long f66205b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66206c;

    /* renamed from: d  reason: collision with root package name */
    public final e f66207d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.c.c.a.b.a.h.a> f66208e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66209f;

    /* renamed from: g  reason: collision with root package name */
    public final b f66210g;

    /* renamed from: h  reason: collision with root package name */
    public final a f66211h;

    /* renamed from: a  reason: collision with root package name */
    public long f66204a = 0;
    public final c i = new c();
    public final c j = new c();
    public com.bytedance.sdk.a.b.a.e.b k = null;

    /* loaded from: classes5.dex */
    public final class a implements p {
        public static final /* synthetic */ boolean i = !g.class.desiredAssertionStatus();

        /* renamed from: e  reason: collision with root package name */
        public final d.c.c.a.a.c f66212e = new d.c.c.a.a.c();

        /* renamed from: f  reason: collision with root package name */
        public boolean f66213f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f66214g;

        public a() {
        }

        @Override // d.c.c.a.a.p
        public r a() {
            return g.this.j;
        }

        @Override // d.c.c.a.a.p
        public void b(d.c.c.a.a.c cVar, long j) throws IOException {
            if (!i && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            this.f66212e.b(cVar, j);
            while (this.f66212e.v() >= 16384) {
                c(false);
            }
        }

        public final void c(boolean z) throws IOException {
            long min;
            synchronized (g.this) {
                g.this.j.l();
                while (g.this.f66205b <= 0 && !this.f66214g && !this.f66213f && g.this.k == null) {
                    g.this.s();
                }
                g.this.j.u();
                g.this.r();
                min = Math.min(g.this.f66205b, this.f66212e.v());
                g.this.f66205b -= min;
            }
            g.this.j.l();
            try {
                g.this.f66207d.v(g.this.f66206c, z && min == this.f66212e.v(), this.f66212e, min);
            } finally {
                g.this.j.u();
            }
        }

        @Override // d.c.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!i && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            synchronized (g.this) {
                if (this.f66213f) {
                    return;
                }
                if (!g.this.f66211h.f66214g) {
                    if (this.f66212e.v() > 0) {
                        while (this.f66212e.v() > 0) {
                            c(true);
                        }
                    } else {
                        g gVar = g.this;
                        gVar.f66207d.v(gVar.f66206c, true, null, 0L);
                    }
                }
                synchronized (g.this) {
                    this.f66213f = true;
                }
                g.this.f66207d.C();
                g.this.q();
            }
        }

        @Override // d.c.c.a.a.p, java.io.Flushable
        public void flush() throws IOException {
            if (!i && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            synchronized (g.this) {
                g.this.r();
            }
            while (this.f66212e.v() > 0) {
                c(false);
                g.this.f66207d.C();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.c.c.a.a.a {
        public c() {
        }

        @Override // d.c.c.a.a.a
        public void p() {
            g.this.f(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        }

        @Override // d.c.c.a.a.a
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

    public g(int i, e eVar, boolean z, boolean z2, List<d.c.c.a.b.a.h.a> list) {
        if (eVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list != null) {
            this.f66206c = i;
            this.f66207d = eVar;
            this.f66205b = eVar.r.i();
            this.f66210g = new b(eVar.q.i());
            a aVar = new a();
            this.f66211h = aVar;
            this.f66210g.i = z2;
            aVar.f66214g = z;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    public int a() {
        return this.f66206c;
    }

    public void b(long j) {
        this.f66205b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void c(d.c.c.a.a.e eVar, int i) throws IOException {
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f66210g.c(eVar, i);
    }

    public void d(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        if (k(bVar)) {
            this.f66207d.D(this.f66206c, bVar);
        }
    }

    public void e(List<d.c.c.a.b.a.h.a> list) {
        boolean z;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = true;
            this.f66209f = true;
            if (this.f66208e == null) {
                this.f66208e = list;
                z = g();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f66208e);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f66208e = arrayList;
            }
        }
        if (z) {
            return;
        }
        this.f66207d.A(this.f66206c);
    }

    public void f(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (k(bVar)) {
            this.f66207d.s(this.f66206c, bVar);
        }
    }

    public synchronized boolean g() {
        if (this.k != null) {
            return false;
        }
        if ((this.f66210g.i || this.f66210g.f66219h) && (this.f66211h.f66214g || this.f66211h.f66213f)) {
            if (this.f66209f) {
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
        return this.f66207d.f66156e == ((this.f66206c & 1) == 1);
    }

    public synchronized List<d.c.c.a.b.a.h.a> j() throws IOException {
        List<d.c.c.a.b.a.h.a> list;
        if (i()) {
            this.i.l();
            while (this.f66208e == null && this.k == null) {
                s();
            }
            this.i.u();
            list = this.f66208e;
            if (list != null) {
                this.f66208e = null;
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
                if (this.f66210g.i && this.f66211h.f66214g) {
                    return false;
                }
                this.k = bVar;
                notifyAll();
                this.f66207d.A(this.f66206c);
                return true;
            }
        }
        throw new AssertionError();
    }

    public r l() {
        return this.i;
    }

    public r m() {
        return this.j;
    }

    public q n() {
        return this.f66210g;
    }

    public p o() {
        synchronized (this) {
            if (!this.f66209f && !i()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f66211h;
    }

    public void p() {
        boolean g2;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f66210g.i = true;
            g2 = g();
            notifyAll();
        }
        if (g2) {
            return;
        }
        this.f66207d.A(this.f66206c);
    }

    public void q() throws IOException {
        boolean z;
        boolean g2;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.f66210g.i && this.f66210g.f66219h && (this.f66211h.f66214g || this.f66211h.f66213f);
            g2 = g();
        }
        if (z) {
            d(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        } else if (g2) {
        } else {
            this.f66207d.A(this.f66206c);
        }
    }

    public void r() throws IOException {
        a aVar = this.f66211h;
        if (!aVar.f66213f) {
            if (!aVar.f66214g) {
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
        public final d.c.c.a.a.c f66216e = new d.c.c.a.a.c();

        /* renamed from: f  reason: collision with root package name */
        public final d.c.c.a.a.c f66217f = new d.c.c.a.a.c();

        /* renamed from: g  reason: collision with root package name */
        public final long f66218g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f66219h;
        public boolean i;

        public b(long j) {
            this.f66218g = j;
        }

        @Override // d.c.c.a.a.q
        public long a(d.c.c.a.a.c cVar, long j) throws IOException {
            if (j >= 0) {
                synchronized (g.this) {
                    n();
                    o();
                    if (this.f66217f.v() == 0) {
                        return -1L;
                    }
                    long a2 = this.f66217f.a(cVar, Math.min(j, this.f66217f.v()));
                    g.this.f66204a += a2;
                    if (g.this.f66204a >= g.this.f66207d.q.i() / 2) {
                        g.this.f66207d.q(g.this.f66206c, g.this.f66204a);
                        g.this.f66204a = 0L;
                    }
                    synchronized (g.this.f66207d) {
                        g.this.f66207d.o += a2;
                        if (g.this.f66207d.o >= g.this.f66207d.q.i() / 2) {
                            g.this.f66207d.q(0, g.this.f66207d.o);
                            g.this.f66207d.o = 0L;
                        }
                    }
                    return a2;
                }
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        public void c(d.c.c.a.a.e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (!k && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (g.this) {
                    z = this.i;
                    z2 = true;
                    z3 = this.f66217f.v() + j > this.f66218g;
                }
                if (z3) {
                    eVar.g(j);
                    g.this.f(com.bytedance.sdk.a.b.a.e.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.g(j);
                    return;
                } else {
                    long a2 = eVar.a(this.f66216e, j);
                    if (a2 != -1) {
                        j -= a2;
                        synchronized (g.this) {
                            if (this.f66217f.v() != 0) {
                                z2 = false;
                            }
                            this.f66217f.l(this.f66216e);
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

        @Override // d.c.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (g.this) {
                this.f66219h = true;
                this.f66217f.L();
                g.this.notifyAll();
            }
            g.this.q();
        }

        public final void n() throws IOException {
            g.this.i.l();
            while (this.f66217f.v() == 0 && !this.i && !this.f66219h && g.this.k == null) {
                try {
                    g.this.s();
                } finally {
                    g.this.i.u();
                }
            }
        }

        public final void o() throws IOException {
            if (!this.f66219h) {
                if (g.this.k != null) {
                    throw new o(g.this.k);
                }
                return;
            }
            throw new IOException("stream closed");
        }

        @Override // d.c.c.a.a.q
        public r a() {
            return g.this.i;
        }
    }
}
