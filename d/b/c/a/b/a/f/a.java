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
public final class a implements e.InterfaceC1826e {

    /* renamed from: a  reason: collision with root package name */
    public final y f65291a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.c.a.b.a.c.f f65292b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.c.a.a.e f65293c;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.c.a.a.d f65294d;

    /* renamed from: e  reason: collision with root package name */
    public int f65295e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f65296f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* loaded from: classes6.dex */
    public abstract class b implements q {

        /* renamed from: e  reason: collision with root package name */
        public final h f65297e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f65298f;

        /* renamed from: g  reason: collision with root package name */
        public long f65299g;

        public b() {
            this.f65297e = new h(a.this.f65293c.a());
            this.f65299g = 0L;
        }

        @Override // d.b.c.a.a.q
        public r a() {
            return this.f65297e;
        }

        public final void c(boolean z, IOException iOException) throws IOException {
            a aVar = a.this;
            int i2 = aVar.f65295e;
            if (i2 == 6) {
                return;
            }
            if (i2 == 5) {
                aVar.f(this.f65297e);
                a aVar2 = a.this;
                aVar2.f65295e = 6;
                d.b.c.a.b.a.c.f fVar = aVar2.f65292b;
                if (fVar != null) {
                    fVar.i(!z, aVar2, this.f65299g, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + a.this.f65295e);
        }

        @Override // d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            try {
                long a2 = a.this.f65293c.a(cVar, j);
                if (a2 > 0) {
                    this.f65299g += a2;
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
        public final h f65301e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f65302f;

        public c() {
            this.f65301e = new h(a.this.f65294d.a());
        }

        @Override // d.b.c.a.a.p
        public r a() {
            return this.f65301e;
        }

        @Override // d.b.c.a.a.p
        public void b(d.b.c.a.a.c cVar, long j) throws IOException {
            if (this.f65302f) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            a.this.f65294d.h(j);
            a.this.f65294d.b(Part.CRLF);
            a.this.f65294d.b(cVar, j);
            a.this.f65294d.b(Part.CRLF);
        }

        @Override // d.b.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f65302f) {
                return;
            }
            this.f65302f = true;
            a.this.f65294d.b("0\r\n\r\n");
            a.this.f(this.f65301e);
            a.this.f65295e = 3;
        }

        @Override // d.b.c.a.a.p, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f65302f) {
                return;
            }
            a.this.f65294d.flush();
        }
    }

    /* loaded from: classes6.dex */
    public class d extends b {

        /* renamed from: i  reason: collision with root package name */
        public final s f65304i;
        public long j;
        public boolean k;

        public d(s sVar) {
            super();
            this.j = -1L;
            this.k = true;
            this.f65304i = sVar;
        }

        @Override // d.b.c.a.b.a.f.a.b, d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f65298f) {
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
            if (this.f65298f) {
                return;
            }
            if (this.k && !d.b.c.a.b.a.e.s(this, 100, TimeUnit.MILLISECONDS)) {
                c(false, null);
            }
            this.f65298f = true;
        }

        public final void n() throws IOException {
            if (this.j != -1) {
                a.this.f65293c.p();
            }
            try {
                this.j = a.this.f65293c.m();
                String trim = a.this.f65293c.p().trim();
                if (this.j >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                    if (this.j == 0) {
                        this.k = false;
                        e.g.f(a.this.f65291a.i(), this.f65304i, a.this.i());
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
        public final h f65305e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f65306f;

        /* renamed from: g  reason: collision with root package name */
        public long f65307g;

        public e(long j) {
            this.f65305e = new h(a.this.f65294d.a());
            this.f65307g = j;
        }

        @Override // d.b.c.a.a.p
        public r a() {
            return this.f65305e;
        }

        @Override // d.b.c.a.a.p
        public void b(d.b.c.a.a.c cVar, long j) throws IOException {
            if (!this.f65306f) {
                d.b.c.a.b.a.e.p(cVar.v(), 0L, j);
                if (j <= this.f65307g) {
                    a.this.f65294d.b(cVar, j);
                    this.f65307g -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f65307g + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        @Override // d.b.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f65306f) {
                return;
            }
            this.f65306f = true;
            if (this.f65307g <= 0) {
                a.this.f(this.f65305e);
                a.this.f65295e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // d.b.c.a.a.p, java.io.Flushable
        public void flush() throws IOException {
            if (this.f65306f) {
                return;
            }
            a.this.f65294d.flush();
        }
    }

    /* loaded from: classes6.dex */
    public class f extends b {

        /* renamed from: i  reason: collision with root package name */
        public long f65309i;

        public f(a aVar, long j) throws IOException {
            super();
            this.f65309i = j;
            if (j == 0) {
                c(true, null);
            }
        }

        @Override // d.b.c.a.b.a.f.a.b, d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f65298f) {
                    long j2 = this.f65309i;
                    if (j2 == 0) {
                        return -1L;
                    }
                    long a2 = super.a(cVar, Math.min(j2, j));
                    if (a2 != -1) {
                        long j3 = this.f65309i - a2;
                        this.f65309i = j3;
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
            if (this.f65298f) {
                return;
            }
            if (this.f65309i != 0 && !d.b.c.a.b.a.e.s(this, 100, TimeUnit.MILLISECONDS)) {
                c(false, null);
            }
            this.f65298f = true;
        }
    }

    /* loaded from: classes6.dex */
    public class g extends b {

        /* renamed from: i  reason: collision with root package name */
        public boolean f65310i;

        public g(a aVar) {
            super();
        }

        @Override // d.b.c.a.b.a.f.a.b, d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            if (j >= 0) {
                if (!this.f65298f) {
                    if (this.f65310i) {
                        return -1L;
                    }
                    long a2 = super.a(cVar, j);
                    if (a2 == -1) {
                        this.f65310i = true;
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
            if (this.f65298f) {
                return;
            }
            if (!this.f65310i) {
                c(false, null);
            }
            this.f65298f = true;
        }
    }

    public a(y yVar, d.b.c.a.b.a.c.f fVar, d.b.c.a.a.e eVar, d.b.c.a.a.d dVar) {
        this.f65291a = yVar;
        this.f65292b = fVar;
        this.f65293c = eVar;
        this.f65294d = dVar;
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1826e
    public void a(a0 a0Var) throws IOException {
        g(a0Var.d(), e.k.b(a0Var, this.f65292b.j().a().b().type()));
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1826e
    public d.b.c.a.b.d b(d.b.c.a.b.c cVar) throws IOException {
        d.b.c.a.b.a.c.f fVar = this.f65292b;
        fVar.f65248f.t(fVar.f65247e);
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

    @Override // d.b.c.a.b.a.e.InterfaceC1826e
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
        if (this.f65295e == 1) {
            this.f65295e = 2;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.f65295e);
    }

    public q e(s sVar) throws IOException {
        if (this.f65295e == 4) {
            this.f65295e = 5;
            return new d(sVar);
        }
        throw new IllegalStateException("state: " + this.f65295e);
    }

    public void f(h hVar) {
        r j = hVar.j();
        hVar.i(r.f65197d);
        j.g();
        j.f();
    }

    public void g(v vVar, String str) throws IOException {
        if (this.f65295e == 0) {
            this.f65294d.b(str).b(Part.CRLF);
            int a2 = vVar.a();
            for (int i2 = 0; i2 < a2; i2++) {
                this.f65294d.b(vVar.b(i2)).b(": ").b(vVar.e(i2)).b(Part.CRLF);
            }
            this.f65294d.b(Part.CRLF);
            this.f65295e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f65295e);
    }

    public q h(long j) throws IOException {
        if (this.f65295e == 4) {
            this.f65295e = 5;
            return new f(this, j);
        }
        throw new IllegalStateException("state: " + this.f65295e);
    }

    public v i() throws IOException {
        v.a aVar = new v.a();
        while (true) {
            String l = l();
            if (l.length() != 0) {
                d.b.c.a.b.a.b.f65218a.f(aVar, l);
            } else {
                return aVar.c();
            }
        }
    }

    public p j() {
        if (this.f65295e == 1) {
            this.f65295e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f65295e);
    }

    public q k() throws IOException {
        if (this.f65295e == 4) {
            d.b.c.a.b.a.c.f fVar = this.f65292b;
            if (fVar != null) {
                this.f65295e = 5;
                fVar.m();
                return new g(this);
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f65295e);
    }

    public final String l() throws IOException {
        String e2 = this.f65293c.e(this.f65296f);
        this.f65296f -= e2.length();
        return e2;
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1826e
    public void a() throws IOException {
        this.f65294d.flush();
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1826e
    public c.a a(boolean z) throws IOException {
        int i2 = this.f65295e;
        if (i2 != 1 && i2 != 3) {
            throw new IllegalStateException("state: " + this.f65295e);
        }
        try {
            e.m b2 = e.m.b(l());
            c.a aVar = new c.a();
            aVar.g(b2.f65288a);
            aVar.a(b2.f65289b);
            aVar.i(b2.f65290c);
            aVar.f(i());
            if (z && b2.f65289b == 100) {
                return null;
            }
            this.f65295e = 4;
            return aVar;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f65292b);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    @Override // d.b.c.a.b.a.e.InterfaceC1826e
    public void b() throws IOException {
        this.f65294d.flush();
    }
}
