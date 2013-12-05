package com.google.zxing;
/* loaded from: classes.dex */
public final class e extends c {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f2872a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;

    public e(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f2872a = bArr;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        if (z) {
            a(i5, i6);
        }
    }

    @Override // com.google.zxing.c
    public byte[] a(int i, byte[] bArr) {
        if (i < 0 || i >= c()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int b = b();
        if (bArr == null || bArr.length < b) {
            bArr = new byte[b];
        }
        System.arraycopy(this.f2872a, ((this.e + i) * this.b) + this.d, bArr, 0, b);
        return bArr;
    }

    @Override // com.google.zxing.c
    public byte[] a() {
        int b = b();
        int c = c();
        if (b == this.b && c == this.c) {
            return this.f2872a;
        }
        int i = b * c;
        byte[] bArr = new byte[i];
        int i2 = (this.e * this.b) + this.d;
        if (b == this.b) {
            System.arraycopy(this.f2872a, i2, bArr, 0, i);
            return bArr;
        }
        byte[] bArr2 = this.f2872a;
        for (int i3 = 0; i3 < c; i3++) {
            System.arraycopy(bArr2, i2, bArr, i3 * b, b);
            i2 += this.b;
        }
        return bArr;
    }

    public int[] d() {
        int b = b() / 2;
        int c = c() / 2;
        int[] iArr = new int[b * c];
        byte[] bArr = this.f2872a;
        int i = (this.e * this.b) + this.d;
        for (int i2 = 0; i2 < c; i2++) {
            int i3 = i2 * b;
            for (int i4 = 0; i4 < b; i4++) {
                iArr[i3 + i4] = ((bArr[(i4 * 2) + i] & 255) * 65793) | (-16777216);
            }
            i += this.b * 2;
        }
        return iArr;
    }

    public int e() {
        return b() / 2;
    }

    public int f() {
        return c() / 2;
    }

    private void a(int i, int i2) {
        byte[] bArr = this.f2872a;
        int i3 = this.d + (this.e * this.b);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i3 + (i / 2);
            int i6 = (i3 + i) - 1;
            int i7 = i3;
            while (i7 < i5) {
                byte b = bArr[i7];
                bArr[i7] = bArr[i6];
                bArr[i6] = b;
                i7++;
                i6--;
            }
            i3 += this.b;
        }
    }
}
