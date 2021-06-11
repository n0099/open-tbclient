package d.a.j.d.a;

import javax.crypto.ShortBufferException;
/* loaded from: classes2.dex */
public final class h implements i {

    /* renamed from: a  reason: collision with root package name */
    public int f43861a;

    public h(int i2) {
        this.f43861a = i2;
    }

    @Override // d.a.j.d.a.i
    public int a(int i2) {
        int i3 = this.f43861a;
        return i3 - (i2 % i3);
    }

    @Override // d.a.j.d.a.i
    public void a(byte[] bArr, int i2, int i3) {
        if (bArr == null) {
            return;
        }
        if (i2 + i3 > bArr.length) {
            throw new ShortBufferException("Buffer too small to hold padding");
        }
        byte b2 = (byte) (i3 & 255);
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i4 + i2] = b2;
        }
    }

    @Override // d.a.j.d.a.i
    public int b(byte[] bArr, int i2, int i3) {
        int i4;
        if (bArr == null || i3 == 0) {
            return 0;
        }
        int i5 = i3 + i2;
        int i6 = bArr[i5 - 1];
        int i7 = i6 & 255;
        if (i7 < 1 || i7 > this.f43861a || (i4 = i5 - i7) < i2) {
            return -1;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (bArr[i4 + i8] != i6) {
                return -1;
            }
        }
        return i4;
    }
}
