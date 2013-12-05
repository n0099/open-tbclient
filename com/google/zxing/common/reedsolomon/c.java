package com.google.zxing.common.reedsolomon;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f2870a;

    public c(a aVar) {
        this.f2870a = aVar;
    }

    public void a(int[] iArr, int i) {
        b bVar = new b(this.f2870a, iArr);
        int[] iArr2 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            int b = bVar.b(this.f2870a.a(this.f2870a.d() + i2));
            iArr2[(iArr2.length - 1) - i2] = b;
            if (b != 0) {
                z = false;
            }
        }
        if (!z) {
            b[] a2 = a(this.f2870a.a(i, 1), new b(this.f2870a, iArr2), i);
            b bVar2 = a2[0];
            b bVar3 = a2[1];
            int[] a3 = a(bVar2);
            int[] a4 = a(bVar3, a3);
            for (int i3 = 0; i3 < a3.length; i3++) {
                int length = (iArr.length - 1) - this.f2870a.b(a3[i3]);
                if (length < 0) {
                    throw new ReedSolomonException("Bad error location");
                }
                iArr[length] = a.b(iArr[length], a4[i3]);
            }
        }
    }

    public b[] a(b bVar, b bVar2, int i) {
        if (bVar.a() >= bVar2.a()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        b a2 = this.f2870a.a();
        b b = this.f2870a.b();
        while (bVar.a() >= i / 2) {
            if (bVar.b()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            b a3 = this.f2870a.a();
            int c = this.f2870a.c(bVar.a(bVar.a()));
            b bVar3 = a3;
            b bVar4 = bVar2;
            while (bVar4.a() >= bVar.a() && !bVar4.b()) {
                int a4 = bVar4.a() - bVar.a();
                int c2 = this.f2870a.c(bVar4.a(bVar4.a()), c);
                bVar3 = bVar3.a(this.f2870a.a(a4, c2));
                bVar4 = bVar4.a(bVar.a(a4, c2));
            }
            b a5 = bVar3.b(b).a(a2);
            if (bVar4.a() >= bVar.a()) {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
            }
            bVar2 = bVar;
            bVar = bVar4;
            b bVar5 = b;
            b = a5;
            a2 = bVar5;
        }
        int a6 = b.a(0);
        if (a6 == 0) {
            throw new ReedSolomonException("sigmaTilde(0) was zero");
        }
        int c3 = this.f2870a.c(a6);
        return new b[]{b.c(c3), bVar.c(c3)};
    }

    private int[] a(b bVar) {
        int i = 0;
        int a2 = bVar.a();
        if (a2 == 1) {
            return new int[]{bVar.a(1)};
        }
        int[] iArr = new int[a2];
        for (int i2 = 1; i2 < this.f2870a.c() && i < a2; i2++) {
            if (bVar.b(i2) == 0) {
                iArr[i] = this.f2870a.c(i2);
                i++;
            }
        }
        if (i != a2) {
            throw new ReedSolomonException("Error locator degree does not match number of roots");
        }
        return iArr;
    }

    private int[] a(b bVar, int[] iArr) {
        int i;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int c = this.f2870a.c(iArr[i2]);
            int i3 = 1;
            int i4 = 0;
            while (i4 < length) {
                if (i2 != i4) {
                    int c2 = this.f2870a.c(iArr[i4], c);
                    i = this.f2870a.c(i3, (c2 & 1) == 0 ? c2 | 1 : c2 & (-2));
                } else {
                    i = i3;
                }
                i4++;
                i3 = i;
            }
            iArr2[i2] = this.f2870a.c(bVar.b(c), this.f2870a.c(i3));
            if (this.f2870a.d() != 0) {
                iArr2[i2] = this.f2870a.c(iArr2[i2], c);
            }
        }
        return iArr2;
    }
}
