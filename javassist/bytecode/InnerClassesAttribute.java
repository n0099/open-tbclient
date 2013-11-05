package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class InnerClassesAttribute extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public InnerClassesAttribute(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    private InnerClassesAttribute(y yVar, byte[] bArr) {
        super(yVar, "InnerClasses", bArr);
    }

    public int a() {
        return g.a(e(), 0);
    }

    public int a(int i) {
        return g.a(e(), (i * 8) + 2);
    }

    public String b(int i) {
        int a2 = a(i);
        if (a2 == 0) {
            return null;
        }
        return this.f2763a.d(a2);
    }

    public int c(int i) {
        return g.a(e(), (i * 8) + 4);
    }

    public String d(int i) {
        int c = c(i);
        if (c == 0) {
            return null;
        }
        return this.f2763a.d(c);
    }

    public int e(int i) {
        return g.a(e(), (i * 8) + 8);
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        byte[] e = e();
        byte[] bArr = new byte[e.length];
        y c = c();
        InnerClassesAttribute innerClassesAttribute = new InnerClassesAttribute(yVar, bArr);
        int a2 = g.a(e, 0);
        g.a(a2, bArr, 0);
        int i = 0;
        int i2 = 2;
        while (i < a2) {
            int a3 = g.a(e, i2);
            int a4 = g.a(e, i2 + 2);
            int a5 = g.a(e, i2 + 4);
            int a6 = g.a(e, i2 + 6);
            if (a3 != 0) {
                a3 = c.a(a3, yVar, map);
            }
            g.a(a3, bArr, i2);
            g.a(a4 != 0 ? c.a(a4, yVar, map) : a4, bArr, i2 + 2);
            g.a(a5 != 0 ? c.a(a5, yVar, map) : a5, bArr, i2 + 4);
            g.a(a6, bArr, i2 + 6);
            i++;
            i2 += 8;
        }
        return innerClassesAttribute;
    }
}
