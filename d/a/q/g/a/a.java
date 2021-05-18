package d.a.q.g.a;

import java.util.Arrays;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d[] f64315a = {new e(8, 0), new f(0, 1), new f(1, 1), new e(7, 1)};

    public byte[] a(byte[] bArr) {
        c cVar = new c();
        byte[] b2 = b.b(bArr, bArr.length + ((this.f64315a.length + 1) * c.f64316b));
        b.a(b2, cVar.b(), bArr.length);
        int i2 = 0;
        while (true) {
            d[] dVarArr = this.f64315a;
            if (i2 >= dVarArr.length) {
                return Arrays.copyOf(cVar.b(), c.f64316b);
            }
            d dVar = dVarArr[i2];
            i2++;
            int length = bArr.length + (c.f64316b * i2);
            cVar.a(dVar.b(b2, 0, length), dVar.a(), dVar.c(), dVar.d());
            b.a(b2, cVar.b(), length);
        }
    }
}
