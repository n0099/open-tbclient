package com.google.zxing.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.NotFoundException;
/* loaded from: classes6.dex */
public final class DefaultGridSampler extends GridSampler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DefaultGridSampler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.google.zxing.common.GridSampler
    public BitMatrix sampleGrid(BitMatrix bitMatrix, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) throws NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bitMatrix, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9), Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(f13), Float.valueOf(f14), Float.valueOf(f15), Float.valueOf(f16), Float.valueOf(f17)})) == null) ? sampleGrid(bitMatrix, i2, i3, PerspectiveTransform.quadrilateralToQuadrilateral(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17)) : (BitMatrix) invokeCommon.objValue;
    }

    @Override // com.google.zxing.common.GridSampler
    public BitMatrix sampleGrid(BitMatrix bitMatrix, int i2, int i3, PerspectiveTransform perspectiveTransform) throws NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bitMatrix, Integer.valueOf(i2), Integer.valueOf(i3), perspectiveTransform})) == null) {
            if (i2 > 0 && i3 > 0) {
                BitMatrix bitMatrix2 = new BitMatrix(i2, i3);
                int i4 = i2 * 2;
                float[] fArr = new float[i4];
                for (int i5 = 0; i5 < i3; i5++) {
                    float f2 = i5 + 0.5f;
                    for (int i6 = 0; i6 < i4; i6 += 2) {
                        fArr[i6] = (i6 / 2) + 0.5f;
                        fArr[i6 + 1] = f2;
                    }
                    perspectiveTransform.transformPoints(fArr);
                    GridSampler.checkAndNudgePoints(bitMatrix, fArr);
                    for (int i7 = 0; i7 < i4; i7 += 2) {
                        try {
                            if (bitMatrix.get((int) fArr[i7], (int) fArr[i7 + 1])) {
                                bitMatrix2.set(i7 / 2, i5);
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
