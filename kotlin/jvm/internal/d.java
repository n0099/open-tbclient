package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.h
/* loaded from: classes7.dex */
final class d extends z {
    private int index;
    private final double[] nEh;

    public d(double[] dArr) {
        q.j(dArr, "array");
        this.nEh = dArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nEh.length;
    }

    @Override // kotlin.collections.z
    public double nextDouble() {
        try {
            double[] dArr = this.nEh;
            int i = this.index;
            this.index = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
