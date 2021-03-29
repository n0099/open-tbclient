package d.b.q.g.a;

import java.util.Arrays;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d[] f64401a = {new e(8, 0), new f(0, 1), new f(1, 1), new e(7, 1)};

    public byte[] a(byte[] bArr) {
        c cVar = new c();
        byte[] b2 = b.b(bArr, bArr.length + ((this.f64401a.length + 1) * c.f64402b));
        b.a(b2, cVar.b(), bArr.length);
        int i = 0;
        while (true) {
            d[] dVarArr = this.f64401a;
            if (i >= dVarArr.length) {
                return Arrays.copyOf(cVar.b(), c.f64402b);
            }
            d dVar = dVarArr[i];
            i++;
            int length = bArr.length + (c.f64402b * i);
            cVar.a(dVar.b(b2, 0, length), dVar.a(), dVar.c(), dVar.d());
            b.a(b2, cVar.b(), length);
        }
    }
}
