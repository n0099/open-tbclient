package com.google.zxing.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
/* loaded from: classes7.dex */
public class GlobalHistogramBinarizer extends Binarizer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte[] EMPTY;
    public static final int LUMINANCE_BITS = 5;
    public static final int LUMINANCE_BUCKETS = 32;
    public static final int LUMINANCE_SHIFT = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] buckets;
    public byte[] luminances;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(978085129, "Lcom/google/zxing/common/GlobalHistogramBinarizer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(978085129, "Lcom/google/zxing/common/GlobalHistogramBinarizer;");
                return;
            }
        }
        EMPTY = new byte[0];
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalHistogramBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {luminanceSource};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((LuminanceSource) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.luminances = EMPTY;
        this.buckets = new int[32];
    }

    public static int estimateBlackPoint(int[] iArr) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iArr)) == null) {
            int length = iArr.length;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                if (iArr[i4] > i) {
                    i = iArr[i4];
                    i3 = i4;
                }
                if (iArr[i4] > i2) {
                    i2 = iArr[i4];
                }
            }
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = i7 - i3;
                int i9 = iArr[i7] * i8 * i8;
                if (i9 > i6) {
                    i5 = i7;
                    i6 = i9;
                }
            }
            if (i3 <= i5) {
                int i10 = i3;
                i3 = i5;
                i5 = i10;
            }
            if (i3 - i5 > length / 16) {
                int i11 = i3 - 1;
                int i12 = i11;
                int i13 = -1;
                while (i11 > i5) {
                    int i14 = i11 - i5;
                    int i15 = i14 * i14 * (i3 - i11) * (i2 - iArr[i11]);
                    if (i15 > i13) {
                        i12 = i11;
                        i13 = i15;
                    }
                    i11--;
                }
                return i12 << 3;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return invokeL.intValue;
    }

    private void initArrays(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
            if (this.luminances.length < i) {
                this.luminances = new byte[i];
            }
            for (int i2 = 0; i2 < 32; i2++) {
                this.buckets[i2] = 0;
            }
        }
    }

    @Override // com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, luminanceSource)) == null) ? new GlobalHistogramBinarizer(luminanceSource) : (Binarizer) invokeL.objValue;
    }

    @Override // com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LuminanceSource luminanceSource = getLuminanceSource();
            int width = luminanceSource.getWidth();
            int height = luminanceSource.getHeight();
            BitMatrix bitMatrix = new BitMatrix(width, height);
            initArrays(width);
            int[] iArr = this.buckets;
            for (int i = 1; i < 5; i++) {
                byte[] row = luminanceSource.getRow((height * i) / 5, this.luminances);
                int i2 = (width << 2) / 5;
                for (int i3 = width / 5; i3 < i2; i3++) {
                    int i4 = (row[i3] & 255) >> 3;
                    iArr[i4] = iArr[i4] + 1;
                }
            }
            int estimateBlackPoint = estimateBlackPoint(iArr);
            byte[] matrix = luminanceSource.getMatrix();
            for (int i5 = 0; i5 < height; i5++) {
                int i6 = i5 * width;
                for (int i7 = 0; i7 < width; i7++) {
                    if ((matrix[i6 + i7] & 255) < estimateBlackPoint) {
                        bitMatrix.set(i7, i5);
                    }
                }
            }
            return bitMatrix;
        }
        return (BitMatrix) invokeV.objValue;
    }

    @Override // com.google.zxing.Binarizer
    public BitArray getBlackRow(int i, BitArray bitArray) throws NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bitArray)) == null) {
            LuminanceSource luminanceSource = getLuminanceSource();
            int width = luminanceSource.getWidth();
            if (bitArray != null && bitArray.getSize() >= width) {
                bitArray.clear();
            } else {
                bitArray = new BitArray(width);
            }
            initArrays(width);
            byte[] row = luminanceSource.getRow(i, this.luminances);
            int[] iArr = this.buckets;
            for (int i2 = 0; i2 < width; i2++) {
                int i3 = (row[i2] & 255) >> 3;
                iArr[i3] = iArr[i3] + 1;
            }
            int estimateBlackPoint = estimateBlackPoint(iArr);
            if (width < 3) {
                for (int i4 = 0; i4 < width; i4++) {
                    if ((row[i4] & 255) < estimateBlackPoint) {
                        bitArray.set(i4);
                    }
                }
            } else {
                int i5 = row[1] & 255;
                int i6 = 1;
                int i7 = row[0] & 255;
                int i8 = i5;
                while (i6 < width - 1) {
                    int i9 = i6 + 1;
                    int i10 = row[i9] & 255;
                    if ((((i8 << 2) - i7) - i10) / 2 < estimateBlackPoint) {
                        bitArray.set(i6);
                    }
                    i7 = i8;
                    i6 = i9;
                    i8 = i10;
                }
            }
            return bitArray;
        }
        return (BitArray) invokeIL.objValue;
    }
}
