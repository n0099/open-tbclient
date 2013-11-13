package javassist.bytecode;

import com.tencent.mm.sdk.platformtools.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class CodeAttribute extends e implements as {
    private int d;
    private int e;
    private ab g;
    private ArrayList h;

    public CodeAttribute(y yVar, int i, int i2, byte[] bArr, ab abVar) {
        super(yVar, "Code");
        this.d = i;
        this.e = i2;
        this.c = bArr;
        this.g = abVar;
        this.h = new ArrayList();
    }

    private CodeAttribute(y yVar, CodeAttribute codeAttribute, Map map) {
        super(yVar, "Code");
        this.d = codeAttribute.f();
        this.e = codeAttribute.g();
        this.g = codeAttribute.k().a(yVar, map);
        this.h = new ArrayList();
        List l = codeAttribute.l();
        int size = l.size();
        for (int i = 0; i < size; i++) {
            this.h.add(((e) l.get(i)).a(yVar, map));
        }
        this.c = codeAttribute.a(yVar, map, this.g, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CodeAttribute(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, (byte[]) null);
        dataInputStream.readInt();
        this.d = dataInputStream.readUnsignedShort();
        this.e = dataInputStream.readUnsignedShort();
        this.c = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(this.c);
        this.g = new ab(yVar, dataInputStream);
        this.h = new ArrayList();
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        for (int i2 = 0; i2 < readUnsignedShort; i2++) {
            this.h.add(e.a(yVar, dataInputStream));
        }
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        try {
            return new CodeAttribute(yVar, this, map);
        } catch (BadBytecode e) {
            throw new RuntimeCopyException("bad bytecode. fatal?");
        }
    }

    /* loaded from: classes.dex */
    public class RuntimeCopyException extends RuntimeException {
        public RuntimeCopyException(String str) {
            super(str);
        }
    }

    @Override // javassist.bytecode.e
    public int d() {
        return this.c.length + 18 + (this.g.a() * 8) + e.a(this.h);
    }

    @Override // javassist.bytecode.e
    void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeShort(this.b);
        dataOutputStream.writeInt(d() - 6);
        dataOutputStream.writeShort(this.d);
        dataOutputStream.writeShort(this.e);
        dataOutputStream.writeInt(this.c.length);
        dataOutputStream.write(this.c);
        this.g.a(dataOutputStream);
        dataOutputStream.writeShort(this.h.size());
        e.a(this.h, dataOutputStream);
    }

    @Override // javassist.bytecode.e
    public byte[] e() {
        throw new UnsupportedOperationException("CodeAttribute.get()");
    }

    @Override // javassist.bytecode.e
    public void a(byte[] bArr) {
        throw new UnsupportedOperationException("CodeAttribute.set()");
    }

    public String a() {
        return c().a();
    }

    public int f() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public int g() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public int h() {
        return this.c.length;
    }

    public byte[] i() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(byte[] bArr) {
        super.a(bArr);
    }

    public CodeIterator j() {
        return new CodeIterator(this);
    }

    public ab k() {
        return this.g;
    }

    public List l() {
        return this.h;
    }

    public e a(String str) {
        return e.a(this.h, str);
    }

    public void a(StackMapTable stackMapTable) {
        e.b(this.h, "StackMapTable");
        if (stackMapTable != null) {
            this.h.add(stackMapTable);
        }
    }

    public void a(StackMap stackMap) {
        e.b(this.h, "StackMap");
        if (stackMap != null) {
            this.h.add(stackMap);
        }
    }

    private byte[] a(y yVar, Map map, ab abVar, CodeAttribute codeAttribute) {
        int h = h();
        byte[] bArr = new byte[h];
        codeAttribute.c = bArr;
        return k.a(bArr, a(this.c, 0, h, c(), bArr, yVar, map), abVar, codeAttribute);
    }

    private static k a(byte[] bArr, int i, int i2, y yVar, byte[] bArr2, y yVar2, Map map) {
        k kVar;
        k kVar2 = null;
        int i3 = i;
        while (i3 < i2) {
            int a2 = CodeIterator.a(bArr, i3);
            byte b = bArr[i3];
            bArr2[i3] = b;
            switch (b & 255) {
                case 18:
                    int a3 = yVar.a(bArr[i3 + 1] & 255, yVar2, map);
                    if (a3 < 256) {
                        bArr2[i3 + 1] = (byte) a3;
                        kVar = kVar2;
                        break;
                    } else {
                        bArr2[i3] = 0;
                        bArr2[i3 + 1] = 0;
                        kVar = new k();
                        kVar.b = i3;
                        kVar.c = a3;
                        kVar.f2816a = kVar2;
                        break;
                    }
                case 19:
                case 20:
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case 187:
                case 189:
                case 192:
                case 193:
                    a(i3 + 1, bArr, yVar, bArr2, yVar2, map);
                    kVar = kVar2;
                    break;
                case 185:
                    a(i3 + 1, bArr, yVar, bArr2, yVar2, map);
                    bArr2[i3 + 3] = bArr[i3 + 3];
                    bArr2[i3 + 4] = bArr[i3 + 4];
                    kVar = kVar2;
                    break;
                case 186:
                    a(i3 + 1, bArr, yVar, bArr2, yVar2, map);
                    bArr2[i3 + 3] = 0;
                    bArr2[i3 + 4] = 0;
                    kVar = kVar2;
                    break;
                case 197:
                    a(i3 + 1, bArr, yVar, bArr2, yVar2, map);
                    bArr2[i3 + 3] = bArr[i3 + 3];
                    kVar = kVar2;
                    break;
                default:
                    int i4 = i3;
                    while (true) {
                        i4++;
                        if (i4 >= a2) {
                            kVar = kVar2;
                            break;
                        } else {
                            bArr2[i4] = bArr[i4];
                        }
                    }
            }
            i3 = a2;
            kVar2 = kVar;
        }
        return kVar2;
    }

    private static void a(int i, byte[] bArr, y yVar, byte[] bArr2, y yVar2, Map map) {
        int a2 = yVar.a(((bArr[i] & Util.MASK_8BIT) << 8) | (bArr[i + 1] & Util.MASK_8BIT), yVar2, map);
        bArr2[i] = (byte) (a2 >> 8);
        bArr2[i + 1] = (byte) a2;
    }
}
