package javassist.bytecode;

import java.util.Map;
/* loaded from: classes.dex */
class be extends bi {

    /* renamed from: a  reason: collision with root package name */
    private y f2967a;
    private y b;
    private Map c;

    public be(y yVar, byte[] bArr, y yVar2, Map map) {
        super(bArr);
        this.f2967a = yVar;
        this.b = yVar2;
        this.c = map;
    }

    @Override // javassist.bytecode.bi
    protected int a(int i, int i2) {
        if (i == 7) {
            return this.f2967a.a(i2, this.b, this.c);
        }
        return i2;
    }

    @Override // javassist.bytecode.bi
    protected int[] a(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[iArr2.length];
        for (int i = 0; i < iArr2.length; i++) {
            if (iArr[i] == 7) {
                iArr3[i] = this.f2967a.a(iArr2[i], this.b, this.c);
            } else {
                iArr3[i] = iArr2[i];
            }
        }
        return iArr3;
    }
}
