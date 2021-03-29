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
    public long f65360b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65361c;

    /* renamed from: d  reason: collision with root package name */
    public final e f65362d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.c.c.a.b.a.h.a> f65363e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65364f;

    /* renamed from: g  reason: collision with root package name */
    public final b f65365g;

    /* renamed from: h  reason: collision with root package name */
    public final a f65366h;

    /* renamed from: a  reason: collision with root package name */
    public long f65359a = 0;
    public final c i = new c();
    public final c j = new c();
    public com.bytedance.sdk.a.b.a.e.b k = null;

    /* loaded from: classes5.dex */
    public final class a implements p {
        public static final /* synthetic */ boolean i = !g.class.desiredAssertionStatus();

        /* renamed from: e  reason: collision with root package name */
        public final d.c.c.a.a.c f65367e = new d.c.c.a.a.c();

        /* renamed from: f  reason: collision with root package name */
        public boolean f65368f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f65369g;

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
            this.f65367e.b(cVar, j);
            while (this.f65367e.v() >= 16384) {
                c(false);
            }
        }

        public final void c(boolean z) throws IOException {
            long min;
            synchronized (g.this) {
                g.this.j.l();
                while (g.this.f65360b <= 0 && !this.f65369g && !this.f65368f && g.this.k == null) {
                    g.this.s();
                }
                g.this.j.u();
                g.this.r();
                min = Math.min(g.this.f65360b, this.f65367e.v());
                g.this.f65360b -= min;
            }
            g.this.j.l();
            try {
                g.this.f65362d.v(g.this.f65361c, z && min == this.f65367e.v(), this.f65367e, min);
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
                if (this.f65368f) {
                    return;
                }
                if (!g.this.f65366h.f65369g) {
                    if (this.f65367e.v() > 0) {
                        while (this.f65367e.v() > 0) {
                            c(true);
                        }
                    } else {
                        g gVar = g.this;
                        gVar.f65362d.v(gVar.f65361c, true, null, 0L);
                    }
                }
                synchronized (g.this) {
                    this.f65368f = true;
                }
                g.this.f65362d.C();
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
            while (this.f65367e.v() > 0) {
                c(false);
                g.this.f65362d.C();
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
            this.f65361c = i;
            this.f65362d = eVar;
            this.f65360b = eVar.r.i();
            this.f65365g = new b(eVar.q.i());
            a aVar = new a();
            this.f65366h = aVar;
            this.f65365g.i = z2;
            aVar.f65369g = z;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    public int a() {
        return this.f65361c;
    }

    public void b(long j) {
        this.f65360b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void c(d.c.c.a.a.e eVar, int i) throws IOException {
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f65365g.c(eVar, i);
    }

    public void d(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        if (k(bVar)) {
            this.f65362d.D(this.f65361c, bVar);
        }
    }

    public void e(List<d.c.c.a.b.a.h.a> list) {
        boolean z;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = true;
            this.f65364f = true;
            if (this.f65363e == null) {
                this.f65363e = list;
                z = g();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f65363e);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f65363e = arrayList;
            }
        }
        if (z) {
            return;
        }
        this.f65362d.A(this.f65361c);
    }

    public void f(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (k(bVar)) {
            this.f65362d.s(this.f65361c, bVar);
        }
    }

    public synchronized boolean g() {
        if (this.k != null) {
            return false;
        }
        if ((this.f65365g.i || this.f65365g.f65374h) && (this.f65366h.f65369g || this.f65366h.f65368f)) {
            if (this.f65364f) {
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
        return this.f65362d.f65311e == ((this.f65361c & 1) == 1);
    }

    public synchronized List<d.c.c.a.b.a.h.a> j() throws IOException {
        List<d.c.c.a.b.a.h.a> list;
        if (i()) {
            this.i.l();
            while (this.f65363e == null && this.k == null) {
                s();
            }
            this.i.u();
            list = this.f65363e;
            if (list != null) {
                this.f65363e = null;
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
                if (this.f65365g.i && this.f65366h.f65369g) {
                    return false;
                }
                this.k = bVar;
                notifyAll();
                this.f65362d.A(this.f65361c);
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
        return this.f65365g;
    }

    public p o() {
        synchronized (this) {
            if (!this.f65364f && !i()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f65366h;
    }

    public void p() {
        boolean g2;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f65365g.i = true;
            g2 = g();
            notifyAll();
        }
        if (g2) {
            return;
        }
        this.f65362d.A(this.f65361c);
    }

    public void q() throws IOException {
        boolean z;
        boolean g2;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.f65365g.i && this.f65365g.f65374h && (this.f65366h.f65369g || this.f65366h.f65368f);
            g2 = g();
        }
        if (z) {
            d(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        } else if (g2) {
        } else {
            this.f65362d.A(this.f65361c);
        }
    }

    public void r() throws IOException {
        a aVar = this.f65366h;
        if (!aVar.f65368f) {
            if (!aVar.f65369g) {
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
        public final d.c.c.a.a.c f65371e = new d.c.c.a.a.c();

        /* renamed from: f  reason: collision with root package name */
        public final d.c.c.a.a.c f65372f = new d.c.c.a.a.c();

        /* renamed from: g  reason: collision with root package name */
        public final long f65373g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f65374h;
        public boolean i;

        public b(long j) {
            this.f65373g = j;
        }

        @Override // d.c.c.a.a.q
        public long a(d.c.c.a.a.c cVar, long j) throws IOException {
            if (j >= 0) {
                synchronized (g.this) {
                    n();
                    o();
                    if (this.f65372f.v() == 0) {
                        return -1L;
                    }
                    long a2 = this.f65372f.a(cVar, Math.min(j, this.f65372f.v()));
                    g.this.f65359a += a2;
                    if (g.this.f65359a >= g.this.f65362d.q.i() / 2) {
                        g.this.f65362d.q(g.this.f65361c, g.this.f65359a);
                        g.this.f65359a = 0L;
                    }
                    synchronized (g.this.f65362d) {
                        g.this.f65362d.o += a2;
                        if (g.this.f65362d.o >= g.this.f65362d.q.i() / 2) {
                            g.this.f65362d.q(0, g.this.f65362d.o);
                            g.this.f65362d.o = 0L;
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
                    z3 = this.f65372f.v() + j > this.f65373g;
                }
                if (z3) {
                    eVar.g(j);
                    g.this.f(com.bytedance.sdk.a.b.a.e.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.g(j);
                    return;
                } else {
                    long a2 = eVar.a(this.f65371e, j);
                    if (a2 != -1) {
                        j -= a2;
                        synchronized (g.this) {
                            if (this.f65372f.v() != 0) {
                                z2 = false;
                            }
                            this.f65372f.l(this.f65371e);
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
                this.f65374h = true;
                this.f65372f.L();
                g.this.notifyAll();
            }
            g.this.q();
        }

        public final void n() throws IOException {
            g.this.i.l();
            while (this.f65372f.v() == 0 && !this.i && !this.f65374h && g.this.k == null) {
                try {
                    g.this.s();
                } finally {
                    g.this.i.u();
                }
            }
        }

        public final void o() throws IOException {
            if (!this.f65374h) {
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
