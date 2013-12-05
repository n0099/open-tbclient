package com.google.zxing.common;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f2859a;
    private final int b;
    private final int c;
    private final int[] d;

    public a(int i) {
        this(i, i);
    }

    public a(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f2859a = i;
        this.b = i2;
        this.c = (i + 31) >> 5;
        this.d = new int[this.c * i2];
    }

    public boolean a(int i, int i2) {
        return ((this.d[(this.c * i2) + (i >> 5)] >>> (i & 31)) & 1) != 0;
    }

    public void b(int i, int i2) {
        int i3 = (this.c * i2) + (i >> 5);
        int[] iArr = this.d;
        iArr[i3] = iArr[i3] | (1 << (i & 31));
    }

    public void c(int i, int i2) {
        int i3 = (this.c * i2) + (i >> 5);
        int[] iArr = this.d;
        iArr[i3] = iArr[i3] ^ (1 << (i & 31));
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i5 = i + i3;
        int i6 = i2 + i4;
        if (i6 > this.b || i5 > this.f2859a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i2 < i6) {
            int i7 = i2 * this.c;
            for (int i8 = i; i8 < i5; i8++) {
                int[] iArr = this.d;
                int i9 = (i8 >> 5) + i7;
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    public int[] a() {
        int i = 0;
        while (i < this.d.length && this.d[i] == 0) {
            i++;
        }
        if (i == this.d.length) {
            return null;
        }
        int i2 = i / this.c;
        int i3 = (i % this.c) << 5;
        int i4 = this.d[i];
        int i5 = 0;
        while ((i4 << (31 - i5)) == 0) {
            i5++;
        }
        return new int[]{i3 + i5, i2};
    }

    public int[] b() {
        int length = this.d.length - 1;
        while (length >= 0 && this.d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = length / this.c;
        int i2 = (length % this.c) << 5;
        int i3 = this.d[length];
        int i4 = 31;
        while ((i3 >>> i4) == 0) {
            i4--;
        }
        return new int[]{i2 + i4, i};
    }

    public int c() {
        return this.f2859a;
    }

    public int d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f2859a == aVar.f2859a && this.b == aVar.b && this.c == aVar.c && this.d.length == aVar.d.length) {
                for (int i = 0; i < this.d.length; i++) {
                    if (this.d[i] != aVar.d[i]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = this.c + (((((this.f2859a * 31) + this.f2859a) * 31) + this.b) * 31);
        for (int i2 : this.d) {
            i = (i * 31) + i2;
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.b * (this.f2859a + 1));
        for (int i = 0; i < this.b; i++) {
            for (int i2 = 0; i2 < this.f2859a; i2++) {
                sb.append(a(i2, i) ? "X " : "  ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
