package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.u;
/* loaded from: classes2.dex */
final class d extends u {
    private int index;
    private final double[] kvc;

    public d(double[] dArr) {
        p.i(dArr, "array");
        this.kvc = dArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kvc.length;
    }

    @Override // kotlin.collections.u
    public double cMH() {
        try {
            double[] dArr = this.kvc;
            int i = this.index;
            this.index = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
