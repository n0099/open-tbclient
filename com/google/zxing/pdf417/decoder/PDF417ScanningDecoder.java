package com.google.zxing.pdf417.decoder;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;
/* loaded from: classes7.dex */
public final class PDF417ScanningDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CODEWORD_SKEW_SIZE = 2;
    public static final int MAX_EC_CODEWORDS = 512;
    public static final int MAX_ERRORS = 3;
    public static final ErrorCorrection errorCorrection;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-501168261, "Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-501168261, "Lcom/google/zxing/pdf417/decoder/PDF417ScanningDecoder;");
                return;
            }
        }
        errorCorrection = new ErrorCorrection();
    }

    public PDF417ScanningDecoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws NotFoundException {
        InterceptResult invokeL;
        int[] rowHeights;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, detectionResultRowIndicatorColumn)) == null) {
            if (detectionResultRowIndicatorColumn == null || (rowHeights = detectionResultRowIndicatorColumn.getRowHeights()) == null) {
                return null;
            }
            int max = getMax(rowHeights);
            int i2 = 0;
            int i3 = 0;
            for (int i4 : rowHeights) {
                i3 += max - i4;
                if (i4 > 0) {
                    break;
                }
            }
            Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
            for (int i5 = 0; i3 > 0 && codewords[i5] == null; i5++) {
                i3--;
            }
            for (int length = rowHeights.length - 1; length >= 0; length--) {
                i2 += max - rowHeights[length];
                if (rowHeights[length] > 0) {
                    break;
                }
            }
            for (int length2 = codewords.length - 1; i2 > 0 && codewords[length2] == null; length2--) {
                i2--;
            }
            return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i3, i2, detectionResultRowIndicatorColumn.isLeft());
        }
        return (BoundingBox) invokeL.objValue;
    }

    public static void adjustCodewordCount(DetectionResult detectionResult, BarcodeValue[][] barcodeValueArr) throws NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, detectionResult, barcodeValueArr) == null) {
            int[] value = barcodeValueArr[0][1].getValue();
            int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
            if (value.length != 0) {
                if (value[0] != barcodeColumnCount) {
                    barcodeValueArr[0][1].setValue(barcodeColumnCount);
                }
            } else if (barcodeColumnCount > 0 && barcodeColumnCount <= 928) {
                barcodeValueArr[0][1].setValue(barcodeColumnCount);
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0026, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0026, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0026, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int adjustCodewordStartColumn(BitMatrix bitMatrix, int i2, int i3, boolean z, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{bitMatrix, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            int i6 = z ? -1 : 1;
            int i7 = i4;
            for (int i8 = 0; i8 < 2; i8++) {
                while (true) {
                    if (z) {
                        if (i7 < i2) {
                            break;
                        }
                        if (z != bitMatrix.get(i7, i5)) {
                            if (Math.abs(i4 - i7) > 2) {
                                return i4;
                            }
                            i7 += i6;
                        }
                    } else {
                        if (i7 >= i3) {
                            break;
                        }
                        if (z != bitMatrix.get(i7, i5)) {
                            break;
                        }
                    }
                }
                i6 = -i6;
                z = !z;
            }
            return i7;
        }
        return invokeCommon.intValue;
    }

    public static boolean checkCodewordSkew(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(AdIconUtil.AD_TEXT_ID, null, i2, i3, i4)) == null) ? i3 + (-2) <= i2 && i2 <= i4 + 2 : invokeIII.booleanValue;
    }

    public static int correctErrors(int[] iArr, int[] iArr2, int i2) throws ChecksumException {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, iArr, iArr2, i2)) == null) {
            if ((iArr2 == null || iArr2.length <= (i2 / 2) + 3) && i2 >= 0 && i2 <= 512) {
                return errorCorrection.decode(iArr, i2, iArr2);
            }
            throw ChecksumException.getChecksumInstance();
        }
        return invokeLLI.intValue;
    }

    public static BarcodeValue[][] createBarcodeMatrix(DetectionResult detectionResult) {
        InterceptResult invokeL;
        DetectionResultColumn[] detectionResultColumns;
        Codeword[] codewords;
        int rowNumber;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, detectionResult)) == null) {
            BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance(BarcodeValue.class, detectionResult.getBarcodeRowCount(), detectionResult.getBarcodeColumnCount() + 2);
            for (int i2 = 0; i2 < barcodeValueArr.length; i2++) {
                for (int i3 = 0; i3 < barcodeValueArr[i2].length; i3++) {
                    barcodeValueArr[i2][i3] = new BarcodeValue();
                }
            }
            int i4 = 0;
            for (DetectionResultColumn detectionResultColumn : detectionResult.getDetectionResultColumns()) {
                if (detectionResultColumn != null) {
                    for (Codeword codeword : detectionResultColumn.getCodewords()) {
                        if (codeword != null && (rowNumber = codeword.getRowNumber()) >= 0 && rowNumber < barcodeValueArr.length) {
                            barcodeValueArr[rowNumber][i4].setValue(codeword.getValue());
                        }
                    }
                }
                i4++;
            }
            return barcodeValueArr;
        }
        return (BarcodeValue[][]) invokeL.objValue;
    }

    public static DecoderResult createDecoderResult(DetectionResult detectionResult) throws FormatException, ChecksumException, NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, detectionResult)) == null) {
            BarcodeValue[][] createBarcodeMatrix = createBarcodeMatrix(detectionResult);
            adjustCodewordCount(detectionResult, createBarcodeMatrix);
            ArrayList arrayList = new ArrayList();
            int[] iArr = new int[detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount()];
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i2 = 0; i2 < detectionResult.getBarcodeRowCount(); i2++) {
                int i3 = 0;
                while (i3 < detectionResult.getBarcodeColumnCount()) {
                    int i4 = i3 + 1;
                    int[] value = createBarcodeMatrix[i2][i4].getValue();
                    int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i2) + i3;
                    if (value.length == 0) {
                        arrayList.add(Integer.valueOf(barcodeColumnCount));
                    } else if (value.length == 1) {
                        iArr[barcodeColumnCount] = value[0];
                    } else {
                        arrayList3.add(Integer.valueOf(barcodeColumnCount));
                        arrayList2.add(value);
                    }
                    i3 = i4;
                }
            }
            int size = arrayList2.size();
            int[][] iArr2 = new int[size];
            for (int i5 = 0; i5 < size; i5++) {
                iArr2[i5] = (int[]) arrayList2.get(i5);
            }
            return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), iArr2);
        }
        return (DecoderResult) invokeL.objValue;
    }

    public static DecoderResult createDecoderResultFromAmbiguousValues(int i2, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Integer.valueOf(i2), iArr, iArr2, iArr3, iArr4})) != null) {
            return (DecoderResult) invokeCommon.objValue;
        }
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i3 = 100;
        while (true) {
            int i4 = i3 - 1;
            if (i3 > 0) {
                for (int i5 = 0; i5 < length; i5++) {
                    iArr[iArr3[i5]] = iArr4[i5][iArr5[i5]];
                }
                try {
                    return decodeCodewords(iArr, i2, iArr2);
                } catch (ChecksumException unused) {
                    if (length == 0) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        } else if (iArr5[i6] < iArr4[i6].length - 1) {
                            iArr5[i6] = iArr5[i6] + 1;
                            break;
                        } else {
                            iArr5[i6] = 0;
                            if (i6 == length - 1) {
                                throw ChecksumException.getChecksumInstance();
                            }
                            i6++;
                        }
                    }
                    i3 = i4;
                }
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    public static DecoderResult decode(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i2, int i3) throws NotFoundException, FormatException, ChecksumException {
        InterceptResult invokeCommon;
        DetectionResultColumn detectionResultRowIndicatorColumn;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2 = null;
            DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn3 = null;
            DetectionResult detectionResult = null;
            BoundingBox boundingBox = new BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
            for (int i7 = 0; i7 < 2; i7++) {
                if (resultPoint != null) {
                    detectionResultRowIndicatorColumn2 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint, true, i2, i3);
                }
                if (resultPoint3 != null) {
                    detectionResultRowIndicatorColumn3 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint3, false, i2, i3);
                }
                detectionResult = merge(detectionResultRowIndicatorColumn2, detectionResultRowIndicatorColumn3);
                if (detectionResult != null) {
                    if (i7 == 0 && detectionResult.getBoundingBox() != null && (detectionResult.getBoundingBox().getMinY() < boundingBox.getMinY() || detectionResult.getBoundingBox().getMaxY() > boundingBox.getMaxY())) {
                        boundingBox = detectionResult.getBoundingBox();
                    } else {
                        detectionResult.setBoundingBox(boundingBox);
                        break;
                    }
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            int barcodeColumnCount = detectionResult.getBarcodeColumnCount() + 1;
            detectionResult.setDetectionResultColumn(0, detectionResultRowIndicatorColumn2);
            detectionResult.setDetectionResultColumn(barcodeColumnCount, detectionResultRowIndicatorColumn3);
            boolean z = detectionResultRowIndicatorColumn2 != null;
            int i8 = i2;
            int i9 = i3;
            for (int i10 = 1; i10 <= barcodeColumnCount; i10++) {
                int i11 = z ? i10 : barcodeColumnCount - i10;
                if (detectionResult.getDetectionResultColumn(i11) == null) {
                    if (i11 != 0 && i11 != barcodeColumnCount) {
                        detectionResultRowIndicatorColumn = new DetectionResultColumn(boundingBox);
                    } else {
                        detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, i11 == 0);
                    }
                    detectionResult.setDetectionResultColumn(i11, detectionResultRowIndicatorColumn);
                    int i12 = -1;
                    int minY = boundingBox.getMinY();
                    int i13 = -1;
                    while (minY <= boundingBox.getMaxY()) {
                        int startColumn = getStartColumn(detectionResult, i11, minY, z);
                        if (startColumn >= 0 && startColumn <= boundingBox.getMaxX()) {
                            i6 = startColumn;
                        } else if (i13 != i12) {
                            i6 = i13;
                        } else {
                            i4 = i13;
                            i5 = minY;
                            i13 = i4;
                            minY = i5 + 1;
                            i12 = -1;
                        }
                        i4 = i13;
                        int i14 = minY;
                        Codeword detectCodeword = detectCodeword(bitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), z, i6, i14, i8, i9);
                        i5 = i14;
                        if (detectCodeword != null) {
                            detectionResultRowIndicatorColumn.setCodeword(i5, detectCodeword);
                            i8 = Math.min(i8, detectCodeword.getWidth());
                            i9 = Math.max(i9, detectCodeword.getWidth());
                            i13 = i6;
                            minY = i5 + 1;
                            i12 = -1;
                        }
                        i13 = i4;
                        minY = i5 + 1;
                        i12 = -1;
                    }
                }
            }
            return createDecoderResult(detectionResult);
        }
        return (DecoderResult) invokeCommon.objValue;
    }

    public static DecoderResult decodeCodewords(int[] iArr, int i2, int[] iArr2) throws FormatException, ChecksumException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65547, null, iArr, i2, iArr2)) == null) {
            if (iArr.length != 0) {
                int i3 = 1 << (i2 + 1);
                int correctErrors = correctErrors(iArr, iArr2, i3);
                verifyCodewordCount(iArr, i3);
                DecoderResult decode = DecodedBitStreamParser.decode(iArr, String.valueOf(i2));
                decode.setErrorsCorrected(Integer.valueOf(correctErrors));
                decode.setErasures(Integer.valueOf(iArr2.length));
                return decode;
            }
            throw FormatException.getFormatInstance();
        }
        return (DecoderResult) invokeLIL.objValue;
    }

    public static Codeword detectCodeword(BitMatrix bitMatrix, int i2, int i3, boolean z, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        int i8;
        int decodedValue;
        int codeword;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{bitMatrix, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            int adjustCodewordStartColumn = adjustCodewordStartColumn(bitMatrix, i2, i3, z, i4, i5);
            int[] moduleBitCount = getModuleBitCount(bitMatrix, i2, i3, z, adjustCodewordStartColumn, i5);
            if (moduleBitCount == null) {
                return null;
            }
            int sum = MathUtils.sum(moduleBitCount);
            if (z) {
                i8 = adjustCodewordStartColumn + sum;
            } else {
                for (int i9 = 0; i9 < moduleBitCount.length / 2; i9++) {
                    int i10 = moduleBitCount[i9];
                    moduleBitCount[i9] = moduleBitCount[(moduleBitCount.length - 1) - i9];
                    moduleBitCount[(moduleBitCount.length - 1) - i9] = i10;
                }
                adjustCodewordStartColumn -= sum;
                i8 = adjustCodewordStartColumn;
            }
            if (checkCodewordSkew(sum, i6, i7) && (codeword = PDF417Common.getCodeword((decodedValue = PDF417CodewordDecoder.getDecodedValue(moduleBitCount)))) != -1) {
                return new Codeword(adjustCodewordStartColumn, i8, getCodewordBucketNumber(decodedValue), codeword);
            }
            return null;
        }
        return (Codeword) invokeCommon.objValue;
    }

    public static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        InterceptResult invokeLL;
        BarcodeMetadata barcodeMetadata;
        BarcodeMetadata barcodeMetadata2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2)) == null) {
            if (detectionResultRowIndicatorColumn == null || (barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata()) == null) {
                if (detectionResultRowIndicatorColumn2 == null) {
                    return null;
                }
                return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
            } else if (detectionResultRowIndicatorColumn2 == null || (barcodeMetadata2 = detectionResultRowIndicatorColumn2.getBarcodeMetadata()) == null || barcodeMetadata.getColumnCount() == barcodeMetadata2.getColumnCount() || barcodeMetadata.getErrorCorrectionLevel() == barcodeMetadata2.getErrorCorrectionLevel() || barcodeMetadata.getRowCount() == barcodeMetadata2.getRowCount()) {
                return barcodeMetadata;
            } else {
                return null;
            }
        }
        return (BarcodeMetadata) invokeLL.objValue;
    }

    public static int[] getBitCountForCodeword(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65550, null, i2)) != null) {
            return (int[]) invokeI.objValue;
        }
        int[] iArr = new int[8];
        int i3 = 0;
        int i4 = 7;
        while (true) {
            int i5 = i2 & 1;
            if (i5 != i3) {
                i4--;
                if (i4 < 0) {
                    return iArr;
                }
                i3 = i5;
            }
            iArr[i4] = iArr[i4] + 1;
            i2 >>= 1;
        }
    }

    public static int getCodewordBucketNumber(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i2)) == null) ? getCodewordBucketNumber(getBitCountForCodeword(i2)) : invokeI.intValue;
    }

    public static int getMax(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, iArr)) == null) {
            int i2 = -1;
            for (int i3 : iArr) {
                i2 = Math.max(i2, i3);
            }
            return i2;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002b A[EDGE_INSN: B:34:0x002b->B:18:0x002b ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] getModuleBitCount(BitMatrix bitMatrix, int i2, int i3, boolean z, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{bitMatrix, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            int[] iArr = new int[8];
            int i6 = z ? 1 : -1;
            int i7 = 0;
            boolean z2 = z;
            while (true) {
                if (z) {
                    if (i4 >= i3) {
                        break;
                    }
                    if (i7 < 8) {
                        break;
                    } else if (bitMatrix.get(i4, i5) == z2) {
                        iArr[i7] = iArr[i7] + 1;
                        i4 += i6;
                    } else {
                        i7++;
                        z2 = !z2;
                    }
                } else {
                    if (i4 < i2) {
                        break;
                    }
                    if (i7 < 8) {
                    }
                }
            }
            if (i7 != 8) {
                if (z) {
                    i2 = i3;
                }
                if (i4 != i2 || i7 != 7) {
                    return null;
                }
            }
            return iArr;
        }
        return (int[]) invokeCommon.objValue;
    }

    public static int getNumberOfECCodeWords(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65555, null, i2)) == null) ? 2 << i2 : invokeI.intValue;
    }

    public static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        int endX;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{bitMatrix, boundingBox, resultPoint, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z);
            int i4 = 0;
            while (i4 < 2) {
                int i5 = i4 == 0 ? 1 : -1;
                int x = (int) resultPoint.getX();
                for (int y = (int) resultPoint.getY(); y <= boundingBox.getMaxY() && y >= boundingBox.getMinY(); y += i5) {
                    Codeword detectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z, x, y, i2, i3);
                    if (detectCodeword != null) {
                        detectionResultRowIndicatorColumn.setCodeword(y, detectCodeword);
                        if (z) {
                            endX = detectCodeword.getStartX();
                        } else {
                            endX = detectCodeword.getEndX();
                        }
                        x = endX;
                    }
                }
                i4++;
            }
            return detectionResultRowIndicatorColumn;
        }
        return (DetectionResultRowIndicatorColumn) invokeCommon.objValue;
    }

    public static int getStartColumn(DetectionResult detectionResult, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Codeword[] codewords;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{detectionResult, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) != null) {
            return invokeCommon.intValue;
        }
        int i4 = z ? 1 : -1;
        int i5 = i2 - i4;
        Codeword codeword = isValidBarcodeColumn(detectionResult, i5) ? detectionResult.getDetectionResultColumn(i5).getCodeword(i3) : null;
        if (codeword != null) {
            return z ? codeword.getEndX() : codeword.getStartX();
        }
        Codeword codewordNearby = detectionResult.getDetectionResultColumn(i2).getCodewordNearby(i3);
        if (codewordNearby != null) {
            return z ? codewordNearby.getStartX() : codewordNearby.getEndX();
        }
        if (isValidBarcodeColumn(detectionResult, i5)) {
            codewordNearby = detectionResult.getDetectionResultColumn(i5).getCodewordNearby(i3);
        }
        if (codewordNearby != null) {
            return z ? codewordNearby.getEndX() : codewordNearby.getStartX();
        }
        int i6 = 0;
        while (true) {
            i2 -= i4;
            if (isValidBarcodeColumn(detectionResult, i2)) {
                for (Codeword codeword2 : detectionResult.getDetectionResultColumn(i2).getCodewords()) {
                    if (codeword2 != null) {
                        return (z ? codeword2.getEndX() : codeword2.getStartX()) + (i4 * i6 * (codeword2.getEndX() - codeword2.getStartX()));
                    }
                }
                i6++;
            } else {
                BoundingBox boundingBox = detectionResult.getBoundingBox();
                return z ? boundingBox.getMinX() : boundingBox.getMaxX();
            }
        }
    }

    public static boolean isValidBarcodeColumn(DetectionResult detectionResult, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, detectionResult, i2)) == null) ? i2 >= 0 && i2 <= detectionResult.getBarcodeColumnCount() + 1 : invokeLI.booleanValue;
    }

    public static DetectionResult merge(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) throws NotFoundException {
        InterceptResult invokeLL;
        BarcodeMetadata barcodeMetadata;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2)) == null) {
            if ((detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) || (barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2)) == null) {
                return null;
            }
            return new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
        }
        return (DetectionResult) invokeLL.objValue;
    }

    public static String toString(BarcodeValue[][] barcodeValueArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, barcodeValueArr)) == null) {
            Formatter formatter = new Formatter();
            for (int i2 = 0; i2 < barcodeValueArr.length; i2++) {
                formatter.format("Row %2d: ", Integer.valueOf(i2));
                for (int i3 = 0; i3 < barcodeValueArr[i2].length; i3++) {
                    BarcodeValue barcodeValue = barcodeValueArr[i2][i3];
                    if (barcodeValue.getValue().length == 0) {
                        formatter.format("        ", null);
                    } else {
                        formatter.format("%4d(%2d)", Integer.valueOf(barcodeValue.getValue()[0]), barcodeValue.getConfidence(barcodeValue.getValue()[0]));
                    }
                }
                formatter.format("%n", new Object[0]);
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        }
        return (String) invokeL.objValue;
    }

    public static void verifyCodewordCount(int[] iArr, int i2) throws FormatException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65561, null, iArr, i2) == null) {
            if (iArr.length >= 4) {
                int i3 = iArr[0];
                if (i3 > iArr.length) {
                    throw FormatException.getFormatInstance();
                }
                if (i3 == 0) {
                    if (i2 < iArr.length) {
                        iArr[0] = iArr.length - i2;
                        return;
                    }
                    throw FormatException.getFormatInstance();
                }
                return;
            }
            throw FormatException.getFormatInstance();
        }
    }

    public static int getCodewordBucketNumber(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, iArr)) == null) ? ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9 : invokeL.intValue;
    }
}
