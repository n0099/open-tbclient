package com.google.zxing.common;

import com.google.zxing.NotFoundException;
/* loaded from: classes5.dex */
public abstract class GridSampler {
    private static GridSampler gridSampler = new DefaultGridSampler();

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws NotFoundException;

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, PerspectiveTransform perspectiveTransform) throws NotFoundException;

    public static void setGridSampler(GridSampler gridSampler2) {
        gridSampler = gridSampler2;
    }

    public static GridSampler getInstance() {
        return gridSampler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void checkAndNudgePoints(BitMatrix bitMatrix, float[] fArr) throws NotFoundException {
        boolean z;
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        boolean z2 = true;
        for (int i = 0; i < fArr.length && z2; i += 2) {
            int i2 = (int) fArr[i];
            int i3 = (int) fArr[i + 1];
            if (i2 < -1 || i2 > width || i3 < -1 || i3 > height) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i2 == -1) {
                fArr[i] = 0.0f;
                z2 = true;
            } else if (i2 == width) {
                fArr[i] = width - 1;
                z2 = true;
            } else {
                z2 = false;
            }
            if (i3 == -1) {
                fArr[i + 1] = 0.0f;
                z2 = true;
            } else if (i3 == height) {
                fArr[i + 1] = height - 1;
                z2 = true;
            }
        }
        int length = fArr.length - 2;
        boolean z3 = true;
        while (length >= 0 && z3) {
            int i4 = (int) fArr[length];
            int i5 = (int) fArr[length + 1];
            if (i4 < -1 || i4 > width || i5 < -1 || i5 > height) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i4 == -1) {
                fArr[length] = 0.0f;
                z = true;
            } else if (i4 == width) {
                fArr[length] = width - 1;
                z = true;
            } else {
                z = false;
            }
            if (i5 == -1) {
                fArr[length + 1] = 0.0f;
                z = true;
            } else if (i5 == height) {
                fArr[length + 1] = height - 1;
                z = true;
            }
            length -= 2;
            z3 = z;
        }
    }
}
