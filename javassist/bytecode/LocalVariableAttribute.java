package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class LocalVariableAttribute extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalVariableAttribute(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalVariableAttribute(y yVar, String str, byte[] bArr) {
        super(yVar, str, bArr);
    }

    public int a() {
        return g.a(this.c, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, boolean z) {
        int a2 = a();
        for (int i3 = 0; i3 < a2; i3++) {
            int i4 = (i3 * 10) + 2;
            int a3 = g.a(this.c, i4);
            int a4 = g.a(this.c, i4 + 2);
            if (a3 > i || (z && a3 == i && a3 != 0)) {
                g.a(a3 + i2, this.c, i4);
            } else if (a3 + a4 > i || (z && a3 + a4 == i)) {
                g.a(a4 + i2, this.c, i4 + 2);
            }
        }
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        byte[] e = e();
        byte[] bArr = new byte[e.length];
        y c = c();
        LocalVariableAttribute a2 = a(yVar, bArr);
        int a3 = g.a(e, 0);
        g.a(a3, bArr, 0);
        int i = 0;
        int i2 = 2;
        while (i < a3) {
            int a4 = g.a(e, i2);
            int a5 = g.a(e, i2 + 2);
            int a6 = g.a(e, i2 + 4);
            int a7 = g.a(e, i2 + 6);
            int a8 = g.a(e, i2 + 8);
            g.a(a4, bArr, i2);
            g.a(a5, bArr, i2 + 2);
            if (a6 != 0) {
                a6 = c.a(a6, yVar, (Map) null);
            }
            g.a(a6, bArr, i2 + 4);
            g.a(a7 != 0 ? yVar.c(z.a(c.w(a7), map)) : a7, bArr, i2 + 6);
            g.a(a8, bArr, i2 + 8);
            i++;
            i2 += 10;
        }
        return a2;
    }

    LocalVariableAttribute a(y yVar, byte[] bArr) {
        return new LocalVariableAttribute(yVar, "LocalVariableTable", bArr);
    }
}
