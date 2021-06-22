package d.b.c.a.b.a.f;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.internal.http.multipart.Part;
import com.bytedance.sdk.a.b.s;
import d.b.c.a.a.h;
import d.b.c.a.a.k;
import d.b.c.a.a.p;
import d.b.c.a.a.q;
import d.b.c.a.a.r;
import d.b.c.a.b.a.e;
import d.b.c.a.b.a0;
import d.b.c.a.b.c;
import d.b.c.a.b.v;
import d.b.c.a.b.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class a implements e.InterfaceC1888e {

    /* renamed from: a  reason: collision with root package name */
    public final y f69126a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.c.a.b.a.c.f f69127b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.c.a.a.e f69128c;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.c.a.a.d f69129d;

    /* renamed from: e  reason: collision with root package name */
    public int f69130e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f69131f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* loaded from: classes6.dex */
    public abstract class b implements q {

        /* renamed from: e  reason: collision with root package name */
        public final h f69132e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f69133f;

        /* renamed from: g  reason: collision with root package name */
        public long f69134g;

        public b() {
            this.f69132e = new h(a.this.f69128c.a());
            this.f69134g = 0L;
        }

        @Override // d.b.c.a.a.q
        public r a() {
            return this.f69132e;
        }

        public final void c(boolean z, IOException iOException) throws IOException {
            a aVar = a.this;
            int i2 = aVar.f69130e;
            if (i2 == 6) {
                return;
            }
            if (i2 == 5) {
                aVar.f(this.f69132e);
                a aVar2 = a.this;
                aVar2.f69130e = 6;
                d.b.c.a.b.a.c.f fVar = aVar2.f69127b;
                if (fVar != null) {
                    fVar.i(!z, aVar2, this.f69134g, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + a.this.f69130e);
        }

        @Override // d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            try {
                long a2 = a.this.f69128c.a(cVar, j);
                if (a2 > 0) {
                    this.f69134g += a2;
                }
                return a2;
            } catch (IOException e2) {
                c(false, e2);
                throw e2;
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class c implements p {

        /* renamed from: e  reason: collision with root package name */
        public final h f69136e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f69137f;

        public c() {
            this.f69136e = new h(a.this.f69129d.a());
        }

        @Override // d.b.c.a.a.p
        public r a() {
            return this.f69136e;
        }

        @Override // d.b.c.a.a.p
        public void b(d.b.c.a.a.c cVar, long j) throws IOException {
            if (this.f69137f) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            a.this.f69129d.h(j);
            a.this.f69129d.b(Part.CRLF);
            a.this.f69129d.b(cVar, j);
            a.this.f69129d.b(Part.CRLF);
        }

        @Override // d.b.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f69137f) {
                return;
            }
            this.f69137f = true;
            a.this.f69129d.b("0\r\n\r\n");
            a.this.f(this.f69136e);
            a.this.f69130e = 3;
        }

        @Override // d.b.c.a.a.p, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f69137f) {
                return;
            }
            a.this.f69129d.flush();
        }
    }

    /* loaded from: classes6.dex */
    public class d extends b {

        /* renamed from: i  reason: collision with root package name */
        public final s f69139i;
        public long j;
        public boolean k;

        public d(s sVar) {
            super();
            this.j = -1L;
            this.k = true;
            this.f69139i = sVar;
        }

        @Override // d.b.c.a.b.a.f.a.b, d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f69133f) {
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

        @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f69133f) {
                return;
            }
            if (this.k && !d.b.c.a.b.a.e.s(this, 100, TimeUnit.MILLISECONDS)) {
                c(false, null);
            }
            this.f69133f = true;
        }

        public final void n() throws IOException {
            if (this.j != -1) {
                a.this.f69128c.p();
            }
            try {
                this.j = a.this.f69128c.m();
                String trim = a.this.f69128c.p().trim();
                if (this.j >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                    if (this.j == 0) {
                        this.k = false;
                        e.g.f(a.this.f69126a.i(), this.f69139i, a.this.i());
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

    /* loaded from: classes6.dex */
    public final class e implements p {

        /* renamed from: e  reason: collision with root package name */
        public final h f69140e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f69141f;

        /* renamed from: g  reason: collision with root package name */
        public long f69142g;

        public e(long j) {
            this.f69140e = new h(a.this.f69129d.a());
            this.f69142g = j;
        }

        @Override // d.b.c.a.a.p
        public r a() {
            return this.f69140e;
        }

        @Override // d.b.c.a.a.p
        public void b(d.b.c.a.a.c cVar, long j) throws IOException {
            if (!this.f69141f) {
                d.b.c.a.b.a.e.p(cVar.v(), 0L, j);
                if (j <= this.f69142g) {
                    a.this.f69129d.b(cVar, j);
                    this.f69142g -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f69142g + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        @Override // d.b.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f69141f) {
                return;
            }
            this.f69141f = true;
            if (this.f69142g <= 0) {
                a.this.f(this.f69140e);
                a.this.f69130e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // d.b.c.a.a.p, java.io.Flushable
        public void flush() throws IOException {
            if (this.f69141f) {
                return;
            }
            a.this.f69129d.flush();
        }
    }

    /* loaded from: classes6.dex */
    public class f extends b {

        /* renamed from: i  reason: collision with root package name */
        public long f69144i;

        public f(a aVar, long j) throws IOException {
            super();
            this.f69144i = j;
            if (j == 0) {
                c(true, null);
            }
        }

        @Override // d.b.c.a.b.a.f.a.b, d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f69133f) {
                    long j2 = this.f69144i;
                    if (j2 == 0) {
                        return -1L;
                    }
                    long a2 = super.a(cVar, Math.min(j2, j));
                    if (a2 != -1) {
                        long j3 = this.f69144i - a2;
                        this.f69144i = j3;
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

        @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f69133f) {
                return;
            }
            if (this.f69144i != 0 && !d.b.c.a.b.a.e.s(this, 100, TimeUnit.MILLISECONDS)) {
                c(false, null);
            }
            this.f69133f = true;
        }
    }

    /* loaded from: classes6.dex */
    public class g extends b {

        /* renamed from: i  reason: collision with root package name */
        public boolean f69145i;

        public g(a aVar) {
            super();
        }

        @Override // d.b.c.a.b.a.f.a.b, d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f69133f) {
                    if (this.f69145i) {
                        return -1L;
                    }
                    long a2 = super.a(cVar, j);
                    if (a2 == -1) {
                        this.f69145i = true;
                        c(true, null);
                        return -1L;
                    }
                    return a2;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }

        @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f69133f) {
                return;
            }
            if (!this.f69145i) {
                c(false, null);
            }
            this.f69133f = true;
        }
    }

    public a(y yVar, d.b.c.a.b.a.c.f fVar, d.b.c.a.a.e eVar, d.b.c.a.a.d dVar) {
        this.f69126a = yVar;
        this.f69127b = fVar;
        this.f69128c = eVar;
        this.f69129d = dVar;
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1888e
    public void a(a0 a0Var) throws IOException {
        g(a0Var.d(), e.k.b(a0Var, this.f69127b.j().a().b().type()));
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1888e
    public d.b.c.a.b.d b(d.b.c.a.b.c cVar) throws IOException {
        d.b.c.a.b.a.c.f fVar = this.f69127b;
        fVar.f69083f.t(fVar.f69082e);
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

    @Override // d.b.c.a.b.a.e.InterfaceC1888e
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
        if (this.f69130e == 1) {
            this.f69130e = 2;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.f69130e);
    }

    public q e(s sVar) throws IOException {
        if (this.f69130e == 4) {
            this.f69130e = 5;
            return new d(sVar);
        }
        throw new IllegalStateException("state: " + this.f69130e);
    }

    public void f(h hVar) {
        r j = hVar.j();
        hVar.i(r.f69032d);
        j.g();
        j.f();
    }

    public void g(v vVar, String str) throws IOException {
        if (this.f69130e == 0) {
            this.f69129d.b(str).b(Part.CRLF);
            int a2 = vVar.a();
            for (int i2 = 0; i2 < a2; i2++) {
                this.f69129d.b(vVar.b(i2)).b(": ").b(vVar.e(i2)).b(Part.CRLF);
            }
            this.f69129d.b(Part.CRLF);
            this.f69130e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f69130e);
    }

    public q h(long j) throws IOException {
        if (this.f69130e == 4) {
            this.f69130e = 5;
            return new f(this, j);
        }
        throw new IllegalStateException("state: " + this.f69130e);
    }

    public v i() throws IOException {
        v.a aVar = new v.a();
        while (true) {
            String l = l();
            if (l.length() != 0) {
                d.b.c.a.b.a.b.f69053a.f(aVar, l);
            } else {
                return aVar.c();
            }
        }
    }

    public p j() {
        if (this.f69130e == 1) {
            this.f69130e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f69130e);
    }

    public q k() throws IOException {
        if (this.f69130e == 4) {
            d.b.c.a.b.a.c.f fVar = this.f69127b;
            if (fVar != null) {
                this.f69130e = 5;
                fVar.m();
                return new g(this);
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f69130e);
    }

    public final String l() throws IOException {
        String e2 = this.f69128c.e(this.f69131f);
        this.f69131f -= e2.length();
        return e2;
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1888e
    public void a() throws IOException {
        this.f69129d.flush();
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1888e
    public c.a a(boolean z) throws IOException {
        int i2 = this.f69130e;
        if (i2 != 1 && i2 != 3) {
            throw new IllegalStateException("state: " + this.f69130e);
        }
        try {
            e.m b2 = e.m.b(l());
            c.a aVar = new c.a();
            aVar.g(b2.f69123a);
            aVar.a(b2.f69124b);
            aVar.i(b2.f69125c);
            aVar.f(i());
            if (z && b2.f69124b == 100) {
                return null;
            }
            this.f69130e = 4;
            return aVar;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f69127b);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1888e
    public void b() throws IOException {
        this.f69129d.flush();
    }
}
