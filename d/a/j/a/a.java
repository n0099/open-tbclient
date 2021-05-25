package d.a.j.a;

import java.util.Arrays;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public e[] f40089a = {new f(8, 0), new g(0, 1), new g(1, 1), new f(7, 1)};

    public byte[] a(byte[] bArr) {
        d dVar = new d();
        byte[] b2 = b.b(bArr, bArr.length + ((this.f40089a.length + 1) * d.f40090b));
        b.a(b2, dVar.b(), bArr.length);
        int i2 = 0;
        while (true) {
            e[] eVarArr = this.f40089a;
            if (i2 >= eVarArr.length) {
                return Arrays.copyOf(dVar.b(), d.f40090b);
            }
            e eVar = eVarArr[i2];
            i2++;
            int length = bArr.length + (d.f40090b * i2);
            dVar.a(eVar.b(b2, 0, length), eVar.a(), eVar.c(), eVar.d());
            b.a(b2, dVar.b(), length);
        }
    }
}
