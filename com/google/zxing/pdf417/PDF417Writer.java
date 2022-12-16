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
/* loaded from: classes8.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static BitMatrix bitMatrixFromEncoder(PDF417 pdf417, String str, int i, int i2, int i3, int i4) throws WriterException {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{pdf417, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            pdf417.generateBarcodeLogic(str, i);
            byte[][] scaledMatrix = pdf417.getBarcodeMatrix().getScaledMatrix(1, 4);
            if (i3 > i2) {
                z = true;
            } else {
                z = false;
            }
            if (scaledMatrix[0].length < scaledMatrix.length) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z ^ z2) {
                scaledMatrix = rotateArray(scaledMatrix);
                z3 = true;
            } else {
                z3 = false;
            }
            int length = i2 / scaledMatrix[0].length;
            int length2 = i3 / scaledMatrix.length;
            if (length >= length2) {
                length = length2;
            }
            if (length > 1) {
                byte[][] scaledMatrix2 = pdf417.getBarcodeMatrix().getScaledMatrix(length, length << 2);
                if (z3) {
                    scaledMatrix2 = rotateArray(scaledMatrix2);
                }
                return bitMatrixFrombitArray(scaledMatrix2, i4);
            }
            return bitMatrixFrombitArray(scaledMatrix, i4);
        }
        return (BitMatrix) invokeCommon.objValue;
    }

    public static BitMatrix bitMatrixFrombitArray(byte[][] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bArr, i)) == null) {
            int i2 = i * 2;
            BitMatrix bitMatrix = new BitMatrix(bArr[0].length + i2, bArr.length + i2);
            bitMatrix.clear();
            int height = (bitMatrix.getHeight() - i) - 1;
            int i3 = 0;
            while (i3 < bArr.length) {
                for (int i4 = 0; i4 < bArr[0].length; i4++) {
                    if (bArr[i3][i4] == 1) {
                        bitMatrix.set(i4 + i, height);
                    }
                }
                i3++;
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
            for (int i = 0; i < bArr.length; i++) {
                int length = (bArr.length - i) - 1;
                for (int i2 = 0; i2 < bArr[0].length; i2++) {
                    bArr2[i2][length] = bArr[i][i2];
                }
            }
            return bArr2;
        }
        return (byte[][]) invokeL.objValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, str, barcodeFormat, i, i2)) == null) {
            return encode(str, barcodeFormat, i, i2, null);
        }
        return (BitMatrix) invokeLLII.objValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, barcodeFormat, Integer.valueOf(i), Integer.valueOf(i2), map})) == null) {
            if (barcodeFormat == BarcodeFormat.PDF_417) {
                PDF417 pdf417 = new PDF417();
                int i5 = 30;
                int i6 = 2;
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
                    if (map.containsKey(EncodeHintType.MARGIN)) {
                        i5 = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
                    }
                    if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                        i6 = Integer.parseInt(map.get(EncodeHintType.ERROR_CORRECTION).toString());
                    }
                    if (map.containsKey(EncodeHintType.CHARACTER_SET)) {
                        pdf417.setEncoding(Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString()));
                    }
                    i4 = i5;
                    i3 = i6;
                } else {
                    i3 = 2;
                    i4 = 30;
                }
                return bitMatrixFromEncoder(pdf417, str, i3, i, i2, i4);
            }
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
        }
        return (BitMatrix) invokeCommon.objValue;
    }
}
