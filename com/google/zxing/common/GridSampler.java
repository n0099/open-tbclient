package com.google.zxing.common;

import com.google.zxing.NotFoundException;
/* loaded from: classes6.dex */
public abstract class GridSampler {
    public static GridSampler gridSampler = new DefaultGridSampler();

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void checkAndNudgePoints(BitMatrix bitMatrix, float[] fArr) throws NotFoundException {
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        boolean z = true;
        for (int i2 = 0; i2 < fArr.length && z; i2 += 2) {
            int i3 = (int) fArr[i2];
            int i4 = i2 + 1;
            int i5 = (int) fArr[i4];
            if (i3 < -1 || i3 > width || i5 < -1 || i5 > height) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i3 == -1) {
                fArr[i2] = 0.0f;
            } else if (i3 == width) {
                fArr[i2] = width - 1;
            } else {
                z = false;
                if (i5 != -1) {
                    fArr[i4] = 0.0f;
                } else if (i5 == height) {
                    fArr[i4] = height - 1;
                }
                z = true;
            }
            z = true;
            if (i5 != -1) {
            }
            z = true;
        }
        boolean z2 = true;
        for (int length = fArr.length - 2; length >= 0 && z2; length -= 2) {
            int i6 = (int) fArr[length];
            int i7 = length + 1;
            int i8 = (int) fArr[i7];
            if (i6 < -1 || i6 > width || i8 < -1 || i8 > height) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i6 == -1) {
                fArr[length] = 0.0f;
            } else if (i6 == width) {
                fArr[length] = width - 1;
            } else {
                z2 = false;
                if (i8 != -1) {
                    fArr[i7] = 0.0f;
                } else if (i8 == height) {
                    fArr[i7] = height - 1;
                }
                z2 = true;
            }
            z2 = true;
            if (i8 != -1) {
            }
            z2 = true;
        }
    }

    public static GridSampler getInstance() {
        return gridSampler;
    }

    public static void setGridSampler(GridSampler gridSampler2) {
        gridSampler = gridSampler2;
    }

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) throws NotFoundException;

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i2, int i3, PerspectiveTransform perspectiveTransform) throws NotFoundException;
}
