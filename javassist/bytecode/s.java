package javassist.bytecode;
/* loaded from: classes.dex */
class s extends u {
    int[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(int i, int i2, int[] iArr, int[] iArr2, t tVar) {
        super(i, i2, iArr2, tVar);
        this.c = iArr;
    }

    @Override // javassist.bytecode.u
    int a(int i, byte[] bArr) {
        int length = this.c.length;
        g.b(length, bArr, i);
        int i2 = i + 4;
        for (int i3 = 0; i3 < length; i3++) {
            g.b(this.c[i3], bArr, i2);
            g.b(this.f[i3], bArr, i2 + 4);
            i2 += 8;
        }
        return (length * 8) + 4;
    }

    @Override // javassist.bytecode.u
    int d() {
        return (this.c.length * 8) + 4;
    }
}
