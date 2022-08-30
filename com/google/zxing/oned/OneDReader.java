package com.google.zxing.oned;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class OneDReader implements Reader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OneDReader() {
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

    private Result doDecode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        InterceptResult invokeLL;
        Map<DecodeHintType, ?> map2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, binaryBitmap, map)) == null) {
            EnumMap enumMap = map;
            int width = binaryBitmap.getWidth();
            int height = binaryBitmap.getHeight();
            BitArray bitArray = new BitArray(width);
            int i2 = height >> 1;
            char c = 0;
            int i3 = 1;
            boolean z = enumMap != null && enumMap.containsKey(DecodeHintType.TRY_HARDER);
            int max = Math.max(1, height >> (z ? 8 : 5));
            int i4 = z ? height : 15;
            int i5 = 0;
            while (i5 < i4) {
                int i6 = i5 + 1;
                int i7 = i6 / 2;
                if (!((i5 & 1) == 0)) {
                    i7 = -i7;
                }
                int i8 = (i7 * max) + i2;
                if (i8 < 0 || i8 >= height) {
                    break;
                }
                try {
                    bitArray = binaryBitmap.getBlackRow(i8, bitArray);
                    int i9 = 0;
                    while (i9 < 2) {
                        if (i9 == i3) {
                            bitArray.reverse();
                            if (enumMap != null && enumMap.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                                EnumMap enumMap2 = new EnumMap(DecodeHintType.class);
                                enumMap2.putAll(enumMap);
                                enumMap2.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                                enumMap = enumMap2;
                            }
                        }
                        try {
                            Result decodeRow = decodeRow(i8, bitArray, enumMap);
                            if (i9 == i3) {
                                decodeRow.putMetadata(ResultMetadataType.ORIENTATION, 180);
                                ResultPoint[] resultPoints = decodeRow.getResultPoints();
                                if (resultPoints != null) {
                                    map2 = enumMap;
                                    float f = width;
                                    try {
                                        i = width;
                                    } catch (ReaderException unused) {
                                        i = width;
                                        i9++;
                                        enumMap = map2;
                                        width = i;
                                        c = 0;
                                        i3 = 1;
                                    }
                                    try {
                                        resultPoints[0] = new ResultPoint((f - resultPoints[c].getX()) - 1.0f, resultPoints[c].getY());
                                        try {
                                            resultPoints[1] = new ResultPoint((f - resultPoints[1].getX()) - 1.0f, resultPoints[1].getY());
                                        } catch (ReaderException unused2) {
                                            continue;
                                            i9++;
                                            enumMap = map2;
                                            width = i;
                                            c = 0;
                                            i3 = 1;
                                        }
                                    } catch (ReaderException unused3) {
                                        i9++;
                                        enumMap = map2;
                                        width = i;
                                        c = 0;
                                        i3 = 1;
                                    }
                                }
                            }
                            return decodeRow;
                        } catch (ReaderException unused4) {
                            map2 = enumMap;
                        }
                    }
                    continue;
                } catch (NotFoundException unused5) {
                }
                i5 = i6;
                width = width;
                c = 0;
                i3 = 1;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (Result) invokeLL.objValue;
    }

    public static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{iArr, iArr2, Float.valueOf(f)})) == null) {
            int length = iArr.length;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i += iArr[i3];
                i2 += iArr2[i3];
            }
            if (i < i2) {
                return Float.POSITIVE_INFINITY;
            }
            float f2 = i;
            float f3 = f2 / i2;
            float f4 = f * f3;
            float f5 = 0.0f;
            for (int i4 = 0; i4 < length; i4++) {
                float f6 = iArr2[i4] * f3;
                float f7 = iArr[i4];
                float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
                if (f8 > f4) {
                    return Float.POSITIVE_INFINITY;
                }
                f5 += f8;
            }
            return f5 / f2;
        }
        return invokeCommon.floatValue;
    }

    public static void recordPattern(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65539, null, bitArray, i, iArr) == null) {
            int length = iArr.length;
            int i2 = 0;
            Arrays.fill(iArr, 0, length, 0);
            int size = bitArray.getSize();
            if (i < size) {
                boolean z = !bitArray.get(i);
                while (i < size) {
                    if (!(bitArray.get(i) ^ z)) {
                        i2++;
                        if (i2 == length) {
                            break;
                        }
                        iArr[i2] = 1;
                        z = !z;
                    } else {
                        iArr[i2] = iArr[i2] + 1;
                    }
                    i++;
                }
                if (i2 != length) {
                    if (i2 != length - 1 || i != size) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    return;
                }
                return;
            }
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public static void recordPatternInReverse(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, bitArray, i, iArr) == null) {
            int length = iArr.length;
            boolean z = bitArray.get(i);
            while (i > 0 && length >= 0) {
                i--;
                if (bitArray.get(i) != z) {
                    length--;
                    z = !z;
                }
            }
            if (length < 0) {
                recordPattern(bitArray, i + 1, iArr);
                return;
            }
            throw NotFoundException.getNotFoundInstance();
        }
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, binaryBitmap)) == null) ? decode(binaryBitmap, null) : (Result) invokeL.objValue;
    }

    public abstract Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    @Override // com.google.zxing.Reader
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, binaryBitmap, map)) == null) {
            try {
                return doDecode(binaryBitmap, map);
            } catch (NotFoundException e) {
                if ((map != null && map.containsKey(DecodeHintType.TRY_HARDER)) && binaryBitmap.isRotateSupported()) {
                    BinaryBitmap rotateCounterClockwise = binaryBitmap.rotateCounterClockwise();
                    Result doDecode = doDecode(rotateCounterClockwise, map);
                    Map<ResultMetadataType, Object> resultMetadata = doDecode.getResultMetadata();
                    int i = 270;
                    if (resultMetadata != null && resultMetadata.containsKey(ResultMetadataType.ORIENTATION)) {
                        i = (((Integer) resultMetadata.get(ResultMetadataType.ORIENTATION)).intValue() + 270) % 360;
                    }
                    doDecode.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(i));
                    ResultPoint[] resultPoints = doDecode.getResultPoints();
                    if (resultPoints != null) {
                        int height = rotateCounterClockwise.getHeight();
                        for (int i2 = 0; i2 < resultPoints.length; i2++) {
                            resultPoints[i2] = new ResultPoint((height - resultPoints[i2].getY()) - 1.0f, resultPoints[i2].getX());
                        }
                    }
                    return doDecode;
                }
                throw e;
            }
        }
        return (Result) invokeLL.objValue;
    }
}
