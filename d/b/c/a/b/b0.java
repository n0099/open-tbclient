package d.b.c.a.b;

import java.io.IOException;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public abstract class b0 {

    /* loaded from: classes6.dex */
    public static class a extends b0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ x f69242a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f69243b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ byte[] f69244c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f69245d;

        public a(x xVar, int i2, byte[] bArr, int i3) {
            this.f69242a = xVar;
            this.f69243b = i2;
            this.f69244c = bArr;
            this.f69245d = i3;
        }

        @Override // d.b.c.a.b.b0
        public x a() {
            return this.f69242a;
        }

        @Override // d.b.c.a.b.b0
        public void e(d.b.c.a.a.d dVar) throws IOException {
            dVar.c(this.f69244c, this.f69245d, this.f69243b);
        }

        @Override // d.b.c.a.b.b0
        public long f() {
            return this.f69243b;
        }
    }

    public static b0 b(x xVar, String str) {
        Charset charset = d.b.c.a.b.a.e.j;
        if (xVar != null && (charset = xVar.b()) == null) {
            charset = d.b.c.a.b.a.e.j;
            xVar = x.a(xVar + "; charset=utf-8");
        }
        return c(xVar, str.getBytes(charset));
    }

    public static b0 c(x xVar, byte[] bArr) {
        return d(xVar, bArr, 0, bArr.length);
    }

    public static b0 d(x xVar, byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            d.b.c.a.b.a.e.p(bArr.length, i2, i3);
            return new a(xVar, i3, bArr, i2);
        }
        throw new NullPointerException("content == null");
    }

    public abstract x a();

    public abstract void e(d.b.c.a.a.d dVar) throws IOException;

    public abstract long f() throws IOException;
}
