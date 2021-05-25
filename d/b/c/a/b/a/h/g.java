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
    public long f65410b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65411c;

    /* renamed from: d  reason: collision with root package name */
    public final e f65412d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.c.a.b.a.h.a> f65413e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65414f;

    /* renamed from: g  reason: collision with root package name */
    public final b f65415g;

    /* renamed from: h  reason: collision with root package name */
    public final a f65416h;

    /* renamed from: a  reason: collision with root package name */
    public long f65409a = 0;

    /* renamed from: i  reason: collision with root package name */
    public final c f65417i = new c();
    public final c j = new c();
    public com.bytedance.sdk.a.b.a.e.b k = null;

    /* loaded from: classes6.dex */
    public final class a implements p {

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ boolean f65418i = !g.class.desiredAssertionStatus();

        /* renamed from: e  reason: collision with root package name */
        public final d.b.c.a.a.c f65419e = new d.b.c.a.a.c();

        /* renamed from: f  reason: collision with root package name */
        public boolean f65420f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f65421g;

        public a() {
        }

        @Override // d.b.c.a.a.p
        public r a() {
            return g.this.j;
        }

        @Override // d.b.c.a.a.p
        public void b(d.b.c.a.a.c cVar, long j) throws IOException {
            if (!f65418i && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            this.f65419e.b(cVar, j);
            while (this.f65419e.v() >= 16384) {
                c(false);
            }
        }

        public final void c(boolean z) throws IOException {
            long min;
            synchronized (g.this) {
                g.this.j.l();
                while (g.this.f65410b <= 0 && !this.f65421g && !this.f65420f && g.this.k == null) {
                    g.this.s();
                }
                g.this.j.u();
                g.this.r();
                min = Math.min(g.this.f65410b, this.f65419e.v());
                g.this.f65410b -= min;
            }
            g.this.j.l();
            try {
                g.this.f65412d.v(g.this.f65411c, z && min == this.f65419e.v(), this.f65419e, min);
            } finally {
                g.this.j.u();
            }
        }

        @Override // d.b.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f65418i && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            synchronized (g.this) {
                if (this.f65420f) {
                    return;
                }
                if (!g.this.f65416h.f65421g) {
                    if (this.f65419e.v() > 0) {
                        while (this.f65419e.v() > 0) {
                            c(true);
                        }
                    } else {
                        g gVar = g.this;
                        gVar.f65412d.v(gVar.f65411c, true, null, 0L);
                    }
                }
                synchronized (g.this) {
                    this.f65420f = true;
                }
                g.this.f65412d.C();
                g.this.q();
            }
        }

        @Override // d.b.c.a.a.p, java.io.Flushable
        public void flush() throws IOException {
            if (!f65418i && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            synchronized (g.this) {
                g.this.r();
            }
            while (this.f65419e.v() > 0) {
                c(false);
                g.this.f65412d.C();
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
            this.f65411c = i2;
            this.f65412d = eVar;
            this.f65410b = eVar.r.i();
            this.f65415g = new b(eVar.q.i());
            a aVar = new a();
            this.f65416h = aVar;
            this.f65415g.f65427i = z2;
            aVar.f65421g = z;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    public int a() {
        return this.f65411c;
    }

    public void b(long j) {
        this.f65410b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void c(d.b.c.a.a.e eVar, int i2) throws IOException {
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f65415g.c(eVar, i2);
    }

    public void d(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        if (k(bVar)) {
            this.f65412d.D(this.f65411c, bVar);
        }
    }

    public void e(List<d.b.c.a.b.a.h.a> list) {
        boolean z;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = true;
            this.f65414f = true;
            if (this.f65413e == null) {
                this.f65413e = list;
                z = g();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f65413e);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f65413e = arrayList;
            }
        }
        if (z) {
            return;
        }
        this.f65412d.A(this.f65411c);
    }

    public void f(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (k(bVar)) {
            this.f65412d.s(this.f65411c, bVar);
        }
    }

    public synchronized boolean g() {
        if (this.k != null) {
            return false;
        }
        if ((this.f65415g.f65427i || this.f65415g.f65426h) && (this.f65416h.f65421g || this.f65416h.f65420f)) {
            if (this.f65414f) {
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
        return this.f65412d.f65355e == ((this.f65411c & 1) == 1);
    }

    public synchronized List<d.b.c.a.b.a.h.a> j() throws IOException {
        List<d.b.c.a.b.a.h.a> list;
        if (i()) {
            this.f65417i.l();
            while (this.f65413e == null && this.k == null) {
                s();
            }
            this.f65417i.u();
            list = this.f65413e;
            if (list != null) {
                this.f65413e = null;
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
                if (this.f65415g.f65427i && this.f65416h.f65421g) {
                    return false;
                }
                this.k = bVar;
                notifyAll();
                this.f65412d.A(this.f65411c);
                return true;
            }
        }
        throw new AssertionError();
    }

    public r l() {
        return this.f65417i;
    }

    public r m() {
        return this.j;
    }

    public q n() {
        return this.f65415g;
    }

    public p o() {
        synchronized (this) {
            if (!this.f65414f && !i()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f65416h;
    }

    public void p() {
        boolean g2;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f65415g.f65427i = true;
            g2 = g();
            notifyAll();
        }
        if (g2) {
            return;
        }
        this.f65412d.A(this.f65411c);
    }

    public void q() throws IOException {
        boolean z;
        boolean g2;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.f65415g.f65427i && this.f65415g.f65426h && (this.f65416h.f65421g || this.f65416h.f65420f);
            g2 = g();
        }
        if (z) {
            d(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        } else if (g2) {
        } else {
            this.f65412d.A(this.f65411c);
        }
    }

    public void r() throws IOException {
        a aVar = this.f65416h;
        if (!aVar.f65420f) {
            if (!aVar.f65421g) {
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
        public final d.b.c.a.a.c f65423e = new d.b.c.a.a.c();

        /* renamed from: f  reason: collision with root package name */
        public final d.b.c.a.a.c f65424f = new d.b.c.a.a.c();

        /* renamed from: g  reason: collision with root package name */
        public final long f65425g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f65426h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f65427i;

        public b(long j) {
            this.f65425g = j;
        }

        @Override // d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            if (j >= 0) {
                synchronized (g.this) {
                    n();
                    o();
                    if (this.f65424f.v() == 0) {
                        return -1L;
                    }
                    long a2 = this.f65424f.a(cVar, Math.min(j, this.f65424f.v()));
                    g.this.f65409a += a2;
                    if (g.this.f65409a >= g.this.f65412d.q.i() / 2) {
                        g.this.f65412d.q(g.this.f65411c, g.this.f65409a);
                        g.this.f65409a = 0L;
                    }
                    synchronized (g.this.f65412d) {
                        g.this.f65412d.o += a2;
                        if (g.this.f65412d.o >= g.this.f65412d.q.i() / 2) {
                            g.this.f65412d.q(0, g.this.f65412d.o);
                            g.this.f65412d.o = 0L;
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
                    z = this.f65427i;
                    z2 = true;
                    z3 = this.f65424f.v() + j > this.f65425g;
                }
                if (z3) {
                    eVar.g(j);
                    g.this.f(com.bytedance.sdk.a.b.a.e.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.g(j);
                    return;
                } else {
                    long a2 = eVar.a(this.f65423e, j);
                    if (a2 != -1) {
                        j -= a2;
                        synchronized (g.this) {
                            if (this.f65424f.v() != 0) {
                                z2 = false;
                            }
                            this.f65424f.l(this.f65423e);
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
                this.f65426h = true;
                this.f65424f.L();
                g.this.notifyAll();
            }
            g.this.q();
        }

        public final void n() throws IOException {
            g.this.f65417i.l();
            while (this.f65424f.v() == 0 && !this.f65427i && !this.f65426h && g.this.k == null) {
                try {
                    g.this.s();
                } finally {
                    g.this.f65417i.u();
                }
            }
        }

        public final void o() throws IOException {
            if (!this.f65426h) {
                if (g.this.k != null) {
                    throw new o(g.this.k);
                }
                return;
            }
            throw new IOException("stream closed");
        }

        @Override // d.b.c.a.a.q
        public r a() {
            return g.this.f65417i;
        }
    }
}
