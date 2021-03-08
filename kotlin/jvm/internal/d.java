package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes14.dex */
final class d extends kotlin.collections.u {
    private int index;
    private final double[] quo;

    public d(double[] dArr) {
        p.p(dArr, com.baidu.fsg.base.statistics.b.j);
        this.quo = dArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.quo.length;
    }

    @Override // kotlin.collections.u
    public double eBK() {
        try {
            double[] dArr = this.quo;
            int i = this.index;
            this.index = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
