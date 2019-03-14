package com.google.zxing.oned.rss;

import com.google.zxing.ResultPoint;
/* loaded from: classes5.dex */
public final class FinderPattern {
    private final ResultPoint[] resultPoints;
    private final int[] startEnd;
    private final int value;

    public FinderPattern(int i, int[] iArr, int i2, int i3, int i4) {
        this.value = i;
        this.startEnd = iArr;
        this.resultPoints = new ResultPoint[]{new ResultPoint(i2, i4), new ResultPoint(i3, i4)};
    }

    public int getValue() {
        return this.value;
    }

    public int[] getStartEnd() {
        return this.startEnd;
    }

    public ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public boolean equals(Object obj) {
        return (obj instanceof FinderPattern) && this.value == ((FinderPattern) obj).value;
    }

    public int hashCode() {
        return this.value;
    }
}
