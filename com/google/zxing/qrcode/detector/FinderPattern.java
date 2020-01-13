package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;
/* loaded from: classes8.dex */
public final class FinderPattern extends ResultPoint {
    private final int count;
    private final float estimatedModuleSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FinderPattern(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    private FinderPattern(float f, float f2, float f3, int i) {
        super(f, f2);
        this.estimatedModuleSize = f3;
        this.count = i;
    }

    public float getEstimatedModuleSize() {
        return this.estimatedModuleSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCount() {
        return this.count;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aboutEquals(float f, float f2, float f3) {
        if (Math.abs(f2 - getY()) > f || Math.abs(f3 - getX()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.estimatedModuleSize);
        return abs <= 1.0f || abs <= this.estimatedModuleSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FinderPattern combineEstimate(float f, float f2, float f3) {
        int i = this.count + 1;
        return new FinderPattern(((this.count * getX()) + f2) / i, ((this.count * getY()) + f) / i, ((this.count * this.estimatedModuleSize) + f3) / i, i);
    }
}
