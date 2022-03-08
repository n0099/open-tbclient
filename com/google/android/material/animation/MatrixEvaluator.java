package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final float[] tempEndValues;
    public final Matrix tempMatrix;
    public final float[] tempStartValues;

    public MatrixEvaluator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.tempStartValues = new float[9];
        this.tempEndValues = new float[9];
        this.tempMatrix = new Matrix();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    @NonNull
    public Matrix evaluate(float f2, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), matrix, matrix2})) == null) {
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
        return (Matrix) invokeCommon.objValue;
    }
}
