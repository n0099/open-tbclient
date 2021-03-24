package d.b.j.d.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public c f63726a;

    public static a a() {
        a aVar = new a();
        c cVar = new c();
        aVar.f63726a = cVar;
        cVar.e("PKCS1Padding");
        return aVar;
    }

    public void b(int i, d dVar) {
        this.f63726a.a(i, dVar, b.f63727a);
    }

    public final byte[] c(byte[] bArr) {
        if (bArr != null) {
            return this.f63726a.d(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
