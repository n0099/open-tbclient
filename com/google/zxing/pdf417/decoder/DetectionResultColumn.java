package com.google.zxing.pdf417.decoder;

import java.util.Formatter;
/* loaded from: classes10.dex */
public class DetectionResultColumn {
    public static final int MAX_NEARBY_DISTANCE = 5;
    public final BoundingBox boundingBox;
    public final Codeword[] codewords;

    public DetectionResultColumn(BoundingBox boundingBox) {
        this.boundingBox = new BoundingBox(boundingBox);
        this.codewords = new Codeword[(boundingBox.getMaxY() - boundingBox.getMinY()) + 1];
    }

    public final Codeword getCodeword(int i) {
        return this.codewords[imageRowToCodewordIndex(i)];
    }

    public final Codeword getCodewordNearby(int i) {
        Codeword codeword;
        Codeword codeword2;
        Codeword codeword3 = getCodeword(i);
        if (codeword3 != null) {
            return codeword3;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int imageRowToCodewordIndex = imageRowToCodewordIndex(i) - i2;
            if (imageRowToCodewordIndex >= 0 && (codeword2 = this.codewords[imageRowToCodewordIndex]) != null) {
                return codeword2;
            }
            int imageRowToCodewordIndex2 = imageRowToCodewordIndex(i) + i2;
            Codeword[] codewordArr = this.codewords;
            if (imageRowToCodewordIndex2 < codewordArr.length && (codeword = codewordArr[imageRowToCodewordIndex2]) != null) {
                return codeword;
            }
        }
        return null;
    }

    public final int imageRowToCodewordIndex(int i) {
        return i - this.boundingBox.getMinY();
    }

    public final BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public final Codeword[] getCodewords() {
        return this.codewords;
    }

    public final void setCodeword(int i, Codeword codeword) {
        this.codewords[imageRowToCodewordIndex(i)] = codeword;
    }

    public String toString() {
        Codeword[] codewordArr;
        Formatter formatter = new Formatter();
        int i = 0;
        for (Codeword codeword : this.codewords) {
            if (codeword == null) {
                formatter.format("%3d:    |   %n", Integer.valueOf(i));
                i++;
            } else {
                formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(codeword.getRowNumber()), Integer.valueOf(codeword.getValue()));
                i++;
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
