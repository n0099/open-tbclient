package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.u;
/* loaded from: classes2.dex */
final class d extends u {
    private int index;
    private final double[] jSG;

    public d(double[] dArr) {
        p.k(dArr, "array");
        this.jSG = dArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.jSG.length;
    }

    @Override // kotlin.collections.u
    public double nextDouble() {
        try {
            double[] dArr = this.jSG;
            int i = this.index;
            this.index = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
