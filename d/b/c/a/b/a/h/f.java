package d.b.c.a.b.a.h;

import d.b.c.a.a.q;
import d.b.c.a.a.r;
import d.b.c.a.b.a.h.b;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes5.dex */
public final class f implements Closeable {

    /* renamed from: i  reason: collision with root package name */
    public static final Logger f64670i = Logger.getLogger(c.class.getName());

    /* renamed from: e  reason: collision with root package name */
    public final d.b.c.a.a.e f64671e;

    /* renamed from: f  reason: collision with root package name */
    public final a f64672f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f64673g;

    /* renamed from: h  reason: collision with root package name */
    public final b.a f64674h;

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void a(int i2, long j);

        void a(int i2, com.bytedance.sdk.a.b.a.e.b bVar);

        void b(boolean z, int i2, int i3);

        void c(int i2, int i3, List<d.b.c.a.b.a.h.a> list) throws IOException;

        void d(boolean z, int i2, int i3, List<d.b.c.a.b.a.h.a> list);

        void e(int i2, int i3, int i4, boolean z);

        void f(int i2, com.bytedance.sdk.a.b.a.e.b bVar, com.bytedance.sdk.a.a.f fVar);

        void g(boolean z, int i2, d.b.c.a.a.e eVar, int i3) throws IOException;

