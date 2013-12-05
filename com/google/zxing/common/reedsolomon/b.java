package com.google.zxing.common.reedsolomon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f2869a;
    private final int[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, int[] iArr) {
        int i = 1;
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f2869a = aVar;
        int length = iArr.length;
        if (length > 1 && iArr[0] == 0) {
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.b = aVar.a().b;
                return;
            }
            this.b = new int[length - i];
            System.arraycopy(iArr, i, this.b, 0, this.b.length);
            return;
        }
        this.b = iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.b.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.b[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        return this.b[(this.b.length - 1) - i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        int i2 = 0;
        if (i == 0) {
            return a(0);
        }
        int length = this.b.length;
        if (i == 1) {
            int[] iArr = this.b;
            int length2 = iArr.length;
            int i3 = 0;
            while (i2 < length2) {
                int b = a.b(i3, iArr[i2]);
                i2++;
                i3 = b;
            }
            return i3;
        }
        int i4 = this.b[0];
        int i5 = 1;
        while (i5 < length) {
            int b2 = a.b(this.f2869a.c(i, i4), this.b[i5]);
            i5++;
            i4 = b2;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(b bVar) {
        if (!this.f2869a.equals(bVar.f2869a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (!b()) {
            if (bVar.b()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = bVar.b;
            if (iArr.length <= iArr2.length) {
                iArr2 = iArr;
                iArr = iArr2;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr3[i] = a.b(iArr2[i - length], iArr[i]);
            }
            return new b(this.f2869a, iArr3);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b(b bVar) {
        if (!this.f2869a.equals(bVar.f2869a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (b() || bVar.b()) {
            return this.f2869a.a();
        }
        int[] iArr = this.b;
        int length = iArr.length;
        int[] iArr2 = bVar.b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                iArr3[i + i3] = a.b(iArr3[i + i3], this.f2869a.c(i2, iArr2[i3]));
            }
        }
        return new b(this.f2869a, iArr3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b c(int i) {
        if (i == 0) {
            return this.f2869a.a();
        }
        if (i != 1) {
            int length = this.b.length;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = this.f2869a.c(this.b[i2], i);
            }
            return new b(this.f2869a, iArr);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f2869a.a();
        }
        int length = this.b.length;
        int[] iArr = new int[length + i];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f2869a.c(this.b[i3], i2);
        }
        return new b(this.f2869a, iArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(a() * 8);
        for (int a2 = a(); a2 >= 0; a2--) {
            int a3 = a(a2);
            if (a3 != 0) {
                if (a3 < 0) {
                    sb.append(" - ");
                    a3 = -a3;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (a2 == 0 || a3 != 1) {
                    int b = this.f2869a.b(a3);
                    if (b == 0) {
                        sb.append('1');
                    } else if (b == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(b);
                    }
                }
                if (a2 != 0) {
                    if (a2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(a2);
                    }
                }
            }
        }
        return sb.toString();
    }
}
