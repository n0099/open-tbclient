package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class ParameterAnnotationsAttribute extends e {
    public ParameterAnnotationsAttribute(y yVar, String str, byte[] bArr) {
        super(yVar, str, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParameterAnnotationsAttribute(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        b bVar = new b(this.c, this.f2763a, yVar, map);
        try {
            bVar.d();
            return new ParameterAnnotationsAttribute(yVar, b(), bVar.a());
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    public javassist.bytecode.annotation.a[][] a() {
        try {
            return new c(this.c, this.f2763a).a();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    public String toString() {
        javassist.bytecode.annotation.a[][] a2 = a();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < a2.length) {
            int i2 = i + 1;
            javassist.bytecode.annotation.a[] aVarArr = a2[i];
            int i3 = 0;
            while (i3 < aVarArr.length) {
                int i4 = i3 + 1;
                sb.append(aVarArr[i3].toString());
                if (i4 != aVarArr.length) {
                    sb.append(" ");
                    i3 = i4;
                } else {
                    i3 = i4;
                }
            }
            if (i2 != a2.length) {
                sb.append(", ");
            }
            i = i2;
        }
        return sb.toString();
    }
}
