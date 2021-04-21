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
    public long f66300b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66301c;

    /* renamed from: d  reason: collision with root package name */
    public final e f66302d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.c.c.a.b.a.h.a> f66303e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66304f;

    /* renamed from: g  reason: collision with root package name */
    public final b f66305g;

    /* renamed from: h  reason: collision with root package name */
    public final a f66306h;

    /* renamed from: a  reason: collision with root package name */
    public long f66299a = 0;
    public final c i = new c();
    public final c j = new c();
    public com.bytedance.sdk.a.b.a.e.b k = null;

    /* loaded from: classes5.dex */
    public final class a implements p {
        public static final /* synthetic */ boolean i = !g.class.desiredAssertionStatus();

        /* renamed from: e  reason: collision with root package name */
        public final d.c.c.a.a.c f66307e = new d.c.c.a.a.c();

        /* renamed from: f  reason: collision with root package name */
        public boolean f66308f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f66309g;

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
            this.f66307e.b(cVar, j);
            while (this.f66307e.v() >= 16384) {
                c(false);
            }
        }

        public final void c(boolean z) throws IOException {
            long min;
            synchronized (g.this) {
                g.this.j.l();
                while (g.this.f66300b <= 0 && !this.f66309g && !this.f66308f && g.this.k == null) {
                    g.this.s();
                }
                g.this.j.u();
                g.this.r();
                min = Math.min(g.this.f66300b, this.f66307e.v());
                g.this.f66300b -= min;
            }
            g.this.j.l();
            try {
                g.this.f66302d.v(g.this.f66301c, z && min == this.f66307e.v(), this.f66307e, min);
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
                if (this.f66308f) {
                    return;
                }
                if (!g.this.f66306h.f66309g) {
                    if (this.f66307e.v() > 0) {
                        while (this.f66307e.v() > 0) {
                            c(true);
                        }
                    } else {
                        g gVar = g.this;
                        gVar.f66302d.v(gVar.f66301c, true, null, 0L);
                    }
                }
                synchronized (g.this) {
                    this.f66308f = true;
                }
                g.this.f66302d.C();
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
            while (this.f66307e.v() > 0) {
                c(false);
                g.this.f66302d.C();
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
            this.f66301c = i;
            this.f66302d = eVar;
            this.f66300b = eVar.r.i();
            this.f66305g = new b(eVar.q.i());
            a aVar = new a();
            this.f66306h = aVar;
            this.f66305g.i = z2;
            aVar.f66309g = z;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    public int a() {
        return this.f66301c;
    }

    public void b(long j) {
        this.f66300b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void c(d.c.c.a.a.e eVar, int i) throws IOException {
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f66305g.c(eVar, i);
    }

    public void d(com.bytedance.sdk.a.b.a.e.b bVar) throws IOException {
        if (k(bVar)) {
            this.f66302d.D(this.f66301c, bVar);
        }
    }

    public void e(List<d.c.c.a.b.a.h.a> list) {
        boolean z;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = true;
            this.f66304f = true;
            if (this.f66303e == null) {
                this.f66303e = list;
                z = g();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f66303e);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f66303e = arrayList;
            }
        }
        if (z) {
            return;
        }
        this.f66302d.A(this.f66301c);
    }

    public void f(com.bytedance.sdk.a.b.a.e.b bVar) {
        if (k(bVar)) {
            this.f66302d.s(this.f66301c, bVar);
        }
    }

    public synchronized boolean g() {
        if (this.k != null) {
            return false;
        }
        if ((this.f66305g.i || this.f66305g.f66314h) && (this.f66306h.f66309g || this.f66306h.f66308f)) {
            if (this.f66304f) {
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
        return this.f66302d.f66251e == ((this.f66301c & 1) == 1);
    }

    public synchronized List<d.c.c.a.b.a.h.a> j() throws IOException {
        List<d.c.c.a.b.a.h.a> list;
        if (i()) {
            this.i.l();
            while (this.f66303e == null && this.k == null) {
                s();
            }
            this.i.u();
            list = this.f66303e;
            if (list != null) {
                this.f66303e = null;
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
                if (this.f66305g.i && this.f66306h.f66309g) {
                    return false;
                }
                this.k = bVar;
                notifyAll();
                this.f66302d.A(this.f66301c);
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
        return this.f66305g;
    }

    public p o() {
        synchronized (this) {
            if (!this.f66304f && !i()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f66306h;
    }

    public void p() {
        boolean g2;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f66305g.i = true;
            g2 = g();
            notifyAll();
        }
        if (g2) {
            return;
        }
        this.f66302d.A(this.f66301c);
    }

    public void q() throws IOException {
        boolean z;
        boolean g2;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.f66305g.i && this.f66305g.f66314h && (this.f66306h.f66309g || this.f66306h.f66308f);
            g2 = g();
        }
        if (z) {
            d(com.bytedance.sdk.a.b.a.e.b.CANCEL);
        } else if (g2) {
        } else {
            this.f66302d.A(this.f66301c);
        }
    }

    public void r() throws IOException {
        a aVar = this.f66306h;
        if (!aVar.f66308f) {
            if (!aVar.f66309g) {
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
        public final d.c.c.a.a.c f66311e = new d.c.c.a.a.c();

        /* renamed from: f  reason: collision with root package name */
        public final d.c.c.a.a.c f66312f = new d.c.c.a.a.c();

        /* renamed from: g  reason: collision with root package name */
        public final long f66313g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f66314h;
        public boolean i;

        public b(long j) {
            this.f66313g = j;
        }

        @Override // d.c.c.a.a.q
        public long a(d.c.c.a.a.c cVar, long j) throws IOException {
            if (j >= 0) {
                synchronized (g.this) {
                    n();
                    o();
                    if (this.f66312f.v() == 0) {
                        return -1L;
                    }
                    long a2 = this.f66312f.a(cVar, Math.min(j, this.f66312f.v()));
                    g.this.f66299a += a2;
                    if (g.this.f66299a >= g.this.f66302d.q.i() / 2) {
                        g.this.f66302d.q(g.this.f66301c, g.this.f66299a);
                        g.this.f66299a = 0L;
                    }
                    synchronized (g.this.f66302d) {
                        g.this.f66302d.o += a2;
                        if (g.this.f66302d.o >= g.this.f66302d.q.i() / 2) {
                            g.this.f66302d.q(0, g.this.f66302d.o);
                            g.this.f66302d.o = 0L;
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
                    z3 = this.f66312f.v() + j > this.f66313g;
                }
                if (z3) {
                    eVar.g(j);
                    g.this.f(com.bytedance.sdk.a.b.a.e.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.g(j);
                    return;
                } else {
                    long a2 = eVar.a(this.f66311e, j);
                    if (a2 != -1) {
                        j -= a2;
                        synchronized (g.this) {
                            if (this.f66312f.v() != 0) {
                                z2 = false;
                            }
                            this.f66312f.l(this.f66311e);
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
                this.f66314h = true;
                this.f66312f.L();
                g.this.notifyAll();
            }
            g.this.q();
        }

        public final void n() throws IOException {
            g.this.i.l();
            while (this.f66312f.v() == 0 && !this.i && !this.f66314h && g.this.k == null) {
                try {
                    g.this.s();
                } finally {
                    g.this.i.u();
                }
            }
        }

        public final void o() throws IOException {
            if (!this.f66314h) {
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
