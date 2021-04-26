package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {
    public final float[] tempStartValues = new float[9];
    public final float[] tempEndValues = new float[9];
    public final Matrix tempMatrix = new Matrix();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    @NonNull
    public Matrix evaluate(float f2, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        matrix.getValues(this.tempStartValues);
        matrix2.getValues(this.tempEndValues);
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.tempEndValues;
            float f3 = fArr[i2];
            float[] fArr2 = this.tempStartValues;
            fArr[i2] = fArr2[i2] + ((f3 - fArr2[i2]) * f2);
        }
        this.tempMatrix.setValues(this.tempEndValues);
        return this.tempMatrix;
    }
}
