package d.b.j.d.d;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public c f64427a;

    public static a a() {
        a aVar = new a();
        c cVar = new c();
        aVar.f64427a = cVar;
        cVar.e("PKCS1Padding");
        return aVar;
    }

    public void b(int i, d dVar) {
        this.f64427a.a(i, dVar, b.f64428a);
    }

    public final byte[] c(byte[] bArr) {
        if (bArr != null) {
            return this.f64427a.d(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
