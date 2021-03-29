package d.c.c.a.b;

import java.io.IOException;
import java.nio.charset.Charset;
/* loaded from: classes5.dex */
public abstract class b0 {

    /* loaded from: classes5.dex */
    public static class a extends b0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ x f65456a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f65457b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ byte[] f65458c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f65459d;

        public a(x xVar, int i, byte[] bArr, int i2) {
            this.f65456a = xVar;
            this.f65457b = i;
            this.f65458c = bArr;
            this.f65459d = i2;
        }

        @Override // d.c.c.a.b.b0
        public x a() {
            return this.f65456a;
        }

        @Override // d.c.c.a.b.b0
        public void e(d.c.c.a.a.d dVar) throws IOException {
            dVar.c(this.f65458c, this.f65459d, this.f65457b);
        }

        @Override // d.c.c.a.b.b0
        public long f() {
            return this.f65457b;
        }
    }

    public static b0 b(x xVar, String str) {
        Charset charset = d.c.c.a.b.a.e.j;
        if (xVar != null && (charset = xVar.b()) == null) {
            charset = d.c.c.a.b.a.e.j;
            xVar = x.a(xVar + "; charset=utf-8");
        }
        return c(xVar, str.getBytes(charset));
    }

    public static b0 c(x xVar, byte[] bArr) {
        return d(xVar, bArr, 0, bArr.length);
    }

    public static b0 d(x xVar, byte[] bArr, int i, int i2) {
        if (bArr != null) {
            d.c.c.a.b.a.e.p(bArr.length, i, i2);
            return new a(xVar, i2, bArr, i);
        }
        throw new NullPointerException("content == null");
    }

    public abstract x a();

    public abstract void e(d.c.c.a.a.d dVar) throws IOException;

    public abstract long f() throws IOException;
}
