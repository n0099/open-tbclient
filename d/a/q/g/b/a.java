package d.a.q.g.b;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.q.g.b.d.a.b f63694a;

    public static a b() {
        a aVar = new a();
        d.a.q.g.b.d.a.b bVar = new d.a.q.g.b.d.a.b();
        aVar.f63694a = bVar;
        bVar.e("PKCS1Padding");
        return aVar;
    }

    public final byte[] a(byte[] bArr) {
        if (bArr != null) {
            return this.f63694a.d(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }

    public void c(int i2, d.a.q.g.b.e.a aVar) {
        this.f63694a.a(i2, aVar, d.a.q.g.b.d.a.a.f63696a);
    }
}
