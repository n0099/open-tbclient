package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
/* loaded from: classes3.dex */
final class BoundingBox {
    private ResultPoint bottomLeft;
    private ResultPoint bottomRight;
    private BitMatrix image;
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    private ResultPoint topLeft;
    private ResultPoint topRight;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundingBox(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        if ((resultPoint == null && resultPoint3 == null) || ((resultPoint2 == null && resultPoint4 == null) || ((resultPoint != null && resultPoint2 == null) || (resultPoint3 != null && resultPoint4 == null)))) {
            throw NotFoundException.getNotFoundInstance();
        }
        init(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundingBox(BoundingBox boundingBox) {
        init(boundingBox.image, boundingBox.topLeft, boundingBox.bottomLeft, boundingBox.topRight, boundingBox.bottomRight);
    }

    private void init(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        this.image = bitMatrix;
        this.topLeft = resultPoint;
        this.bottomLeft = resultPoint2;
        this.topRight = resultPoint3;
        this.bottomRight = resultPoint4;
        calculateMinMaxValues();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BoundingBox merge(BoundingBox boundingBox, BoundingBox boundingBox2) throws NotFoundException {
        if (boundingBox == null) {
            return boundingBox2;
        }
        return boundingBox2 == null ? boundingBox : new BoundingBox(boundingBox.image, boundingBox.topLeft, boundingBox.bottomLeft, boundingBox2.topRight, boundingBox2.bottomRight);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundingBox addMissingRows(int i, int i2, boolean z) throws NotFoundException {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3 = this.topLeft;
        ResultPoint resultPoint4 = this.bottomLeft;
        ResultPoint resultPoint5 = this.topRight;
        ResultPoint resultPoint6 = this.bottomRight;
        if (i > 0) {
            ResultPoint resultPoint7 = z ? this.topLeft : this.topRight;
            int y = ((int) resultPoint7.getY()) - i;
            if (y < 0) {
                y = 0;
            }
            resultPoint = new ResultPoint(resultPoint7.getX(), y);
            if (!z) {
                resultPoint5 = resultPoint;
                resultPoint = resultPoint3;
            }
        } else {
            resultPoint = resultPoint3;
        }
        if (i2 > 0) {
            ResultPoint resultPoint8 = z ? this.bottomLeft : this.bottomRight;
            int y2 = ((int) resultPoint8.getY()) + i2;
            if (y2 >= this.image.getHeight()) {
                y2 = this.image.getHeight() - 1;
            }
            resultPoint2 = new ResultPoint(resultPoint8.getX(), y2);
            if (!z) {
                resultPoint6 = resultPoint2;
                resultPoint2 = resultPoint4;
            }
        } else {
            resultPoint2 = resultPoint4;
        }
        calculateMinMaxValues();
        return new BoundingBox(this.image, resultPoint, resultPoint2, resultPoint5, resultPoint6);
    }

    private void calculateMinMaxValues() {
        if (this.topLeft == null) {
            this.topLeft = new ResultPoint(0.0f, this.topRight.getY());
            this.bottomLeft = new ResultPoint(0.0f, this.bottomRight.getY());
        } else if (this.topRight == null) {
            this.topRight = new ResultPoint(this.image.getWidth() - 1, this.topLeft.getY());
            this.bottomRight = new ResultPoint(this.image.getWidth() - 1, this.bottomLeft.getY());
        }
        this.minX = (int) Math.min(this.topLeft.getX(), this.bottomLeft.getX());
        this.maxX = (int) Math.max(this.topRight.getX(), this.bottomRight.getX());
        this.minY = (int) Math.min(this.topLeft.getY(), this.topRight.getY());
        this.maxY = (int) Math.max(this.bottomLeft.getY(), this.bottomRight.getY());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMinX() {
        return this.minX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMaxX() {
        return this.maxX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMinY() {
        return this.minY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMaxY() {
        return this.maxY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultPoint getTopLeft() {
        return this.topLeft;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultPoint getTopRight() {
        return this.topRight;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultPoint getBottomLeft() {
        return this.bottomLeft;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultPoint getBottomRight() {
        return this.bottomRight;
    }
}
