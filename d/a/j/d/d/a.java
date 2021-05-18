package d.a.j.d.d;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public c f48527a;

    public static a a() {
        a aVar = new a();
        c cVar = new c();
        aVar.f48527a = cVar;
        cVar.e("PKCS1Padding");
        return aVar;
    }

    public void b(int i2, d dVar) {
        this.f48527a.a(i2, dVar, b.f48528a);
    }

    public final byte[] c(byte[] bArr) {
        if (bArr != null) {
            return this.f48527a.d(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
