package javassist.bytecode;
/* loaded from: classes.dex */
class r extends l {
    int c;
    boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(int i, int i2) {
        super(i);
        this.c = i2;
        this.d = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.l
    public boolean a() {
        if (this.d) {
            this.d = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.l
    public int c() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.l
    public int a(int i, byte[] bArr, int i2, byte[] bArr2) {
        bArr2[i2] = 19;
        g.a(this.c, bArr2, i2 + 1);
        return 2;
    }
}
