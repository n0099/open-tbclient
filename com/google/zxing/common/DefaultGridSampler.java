package com.google.zxing.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.NotFoundException;
/* loaded from: classes7.dex */
public final class DefaultGridSampler extends GridSampler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DefaultGridSampler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.google.zxing.common.GridSampler
    public BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bitMatrix, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9), Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(f13), Float.valueOf(f14), Float.valueOf(f15), Float.valueOf(f16)})) == null) {
            return sampleGrid(bitMatrix, i, i2, PerspectiveTransform.quadrilateralToQuadrilateral(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
        }
        return (BitMatrix) invokeCommon.objValue;
    }

    @Override // com.google.zxing.common.GridSampler
    public BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, PerspectiveTransform perspectiveTransform) throws NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bitMatrix, Integer.valueOf(i), Integer.valueOf(i2), perspectiveTransform})) == null) {
            if (i > 0 && i2 > 0) {
                BitMatrix bitMatrix2 = new BitMatrix(i, i2);
                int i3 = i * 2;
                float[] fArr = new float[i3];
                for (int i4 = 0; i4 < i2; i4++) {
                    float f = i4 + 0.5f;
                    for (int i5 = 0; i5 < i3; i5 += 2) {
                        fArr[i5] = (i5 / 2) + 0.5f;
                        fArr[i5 + 1] = f;
                    }
                    perspectiveTransform.transformPoints(fArr);
                    GridSampler.checkAndNudgePoints(bitMatrix, fArr);
                    for (int i6 = 0; i6 < i3; i6 += 2) {
                        try {
                            if (bitMatrix.get((int) fArr[i6], (int) fArr[i6 + 1])) {
                                bitMatrix2.set(i6 / 2, i4);
                            }
                        } catch (ArrayIndexOutOfBoundsException unused) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                    }
                }
                return bitMatrix2;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (BitMatrix) invokeCommon.objValue;
    }
}
