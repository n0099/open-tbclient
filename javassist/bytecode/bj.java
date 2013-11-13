package javassist.bytecode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends bh {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(StackMapTable stackMapTable, int i, int i2) {
        super(stackMapTable, i, i2, false);
    }

    @Override // javassist.bytecode.bh
    void b(int i, int i2, int i3, int i4) {
        int i5;
        int i6 = this.c;
        this.c = (i6 == 0 ? 0 : 1) + i6 + i2;
        if (this.f2805a == this.c) {
            i5 = i2 - this.b;
        } else if (this.f2805a == i6) {
            i5 = this.b + i2;
        } else {
            return;
        }
        if (i2 < 64) {
            if (i5 < 64) {
                this.f[i] = (byte) (i5 + i3);
                return;
            }
            byte[] a2 = a(this.f, i, 2);
            a2[i] = (byte) i4;
            g.a(i5, a2, i + 1);
            this.d = a2;
        } else if (i5 < 64) {
            byte[] b = b(this.f, i, 2);
            b[i] = (byte) (i5 + i3);
            this.d = b;
        } else {
            g.a(i5, this.f, i + 1);
        }
    }

    static byte[] b(byte[] bArr, int i, int i2) {
        int i3 = i + i2;
        int length = bArr.length;
        byte[] bArr2 = new byte[length - i2];
        int i4 = 0;
        while (i4 < length) {
            bArr2[i4 - (i4 < i3 ? 0 : i2)] = bArr[i4];
            i4++;
        }
        return bArr2;
    }

    @Override // javassist.bytecode.bh
    void b(int i, int i2) {
        int i3;
        int i4 = this.c;
        this.c = (i4 == 0 ? 0 : 1) + i4 + i2;
        if (this.f2805a == this.c) {
            i3 = i2 - this.b;
        } else if (this.f2805a == i4) {
            i3 = this.b + i2;
        } else {
            return;
        }
        g.a(i3, this.f, i + 1);
    }
}
