package com.google.zxing.common;

import com.google.zxing.NotFoundException;
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f2864a = new d();

    public abstract a a(a aVar, int i, int i2, i iVar);

    public static g a() {
        return f2864a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(a aVar, float[] fArr) {
        int c = aVar.c();
        int d = aVar.d();
        boolean z = true;
        for (int i = 0; i < fArr.length && z; i += 2) {
            int i2 = (int) fArr[i];
            int i3 = (int) fArr[i + 1];
            if (i2 < -1 || i2 > c || i3 < -1 || i3 > d) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i2 == -1) {
                fArr[i] = 0.0f;
                z = true;
            } else if (i2 == c) {
                fArr[i] = c - 1;
                z = true;
            } else {
                z = false;
            }
            if (i3 == -1) {
                fArr[i + 1] = 0.0f;
                z = true;
            } else if (i3 == d) {
                fArr[i + 1] = d - 1;
                z = true;
            }
        }
        boolean z2 = true;
        for (int length = fArr.length - 2; length >= 0 && z2; length -= 2) {
            int i4 = (int) fArr[length];
            int i5 = (int) fArr[length + 1];
            if (i4 < -1 || i4 > c || i5 < -1 || i5 > d) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i4 == -1) {
                fArr[length] = 0.0f;
                z2 = true;
            } else if (i4 == c) {
                fArr[length] = c - 1;
                z2 = true;
            } else {
                z2 = false;
            }
            if (i5 == -1) {
                fArr[length + 1] = 0.0f;
                z2 = true;
            } else if (i5 == d) {
                fArr[length + 1] = d - 1;
                z2 = true;
            }
        }
    }
}
