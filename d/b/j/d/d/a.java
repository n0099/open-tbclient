package d.b.j.d.d;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public c f52622a;

    public static a a() {
        a aVar = new a();
        c cVar = new c();
        aVar.f52622a = cVar;
        cVar.e("PKCS1Padding");
        return aVar;
    }

    public void b(int i, d dVar) {
        this.f52622a.a(i, dVar, b.f52623a);
    }

    public final byte[] c(byte[] bArr) {
        if (bArr != null) {
            return this.f52622a.d(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
