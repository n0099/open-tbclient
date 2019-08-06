package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.u;
/* loaded from: classes2.dex */
final class d extends u {
    private int index;
    private final double[] ksS;

    public d(double[] dArr) {
        p.k(dArr, "array");
        this.ksS = dArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.ksS.length;
    }

    @Override // kotlin.collections.u
    public double cNQ() {
        try {
            double[] dArr = this.ksS;
            int i = this.index;
            this.index = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
