package d.b.j.a;

import java.util.Arrays;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public e[] f63627a = {new f(8, 0), new g(0, 1), new g(1, 1), new f(7, 1)};

    public byte[] a(byte[] bArr) {
        d dVar = new d();
        byte[] b2 = b.b(bArr, bArr.length + ((this.f63627a.length + 1) * d.f63628b));
        b.a(b2, dVar.b(), bArr.length);
        int i = 0;
        while (true) {
            e[] eVarArr = this.f63627a;
            if (i >= eVarArr.length) {
                return Arrays.copyOf(dVar.b(), d.f63628b);
            }
            e eVar = eVarArr[i];
            i++;
            int length = bArr.length + (d.f63628b * i);
            dVar.a(eVar.b(b2, 0, length), eVar.a(), eVar.c(), eVar.d());
            b.a(b2, dVar.b(), length);
        }
    }
}
