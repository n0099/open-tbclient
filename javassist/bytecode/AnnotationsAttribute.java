package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class AnnotationsAttribute extends e {
    public AnnotationsAttribute(y yVar, String str, byte[] bArr) {
        super(yVar, str, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnnotationsAttribute(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        b bVar = new b(this.c, this.f2811a, yVar, map);
        try {
            bVar.e();
            return new AnnotationsAttribute(yVar, b(), bVar.a());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public javassist.bytecode.annotation.a[] a() {
        try {
            return new c(this.c, this.f2811a).b();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        javassist.bytecode.annotation.a[] a2 = a();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < a2.length) {
            int i2 = i + 1;
            sb.append(a2[i].toString());
            if (i2 != a2.length) {
                sb.append(", ");
                i = i2;
            } else {
                i = i2;
            }
        }
        return sb.toString();
    }
}
