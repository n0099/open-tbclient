package com.google.zxing.qrcode.decoder;
/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f2880a;
    private final byte[] b;

    private b(int i, byte[] bArr) {
        this.f2880a = i;
        this.b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b[] a(byte[] bArr, o oVar, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != oVar.c()) {
            throw new IllegalArgumentException();
        }
        q a2 = oVar.a(errorCorrectionLevel);
        p[] b = a2.b();
        int i = 0;
        for (p pVar : b) {
            i += pVar.a();
        }
        b[] bVarArr = new b[i];
        int length = b.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            p pVar2 = b[i2];
            int i4 = i3;
            int i5 = 0;
            while (i5 < pVar2.a()) {
                int b2 = pVar2.b();
                bVarArr[i4] = new b(b2, new byte[a2.a() + b2]);
                i5++;
                i4++;
            }
            i2++;
            i3 = i4;
        }
        int length2 = bVarArr[0].b.length;
        int length3 = bVarArr.length - 1;
        while (length3 >= 0 && bVarArr[length3].b.length != length2) {
            length3--;
        }
        int i6 = length3 + 1;
        int a3 = length2 - a2.a();
        int i7 = 0;
        int i8 = 0;
        while (i7 < a3) {
            int i9 = i8;
            int i10 = 0;
            while (i10 < i3) {
                bVarArr[i10].b[i7] = bArr[i9];
                i10++;
                i9++;
            }
            i7++;
            i8 = i9;
        }
        int i11 = i6;
        while (i11 < i3) {
            bVarArr[i11].b[a3] = bArr[i8];
            i11++;
            i8++;
        }
        int length4 = bVarArr[0].b.length;
        while (a3 < length4) {
            int i12 = 0;
            int i13 = i8;
            while (i12 < i3) {
                bVarArr[i12].b[i12 < i6 ? a3 : a3 + 1] = bArr[i13];
                i12++;
                i13++;
            }
            a3++;
            i8 = i13;
        }
        return bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f2880a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] b() {
        return this.b;
    }
}
