package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes4.dex */
final class d extends kotlin.collections.u {
    private int index;
    private final double[] mYY;

    public d(double[] dArr) {
        p.j(dArr, "array");
        this.mYY = dArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.mYY.length;
    }

    @Override // kotlin.collections.u
    public double dyH() {
        try {
            double[] dArr = this.mYY;
            int i = this.index;
            this.index = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
