package javassist.bytecode;
/* loaded from: classes.dex */
class p extends m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i, int i2) {
        super(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.l
    public int c() {
        return this.d == 2 ? 2 : 0;
    }

    @Override // javassist.bytecode.m
    void b(int i, byte[] bArr, int i2, byte[] bArr2) {
        bArr2[i2] = (byte) ((bArr[i] & 255) == 167 ? 200 : 201);
        g.b(this.c, bArr2, i2 + 1);
    }
}