        void h(boolean z, l lVar);
    }

    public f(d.b.c.a.a.e eVar, boolean z) {
        this.f64671e = eVar;
        this.f64673g = z;
        a aVar = new a(eVar);
        this.f64672f = aVar;
        this.f64674h = new b.a(4096, aVar);
    }

    public static int c(int i2, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        c.d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
        throw null;
    }

    public static int d(d.b.c.a.a.e eVar) throws IOException {
        return (eVar.h() & 255) | ((eVar.h() & 255) << 16) | ((eVar.h() & 255) << 8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f64671e.close();
    }

    public final List<d.b.c.a.b.a.h.a> e(int i2, short s, byte b2, int i3) throws IOException {
        a aVar = this.f64672f;
        aVar.f64679i = i2;
        aVar.f64676f = i2;
        aVar.j = s;
        aVar.f64677g = b2;
        aVar.f64678h = i3;
        this.f64674h.c();
        return this.f64674h.e();
    }

    public void l(b bVar) throws IOException {
        if (this.f64673g) {
            if (o(true, bVar)) {
                return;
            }
            c.d("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        com.bytedance.sdk.a.a.f c2 = this.f64671e.c(c.f64610a.g());
        if (f64670i.isLoggable(Level.FINE)) {
            f64670i.fine(d.b.c.a.b.a.e.j("<< CONNECTION %s", c2.e()));
        }
        if (c.f64610a.equals(c2)) {
            return;
        }
        c.d("Expected a connection header but was %s", c2.a());
        throw null;
    }

    public final void m(b bVar, int i2) throws IOException {
        int j = this.f64671e.j();
        bVar.e(i2, j & Integer.MAX_VALUE, (this.f64671e.h() & 255) + 1, (Integer.MIN_VALUE & j) != 0);
    }

    public final void n(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 != 0) {
            boolean z = (b2 & 1) != 0;
            short h2 = (b2 & 8) != 0 ? (short) (this.f64671e.h() & 255) : (short) 0;
            if ((b2 & 32) != 0) {
                m(bVar, i3);
                i2 -= 5;
            }
            bVar.d(z, i3, -1, e(c(i2, b2, h2), h2, b2, i3));
            return;
        }
        c.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    }

    public boolean o(boolean z, b bVar) throws IOException {
        try {
            this.f64671e.a(9L);
            int d2 = d(this.f64671e);
            if (d2 < 0 || d2 > 16384) {
                c.d("FRAME_SIZE_ERROR: %s", Integer.valueOf(d2));
                throw null;
            }
            byte h2 = (byte) (this.f64671e.h() & 255);
            if (z && h2 != 4) {
                c.d("Expected a SETTINGS frame but was %s", Byte.valueOf(h2));
                throw null;
            }
            byte h3 = (byte) (this.f64671e.h() & 255);
            int j = this.f64671e.j() & Integer.MAX_VALUE;
            if (f64670i.isLoggable(Level.FINE)) {
                f64670i.fine(c.c(true, j, d2, h2, h3));
            }
            switch (h2) {
                case 0:
                    p(bVar, d2, h3, j);
                    break;
                case 1:
                    n(bVar, d2, h3, j);
                    break;
                case 2:
                    q(bVar, d2, h3, j);
                    break;
                case 3:
                    r(bVar, d2, h3, j);
                    break;
                case 4:
                    s(bVar, d2, h3, j);
                    break;
                case 5:
                    t(bVar, d2, h3, j);
                    break;
                case 6:
                    u(bVar, d2, h3, j);
                    break;
                case 7:
                    v(bVar, d2, h3, j);
                    break;
                case 8:
                    w(bVar, d2, h3, j);
                    break;
                default:
                    this.f64671e.g(d2);
                    break;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public final void p(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 == 0) {
            c.d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b2 & 1) != 0;
        if (!((b2 & 32) != 0)) {
            short h2 = (b2 & 8) != 0 ? (short) (this.f64671e.h() & 255) : (short) 0;
            bVar.g(z, i3, this.f64671e, c(i2, b2, h2));
            this.f64671e.g(h2);
            return;
        }
        c.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        throw null;
    }

    public final void q(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 5) {
            c.d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
            throw null;
        } else if (i3 != 0) {
            m(bVar, i3);
        } else {
            c.d("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    public final void r(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 4) {
            c.d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
            throw null;
        } else if (i3 != 0) {
            int j = this.f64671e.j();
            com.bytedance.sdk.a.b.a.e.b a2 = com.bytedance.sdk.a.b.a.e.b.a(j);
            if (a2 != null) {
                bVar.a(i3, a2);
            } else {
                c.d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(j));
                throw null;
            }
        } else {
            c.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
    }

    public final void s(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 != 0) {
            c.d("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        } else if ((b2 & 1) != 0) {
            if (i2 == 0) {
                bVar.a();
            } else {
                c.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        } else if (i2 % 6 != 0) {
            c.d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
            throw null;
        } else {
            l lVar = new l();
            for (int i4 = 0; i4 < i2; i4 += 6) {
                short i5 = this.f64671e.i();
                int j = this.f64671e.j();
                if (i5 != 2) {
                    if (i5 == 3) {
                        i5 = 4;
                    } else if (i5 == 4) {
                        i5 = 7;
                        if (j < 0) {
                            c.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            throw null;
                        }
                    } else if (i5 == 5 && (j < 16384 || j > 16777215)) {
                        c.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(j));
                        throw null;
                    }
                } else if (j != 0 && j != 1) {
                    c.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    throw null;
                }
                lVar.a(i5, j);
            }
            bVar.h(false, lVar);
        }
    }

    public final void t(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 != 0) {
            short h2 = (b2 & 8) != 0 ? (short) (this.f64671e.h() & 255) : (short) 0;
            bVar.c(i3, this.f64671e.j() & Integer.MAX_VALUE, e(c(i2 - 4, b2, h2), h2, b2, i3));
            return;
        }
        c.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        throw null;
    }

    public final void u(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 8) {
            c.d("TYPE_PING length != 8: %s", Integer.valueOf(i2));
            throw null;
        } else if (i3 == 0) {
            bVar.b((b2 & 1) != 0, this.f64671e.j(), this.f64671e.j());
        } else {
            c.d("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
    }

    public final void v(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 < 8) {
            c.d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
            throw null;
        } else if (i3 == 0) {
            int j = this.f64671e.j();
            int j2 = this.f64671e.j();
            int i4 = i2 - 8;
            com.bytedance.sdk.a.b.a.e.b a2 = com.bytedance.sdk.a.b.a.e.b.a(j2);
            if (a2 == null) {
                c.d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(j2));
                throw null;
            }
            com.bytedance.sdk.a.a.f fVar = com.bytedance.sdk.a.a.f.f27669b;
            if (i4 > 0) {
                fVar = this.f64671e.c(i4);
            }
            bVar.f(j, a2, fVar);
        } else {
            c.d("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
    }

    public final void w(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 4) {
            c.d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
            throw null;
        }
        long j = this.f64671e.j() & 2147483647L;
        if (j != 0) {
            bVar.a(i3, j);
        } else {
            c.d("windowSizeIncrement was 0", Long.valueOf(j));
            throw null;
        }
    }

    /* loaded from: classes5.dex */
    public static final class a implements q {

        /* renamed from: e  reason: collision with root package name */
        public final d.b.c.a.a.e f64675e;

        /* renamed from: f  reason: collision with root package name */
        public int f64676f;

        /* renamed from: g  reason: collision with root package name */
        public byte f64677g;

        /* renamed from: h  reason: collision with root package name */
        public int f64678h;

        /* renamed from: i  reason: collision with root package name */
        public int f64679i;
        public short j;

        public a(d.b.c.a.a.e eVar) {
            this.f64675e = eVar;
        }

        @Override // d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            while (true) {
                int i2 = this.f64679i;
                if (i2 == 0) {
                    this.f64675e.g(this.j);
                    this.j = (short) 0;
                    if ((this.f64677g & 4) != 0) {
                        return -1L;
                    }
                    n();
                } else {
                    long a2 = this.f64675e.a(cVar, Math.min(j, i2));
                    if (a2 == -1) {
                        return -1L;
                    }
                    this.f64679i = (int) (this.f64679i - a2);
                    return a2;
                }
            }
        }

        @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public final void n() throws IOException {
            int i2 = this.f64678h;
            int d2 = f.d(this.f64675e);
            this.f64679i = d2;
            this.f64676f = d2;
            byte h2 = (byte) (this.f64675e.h() & 255);
            this.f64677g = (byte) (this.f64675e.h() & 255);
            if (f.f64670i.isLoggable(Level.FINE)) {
                f.f64670i.fine(c.c(true, this.f64678h, this.f64676f, h2, this.f64677g));
            }
            int j = this.f64675e.j() & Integer.MAX_VALUE;
            this.f64678h = j;
            if (h2 != 9) {
                c.d("%s != TYPE_CONTINUATION", Byte.valueOf(h2));
                throw null;
            } else if (j == i2) {
            } else {
                c.d("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
        }

        @Override // d.b.c.a.a.q
        public r a() {
            return this.f64675e.a();
        }
    }
}
