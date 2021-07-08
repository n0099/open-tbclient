package com.google.zxing.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;
/* loaded from: classes6.dex */
public final class HybridBinarizer extends GlobalHistogramBinarizer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BLOCK_SIZE = 8;
    public static final int BLOCK_SIZE_MASK = 7;
    public static final int BLOCK_SIZE_POWER = 3;
    public static final int MINIMUM_DIMENSION = 40;
    public static final int MIN_DYNAMIC_RANGE = 24;
    public transient /* synthetic */ FieldHolder $fh;
    public BitMatrix matrix;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {luminanceSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((LuminanceSource) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static int[][] calculateBlackPoints(byte[] bArr, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            int[][] iArr = (int[][]) Array.newInstance(int.class, i3, i2);
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = i6 << 3;
                int i8 = i5 - 8;
                if (i7 > i8) {
                    i7 = i8;
                }
                for (int i9 = 0; i9 < i2; i9++) {
                    int i10 = i9 << 3;
                    int i11 = i4 - 8;
                    if (i10 > i11) {
                        i10 = i11;
                    }
                    int i12 = (i7 * i4) + i10;
                    int i13 = 0;
                    int i14 = 0;
                    int i15 = 0;
                    int i16 = 255;
                    while (i13 < 8) {
                        for (int i17 = 0; i17 < 8; i17++) {
                            int i18 = bArr[i12 + i17] & 255;
                            i14 += i18;
                            if (i18 < i16) {
                                i16 = i18;
                            }
                            if (i18 > i15) {
                                i15 = i18;
                            }
                        }
                        if (i15 - i16 <= 24) {
                            i13++;
                            i12 += i4;
                        }
                        while (true) {
                            i13++;
                            i12 += i4;
                            if (i13 < 8) {
                                for (int i19 = 0; i19 < 8; i19++) {
                                    i14 += bArr[i12 + i19] & 255;
                                }
                            }
                        }
                        i13++;
                        i12 += i4;
                    }
                    int i20 = i14 >> 6;
                    if (i15 - i16 <= 24) {
                        i20 = i16 / 2;
                        if (i6 > 0 && i9 > 0) {
                            int i21 = i6 - 1;
                            int i22 = i9 - 1;
                            int i23 = ((iArr[i21][i9] + (iArr[i6][i22] * 2)) + iArr[i21][i22]) / 4;
                            if (i16 < i23) {
                                i20 = i23;
                            }
                            iArr[i6][i9] = i20;
                        }
                    }
                    iArr[i6][i9] = i20;
                }
            }
            return iArr;
        }
        return (int[][]) invokeCommon.objValue;
    }

    public static void calculateThresholdForBlock(byte[] bArr, int i2, int i3, int i4, int i5, int[][] iArr, BitMatrix bitMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr, bitMatrix}) == null) {
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = i6 << 3;
                int i8 = i5 - 8;
                if (i7 > i8) {
                    i7 = i8;
                }
                for (int i9 = 0; i9 < i2; i9++) {
                    int i10 = i9 << 3;
                    int i11 = i4 - 8;
                    if (i10 <= i11) {
                        i11 = i10;
                    }
                    int cap = cap(i9, 2, i2 - 3);
                    int cap2 = cap(i6, 2, i3 - 3);
                    int i12 = 0;
                    for (int i13 = -2; i13 <= 2; i13++) {
                        int[] iArr2 = iArr[cap2 + i13];
                        i12 += iArr2[cap - 2] + iArr2[cap - 1] + iArr2[cap] + iArr2[cap + 1] + iArr2[cap + 2];
                    }
                    thresholdBlock(bArr, i11, i7, i12 / 25, i4, bitMatrix);
                }
            }
        }
    }

    public static int cap(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65539, null, i2, i3, i4)) == null) ? i2 < i3 ? i3 : i2 > i4 ? i4 : i2 : invokeIII.intValue;
    }

    public static void thresholdBlock(byte[] bArr, int i2, int i3, int i4, int i5, BitMatrix bitMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), bitMatrix}) == null) {
            int i6 = (i3 * i5) + i2;
            int i7 = 0;
            while (i7 < 8) {
                for (int i8 = 0; i8 < 8; i8++) {
                    if ((bArr[i6 + i8] & 255) <= i4) {
                        bitMatrix.set(i2 + i8, i3 + i7);
                    }
                }
                i7++;
                i6 += i5;
            }
        }
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, luminanceSource)) == null) ? new HybridBinarizer(luminanceSource) : (Binarizer) invokeL.objValue;
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BitMatrix bitMatrix = this.matrix;
            if (bitMatrix != null) {
                return bitMatrix;
            }
            LuminanceSource luminanceSource = getLuminanceSource();
            int width = luminanceSource.getWidth();
            int height = luminanceSource.getHeight();
            if (width >= 40 && height >= 40) {
                byte[] matrix = luminanceSource.getMatrix();
                int i2 = width >> 3;
                if ((width & 7) != 0) {
                    i2++;
                }
                int i3 = i2;
                int i4 = height >> 3;
                if ((height & 7) != 0) {
                    i4++;
                }
                int i5 = i4;
                int[][] calculateBlackPoints = calculateBlackPoints(matrix, i3, i5, width, height);
                BitMatrix bitMatrix2 = new BitMatrix(width, height);
                calculateThresholdForBlock(matrix, i3, i5, width, height, calculateBlackPoints, bitMatrix2);
                this.matrix = bitMatrix2;
            } else {
                this.matrix = super.getBlackMatrix();
            }
            return this.matrix;
        }
        return (BitMatrix) invokeV.objValue;
    }
}
