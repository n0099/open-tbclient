package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class BootstrapMethodsAttribute extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BootstrapMethodsAttribute(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BootstrapMethodsAttribute(y yVar, f[] fVarArr) {
        super(yVar, "BootstrapMethods");
        int i = 2;
        int i2 = 2;
        for (f fVar : fVarArr) {
            i2 += (fVar.b.length * 2) + 4;
        }
        byte[] bArr = new byte[i2];
        g.a(fVarArr.length, bArr, 0);
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            g.a(fVarArr[i3].f2764a, bArr, i);
            g.a(fVarArr[i3].b.length, bArr, i + 2);
            i += 4;
            for (int i4 : fVarArr[i3].b) {
                g.a(i4, bArr, i);
                i += 2;
            }
        }
        a(bArr);
    }

    public f[] a() {
        byte[] e = e();
        int a2 = g.a(e, 0);
        f[] fVarArr = new f[a2];
        int i = 2;
        for (int i2 = 0; i2 < a2; i2++) {
            int a3 = g.a(e, i);
            int a4 = g.a(e, i + 2);
            int[] iArr = new int[a4];
            i += 4;
            for (int i3 = 0; i3 < a4; i3++) {
                iArr[i3] = g.a(e, i);
                i += 2;
            }
            fVarArr[i2] = new f(a3, iArr);
        }
        return fVarArr;
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        f[] a2 = a();
        y c = c();
        for (f fVar : a2) {
            fVar.f2764a = c.a(fVar.f2764a, yVar, map);
            for (int i = 0; i < fVar.b.length; i++) {
                fVar.b[i] = c.a(fVar.b[i], yVar, map);
            }
        }
        return new BootstrapMethodsAttribute(yVar, a2);
    }
}
