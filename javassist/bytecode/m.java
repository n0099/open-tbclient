package javassist.bytecode;
/* loaded from: classes.dex */
abstract class m extends l {
    int c;
    int d;

    abstract void b(int i, byte[] bArr, int i2, byte[] bArr2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(int i, int i2) {
        super(i);
        this.c = i2;
        this.d = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.l
    public void a(int i, int i2, boolean z) {
        this.c = a(this.f2817a, this.c, i, i2, z);
        super.a(i, i2, z);
        if (this.d == 0) {
            if (this.c < -32768 || 32767 < this.c) {
                this.d = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.l
    public boolean a() {
        if (this.d == 1) {
            this.d = 2;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.l
    public int a(int i, byte[] bArr, int i2, byte[] bArr2) {
        if (this.d == 2) {
            b(i, bArr, i2, bArr2);
            return 3;
        }
        bArr2[i2] = bArr[i];
        g.a(this.c, bArr2, i2 + 1);
        return 3;
    }
}
