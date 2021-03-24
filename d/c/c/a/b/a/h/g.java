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
    public long f65359b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65360c;

    /* renamed from: d  reason: collision with root package name */
    public final e f65361d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.c.c.a.b.a.h.a> f65362e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65363f;

    /* renamed from: g  reason: collision with root package name */
    public final b f65364g;

    /* renamed from: h  reason: collision with root package name */
    public final a f65365h;

    /* renamed from: a  reason: collision with root package name */
    public long f65358a = 0;
    public final c i = new c();
    public final c j = new c();
    public com.bytedance.sdk.a.b.a.e.b k = null;

    /* loaded from: classes5.dex */
    public final class a implements p {
        public static final /* synthetic */ boolean i = !g.class.desiredAssertionStatus();

        /* renamed from: e  reason: collision with root package name */
        public final d.c.c.a.a.c f65366e = new d.c.c.a.a.c();

        /* renamed from: f  reason: collision with root package name */
        public boolean f65367f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f65368g;

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
            this.f65366e.b(cVar, j);
            while (this.f65366e.v() >= 16384) {
                c(false);
            }
        }

        public final void c(boolean z) throws IOException {
            long min;
            synchronized (g.this) {
                g.this.j.l();
                while (g.this.f65359b <= 0 && !this.f65368g && !this.f65367f && g.this.k == null) {
                    g.this.s();
                }
                g.this.j.u();
                g.this.r();
                min = Math.min(g.this.f65359b, this.f65366e.v());
                g.this.f65359b -= min;
            }
            g.this.j.l();
            try {
                g.this.f65361d.v(g.this.f65360c, z && min == this.f65366e.v(), this.f65366e, min);
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
                if (this.f65367f) {
                    return;
                }
                if (!g.this.f65365h.f65368g) {
                    if (this.f65366e.v() > 0) {
                        while (this.f65366e.v() > 0) {
                            c(true);
                        }
                    } else {
                        g gVar = g.this;
                        gVar.f65361d.v(gVar.f65360c, true, null, 0L);
                    }
                }
                synchronized (g.this) {
                    this.f65367f = true;
                }
                g.this.f65361d.C();
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
            while (this.f65366e.v() > 0) {
                c(false);
                g.this.f65361d.C();
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
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(com.alipay.sdk.data.a.i);
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
            this.f65360c = i;
            this.f65361d = eVar;
            this.f65359b = eVar.r.i();
            this.f65364g = new b(eVar.q.i());
            a aVar = new a();
            this.f65365h = aVar;
            this.f65364g.i = z2;
            aVar.f65368g = z;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    public int a() {
        return this.f65360c;
    }

    public void b(long j) {
        this.f65359b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void c(d.c.c.a.a.e eVar, int i) throws IOException {
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f65364g.c(eVar, i);
    }

    public void d(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        if (k(bVar)) {
            this.f65361d.D(this.f65360c, bVar);
        }
    }

    public void e(List<d.c.c.a.b.a.h.a> list) {
        boolean z;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = true;
            this.f65363f = true;
            if (this.f65362e == null) {
                this.f65362e = list;
                z = g();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f65362e);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f65362e = arrayList;
            }
        }
        if (z) {
            return;
        }
        this.f65361d.A(this.f65360c);
    }

    public void f(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (k(bVar)) {
            this.f65361d.s(this.f65360c, bVar);
        }
    }

    public synchronized boolean g() {
        if (this.k != null) {
            return false;
        }
        if ((this.f65364g.i || this.f65364g.f65373h) && (this.f65365h.f65368g || this.f65365h.f65367f)) {
            if (this.f65363f) {
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
        return this.f65361d.f65310e == ((this.f65360c & 1) == 1);
    }

    public synchronized List<d.c.c.a.b.a.h.a> j() throws IOException {
        List<d.c.c.a.b.a.h.a> list;
        if (i()) {
            this.i.l();
            while (this.f65362e == null && this.k == null) {
                s();
            }
            this.i.u();
            list = this.f65362e;
            if (list != null) {
                this.f65362e = null;
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
                if (this.f65364g.i && this.f65365h.f65368g) {
                    return false;
                }
                this.k = bVar;
                notifyAll();
                this.f65361d.A(this.f65360c);
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
        return this.f65364g;
    }

    public p o() {
        synchronized (this) {
            if (!this.f65363f && !i()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f65365h;
    }

    public void p() {
        boolean g2;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f65364g.i = true;
            g2 = g();
            notifyAll();
        }
        if (g2) {
            return;
        }
        this.f65361d.A(this.f65360c);
    }

    public void q() throws IOException {
        boolean z;
        boolean g2;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.f65364g.i && this.f65364g.f65373h && (this.f65365h.f65368g || this.f65365h.f65367f);
            g2 = g();
        }
        if (z) {
            d(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        } else if (g2) {
        } else {
            this.f65361d.A(this.f65360c);
        }
    }

    public void r() throws IOException {
        a aVar = this.f65365h;
        if (!aVar.f65367f) {
            if (!aVar.f65368g) {
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
        public final d.c.c.a.a.c f65370e = new d.c.c.a.a.c();

        /* renamed from: f  reason: collision with root package name */
        public final d.c.c.a.a.c f65371f = new d.c.c.a.a.c();

        /* renamed from: g  reason: collision with root package name */
        public final long f65372g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f65373h;
        public boolean i;

        public b(long j) {
            this.f65372g = j;
        }

        @Override // d.c.c.a.a.q
        public long a(d.c.c.a.a.c cVar, long j) throws IOException {
            if (j >= 0) {
                synchronized (g.this) {
                    n();
                    o();
                    if (this.f65371f.v() == 0) {
                        return -1L;
                    }
                    long a2 = this.f65371f.a(cVar, Math.min(j, this.f65371f.v()));
                    g.this.f65358a += a2;
                    if (g.this.f65358a >= g.this.f65361d.q.i() / 2) {
                        g.this.f65361d.q(g.this.f65360c, g.this.f65358a);
                        g.this.f65358a = 0L;
                    }
                    synchronized (g.this.f65361d) {
                        g.this.f65361d.o += a2;
                        if (g.this.f65361d.o >= g.this.f65361d.q.i() / 2) {
                            g.this.f65361d.q(0, g.this.f65361d.o);
                            g.this.f65361d.o = 0L;
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
                    z3 = this.f65371f.v() + j > this.f65372g;
                }
                if (z3) {
                    eVar.g(j);
                    g.this.f(com.bytedance.sdk.a.b.a.e.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.g(j);
                    return;
                } else {
                    long a2 = eVar.a(this.f65370e, j);
                    if (a2 != -1) {
                        j -= a2;
                        synchronized (g.this) {
                            if (this.f65371f.v() != 0) {
                                z2 = false;
                            }
                            this.f65371f.l(this.f65370e);
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
                this.f65373h = true;
                this.f65371f.L();
                g.this.notifyAll();
            }
            g.this.q();
        }

        public final void n() throws IOException {
            g.this.i.l();
            while (this.f65371f.v() == 0 && !this.i && !this.f65373h && g.this.k == null) {
                try {
                    g.this.s();
                } finally {
                    g.this.i.u();
                }
            }
        }

        public final void o() throws IOException {
            if (!this.f65373h) {
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
