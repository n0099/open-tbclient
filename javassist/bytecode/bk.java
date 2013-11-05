package javassist.bytecode;
/* loaded from: classes.dex */
public class bk {
    byte[] f;
    int g;

    public bk(StackMapTable stackMapTable) {
        this(stackMapTable.e());
    }

    public bk(byte[] bArr) {
        this.f = bArr;
        this.g = g.a(bArr, 0);
    }

    public void b() {
        int i = this.g;
        int i2 = 2;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = c(i2, i3);
        }
    }

    int c(int i, int i2) {
        int i3 = this.f[i] & 255;
        if (i3 < 64) {
            a_(i, i3);
            return i + 1;
        } else if (i3 < 128) {
            return b(i, i3);
        } else {
            if (i3 < 247) {
                throw new BadBytecode("bad frame_type in StackMapTable");
            }
            if (i3 == 247) {
                return b(i, i3);
            }
            if (i3 < 251) {
                b(i, g.a(this.f, i + 1), 251 - i3);
                return i + 3;
            } else if (i3 == 251) {
                a_(i, g.a(this.f, i + 1));
                return i + 3;
            } else if (i3 < 255) {
                return d(i, i3);
            } else {
                return a(i);
            }
        }
    }

    public void a_(int i, int i2) {
    }

    private int b(int i, int i2) {
        int a2;
        int i3;
        int i4;
        int i5;
        if (i2 < 128) {
            a2 = i2 - 64;
            i3 = i;
        } else {
            a2 = g.a(this.f, i + 1);
            i3 = i + 2;
        }
        int i6 = this.f[i3 + 1] & 255;
        if (i6 != 7 && i6 != 8) {
            i4 = i3;
            i5 = 0;
        } else {
            int a3 = g.a(this.f, i3 + 2);
            a(i6, a3, i3 + 2);
            i4 = i3 + 2;
            i5 = a3;
        }
        a(i, a2, i6, i5);
        return i4 + 2;
    }

    public void a(int i, int i2, int i3, int i4) {
    }

    public void b(int i, int i2, int i3) {
    }

    private int d(int i, int i2) {
        int i3 = i2 - 251;
        int a2 = g.a(this.f, i + 1);
        int[] iArr = new int[i3];
        int[] iArr2 = new int[i3];
        int i4 = i + 3;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = this.f[i4] & 255;
            iArr[i5] = i6;
            if (i6 == 7 || i6 == 8) {
                iArr2[i5] = g.a(this.f, i4 + 1);
                a(i6, iArr2[i5], i4 + 1);
                i4 += 3;
            } else {
                iArr2[i5] = 0;
                i4++;
            }
        }
        a(i, a2, iArr, iArr2);
        return i4;
    }

    public void a(int i, int i2, int[] iArr, int[] iArr2) {
    }

    private int a(int i) {
        int a2 = g.a(this.f, i + 1);
        int a3 = g.a(this.f, i + 3);
        int[] iArr = new int[a3];
        int[] iArr2 = new int[a3];
        int b = b(i + 5, a3, iArr, iArr2);
        int a4 = g.a(this.f, b);
        int[] iArr3 = new int[a4];
        int[] iArr4 = new int[a4];
        int b2 = b(b + 2, a4, iArr3, iArr4);
        a(i, a2, iArr, iArr2, iArr3, iArr4);
        return b2;
    }

    public void a(int i, int i2, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
    }

    private int b(int i, int i2, int[] iArr, int[] iArr2) {
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i + 1;
            int i5 = this.f[i] & 255;
            iArr[i3] = i5;
            if (i5 == 7 || i5 == 8) {
                iArr2[i3] = g.a(this.f, i4);
                a(i5, iArr2[i3], i4);
                i4 += 2;
            }
            i3++;
            i = i4;
        }
        return i;
    }

    public void a(int i, int i2, int i3) {
    }
}
