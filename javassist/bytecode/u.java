package javassist.bytecode;
/* loaded from: classes.dex */
abstract class u extends l {
    int d;
    int e;
    int[] f;
    t g;

    abstract int a(int i, byte[] bArr);

    abstract int d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(int i, int i2, int[] iArr, t tVar) {
        super(i);
        this.d = 3 - (i & 3);
        this.e = i2;
        this.f = iArr;
        this.g = tVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.l
    public void a(int i, int i2, boolean z) {
        int i3 = this.f2817a;
        this.e = a(i3, this.e, i, i2, z);
        int length = this.f.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f[i4] = a(i3, this.f[i4], i, i2, z);
        }
        super.a(i, i2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.l
    public int b() {
        int i = 3 - (this.f2817a & 3);
        if (i > this.d) {
            int i2 = i - this.d;
            this.d = i;
            return i2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.l
    public int c() {
        return this.d - (3 - (this.b & 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.l
    public int a(int i, byte[] bArr, int i2, byte[] bArr2) {
        int i3 = 3 - (this.f2817a & 3);
        int i4 = this.d - i3;
        int d = (3 - (this.b & 3)) + 5 + d();
        if (i4 > 0) {
            a(d, i4);
        }
        bArr2[i2] = bArr[i];
        int i5 = i2 + 1;
        while (true) {
            int i6 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            bArr2[i5] = 0;
            i5++;
            i3 = i6;
        }
        g.b(this.e, bArr2, i5);
        int a2 = a(i5 + 4, bArr2);
        int i7 = a2 + 4 + i5;
        while (true) {
            int i8 = i4 - 1;
            if (i4 > 0) {
                bArr2[i7] = 0;
                i7++;
                i4 = i8;
            } else {
                return (3 - (this.b & 3)) + 5 + a2;
            }
        }
    }

    void a(int i, int i2) {
        this.g.a(this.f2817a + i, i2);
        if (this.e == i) {
            this.e -= i2;
        }
        for (int i3 = 0; i3 < this.f.length; i3++) {
            if (this.f[i3] == i) {
                int[] iArr = this.f;
                iArr[i3] = iArr[i3] - i2;
            }
        }
    }
}
