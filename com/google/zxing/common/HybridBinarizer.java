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
/* loaded from: classes5.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((LuminanceSource) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static int[][] calculateBlackPoints(byte[] bArr, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int[][] iArr = (int[][]) Array.newInstance(int.class, i2, i);
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i5 << 3;
                int i7 = i4 - 8;
                if (i6 > i7) {
                    i6 = i7;
                }
                for (int i8 = 0; i8 < i; i8++) {
                    int i9 = i8 << 3;
                    int i10 = i3 - 8;
                    if (i9 > i10) {
                        i9 = i10;
                    }
                    int i11 = (i6 * i3) + i9;
                    int i12 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    int i15 = 255;
                    while (i12 < 8) {
                        for (int i16 = 0; i16 < 8; i16++) {
                            int i17 = bArr[i11 + i16] & 255;
                            i13 += i17;
                            if (i17 < i15) {
                                i15 = i17;
                            }
                            if (i17 > i14) {
                                i14 = i17;
                            }
                        }
                        if (i14 - i15 <= 24) {
                            i12++;
                            i11 += i3;
                        }
                        while (true) {
                            i12++;
                            i11 += i3;
                            if (i12 < 8) {
                                for (int i18 = 0; i18 < 8; i18++) {
                                    i13 += bArr[i11 + i18] & 255;
                                }
                            }
                        }
                        i12++;
                        i11 += i3;
                    }
                    int i19 = i13 >> 6;
                    if (i14 - i15 <= 24) {
                        i19 = i15 / 2;
                        if (i5 > 0 && i8 > 0) {
                            int i20 = i5 - 1;
                            int i21 = i8 - 1;
                            int i22 = ((iArr[i20][i8] + (iArr[i5][i21] * 2)) + iArr[i20][i21]) / 4;
                            if (i15 < i22) {
                                i19 = i22;
                            }
                            iArr[i5][i8] = i19;
                        }
                    }
                    iArr[i5][i8] = i19;
                }
            }
            return iArr;
        }
        return (int[][]) invokeCommon.objValue;
    }

    public static void calculateThresholdForBlock(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, BitMatrix bitMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, bitMatrix}) == null) {
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i5 << 3;
                int i7 = i4 - 8;
                if (i6 > i7) {
                    i6 = i7;
                }
                for (int i8 = 0; i8 < i; i8++) {
                    int i9 = i8 << 3;
                    int i10 = i3 - 8;
                    if (i9 <= i10) {
                        i10 = i9;
                    }
                    int cap = cap(i8, 2, i - 3);
                    int cap2 = cap(i5, 2, i2 - 3);
                    int i11 = 0;
                    for (int i12 = -2; i12 <= 2; i12++) {
                        int[] iArr2 = iArr[cap2 + i12];
                        i11 += iArr2[cap - 2] + iArr2[cap - 1] + iArr2[cap] + iArr2[cap + 1] + iArr2[cap + 2];
                    }
                    thresholdBlock(bArr, i10, i6, i11 / 25, i3, bitMatrix);
                }
            }
        }
    }

    public static int cap(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65539, null, i, i2, i3)) == null) ? i < i2 ? i2 : i > i3 ? i3 : i : invokeIII.intValue;
    }

    public static void thresholdBlock(byte[] bArr, int i, int i2, int i3, int i4, BitMatrix bitMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bitMatrix}) == null) {
            int i5 = (i2 * i4) + i;
            int i6 = 0;
            while (i6 < 8) {
                for (int i7 = 0; i7 < 8; i7++) {
                    if ((bArr[i5 + i7] & 255) <= i3) {
                        bitMatrix.set(i + i7, i2 + i6);
                    }
                }
                i6++;
                i5 += i4;
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
                int i = width >> 3;
                if ((width & 7) != 0) {
                    i++;
                }
                int i2 = i;
                int i3 = height >> 3;
                if ((height & 7) != 0) {
                    i3++;
                }
                int i4 = i3;
                int[][] calculateBlackPoints = calculateBlackPoints(matrix, i2, i4, width, height);
                BitMatrix bitMatrix2 = new BitMatrix(width, height);
                calculateThresholdForBlock(matrix, i2, i4, width, height, calculateBlackPoints, bitMatrix2);
                this.matrix = bitMatrix2;
            } else {
                this.matrix = super.getBlackMatrix();
            }
            return this.matrix;
        }
        return (BitMatrix) invokeV.objValue;
    }
}
