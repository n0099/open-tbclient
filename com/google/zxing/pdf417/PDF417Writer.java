package com.google.zxing.pdf417;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.Dimensions;
import com.google.zxing.pdf417.encoder.PDF417;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;
/* loaded from: classes2.dex */
public final class PDF417Writer implements Writer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_ERROR_CORRECTION_LEVEL = 2;
    public static final int WHITE_SPACE = 30;
    public transient /* synthetic */ FieldHolder $fh;

    public PDF417Writer() {
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

    public static BitMatrix bitMatrixFromEncoder(PDF417 pdf417, String str, int i2, int i3, int i4, int i5) throws WriterException {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{pdf417, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            pdf417.generateBarcodeLogic(str, i2);
            byte[][] scaledMatrix = pdf417.getBarcodeMatrix().getScaledMatrix(1, 4);
            if ((i4 > i3) ^ (scaledMatrix[0].length < scaledMatrix.length)) {
                scaledMatrix = rotateArray(scaledMatrix);
                z = true;
            } else {
                z = false;
            }
            int length = i3 / scaledMatrix[0].length;
            int length2 = i4 / scaledMatrix.length;
            if (length >= length2) {
                length = length2;
            }
            if (length > 1) {
                byte[][] scaledMatrix2 = pdf417.getBarcodeMatrix().getScaledMatrix(length, length << 2);
                if (z) {
                    scaledMatrix2 = rotateArray(scaledMatrix2);
                }
                return bitMatrixFrombitArray(scaledMatrix2, i5);
            }
            return bitMatrixFrombitArray(scaledMatrix, i5);
        }
        return (BitMatrix) invokeCommon.objValue;
    }

    public static BitMatrix bitMatrixFrombitArray(byte[][] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bArr, i2)) == null) {
            int i3 = i2 * 2;
            BitMatrix bitMatrix = new BitMatrix(bArr[0].length + i3, bArr.length + i3);
            bitMatrix.clear();
            int height = (bitMatrix.getHeight() - i2) - 1;
            int i4 = 0;
            while (i4 < bArr.length) {
                for (int i5 = 0; i5 < bArr[0].length; i5++) {
                    if (bArr[i4][i5] == 1) {
                        bitMatrix.set(i5 + i2, height);
                    }
                }
                i4++;
                height--;
            }
            return bitMatrix;
        }
        return (BitMatrix) invokeLI.objValue;
    }

    public static byte[][] rotateArray(byte[][] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, bArr[0].length, bArr.length);
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int length = (bArr.length - i2) - 1;
                for (int i3 = 0; i3 < bArr[0].length; i3++) {
                    bArr2[i3][length] = bArr[i2][i3];
                }
            }
            return bArr2;
        }
        return (byte[][]) invokeL.objValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        InterceptResult invokeCommon;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, barcodeFormat, Integer.valueOf(i2), Integer.valueOf(i3), map})) == null) {
            if (barcodeFormat == BarcodeFormat.PDF_417) {
                PDF417 pdf417 = new PDF417();
                if (map != null) {
                    if (map.containsKey(EncodeHintType.PDF417_COMPACT)) {
                        pdf417.setCompact(Boolean.valueOf(map.get(EncodeHintType.PDF417_COMPACT).toString()).booleanValue());
                    }
                    if (map.containsKey(EncodeHintType.PDF417_COMPACTION)) {
                        pdf417.setCompaction(Compaction.valueOf(map.get(EncodeHintType.PDF417_COMPACTION).toString()));
                    }
                    if (map.containsKey(EncodeHintType.PDF417_DIMENSIONS)) {
                        Dimensions dimensions = (Dimensions) map.get(EncodeHintType.PDF417_DIMENSIONS);
                        pdf417.setDimensions(dimensions.getMaxCols(), dimensions.getMinCols(), dimensions.getMaxRows(), dimensions.getMinRows());
                    }
                    int parseInt = map.containsKey(EncodeHintType.MARGIN) ? Integer.parseInt(map.get(EncodeHintType.MARGIN).toString()) : 30;
                    int parseInt2 = map.containsKey(EncodeHintType.ERROR_CORRECTION) ? Integer.parseInt(map.get(EncodeHintType.ERROR_CORRECTION).toString()) : 2;
                    if (map.containsKey(EncodeHintType.CHARACTER_SET)) {
                        pdf417.setEncoding(Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString()));
                    }
                    i5 = parseInt;
                    i4 = parseInt2;
                } else {
                    i4 = 2;
                    i5 = 30;
                }
                return bitMatrixFromEncoder(pdf417, str, i4, i2, i3, i5);
            }
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
        }
        return (BitMatrix) invokeCommon.objValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, str, barcodeFormat, i2, i3)) == null) ? encode(str, barcodeFormat, i2, i3, null) : (BitMatrix) invokeLLII.objValue;
    }
}
