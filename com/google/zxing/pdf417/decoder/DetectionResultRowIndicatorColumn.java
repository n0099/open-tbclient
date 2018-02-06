package com.google.zxing.pdf417.decoder;

import com.google.zxing.ResultPoint;
/* loaded from: classes3.dex */
final class DetectionResultRowIndicatorColumn extends DetectionResultColumn {
    private final boolean isLeft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DetectionResultRowIndicatorColumn(BoundingBox boundingBox, boolean z) {
        super(boundingBox);
        this.isLeft = z;
    }

    private void setRowNumbers() {
        Codeword[] codewords;
        for (Codeword codeword : getCodewords()) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void adjustCompleteIndicatorColumnRowNumbers(BarcodeMetadata barcodeMetadata) {
        int i;
        int i2;
        int i3;
        Codeword[] codewords = getCodewords();
        setRowNumbers();
        removeIncorrectCodewords(codewords, barcodeMetadata);
        BoundingBox boundingBox = getBoundingBox();
        ResultPoint topLeft = this.isLeft ? boundingBox.getTopLeft() : boundingBox.getTopRight();
        ResultPoint bottomLeft = this.isLeft ? boundingBox.getBottomLeft() : boundingBox.getBottomRight();
        int imageRowToCodewordIndex = imageRowToCodewordIndex((int) topLeft.getY());
        int imageRowToCodewordIndex2 = imageRowToCodewordIndex((int) bottomLeft.getY());
        int i4 = -1;
        int i5 = imageRowToCodewordIndex;
        int i6 = 0;
        int i7 = 1;
        while (i5 < imageRowToCodewordIndex2) {
            if (codewords[i5] != null) {
                Codeword codeword = codewords[i5];
                int rowNumber = codeword.getRowNumber() - i4;
                if (rowNumber == 0) {
                    i = i6 + 1;
                    i2 = i7;
                    i3 = i4;
                } else if (rowNumber == 1) {
                    int max = Math.max(i7, i6);
                    i3 = codeword.getRowNumber();
                    i2 = max;
                    i = 1;
                } else if (rowNumber < 0 || codeword.getRowNumber() >= barcodeMetadata.getRowCount() || rowNumber > i5) {
                    codewords[i5] = null;
                    i = i6;
                    i2 = i7;
                    i3 = i4;
                } else {
                    int i8 = i7 > 2 ? rowNumber * (i7 - 2) : rowNumber;
                    boolean z = i8 >= i5;
                    for (int i9 = 1; i9 <= i8 && !z; i9++) {
                        z = codewords[i5 - i9] != null;
                    }
                    if (z) {
                        codewords[i5] = null;
                        i = i6;
                        i2 = i7;
                        i3 = i4;
                    } else {
                        i2 = i7;
                        i3 = codeword.getRowNumber();
                        i = 1;
                    }
                }
            } else {
                i = i6;
                i2 = i7;
                i3 = i4;
            }
            i5++;
            i4 = i3;
            i7 = i2;
            i6 = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getRowHeights() {
        Codeword[] codewords;
        int rowNumber;
        BarcodeMetadata barcodeMetadata = getBarcodeMetadata();
        if (barcodeMetadata == null) {
            return null;
        }
        adjustIncompleteIndicatorColumnRowNumbers(barcodeMetadata);
        int[] iArr = new int[barcodeMetadata.getRowCount()];
        for (Codeword codeword : getCodewords()) {
            if (codeword != null && (rowNumber = codeword.getRowNumber()) < iArr.length) {
                iArr[rowNumber] = iArr[rowNumber] + 1;
            }
        }
        return iArr;
    }

    private void adjustIncompleteIndicatorColumnRowNumbers(BarcodeMetadata barcodeMetadata) {
        BoundingBox boundingBox = getBoundingBox();
        ResultPoint topLeft = this.isLeft ? boundingBox.getTopLeft() : boundingBox.getTopRight();
        ResultPoint bottomLeft = this.isLeft ? boundingBox.getBottomLeft() : boundingBox.getBottomRight();
        int imageRowToCodewordIndex = imageRowToCodewordIndex((int) topLeft.getY());
        int imageRowToCodewordIndex2 = imageRowToCodewordIndex((int) bottomLeft.getY());
        Codeword[] codewords = getCodewords();
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        for (int i4 = imageRowToCodewordIndex; i4 < imageRowToCodewordIndex2; i4++) {
            if (codewords[i4] != null) {
                Codeword codeword = codewords[i4];
                codeword.setRowNumberAsRowIndicatorColumn();
                int rowNumber = codeword.getRowNumber() - i;
                if (rowNumber == 0) {
                    i2++;
                } else if (rowNumber == 1) {
                    int max = Math.max(i3, i2);
                    i = codeword.getRowNumber();
                    i3 = max;
                    i2 = 1;
                } else if (codeword.getRowNumber() >= barcodeMetadata.getRowCount()) {
                    codewords[i4] = null;
                } else {
                    i = codeword.getRowNumber();
                    i2 = 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BarcodeMetadata getBarcodeMetadata() {
        Codeword[] codewords = getCodewords();
        BarcodeValue barcodeValue = new BarcodeValue();
        BarcodeValue barcodeValue2 = new BarcodeValue();
        BarcodeValue barcodeValue3 = new BarcodeValue();
        BarcodeValue barcodeValue4 = new BarcodeValue();
        for (Codeword codeword : codewords) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (!this.isLeft) {
                    rowNumber += 2;
                }
                switch (rowNumber % 3) {
                    case 0:
                        barcodeValue2.setValue((value * 3) + 1);
                        continue;
                    case 1:
                        barcodeValue4.setValue(value / 3);
                        barcodeValue3.setValue(value % 3);
                        continue;
                    case 2:
                        barcodeValue.setValue(value + 1);
                        continue;
                }
            }
        }
        if (barcodeValue.getValue().length == 0 || barcodeValue2.getValue().length == 0 || barcodeValue3.getValue().length == 0 || barcodeValue4.getValue().length == 0 || barcodeValue.getValue()[0] <= 0 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] < 3 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] > 90) {
            return null;
        }
        BarcodeMetadata barcodeMetadata = new BarcodeMetadata(barcodeValue.getValue()[0], barcodeValue2.getValue()[0], barcodeValue3.getValue()[0], barcodeValue4.getValue()[0]);
        removeIncorrectCodewords(codewords, barcodeMetadata);
        return barcodeMetadata;
    }

    private void removeIncorrectCodewords(Codeword[] codewordArr, BarcodeMetadata barcodeMetadata) {
        for (int i = 0; i < codewordArr.length; i++) {
            Codeword codeword = codewordArr[i];
            if (codewordArr[i] != null) {
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (rowNumber > barcodeMetadata.getRowCount()) {
                    codewordArr[i] = null;
                } else {
                    if (!this.isLeft) {
                        rowNumber += 2;
                    }
                    switch (rowNumber % 3) {
                        case 0:
                            if ((value * 3) + 1 != barcodeMetadata.getRowCountUpperPart()) {
                                codewordArr[i] = null;
                                break;
                            } else {
                                continue;
                            }
                        case 1:
                            if (value / 3 != barcodeMetadata.getErrorCorrectionLevel() || value % 3 != barcodeMetadata.getRowCountLowerPart()) {
                                codewordArr[i] = null;
                                break;
                            } else {
                                continue;
                            }
                        case 2:
                            if (value + 1 != barcodeMetadata.getColumnCount()) {
                                codewordArr[i] = null;
                                break;
                            } else {
                                continue;
                            }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLeft() {
        return this.isLeft;
    }

    @Override // com.google.zxing.pdf417.decoder.DetectionResultColumn
    public String toString() {
        return "IsLeft: " + this.isLeft + '\n' + super.toString();
    }
}
