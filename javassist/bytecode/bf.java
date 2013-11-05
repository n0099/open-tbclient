package javassist.bytecode;
/* loaded from: classes.dex */
class bf extends bi {

    /* renamed from: a  reason: collision with root package name */
    int f2755a;

    public bf(byte[] bArr, int i) {
        super(bArr);
        this.f2755a = i;
    }

    @Override // javassist.bytecode.bi, javassist.bytecode.bk
    public void a(int i, int i2, int i3, int i4) {
        if (i3 == 8 && i4 == this.f2755a) {
            super.a_(i, i2);
        } else {
            super.a(i, i2, i3, i4);
        }
    }

    @Override // javassist.bytecode.bi, javassist.bytecode.bk
    public void a(int i, int i2, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int[] iArr5;
        int[] iArr6;
        int i3 = 0;
        int length = iArr3.length - 1;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                iArr5 = iArr4;
                iArr6 = iArr3;
                break;
            } else if (iArr3[i4] != 8 || iArr4[i4] != this.f2755a || iArr3[i4 + 1] != 8 || iArr4[i4 + 1] != this.f2755a) {
                i4++;
            } else {
                int i5 = length + 1;
                iArr6 = new int[i5 - 2];
                iArr5 = new int[i5 - 2];
                int i6 = 0;
                while (i3 < i5) {
                    if (i3 == i4) {
                        i3++;
                    } else {
                        iArr6[i6] = iArr3[i3];
                        iArr5[i6] = iArr4[i3];
                        i6++;
                    }
                    i3++;
                }
            }
        }
        super.a(i, i2, iArr, iArr2, iArr6, iArr5);
    }
}
