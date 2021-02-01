package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes6.dex */
final class d extends kotlin.collections.u {
    private int index;
    private final double[] qtm;

    public d(double[] dArr) {
        p.o(dArr, com.baidu.fsg.base.statistics.b.j);
        this.qtm = dArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qtm.length;
    }

    @Override // kotlin.collections.u
    public double eBw() {
        try {
            double[] dArr = this.qtm;
            int i = this.index;
            this.index = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
