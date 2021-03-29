package d.b.q.g.b;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.q.g.b.d.a.b f64417a;

    public static a b() {
        a aVar = new a();
        d.b.q.g.b.d.a.b bVar = new d.b.q.g.b.d.a.b();
        aVar.f64417a = bVar;
        bVar.e("PKCS1Padding");
        return aVar;
    }

    public final byte[] a(byte[] bArr) {
        if (bArr != null) {
            return this.f64417a.d(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }

    public void c(int i, d.b.q.g.b.e.a aVar) {
        this.f64417a.a(i, aVar, d.b.q.g.b.d.a.a.f64419a);
    }
}
