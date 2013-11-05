package javassist.bytecode;
/* loaded from: classes.dex */
class o extends m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public o(int i, int i2) {
        super(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.l
    public int c() {
        return this.d == 2 ? 5 : 0;
    }

    @Override // javassist.bytecode.m
    void b(int i, byte[] bArr, int i2, byte[] bArr2) {
        bArr2[i2] = (byte) a(bArr[i] & 255);
        bArr2[i2 + 1] = 0;
        bArr2[i2 + 2] = 8;
        bArr2[i2 + 3] = -56;
        g.b(this.c - 3, bArr2, i2 + 4);
    }

    int a(int i) {
        if (i == 198) {
            return 199;
        }
        if (i == 199) {
            return 198;
        }
        if (((i - 153) & 1) == 0) {
            return i + 1;
        }
        return i - 1;
    }
}
