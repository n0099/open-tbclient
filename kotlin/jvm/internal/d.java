package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.u;
/* loaded from: classes2.dex */
final class d extends u {
    private int index;
    private final double[] kvT;

    public d(double[] dArr) {
        p.i(dArr, "array");
        this.kvT = dArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kvT.length;
    }

    @Override // kotlin.collections.u
    public double cMJ() {
        try {
            double[] dArr = this.kvT;
            int i = this.index;
            this.index = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
