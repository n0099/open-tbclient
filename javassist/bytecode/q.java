package javassist.bytecode;
/* loaded from: classes.dex */
class q extends l {
    int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(int i, int i2) {
        super(i);
        this.c = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.l
    public void a(int i, int i2, boolean z) {
        this.c = a(this.f2769a, this.c, i, i2, z);
        super.a(i, i2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.l
    public int a(int i, byte[] bArr, int i2, byte[] bArr2) {
        bArr2[i2] = bArr[i];
        g.b(this.c, bArr2, i2 + 1);
        return 5;
    }
}
