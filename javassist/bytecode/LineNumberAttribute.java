package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class LineNumberAttribute extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LineNumberAttribute(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    private LineNumberAttribute(y yVar, byte[] bArr) {
        super(yVar, "LineNumberTable", bArr);
    }

    public int a() {
        return g.a(this.c, 0);
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        byte[] bArr = this.c;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr2[i] = bArr[i];
        }
        return new LineNumberAttribute(yVar, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, boolean z) {
        int a2 = a();
        for (int i3 = 0; i3 < a2; i3++) {
            int i4 = (i3 * 4) + 2;
            int a3 = g.a(this.c, i4);
            if (a3 > i || (z && a3 == i)) {
                g.a(a3 + i2, this.c, i4);
            }
        }
    }
}
