package javassist.bytecode;
/* loaded from: classes.dex */
class v extends u {
    int c;
    int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(int i, int i2, int i3, int i4, int[] iArr, t tVar) {
        super(i, i2, iArr, tVar);
        this.c = i3;
        this.h = i4;
    }

    @Override // javassist.bytecode.u
    int a(int i, byte[] bArr) {
        g.b(this.c, bArr, i);
        g.b(this.h, bArr, i + 4);
        int length = this.f.length;
        int i2 = i + 8;
        for (int i3 = 0; i3 < length; i3++) {
            g.b(this.f[i3], bArr, i2);
            i2 += 4;
        }
        return (length * 4) + 8;
    }

    @Override // javassist.bytecode.u
    int d() {
        return (this.f.length * 4) + 8;
    }
}
