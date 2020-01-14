package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.z;
/* loaded from: classes5.dex */
final class d extends z {
    private int index;
    private final double[] nBF;

    public d(double[] dArr) {
        q.j(dArr, "array");
        this.nBF = dArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nBF.length;
    }

    @Override // kotlin.collections.z
    public double nextDouble() {
        try {
            double[] dArr = this.nBF;
            int i = this.index;
            this.index = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
