package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
/* loaded from: classes6.dex */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {
    public final float[] tempStartValues = new float[9];
    public final float[] tempEndValues = new float[9];
    public final Matrix tempMatrix = new Matrix();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.tempStartValues);
        matrix2.getValues(this.tempEndValues);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.tempEndValues;
            float f3 = fArr[i];
            float[] fArr2 = this.tempStartValues;
            fArr[i] = fArr2[i] + ((f3 - fArr2[i]) * f2);
        }
        this.tempMatrix.setValues(this.tempEndValues);
        return this.tempMatrix;
    }
}
