package d.c.c.a.b;

import java.io.IOException;
import java.nio.charset.Charset;
/* loaded from: classes5.dex */
public abstract class b0 {

    /* loaded from: classes5.dex */
    public static class a extends b0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ x f66301a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f66302b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ byte[] f66303c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f66304d;

        public a(x xVar, int i, byte[] bArr, int i2) {
            this.f66301a = xVar;
            this.f66302b = i;
            this.f66303c = bArr;
            this.f66304d = i2;
        }

        @Override // d.c.c.a.b.b0
        public x a() {
            return this.f66301a;
        }

        @Override // d.c.c.a.b.b0
        public void e(d.c.c.a.a.d dVar) throws IOException {
            dVar.c(this.f66303c, this.f66304d, this.f66302b);
        }

        @Override // d.c.c.a.b.b0
        public long f() {
            return this.f66302b;
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
