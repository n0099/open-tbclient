package d.b.j.d.a;

import javax.crypto.ShortBufferException;
/* loaded from: classes.dex */
public final class h implements i {

    /* renamed from: a  reason: collision with root package name */
    public int f64416a;

    public h(int i) {
        this.f64416a = i;
    }

    @Override // d.b.j.d.a.i
    public int a(int i) {
        int i2 = this.f64416a;
        return i2 - (i % i2);
    }

    @Override // d.b.j.d.a.i
    public void a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return;
        }
        if (i + i2 > bArr.length) {
            throw new ShortBufferException("Buffer too small to hold padding");
        }
        byte b2 = (byte) (i2 & 255);
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3 + i] = b2;
        }
    }

    @Override // d.b.j.d.a.i
    public int b(byte[] bArr, int i, int i2) {
        int i3;
        if (bArr == null || i2 == 0) {
            return 0;
        }
        int i4 = i2 + i;
        int i5 = bArr[i4 - 1];
        int i6 = i5 & 255;
        if (i6 < 1 || i6 > this.f64416a || (i3 = i4 - i6) < i) {
            return -1;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (bArr[i3 + i7] != i5) {
                return -1;
            }
        }
        return i3;
    }
}
