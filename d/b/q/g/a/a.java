package d.b.q.g.a;

import java.util.Arrays;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d[] f65359a = {new e(8, 0), new f(0, 1), new f(1, 1), new e(7, 1)};

    public byte[] a(byte[] bArr) {
        c cVar = new c();
        byte[] b2 = b.b(bArr, bArr.length + ((this.f65359a.length + 1) * c.f65360b));
        b.a(b2, cVar.b(), bArr.length);
        int i = 0;
        while (true) {
            d[] dVarArr = this.f65359a;
            if (i >= dVarArr.length) {
                return Arrays.copyOf(cVar.b(), c.f65360b);
            }
            d dVar = dVarArr[i];
            i++;
            int length = bArr.length + (c.f65360b * i);
            cVar.a(dVar.b(b2, 0, length), dVar.a(), dVar.c(), dVar.d());
            b.a(b2, cVar.b(), length);
        }
    }
}
