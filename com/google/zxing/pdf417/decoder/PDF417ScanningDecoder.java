package com.google.zxing.pdf417.decoder;

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
/* loaded from: classes10.dex */
public final class PDF417ScanningDecoder {
    public static final int CODEWORD_SKEW_SIZE = 2;
    public static final int MAX_EC_CODEWORDS = 512;
    public static final int MAX_ERRORS = 3;
    public static final ErrorCorrection errorCorrection = new ErrorCorrection();

    public static boolean checkCodewordSkew(int i, int i2, int i3) {
        return i2 + (-2) <= i && i <= i3 + 2;
    }

    public static int getNumberOfECCodeWords(int i) {
        return 2 << i;
    }

    public static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws NotFoundException {
        int[] rowHeights;
        if (detectionResultRowIndicatorColumn == null || (rowHeights = detectionResultRowIndicatorColumn.getRowHeights()) == null) {
            return null;
        }
        int max = getMax(rowHeights);
        int i = 0;
        int i2 = 0;
        for (int i3 : rowHeights) {
            i2 += max - i3;
            if (i3 > 0) {
                break;
            }
        }
        Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
        for (int i4 = 0; i2 > 0 && codewords[i4] == null; i4++) {
            i2--;
        }
        for (int length = rowHeights.length - 1; length >= 0; length--) {
            i += max - rowHeights[length];
            if (rowHeights[length] > 0) {
                break;
            }
        }
        for (int length2 = codewords.length - 1; i > 0 && codewords[length2] == null; length2--) {
            i--;
        }
        return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i2, i, detectionResultRowIndicatorColumn.isLeft());
    }

    public static void adjustCodewordCount(DetectionResult detectionResult, BarcodeValue[][] barcodeValueArr) throws NotFoundException {
        int[] value = barcodeValueArr[0][1].getValue();
        int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length == 0) {
            if (barcodeColumnCount > 0 && barcodeColumnCount <= 928) {
                barcodeValueArr[0][1].setValue(barcodeColumnCount);
                return;
            }
            throw NotFoundException.getNotFoundInstance();
        } else if (value[0] != barcodeColumnCount) {
            barcodeValueArr[0][1].setValue(barcodeColumnCount);
        }
    }

    public static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        BarcodeMetadata barcodeMetadata;
        BarcodeMetadata barcodeMetadata2;
        if (detectionResultRowIndicatorColumn != null && (barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata()) != null) {
            if (detectionResultRowIndicatorColumn2 != null && (barcodeMetadata2 = detectionResultRowIndicatorColumn2.getBarcodeMetadata()) != null && barcodeMetadata.getColumnCount() != barcodeMetadata2.getColumnCount() && barcodeMetadata.getErrorCorrectionLevel() != barcodeMetadata2.getErrorCorrectionLevel() && barcodeMetadata.getRowCount() != barcodeMetadata2.getRowCount()) {
                return null;
            }
            return barcodeMetadata;
        } else if (detectionResultRowIndicatorColumn2 == null) {
            return null;
        } else {
            return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0022, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0022, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0022, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int adjustCodewordStartColumn(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int i5;
        if (z) {
            i5 = -1;
        } else {
            i5 = 1;
        }
        int i6 = i3;
        for (int i7 = 0; i7 < 2; i7++) {
            while (true) {
                if (z) {
                    if (i6 < i) {
                        break;
                    }
                    if (z != bitMatrix.get(i6, i4)) {
                        if (Math.abs(i3 - i6) > 2) {
                            return i3;
                        }
                        i6 += i5;
                    }
                } else {
                    if (i6 >= i2) {
                        break;
                    }
                    if (z != bitMatrix.get(i6, i4)) {
                        break;
                    }
                }
            }
            i5 = -i5;
            z = !z;
        }
        return i6;
    }

    public static int correctErrors(int[] iArr, int[] iArr2, int i) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return errorCorrection.decode(iArr, i, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    public static DecoderResult decodeCodewords(int[] iArr, int i, int[] iArr2) throws FormatException, ChecksumException {
        if (iArr.length != 0) {
            int i2 = 1 << (i + 1);
            int correctErrors = correctErrors(iArr, iArr2, i2);
            verifyCodewordCount(iArr, i2);
            DecoderResult decode = DecodedBitStreamParser.decode(iArr, String.valueOf(i));
            decode.setErrorsCorrected(Integer.valueOf(correctErrors));
            decode.setErasures(Integer.valueOf(iArr2.length));
            return decode;
        }
        throw FormatException.getFormatInstance();
    }

    public static BarcodeValue[][] createBarcodeMatrix(DetectionResult detectionResult) {
        DetectionResultColumn[] detectionResultColumns;
        Codeword[] codewords;
        int rowNumber;
        BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance(BarcodeValue.class, detectionResult.getBarcodeRowCount(), detectionResult.getBarcodeColumnCount() + 2);
        for (int i = 0; i < barcodeValueArr.length; i++) {
            for (int i2 = 0; i2 < barcodeValueArr[i].length; i2++) {
                barcodeValueArr[i][i2] = new BarcodeValue();
            }
        }
        int i3 = 0;
        for (DetectionResultColumn detectionResultColumn : detectionResult.getDetectionResultColumns()) {
            if (detectionResultColumn != null) {
                for (Codeword codeword : detectionResultColumn.getCodewords()) {
                    if (codeword != null && (rowNumber = codeword.getRowNumber()) >= 0 && rowNumber < barcodeValueArr.length) {
                        barcodeValueArr[rowNumber][i3].setValue(codeword.getValue());
                    }
                }
            }
            i3++;
        }
        return barcodeValueArr;
    }

    public static DecoderResult createDecoderResult(DetectionResult detectionResult) throws FormatException, ChecksumException, NotFoundException {
        BarcodeValue[][] createBarcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, createBarcodeMatrix);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < detectionResult.getBarcodeRowCount(); i++) {
            int i2 = 0;
            while (i2 < detectionResult.getBarcodeColumnCount()) {
                int i3 = i2 + 1;
                int[] value = createBarcodeMatrix[i][i3].getValue();
                int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i) + i2;
                if (value.length == 0) {
                    arrayList.add(Integer.valueOf(barcodeColumnCount));
                } else if (value.length == 1) {
                    iArr[barcodeColumnCount] = value[0];
                } else {
                    arrayList3.add(Integer.valueOf(barcodeColumnCount));
                    arrayList2.add(value);
                }
                i2 = i3;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), iArr2);
    }

    public static String toString(BarcodeValue[][] barcodeValueArr) {
        Formatter formatter = new Formatter();
        for (int i = 0; i < barcodeValueArr.length; i++) {
            formatter.format("Row %2d: ", Integer.valueOf(i));
            for (int i2 = 0; i2 < barcodeValueArr[i].length; i2++) {
                BarcodeValue barcodeValue = barcodeValueArr[i][i2];
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

    public static DecoderResult createDecoderResultFromAmbiguousValues(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
                }
                try {
                    return decodeCodewords(iArr, i, iArr2);
                } catch (ChecksumException unused) {
                    if (length != 0) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length) {
                                break;
                            } else if (iArr5[i5] < iArr4[i5].length - 1) {
                                iArr5[i5] = iArr5[i5] + 1;
                                break;
                            } else {
                                iArr5[i5] = 0;
                                if (i5 != length - 1) {
                                    i5++;
                                } else {
                                    throw ChecksumException.getChecksumInstance();
                                }
                            }
                        }
                        i2 = i3;
                    } else {
                        throw ChecksumException.getChecksumInstance();
                    }
                }
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    public static DecoderResult decode(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException, FormatException, ChecksumException {
        boolean z;
        int i3;
        DetectionResultColumn detectionResultRowIndicatorColumn;
        boolean z2;
        int i4;
        int i5;
        int i6;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2 = null;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn3 = null;
        DetectionResult detectionResult = null;
        BoundingBox boundingBox = new BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        for (int i7 = 0; i7 < 2; i7++) {
            if (resultPoint != null) {
                detectionResultRowIndicatorColumn2 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint, true, i, i2);
            }
            if (resultPoint3 != null) {
                detectionResultRowIndicatorColumn3 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint3, false, i, i2);
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
        if (detectionResultRowIndicatorColumn2 != null) {
            z = true;
        } else {
            z = false;
        }
        int i8 = i;
        int i9 = i2;
        for (int i10 = 1; i10 <= barcodeColumnCount; i10++) {
            if (z) {
                i3 = i10;
            } else {
                i3 = barcodeColumnCount - i10;
            }
            if (detectionResult.getDetectionResultColumn(i3) == null) {
                if (i3 != 0 && i3 != barcodeColumnCount) {
                    detectionResultRowIndicatorColumn = new DetectionResultColumn(boundingBox);
                } else {
                    if (i3 == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z2);
                }
                detectionResult.setDetectionResultColumn(i3, detectionResultRowIndicatorColumn);
                int i11 = -1;
                int minY = boundingBox.getMinY();
                int i12 = -1;
                while (minY <= boundingBox.getMaxY()) {
                    int startColumn = getStartColumn(detectionResult, i3, minY, z);
                    if (startColumn >= 0 && startColumn <= boundingBox.getMaxX()) {
                        i6 = startColumn;
                    } else if (i12 != i11) {
                        i6 = i12;
                    } else {
                        i4 = i12;
                        i5 = minY;
                        i12 = i4;
                        minY = i5 + 1;
                        i11 = -1;
                    }
                    i4 = i12;
                    int i13 = minY;
                    Codeword detectCodeword = detectCodeword(bitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), z, i6, i13, i8, i9);
                    i5 = i13;
                    if (detectCodeword != null) {
                        detectionResultRowIndicatorColumn.setCodeword(i5, detectCodeword);
                        i8 = Math.min(i8, detectCodeword.getWidth());
                        i9 = Math.max(i9, detectCodeword.getWidth());
                        i12 = i6;
                        minY = i5 + 1;
                        i11 = -1;
                    }
                    i12 = i4;
                    minY = i5 + 1;
                    i11 = -1;
                }
            }
        }
        return createDecoderResult(detectionResult);
    }

    public static Codeword detectCodeword(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int decodedValue;
        int codeword;
        int adjustCodewordStartColumn = adjustCodewordStartColumn(bitMatrix, i, i2, z, i3, i4);
        int[] moduleBitCount = getModuleBitCount(bitMatrix, i, i2, z, adjustCodewordStartColumn, i4);
        if (moduleBitCount == null) {
            return null;
        }
        int sum = MathUtils.sum(moduleBitCount);
        if (z) {
            i7 = adjustCodewordStartColumn + sum;
        } else {
            for (int i8 = 0; i8 < moduleBitCount.length / 2; i8++) {
                int i9 = moduleBitCount[i8];
                moduleBitCount[i8] = moduleBitCount[(moduleBitCount.length - 1) - i8];
                moduleBitCount[(moduleBitCount.length - 1) - i8] = i9;
            }
            adjustCodewordStartColumn -= sum;
            i7 = adjustCodewordStartColumn;
        }
        if (!checkCodewordSkew(sum, i5, i6) || (codeword = PDF417Common.getCodeword((decodedValue = PDF417CodewordDecoder.getDecodedValue(moduleBitCount)))) == -1) {
            return null;
        }
        return new Codeword(adjustCodewordStartColumn, i7, getCodewordBucketNumber(decodedValue), codeword);
    }

    public static int[] getBitCountForCodeword(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 >= 0) {
                    i2 = i4;
                } else {
                    return iArr;
                }
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    public static int getCodewordBucketNumber(int i) {
        return getCodewordBucketNumber(getBitCountForCodeword(i));
    }

    public static int getMax(int[] iArr) {
        int i = -1;
        for (int i2 : iArr) {
            i = Math.max(i, i2);
        }
        return i;
    }

    public static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0027 A[EDGE_INSN: B:27:0x0027->B:16:0x0027 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] getModuleBitCount(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int i5;
        int[] iArr = new int[8];
        if (z) {
            i5 = 1;
        } else {
            i5 = -1;
        }
        int i6 = 0;
        boolean z2 = z;
        while (true) {
            if (z) {
                if (i3 >= i2) {
                    break;
                }
                if (i6 < 8) {
                    break;
                } else if (bitMatrix.get(i3, i4) == z2) {
                    iArr[i6] = iArr[i6] + 1;
                    i3 += i5;
                } else {
                    i6++;
                    z2 = !z2;
                }
            } else {
                if (i3 < i) {
                    break;
                }
                if (i6 < 8) {
                }
            }
        }
        if (i6 != 8) {
            if (z) {
                i = i2;
            }
            if (i3 != i || i6 != 7) {
                return null;
            }
        }
        return iArr;
    }

    public static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z, int i, int i2) {
        int i3;
        int endX;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z);
        for (int i4 = 0; i4 < 2; i4++) {
            if (i4 == 0) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            int x = (int) resultPoint.getX();
            for (int y = (int) resultPoint.getY(); y <= boundingBox.getMaxY() && y >= boundingBox.getMinY(); y += i3) {
                Codeword detectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z, x, y, i, i2);
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
        }
        return detectionResultRowIndicatorColumn;
    }

    public static int getStartColumn(DetectionResult detectionResult, int i, int i2, boolean z) {
        int i3;
        Codeword[] codewords;
        int startX;
        if (z) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        Codeword codeword = null;
        int i4 = i - i3;
        if (isValidBarcodeColumn(detectionResult, i4)) {
            codeword = detectionResult.getDetectionResultColumn(i4).getCodeword(i2);
        }
        if (codeword != null) {
            if (z) {
                return codeword.getEndX();
            }
            return codeword.getStartX();
        }
        Codeword codewordNearby = detectionResult.getDetectionResultColumn(i).getCodewordNearby(i2);
        if (codewordNearby != null) {
            if (z) {
                return codewordNearby.getStartX();
            }
            return codewordNearby.getEndX();
        }
        if (isValidBarcodeColumn(detectionResult, i4)) {
            codewordNearby = detectionResult.getDetectionResultColumn(i4).getCodewordNearby(i2);
        }
        if (codewordNearby != null) {
            if (z) {
                return codewordNearby.getEndX();
            }
            return codewordNearby.getStartX();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (isValidBarcodeColumn(detectionResult, i)) {
                for (Codeword codeword2 : detectionResult.getDetectionResultColumn(i).getCodewords()) {
                    if (codeword2 != null) {
                        if (z) {
                            startX = codeword2.getEndX();
                        } else {
                            startX = codeword2.getStartX();
                        }
                        return startX + (i3 * i5 * (codeword2.getEndX() - codeword2.getStartX()));
                    }
                }
                i5++;
            } else {
                BoundingBox boundingBox = detectionResult.getBoundingBox();
                if (z) {
                    return boundingBox.getMinX();
                }
                return boundingBox.getMaxX();
            }
        }
    }

    public static boolean isValidBarcodeColumn(DetectionResult detectionResult, int i) {
        if (i >= 0 && i <= detectionResult.getBarcodeColumnCount() + 1) {
            return true;
        }
        return false;
    }

    public static DetectionResult merge(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) throws NotFoundException {
        BarcodeMetadata barcodeMetadata;
        if ((detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) || (barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2)) == null) {
            return null;
        }
        return new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
    }

    public static void verifyCodewordCount(int[] iArr, int i) throws FormatException {
        if (iArr.length >= 4) {
            int i2 = iArr[0];
            if (i2 <= iArr.length) {
                if (i2 == 0) {
                    if (i < iArr.length) {
                        iArr[0] = iArr.length - i;
                        return;
                    }
                    throw FormatException.getFormatInstance();
                }
                return;
            }
            throw FormatException.getFormatInstance();
        }
        throw FormatException.getFormatInstance();
    }
}
