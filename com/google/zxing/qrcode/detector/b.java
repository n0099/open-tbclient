package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.zxing.common.a f2890a;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final float g;
    private final j i;
    private final List<a> b = new ArrayList(5);
    private final int[] h = new int[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.google.zxing.common.a aVar, int i, int i2, int i3, int i4, float f, j jVar) {
        this.f2890a = aVar;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = f;
        this.i = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a() {
        a a2;
        a a3;
        int i = this.c;
        int i2 = this.f;
        int i3 = i + this.e;
        int i4 = this.d + (i2 >> 1);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i4 + ((i5 & 1) == 0 ? (i5 + 1) >> 1 : -((i5 + 1) >> 1));
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i;
            while (i7 < i3 && !this.f2890a.a(i7, i6)) {
                i7++;
            }
            int i8 = 0;
            for (int i9 = i7; i9 < i3; i9++) {
                if (this.f2890a.a(i9, i6)) {
                    if (i8 == 1) {
                        iArr[i8] = iArr[i8] + 1;
                    } else if (i8 == 2) {
                        if (a(iArr) && (a3 = a(iArr, i6, i9)) != null) {
                            return a3;
                        }
                        iArr[0] = iArr[2];
                        iArr[1] = 1;
                        iArr[2] = 0;
                        i8 = 1;
                    } else {
                        i8++;
                        iArr[i8] = iArr[i8] + 1;
                    }
                } else {
                    if (i8 == 1) {
                        i8++;
                    }
                    iArr[i8] = iArr[i8] + 1;
                }
            }
            if (a(iArr) && (a2 = a(iArr, i6, i3)) != null) {
                return a2;
            }
        }
        if (!this.b.isEmpty()) {
            return this.b.get(0);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static float a(int[] iArr, int i) {
        return (i - iArr[2]) - (iArr[1] / 2.0f);
    }

    private boolean a(int[] iArr) {
        float f = this.g;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - iArr[i]) >= f2) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
        if (r4[1] <= r12) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
        r4[0] = r4[0] + 1;
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
        if (r1 < 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
        if (r2.a(r11, r1) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r4[0] <= r12) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r4[0] > r12) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
        r1 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (r1 >= r3) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
        if (r2.a(r11, r1) == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
        if (r4[1] <= r12) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
        if (r1 == r3) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        if (r4[1] > r12) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
        if (r1 >= r3) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
        if (r2.a(r11, r1) != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
        if (r4[2] <= r12) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
        if (r4[2] > r12) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007d, code lost:
        if ((java.lang.Math.abs(((r4[0] + r4[1]) + r4[2]) - r13) * 5) >= (r13 * 2)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0083, code lost:
        if (a(r4) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008a, code lost:
        r4[1] = r4[1] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0093, code lost:
        r4[2] = r4[2] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
        return a(r4, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float a(int i, int i2, int i3, int i4) {
        com.google.zxing.common.a aVar = this.f2890a;
        int d = aVar.d();
        int[] iArr = this.h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i5 = i;
        while (i5 >= 0 && aVar.a(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5--;
        }
        return Float.NaN;
    }

    private a a(int[] iArr, int i, int i2) {
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float a2 = a(iArr, i2);
        float a3 = a(i, (int) a2, iArr[1] * 2, i3);
        if (!Float.isNaN(a3)) {
            float f = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
            for (a aVar : this.b) {
                if (aVar.a(f, a3, a2)) {
                    return aVar.b(a3, a2, f);
                }
            }
            a aVar2 = new a(a2, a3, f);
            this.b.add(aVar2);
            if (this.i != null) {
                this.i.a(aVar2);
            }
        }
        return null;
    }
}
