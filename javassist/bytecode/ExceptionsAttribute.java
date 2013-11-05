package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class ExceptionsAttribute extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ExceptionsAttribute(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    private ExceptionsAttribute(y yVar, ExceptionsAttribute exceptionsAttribute, Map map) {
        super(yVar, "Exceptions");
        a(exceptionsAttribute, map);
    }

    public ExceptionsAttribute(y yVar) {
        super(yVar, "Exceptions");
        this.c = new byte[]{0, 0};
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        return new ExceptionsAttribute(yVar, this, map);
    }

    private void a(ExceptionsAttribute exceptionsAttribute, Map map) {
        y yVar = exceptionsAttribute.f2763a;
        y yVar2 = this.f2763a;
        byte[] bArr = exceptionsAttribute.c;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        bArr2[0] = bArr[0];
        bArr2[1] = bArr[1];
        for (int i = 2; i < length; i += 2) {
            g.a(yVar.a(g.a(bArr, i), yVar2, map), bArr2, i);
        }
        this.c = bArr2;
    }

    public String[] a() {
        int i = 2;
        byte[] bArr = this.c;
        int length = bArr.length;
        if (length <= 2) {
            return null;
        }
        String[] strArr = new String[(length / 2) - 1];
        int i2 = 0;
        while (i < length) {
            strArr[i2] = this.f2763a.d((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
            i += 2;
            i2++;
        }
        return strArr;
    }

    public void a(String[] strArr) {
        int length = strArr.length;
        byte[] bArr = new byte[(length * 2) + 2];
        g.a(length, bArr, 0);
        for (int i = 0; i < length; i++) {
            g.a(this.f2763a.a(strArr[i]), bArr, (i * 2) + 2);
        }
        this.c = bArr;
    }
}
