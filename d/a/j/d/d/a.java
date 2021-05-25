package d.a.j.d.d;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public c f40191a;

    public static a a() {
        a aVar = new a();
        c cVar = new c();
        aVar.f40191a = cVar;
        cVar.e("PKCS1Padding");
        return aVar;
    }

    public void b(int i2, d dVar) {
        this.f40191a.a(i2, dVar, b.f40192a);
    }

    public final byte[] c(byte[] bArr) {
        if (bArr != null) {
            return this.f40191a.d(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
