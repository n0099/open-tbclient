package d.a.j.d.d;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public c f50306a;

    public static a a() {
        a aVar = new a();
        c cVar = new c();
        aVar.f50306a = cVar;
        cVar.e("PKCS1Padding");
        return aVar;
    }

    public void b(int i2, d dVar) {
        this.f50306a.a(i2, dVar, b.f50307a);
    }

    public final byte[] c(byte[] bArr) {
        if (bArr != null) {
            return this.f50306a.d(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
