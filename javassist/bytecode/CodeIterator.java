package javassist.bytecode;

import java.util.ArrayList;
import javassist.compiler.ast.MethodDecl;
/* loaded from: classes.dex */
public class CodeIterator implements as {
    private static final int[] g = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 2, 3, 3, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 0, 0, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 5, 5, 3, 2, 3, 1, 1, 3, 3, 1, 1, 0, 4, 3, 3, 5, 5};

    /* renamed from: a  reason: collision with root package name */
    protected CodeAttribute f2731a;
    protected byte[] b;
    protected int c;
    protected int d;
    protected int e;

    /* JADX INFO: Access modifiers changed from: protected */
    public CodeIterator(CodeAttribute codeAttribute) {
        this.f2731a = codeAttribute;
        this.b = codeAttribute.i();
        a();
    }

    public void a() {
        this.e = 0;
        this.d = 0;
        this.c = d();
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(int i) {
        this.e = i;
    }

    public int b() {
        return this.e;
    }

    public CodeAttribute c() {
        return this.f2731a;
    }

    public int d() {
        return this.b.length;
    }

    public int c(int i) {
        return this.b[i] & 255;
    }

    public void a(int i, int i2) {
        this.b[i2] = (byte) i;
    }

    public int d(int i) {
        return g.a(this.b, i);
    }

    public int e(int i) {
        return g.b(this.b, i);
    }

    public void b(int i, int i2) {
        g.a(i, this.b, i2);
    }

    public int f(int i) {
        return g.c(this.b, i);
    }

    public boolean e() {
        return this.d < this.c;
    }

    public int f() {
        int i = this.d;
        this.d = a(this.b, i);
        return i;
    }

    public int g() {
        return this.d;
    }

    public int h() {
        return h(0);
    }

    public int i() {
        return h(1);
    }

    private int h(int i) {
        a();
        y c = this.f2731a.c();
        String a2 = this.f2731a.a();
        int i2 = 0;
        while (true) {
            if (!e()) {
                break;
            }
            int f = f();
            int c2 = c(f);
            if (c2 == 187) {
                i2++;
            } else if (c2 == 183) {
                int a3 = g.a(this.b, f + 1);
                if (c.n(a3).equals(MethodDecl.initName) && i2 - 1 < 0) {
                    if (i < 0) {
                        return f;
                    }
                    if (c.l(a3).equals(a2) == (i > 0)) {
                        return f;
                    }
                }
            } else {
                continue;
            }
        }
        a();
        return -1;
    }

    public int a(byte[] bArr) {
        return a(this.d, bArr, false);
    }

    public int b(byte[] bArr) {
        return a(this.d, bArr, true);
    }

    private int a(int i, byte[] bArr, boolean z) {
        int length = bArr.length;
        if (length > 0) {
            i = a(i, length, z).f2802a;
            int i2 = 0;
            int i3 = i;
            while (i2 < length) {
                this.b[i3] = bArr[i2];
                i2++;
                i3++;
            }
        }
        return i;
    }

    public int g(int i) {
        return a(this.d, i, false).f2802a;
    }

    public n a(int i, int i2, boolean z) {
        byte[] a2;
        n nVar = new n();
        if (i2 <= 0) {
            nVar.f2802a = i;
            nVar.b = 0;
        } else {
            if (this.b.length + i2 > 32767) {
                a2 = a(this.b, i, i2, z, c().k(), this.f2731a, nVar);
                i = nVar.f2802a;
            } else {
                int i3 = this.d;
                a2 = a(this.b, i, i2, z, c().k(), this.f2731a);
                i2 = a2.length - this.b.length;
                nVar.f2802a = i;
                nVar.b = i2;
                if (i3 >= i) {
                    this.d = i3 + i2;
                }
                if (this.e > i || (this.e == i && z)) {
                    this.e += i2;
                }
            }
            this.f2731a.b(a2);
            this.b = a2;
            this.c = d();
            c(i, i2);
        }
        return nVar;
    }

    protected void c(int i, int i2) {
    }

    public void a(ab abVar, int i) {
        this.f2731a.k().a(0, abVar, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i) {
        int i2;
        try {
            int i3 = bArr[i] & 255;
            try {
                i2 = g[i3];
            } catch (IndexOutOfBoundsException e) {
            }
            if (i2 > 0) {
                return i + i2;
            }
            if (i3 == 196) {
                if (bArr[i + 1] == -124) {
                    return i + 6;
                }
                return i + 4;
            }
            int i4 = (i & (-4)) + 8;
            if (i3 == 171) {
                return (g.c(bArr, i4) * 8) + i4 + 4;
            }
            if (i3 == 170) {
                return (((g.c(bArr, i4 + 4) - g.c(bArr, i4)) + 1) * 4) + i4 + 8;
            }
            throw new BadBytecode(i3);
        } catch (IndexOutOfBoundsException e2) {
            throw new BadBytecode("invalid opcode address");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class AlignmentException extends Exception {
        AlignmentException() {
        }
    }

    static byte[] a(byte[] bArr, int i, int i2, boolean z, ab abVar, CodeAttribute codeAttribute) {
        if (i2 > 0) {
            try {
                return b(bArr, i, i2, z, abVar, codeAttribute);
            } catch (AlignmentException e) {
                try {
                    return b(bArr, i, (i2 + 3) & (-4), z, abVar, codeAttribute);
                } catch (AlignmentException e2) {
                    throw new RuntimeException("fatal error?");
                }
            }
        }
        return bArr;
    }

    private static byte[] b(byte[] bArr, int i, int i2, boolean z, ab abVar, CodeAttribute codeAttribute) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length + i2];
        a(bArr, i, i2, length, bArr2, z);
        abVar.a(i, i2, z);
        LineNumberAttribute lineNumberAttribute = (LineNumberAttribute) codeAttribute.a("LineNumberTable");
        if (lineNumberAttribute != null) {
            lineNumberAttribute.a(i, i2, z);
        }
        LocalVariableAttribute localVariableAttribute = (LocalVariableAttribute) codeAttribute.a("LocalVariableTable");
        if (localVariableAttribute != null) {
            localVariableAttribute.a(i, i2, z);
        }
        LocalVariableAttribute localVariableAttribute2 = (LocalVariableAttribute) codeAttribute.a("LocalVariableTypeTable");
        if (localVariableAttribute2 != null) {
            localVariableAttribute2.a(i, i2, z);
        }
        StackMapTable stackMapTable = (StackMapTable) codeAttribute.a("StackMapTable");
        if (stackMapTable != null) {
            stackMapTable.a(i, i2, z);
        }
        StackMap stackMap = (StackMap) codeAttribute.a("StackMap");
        if (stackMap != null) {
            stackMap.a(i, i2, z);
        }
        return bArr2;
    }

    private static void a(byte[] bArr, int i, int i2, int i3, byte[] bArr2, boolean z) {
        int i4 = 0;
        int i5 = 0;
        while (i5 < i3) {
            if (i5 == i) {
                int i6 = i4 + i2;
                while (i4 < i6) {
                    bArr2[i4] = 0;
                    i4++;
                }
            }
            int a2 = a(bArr, i5);
            int i7 = bArr[i5] & 255;
            if ((153 <= i7 && i7 <= 168) || i7 == 198 || i7 == 199) {
                int a3 = a(i5, (bArr[i5 + 1] << 8) | (bArr[i5 + 2] & 255), i, i2, z);
                bArr2[i4] = bArr[i5];
                g.a(a3, bArr2, i4 + 1);
                i4 += 3;
            } else if (i7 == 200 || i7 == 201) {
                int a4 = a(i5, g.c(bArr, i5 + 1), i, i2, z);
                int i8 = i4 + 1;
                bArr2[i4] = bArr[i5];
                g.b(a4, bArr2, i8);
                i4 = i8 + 4;
            } else if (i7 == 170) {
                if (i5 != i4 && (i2 & 3) != 0) {
                    throw new AlignmentException();
                }
                int i9 = (i5 & (-4)) + 4;
                int a5 = a(bArr2, i4, bArr, i5, i9);
                g.b(a(i5, g.c(bArr, i9), i, i2, z), bArr2, a5);
                int c = g.c(bArr, i9 + 4);
                g.b(c, bArr2, a5 + 4);
                int c2 = g.c(bArr, i9 + 8);
                g.b(c2, bArr2, a5 + 8);
                int i10 = a5 + 12;
                int i11 = i9 + 12;
                int i12 = i11 + (((c2 - c) + 1) * 4);
                i4 = i10;
                int i13 = i11;
                while (i13 < i12) {
                    g.b(a(i5, g.c(bArr, i13), i, i2, z), bArr2, i4);
                    i13 += 4;
                    i4 += 4;
                }
            } else if (i7 == 171) {
                if (i5 != i4 && (i2 & 3) != 0) {
                    throw new AlignmentException();
                }
                int i14 = (i5 & (-4)) + 4;
                int a6 = a(bArr2, i4, bArr, i5, i14);
                g.b(a(i5, g.c(bArr, i14), i, i2, z), bArr2, a6);
                int c3 = g.c(bArr, i14 + 4);
                g.b(c3, bArr2, a6 + 4);
                int i15 = a6 + 8;
                int i16 = i14 + 8;
                int i17 = i16 + (c3 * 8);
                i4 = i15;
                int i18 = i16;
                while (i18 < i17) {
                    g.a(bArr, i18, bArr2, i4);
                    g.b(a(i5, g.c(bArr, i18 + 4), i, i2, z), bArr2, i4 + 4);
                    i18 += 8;
                    i4 += 8;
                }
            } else {
                for (int i19 = i5; i19 < a2; i19++) {
                    bArr2[i4] = bArr[i19];
                    i4++;
                }
            }
            i5 = a2;
        }
    }

    private static int a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        switch (i3 - i2) {
            case 1:
                break;
            case 4:
                bArr[i] = bArr2[i2];
                i2++;
                i++;
            case 3:
                bArr[i] = bArr2[i2];
                i2++;
                i++;
            case 2:
                bArr[i] = bArr2[i2];
                i2++;
                i++;
                break;
            default:
                return i;
        }
        int i4 = i + 1;
        int i5 = i2 + 1;
        bArr[i] = bArr2[i2];
        return i4;
    }

    private static int a(int i, int i2, int i3, int i4, boolean z) {
        int i5 = i + i2;
        if (i < i3) {
            if (i3 < i5 || (z && i3 == i5)) {
                return i2 + i4;
            }
            return i2;
        } else if (i == i3) {
            if (i5 < i3) {
                return i2 - i4;
            }
            return i2;
        } else if (i5 < i3 || (!z && i3 == i5)) {
            return i2 - i4;
        } else {
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(byte[] bArr, ab abVar, CodeAttribute codeAttribute, k kVar) {
        t tVar = new t(0, 0, 0, abVar, codeAttribute);
        ArrayList a2 = a(bArr, bArr.length, tVar);
        while (kVar != null) {
            a(kVar, a2);
            kVar = kVar.f2800a;
        }
        return a(bArr, 0, 0, false, a2, tVar);
    }

    private static void a(k kVar, ArrayList arrayList) {
        int i = kVar.b;
        r rVar = new r(i, kVar.c);
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i < ((l) arrayList.get(i2)).b) {
                arrayList.add(i2, rVar);
                return;
            }
        }
        arrayList.add(rVar);
    }

    private byte[] a(byte[] bArr, int i, int i2, boolean z, ab abVar, CodeAttribute codeAttribute, n nVar) {
        if (i2 > 0) {
            t tVar = new t(this.d, this.e, i, abVar, codeAttribute);
            bArr = a(bArr, i, i2, z, a(bArr, bArr.length, tVar), tVar);
            this.d = tVar.f2814a;
            this.e = tVar.c;
            int i3 = tVar.b;
            if (i3 == this.d && !z) {
                this.d += i2;
            }
            if (z) {
                i3 -= i2;
            }
            nVar.f2802a = i3;
            nVar.b = i2;
        }
        return bArr;
    }

    private static byte[] a(byte[] bArr, int i, int i2, boolean z, ArrayList arrayList, t tVar) {
        boolean z2;
        boolean z3;
        int size = arrayList.size();
        if (i2 > 0) {
            tVar.a(i, i2, z);
            for (int i3 = 0; i3 < size; i3++) {
                ((l) arrayList.get(i3)).a(i, i2, z);
            }
        }
        boolean z4 = true;
        while (true) {
            if (z4) {
                int i4 = 0;
                z4 = false;
                while (i4 < size) {
                    l lVar = (l) arrayList.get(i4);
                    if (lVar.a()) {
                        int i5 = lVar.f2801a;
                        int c = lVar.c();
                        tVar.a(i5, c, false);
                        for (int i6 = 0; i6 < size; i6++) {
                            ((l) arrayList.get(i6)).a(i5, c, false);
                        }
                        z2 = true;
                    } else {
                        z2 = z4;
                    }
                    i4++;
                    z4 = z2;
                }
            } else {
                int i7 = 0;
                while (i7 < size) {
                    l lVar2 = (l) arrayList.get(i7);
                    int b = lVar2.b();
                    if (b > 0) {
                        int i8 = lVar2.f2801a;
                        tVar.a(i8, b, false);
                        for (int i9 = 0; i9 < size; i9++) {
                            ((l) arrayList.get(i9)).a(i8, b, false);
                        }
                        z3 = true;
                    } else {
                        z3 = z4;
                    }
                    i7++;
                    z4 = z3;
                }
                if (!z4) {
                    return a(bArr, arrayList, i, i2);
                }
            }
        }
    }

    private static ArrayList a(byte[] bArr, int i, t tVar) {
        l pVar;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            int a2 = a(bArr, i2);
            int i3 = bArr[i2] & 255;
            if ((153 <= i3 && i3 <= 168) || i3 == 198 || i3 == 199) {
                int i4 = (bArr[i2 + 1] << 8) | (bArr[i2 + 2] & 255);
                if (i3 == 167 || i3 == 168) {
                    pVar = new p(i2, i4);
                } else {
                    pVar = new o(i2, i4);
                }
                arrayList.add(pVar);
            } else if (i3 == 200 || i3 == 201) {
                arrayList.add(new q(i2, g.c(bArr, i2 + 1)));
            } else if (i3 == 170) {
                int i5 = (i2 & (-4)) + 4;
                int c = g.c(bArr, i5);
                int c2 = g.c(bArr, i5 + 4);
                int c3 = g.c(bArr, i5 + 8);
                int i6 = (c3 - c2) + 1;
                int[] iArr = new int[i6];
                int i7 = i5 + 12;
                for (int i8 = 0; i8 < i6; i8++) {
                    iArr[i8] = g.c(bArr, i7);
                    i7 += 4;
                }
                arrayList.add(new v(i2, c, c2, c3, iArr, tVar));
            } else if (i3 == 171) {
                int i9 = (i2 & (-4)) + 4;
                int c4 = g.c(bArr, i9);
                int c5 = g.c(bArr, i9 + 4);
                int[] iArr2 = new int[c5];
                int[] iArr3 = new int[c5];
                int i10 = i9 + 8;
                for (int i11 = 0; i11 < c5; i11++) {
                    iArr2[i11] = g.c(bArr, i10);
                    iArr3[i11] = g.c(bArr, i10 + 4);
                    i10 += 8;
                }
                arrayList.add(new s(i2, c4, iArr2, iArr3, tVar));
            }
            i2 = a2;
        }
        return arrayList;
    }

    private static byte[] a(byte[] bArr, ArrayList arrayList, int i, int i2) {
        int i3;
        int i4;
        int i5;
        l lVar;
        int i6;
        l lVar2;
        int i7;
        int size = arrayList.size();
        int length = bArr.length + i2;
        for (int i8 = 0; i8 < size; i8++) {
            length += ((l) arrayList.get(i8)).c();
        }
        byte[] bArr2 = new byte[length];
        int length2 = bArr.length;
        if (size <= 0) {
            i3 = 0;
            i4 = 0;
            i5 = length2;
            lVar = null;
            i6 = 0;
        } else {
            l lVar3 = (l) arrayList.get(0);
            i3 = 0;
            i4 = 0;
            i5 = lVar3.b;
            lVar = lVar3;
            i6 = 0;
        }
        while (i3 < length2) {
            if (i3 == i) {
                int i9 = i6 + i2;
                while (i6 < i9) {
                    bArr2[i6] = 0;
                    i6++;
                }
            }
            if (i3 != i5) {
                bArr2[i6] = bArr[i3];
                i6++;
                i3++;
            } else {
                int a2 = lVar.a(i3, bArr, i6, bArr2);
                i3 += a2;
                int c = i6 + a2 + lVar.c();
                int i10 = i4 + 1;
                if (i10 < size) {
                    l lVar4 = (l) arrayList.get(i10);
                    lVar2 = lVar4;
                    i7 = lVar4.b;
                } else {
                    lVar2 = null;
                    i7 = length2;
                }
                i4 = i10;
                i5 = i7;
                i6 = c;
                lVar = lVar2;
            }
        }
        return bArr2;
    }
}
