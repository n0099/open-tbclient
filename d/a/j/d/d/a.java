package d.a.j.d.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public c f43975a;

    public static a a() {
        a aVar = new a();
        c cVar = new c();
        aVar.f43975a = cVar;
        cVar.e("PKCS1Padding");
        return aVar;
    }

    public void b(int i2, d dVar) {
        this.f43975a.a(i2, dVar, b.f43976a);
    }

    public final byte[] c(byte[] bArr) {
        if (bArr != null) {
            return this.f43975a.d(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
