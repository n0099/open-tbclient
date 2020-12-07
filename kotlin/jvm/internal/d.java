package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes17.dex */
final class d extends kotlin.collections.u {
    private int index;
    private final double[] pKw;

    public d(double[] dArr) {
        p.o(dArr, com.baidu.fsg.base.statistics.b.j);
        this.pKw = dArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pKw.length;
    }

    @Override // kotlin.collections.u
    public double eyF() {
        try {
            double[] dArr = this.pKw;
            int i = this.index;
            this.index = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
