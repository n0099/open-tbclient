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
/* loaded from: classes8.dex */
public final class PDF417ScanningDecoder {
    private static final int CODEWORD_SKEW_SIZE = 2;
    private static final int MAX_EC_CODEWORDS = 512;
    private static final int MAX_ERRORS = 3;
    private static final ErrorCorrection errorCorrection = new ErrorCorrection();

    private PDF417ScanningDecoder() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
        r14 = r0.getBarcodeColumnCount() + 1;
        r0.setDetectionResultColumn(0, r2);
        r0.setDetectionResultColumn(r14, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0083, code lost:
        if (r2 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0085, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0086, code lost:
        r11 = 1;
        r9 = r21;
        r8 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008b, code lost:
        if (r11 > r14) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008d, code lost:
        if (r5 == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008f, code lost:
        r10 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0094, code lost:
        if (r0.getDetectionResultColumn(r10) != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0096, code lost:
        if (r10 == 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0098, code lost:
        if (r10 != r14) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
        if (r10 != 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009e, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009f, code lost:
        r12 = new com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn(r1, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a3, code lost:
        r0.setDetectionResultColumn(r10, r12);
        r2 = -1;
        r7 = r1.getMinY();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ac, code lost:
        r13 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b0, code lost:
        if (r7 > r1.getMaxY()) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b2, code lost:
        r6 = getStartColumn(r0, r10, r7, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b6, code lost:
        if (r6 < 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bc, code lost:
        if (r6 <= r1.getMaxX()) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00bf, code lost:
        if (r13 == (-1)) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c1, code lost:
        r6 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c2, code lost:
        r2 = detectCodeword(r15, r1.getMinX(), r1.getMaxX(), r5, r6, r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00cf, code lost:
        if (r2 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d1, code lost:
        r12.setCodeword(r7, r2);
        r8 = java.lang.Math.min(r8, r2.getWidth());
        r9 = java.lang.Math.max(r9, r2.getWidth());
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e5, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e9, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00eb, code lost:
        r10 = r14 - r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ef, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f1, code lost:
        r12 = new com.google.zxing.pdf417.decoder.DetectionResultColumn(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f8, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ff, code lost:
        return createDecoderResult(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0100, code lost:
        r2 = r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DecoderResult decode(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException, FormatException, ChecksumException {
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = null;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2 = null;
        int i3 = 0;
        BoundingBox boundingBox = new BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        DetectionResult detectionResult = null;
        while (true) {
            DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn3 = detectionResultRowIndicatorColumn;
            if (i3 >= 2) {
                break;
            }
            detectionResultRowIndicatorColumn = resultPoint != null ? getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint, true, i, i2) : detectionResultRowIndicatorColumn3;
            DetectionResultRowIndicatorColumn rowIndicatorColumn = resultPoint3 != null ? getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint3, false, i, i2) : detectionResultRowIndicatorColumn2;
            DetectionResult merge = merge(detectionResultRowIndicatorColumn, rowIndicatorColumn);
            if (merge == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i3 != 0 || merge.getBoundingBox() == null || (merge.getBoundingBox().getMinY() >= boundingBox.getMinY() && merge.getBoundingBox().getMaxY() <= boundingBox.getMaxY())) {
                break;
            }
            i3++;
            detectionResultRowIndicatorColumn2 = rowIndicatorColumn;
            detectionResult = merge;
            boundingBox = merge.getBoundingBox();
        }
    }

    private static DetectionResult merge(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) throws NotFoundException {
        BarcodeMetadata barcodeMetadata;
        if ((detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) || (barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2)) == null) {
            return null;
        }
        return new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
    }

    private static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws NotFoundException {
        int[] rowHeights;
        if (detectionResultRowIndicatorColumn == null || (rowHeights = detectionResultRowIndicatorColumn.getRowHeights()) == null) {
            return null;
        }
        int max = getMax(rowHeights);
        int i = 0;
        for (int i2 : rowHeights) {
            i += max - i2;
            if (i2 > 0) {
                break;
            }
        }
        Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
        int i3 = i;
        for (int i4 = 0; i3 > 0 && codewords[i4] == null; i4++) {
            i3--;
        }
        int i5 = 0;
        for (int length = rowHeights.length - 1; length >= 0; length--) {
            i5 += max - rowHeights[length];
            if (rowHeights[length] > 0) {
                break;
            }
        }
        int i6 = i5;
        for (int length2 = codewords.length - 1; i6 > 0 && codewords[length2] == null; length2--) {
            i6--;
        }
        return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i3, i6, detectionResultRowIndicatorColumn.isLeft());
    }

    private static int getMax(int[] iArr) {
        int i = -1;
        for (int i2 : iArr) {
            i = Math.max(i, i2);
        }
        return i;
    }

    private static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        BarcodeMetadata barcodeMetadata;
        BarcodeMetadata barcodeMetadata2;
        if (detectionResultRowIndicatorColumn == null || (barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata()) == null) {
            if (detectionResultRowIndicatorColumn2 == null) {
                return null;
            }
            return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
        } else if (detectionResultRowIndicatorColumn2 == null || (barcodeMetadata2 = detectionResultRowIndicatorColumn2.getBarcodeMetadata()) == null) {
            return barcodeMetadata;
        } else {
            if (barcodeMetadata.getColumnCount() == barcodeMetadata2.getColumnCount() || barcodeMetadata.getErrorCorrectionLevel() == barcodeMetadata2.getErrorCorrectionLevel() || barcodeMetadata.getRowCount() == barcodeMetadata2.getRowCount()) {
                return barcodeMetadata;
            }
            return null;
        }
    }

    private static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z, int i, int i2) {
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < 2) {
                int i5 = i4 == 0 ? 1 : -1;
                int x = (int) resultPoint.getX();
                for (int y = (int) resultPoint.getY(); y <= boundingBox.getMaxY() && y >= boundingBox.getMinY(); y += i5) {
                    Codeword detectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z, x, y, i, i2);
                    if (detectCodeword != null) {
                        detectionResultRowIndicatorColumn.setCodeword(y, detectCodeword);
                        if (z) {
                            x = detectCodeword.getStartX();
                        } else {
                            x = detectCodeword.getEndX();
                        }
                    }
                }
                i3 = i4 + 1;
            } else {
                return detectionResultRowIndicatorColumn;
            }
        }
    }

    private static void adjustCodewordCount(DetectionResult detectionResult, BarcodeValue[][] barcodeValueArr) throws NotFoundException {
        int[] value = barcodeValueArr[0][1].getValue();
        int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length == 0) {
            if (barcodeColumnCount <= 0 || barcodeColumnCount > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            barcodeValueArr[0][1].setValue(barcodeColumnCount);
        } else if (value[0] != barcodeColumnCount) {
            barcodeValueArr[0][1].setValue(barcodeColumnCount);
        }
    }

    private static DecoderResult createDecoderResult(DetectionResult detectionResult) throws FormatException, ChecksumException, NotFoundException {
        BarcodeValue[][] createBarcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, createBarcodeMatrix);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < detectionResult.getBarcodeRowCount(); i++) {
            for (int i2 = 0; i2 < detectionResult.getBarcodeColumnCount(); i2++) {
                int[] value = createBarcodeMatrix[i][i2 + 1].getValue();
                int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i) + i2;
                if (value.length == 0) {
                    arrayList.add(Integer.valueOf(barcodeColumnCount));
                } else if (value.length == 1) {
                    iArr[barcodeColumnCount] = value[0];
                } else {
                    arrayList3.add(Integer.valueOf(barcodeColumnCount));
                    arrayList2.add(value);
                }
            }
        }
        int[][] iArr2 = new int[arrayList2.size()];
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            iArr2[i3] = (int[]) arrayList2.get(i3);
        }
        return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), iArr2);
    }

    private static DecoderResult createDecoderResultFromAmbiguousValues(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
        int[] iArr5 = new int[iArr3.length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                for (int i4 = 0; i4 < iArr5.length; i4++) {
                    iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
                }
                try {
                    return decodeCodewords(iArr, i, iArr2);
                } catch (ChecksumException e) {
                    if (iArr5.length == 0) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    int i5 = 0;
                    while (true) {
                        if (i5 >= iArr5.length) {
                            i2 = i3;
                            break;
                        } else if (iArr5[i5] < iArr4[i5].length - 1) {
                            iArr5[i5] = iArr5[i5] + 1;
                            i2 = i3;
                            break;
                        } else {
                            iArr5[i5] = 0;
                            if (i5 != iArr5.length - 1) {
                                i5++;
                            } else {
                                throw ChecksumException.getChecksumInstance();
                            }
                        }
                    }
                }
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    private static BarcodeValue[][] createBarcodeMatrix(DetectionResult detectionResult) {
        DetectionResultColumn[] detectionResultColumns;
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
                Codeword[] codewords = detectionResultColumn.getCodewords();
                for (Codeword codeword : codewords) {
                    if (codeword != null && (rowNumber = codeword.getRowNumber()) >= 0 && rowNumber < barcodeValueArr.length) {
                        barcodeValueArr[rowNumber][i3].setValue(codeword.getValue());
                    }
                }
            }
            i3++;
        }
        return barcodeValueArr;
    }

    private static boolean isValidBarcodeColumn(DetectionResult detectionResult, int i) {
        return i >= 0 && i <= detectionResult.getBarcodeColumnCount() + 1;
    }

    private static int getStartColumn(DetectionResult detectionResult, int i, int i2, boolean z) {
        Codeword[] codewords;
        int i3 = z ? 1 : -1;
        Codeword codeword = null;
        if (isValidBarcodeColumn(detectionResult, i - i3)) {
            codeword = detectionResult.getDetectionResultColumn(i - i3).getCodeword(i2);
        }
        if (codeword != null) {
            return z ? codeword.getEndX() : codeword.getStartX();
        }
        Codeword codewordNearby = detectionResult.getDetectionResultColumn(i).getCodewordNearby(i2);
        if (codewordNearby != null) {
            return z ? codewordNearby.getStartX() : codewordNearby.getEndX();
        }
        if (isValidBarcodeColumn(detectionResult, i - i3)) {
            codewordNearby = detectionResult.getDetectionResultColumn(i - i3).getCodewordNearby(i2);
        }
        if (codewordNearby != null) {
            return z ? codewordNearby.getEndX() : codewordNearby.getStartX();
        }
        int i4 = 0;
        while (isValidBarcodeColumn(detectionResult, i - i3)) {
            i -= i3;
            for (Codeword codeword2 : detectionResult.getDetectionResultColumn(i).getCodewords()) {
                if (codeword2 != null) {
                    return (i3 * i4 * (codeword2.getEndX() - codeword2.getStartX())) + (z ? codeword2.getEndX() : codeword2.getStartX());
                }
            }
            i4++;
        }
        return z ? detectionResult.getBoundingBox().getMinX() : detectionResult.getBoundingBox().getMaxX();
    }

    private static Codeword detectCodeword(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
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
            i7 = adjustCodewordStartColumn;
            adjustCodewordStartColumn += sum;
        } else {
            for (int i8 = 0; i8 < moduleBitCount.length / 2; i8++) {
                int i9 = moduleBitCount[i8];
                moduleBitCount[i8] = moduleBitCount[(moduleBitCount.length - 1) - i8];
                moduleBitCount[(moduleBitCount.length - 1) - i8] = i9;
            }
            i7 = adjustCodewordStartColumn - sum;
        }
        if (checkCodewordSkew(sum, i5, i6) && (codeword = PDF417Common.getCodeword((decodedValue = PDF417CodewordDecoder.getDecodedValue(moduleBitCount)))) != -1) {
            return new Codeword(i7, adjustCodewordStartColumn, getCodewordBucketNumber(decodedValue), codeword);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0023 A[EDGE_INSN: B:30:0x0023->B:14:0x0023 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int[] getModuleBitCount(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        boolean z2 = z;
        int i6 = 0;
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
            if (!z) {
                i2 = i;
            }
            if (i3 != i2 || i6 != 7) {
                return null;
            }
        }
        return iArr;
    }

    private static int getNumberOfECCodeWords(int i) {
        return 2 << i;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0023 A[EDGE_INSN: B:29:0x0023->B:17:0x0023 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int adjustCodewordStartColumn(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int i5 = 0;
        int i6 = z ? -1 : 1;
        int i7 = i3;
        while (i5 < 2) {
            int i8 = i7;
            while (true) {
                if (!z) {
                    if (i8 >= i2) {
                        break;
                    }
                    if (z == bitMatrix.get(i8, i4)) {
                    }
                } else {
                    if (i8 < i) {
                        break;
                    }
                    if (z == bitMatrix.get(i8, i4)) {
                        break;
                    } else if (Math.abs(i3 - i8) <= 2) {
                        i8 += i6;
                    } else {
                        return i3;
                    }
                }
            }
            i6 = -i6;
            i5++;
            z = !z;
            i7 = i8;
        }
        return i7;
    }

    private static boolean checkCodewordSkew(int i, int i2, int i3) {
        return i2 + (-2) <= i && i <= i3 + 2;
    }

    private static DecoderResult decodeCodewords(int[] iArr, int i, int[] iArr2) throws FormatException, ChecksumException {
        if (iArr.length == 0) {
            throw FormatException.getFormatInstance();
        }
        int i2 = 1 << (i + 1);
        int correctErrors = correctErrors(iArr, iArr2, i2);
        verifyCodewordCount(iArr, i2);
        DecoderResult decode = DecodedBitStreamParser.decode(iArr, String.valueOf(i));
        decode.setErrorsCorrected(Integer.valueOf(correctErrors));
        decode.setErasures(Integer.valueOf(iArr2.length));
        return decode;
    }

    private static int correctErrors(int[] iArr, int[] iArr2, int i) throws ChecksumException {
        if ((iArr2 != null && iArr2.length > (i / 2) + 3) || i < 0 || i > 512) {
            throw ChecksumException.getChecksumInstance();
        }
        return errorCorrection.decode(iArr, i, iArr2);
    }

    private static void verifyCodewordCount(int[] iArr, int i) throws FormatException {
        if (iArr.length < 4) {
            throw FormatException.getFormatInstance();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw FormatException.getFormatInstance();
        }
        if (i2 == 0) {
            if (i < iArr.length) {
                iArr[0] = iArr.length - i;
                return;
            }
            throw FormatException.getFormatInstance();
        }
    }

    private static int[] getBitCountForCodeword(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            if ((i & 1) != i2) {
                i2 = i & 1;
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    private static int getCodewordBucketNumber(int i) {
        return getCodewordBucketNumber(getBitCountForCodeword(i));
    }

    private static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
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
}
