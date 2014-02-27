package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;
/* loaded from: classes.dex */
public final class FinderPattern extends ResultPoint {
    private int count;
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

    public final float getEstimatedModuleSize() {
        return this.estimatedModuleSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getCount() {
        return this.count;
    }

    final void incrementCount() {
        this.count++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean aboutEquals(float f, float f2, float f3) {
        if (Math.abs(f2 - getY()) > f || Math.abs(f3 - getX()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.estimatedModuleSize);
        return abs <= 1.0f || abs <= this.estimatedModuleSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final FinderPattern combineEstimate(float f, float f2, float f3) {
        int i = this.count + 1;
        return new FinderPattern(((this.count * getX()) + f2) / i, ((this.count * getY()) + f) / i, ((this.count * this.estimatedModuleSize) + f3) / i, i);
    }
}
