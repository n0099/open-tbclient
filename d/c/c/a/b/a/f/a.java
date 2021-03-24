package d.c.c.a.b.a.f;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.internal.http.multipart.Part;
import com.bytedance.sdk.a.b.s;
import d.c.c.a.a.h;
import d.c.c.a.a.k;
import d.c.c.a.a.p;
import d.c.c.a.a.q;
import d.c.c.a.a.r;
import d.c.c.a.b.a.e;
import d.c.c.a.b.a0;
import d.c.c.a.b.c;
import d.c.c.a.b.v;
import d.c.c.a.b.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class a implements e.InterfaceC1786e {

    /* renamed from: a  reason: collision with root package name */
    public final y f65252a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.c.a.b.a.c.f f65253b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c.c.a.a.e f65254c;

    /* renamed from: d  reason: collision with root package name */
    public final d.c.c.a.a.d f65255d;

    /* renamed from: e  reason: collision with root package name */
    public int f65256e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f65257f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* loaded from: classes5.dex */
    public abstract class b implements q {

        /* renamed from: e  reason: collision with root package name */
        public final h f65258e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f65259f;

        /* renamed from: g  reason: collision with root package name */
        public long f65260g;

        public b() {
            this.f65258e = new h(a.this.f65254c.a());
            this.f65260g = 0L;
        }

        @Override // d.c.c.a.a.q
        public r a() {
            return this.f65258e;
        }

        public final void c(boolean z, IOException iOException) throws IOException {
            a aVar = a.this;
            int i = aVar.f65256e;
            if (i == 6) {
                return;
            }
            if (i == 5) {
                aVar.f(this.f65258e);
                a aVar2 = a.this;
                aVar2.f65256e = 6;
                d.c.c.a.b.a.c.f fVar = aVar2.f65253b;
                if (fVar != null) {
                    fVar.i(!z, aVar2, this.f65260g, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + a.this.f65256e);
        }

        @Override // d.c.c.a.a.q
        public long a(d.c.c.a.a.c cVar, long j) throws IOException {
            try {
                long a2 = a.this.f65254c.a(cVar, j);
                if (a2 > 0) {
                    this.f65260g += a2;
                }
                return a2;
            } catch (IOException e2) {
                c(false, e2);
                throw e2;
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class c implements p {

        /* renamed from: e  reason: collision with root package name */
        public final h f65262e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f65263f;

        public c() {
            this.f65262e = new h(a.this.f65255d.a());
        }

        @Override // d.c.c.a.a.p
        public r a() {
            return this.f65262e;
        }

        @Override // d.c.c.a.a.p
        public void b(d.c.c.a.a.c cVar, long j) throws IOException {
            if (this.f65263f) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            a.this.f65255d.h(j);
            a.this.f65255d.b(Part.CRLF);
            a.this.f65255d.b(cVar, j);
            a.this.f65255d.b(Part.CRLF);
        }

        @Override // d.c.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f65263f) {
                return;
            }
            this.f65263f = true;
            a.this.f65255d.b("0\r\n\r\n");
            a.this.f(this.f65262e);
            a.this.f65256e = 3;
        }

        @Override // d.c.c.a.a.p, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f65263f) {
                return;
            }
            a.this.f65255d.flush();
        }
    }

    /* loaded from: classes5.dex */
    public class d extends b {
        public final s i;
        public long j;
        public boolean k;

        public d(s sVar) {
            super();
            this.j = -1L;
            this.k = true;
            this.i = sVar;
        }

        @Override // d.c.c.a.b.a.f.a.b, d.c.c.a.a.q
        public long a(d.c.c.a.a.c cVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f65259f) {
                    if (this.k) {
                        long j2 = this.j;
                        if (j2 == 0 || j2 == -1) {
                            n();
                            if (!this.k) {
                                return -1L;
                            }
                        }
                        long a2 = super.a(cVar, Math.min(j, this.j));
                        if (a2 != -1) {
                            this.j -= a2;
                            return a2;
                        }
                        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                        c(false, protocolException);
                        throw protocolException;
                    }
                    return -1L;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // d.c.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f65259f) {
                return;
            }
            if (this.k && !d.c.c.a.b.a.e.s(this, 100, TimeUnit.MILLISECONDS)) {
                c(false, null);
            }
            this.f65259f = true;
        }

        public final void n() throws IOException {
            if (this.j != -1) {
                a.this.f65254c.p();
            }
            try {
                this.j = a.this.f65254c.m();
                String trim = a.this.f65254c.p().trim();
                if (this.j >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                    if (this.j == 0) {
                        this.k = false;
                        e.g.f(a.this.f65252a.i(), this.i, a.this.i());
                        c(true, null);
                        return;
                    }
                    return;
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.j + trim + "\"");
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class e implements p {

        /* renamed from: e  reason: collision with root package name */
        public final h f65265e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f65266f;

        /* renamed from: g  reason: collision with root package name */
        public long f65267g;

        public e(long j) {
            this.f65265e = new h(a.this.f65255d.a());
            this.f65267g = j;
        }

        @Override // d.c.c.a.a.p
        public r a() {
            return this.f65265e;
        }

        @Override // d.c.c.a.a.p
        public void b(d.c.c.a.a.c cVar, long j) throws IOException {
            if (!this.f65266f) {
                d.c.c.a.b.a.e.p(cVar.v(), 0L, j);
                if (j <= this.f65267g) {
                    a.this.f65255d.b(cVar, j);
                    this.f65267g -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f65267g + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        @Override // d.c.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f65266f) {
                return;
            }
            this.f65266f = true;
            if (this.f65267g <= 0) {
                a.this.f(this.f65265e);
                a.this.f65256e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // d.c.c.a.a.p, java.io.Flushable
        public void flush() throws IOException {
            if (this.f65266f) {
                return;
            }
            a.this.f65255d.flush();
        }
    }

    /* loaded from: classes5.dex */
    public class f extends b {
        public long i;

        public f(a aVar, long j) throws IOException {
            super();
            this.i = j;
            if (j == 0) {
                c(true, null);
            }
        }

        @Override // d.c.c.a.b.a.f.a.b, d.c.c.a.a.q
        public long a(d.c.c.a.a.c cVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f65259f) {
                    long j2 = this.i;
                    if (j2 == 0) {
                        return -1L;
                    }
                    long a2 = super.a(cVar, Math.min(j2, j));
                    if (a2 != -1) {
                        long j3 = this.i - a2;
                        this.i = j3;
                        if (j3 == 0) {
                            c(true, null);
                        }
                        return a2;
                    }
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    c(false, protocolException);
                    throw protocolException;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // d.c.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f65259f) {
                return;
            }
            if (this.i != 0 && !d.c.c.a.b.a.e.s(this, 100, TimeUnit.MILLISECONDS)) {
                c(false, null);
            }
            this.f65259f = true;
        }
    }

    /* loaded from: classes5.dex */
    public class g extends b {
        public boolean i;

        public g(a aVar) {
            super();
        }

        @Override // d.c.c.a.b.a.f.a.b, d.c.c.a.a.q
        public long a(d.c.c.a.a.c cVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f65259f) {
                    if (this.i) {
                        return -1L;
                    }
                    long a2 = super.a(cVar, j);
                    if (a2 == -1) {
                        this.i = true;
                        c(true, null);
                        return -1L;
                    }
                    return a2;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // d.c.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f65259f) {
                return;
            }
            if (!this.i) {
                c(false, null);
            }
            this.f65259f = true;
        }
    }

    public a(y yVar, d.c.c.a.b.a.c.f fVar, d.c.c.a.a.e eVar, d.c.c.a.a.d dVar) {
        this.f65252a = yVar;
        this.f65253b = fVar;
        this.f65254c = eVar;
        this.f65255d = dVar;
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1786e
    public void a(a0 a0Var) throws IOException {
        g(a0Var.d(), e.k.b(a0Var, this.f65253b.j().a().b().type()));
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1786e
    public d.c.c.a.b.d b(d.c.c.a.b.c cVar) throws IOException {
        d.c.c.a.b.a.c.f fVar = this.f65253b;
        fVar.f65212f.t(fVar.f65211e);
        String o = cVar.o("Content-Type");
        if (!e.g.h(cVar)) {
            return new e.j(o, 0L, k.b(h(0L)));
        }
        if ("chunked".equalsIgnoreCase(cVar.o("Transfer-Encoding"))) {
            return new e.j(o, -1L, k.b(e(cVar.n().a())));
        }
        long c2 = e.g.c(cVar);
        if (c2 != -1) {
            return new e.j(o, c2, k.b(h(c2)));
        }
        return new e.j(o, -1L, k.b(k()));
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1786e
    public p c(a0 a0Var, long j) {
        if ("chunked".equalsIgnoreCase(a0Var.b("Transfer-Encoding"))) {
            return j();
        }
        if (j != -1) {
            return d(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public p d(long j) {
        if (this.f65256e == 1) {
            this.f65256e = 2;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.f65256e);
    }

    public q e(s sVar) throws IOException {
        if (this.f65256e == 4) {
            this.f65256e = 5;
            return new d(sVar);
        }
        throw new IllegalStateException("state: " + this.f65256e);
    }

    public void f(h hVar) {
        r j = hVar.j();
        hVar.i(r.f65163d);
        j.g();
        j.f();
    }

    public void g(v vVar, String str) throws IOException {
        if (this.f65256e == 0) {
            this.f65255d.b(str).b(Part.CRLF);
            int a2 = vVar.a();
            for (int i = 0; i < a2; i++) {
                this.f65255d.b(vVar.b(i)).b(": ").b(vVar.e(i)).b(Part.CRLF);
            }
            this.f65255d.b(Part.CRLF);
            this.f65256e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f65256e);
    }

    public q h(long j) throws IOException {
        if (this.f65256e == 4) {
            this.f65256e = 5;
            return new f(this, j);
        }
        throw new IllegalStateException("state: " + this.f65256e);
    }

    public v i() throws IOException {
        v.a aVar = new v.a();
        while (true) {
            String l = l();
            if (l.length() != 0) {
                d.c.c.a.b.a.b.f65183a.f(aVar, l);
            } else {
                return aVar.c();
            }
        }
    }

    public p j() {
        if (this.f65256e == 1) {
            this.f65256e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f65256e);
    }

    public q k() throws IOException {
        if (this.f65256e == 4) {
            d.c.c.a.b.a.c.f fVar = this.f65253b;
            if (fVar != null) {
                this.f65256e = 5;
                fVar.m();
                return new g(this);
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f65256e);
    }

    public final String l() throws IOException {
        String e2 = this.f65254c.e(this.f65257f);
        this.f65257f -= e2.length();
        return e2;
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1786e
    public void a() throws IOException {
        this.f65255d.flush();
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1786e
    public c.a a(boolean z) throws IOException {
        int i = this.f65256e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.f65256e);
        }
        try {
            e.m b2 = e.m.b(l());
            c.a aVar = new c.a();
            aVar.g(b2.f65249a);
            aVar.a(b2.f65250b);
            aVar.i(b2.f65251c);
            aVar.f(i());
            if (z && b2.f65250b == 100) {
                return null;
            }
            this.f65256e = 4;
            return aVar;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f65253b);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    @Override // d.c.c.a.b.a.e.InterfaceC1786e
    public void b() throws IOException {
        this.f65255d.flush();
    }
}
