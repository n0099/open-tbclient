package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes5.dex */
final class d extends kotlin.collections.u {
    private int index;
    private final double[] qmb;

    public d(double[] dArr) {
        p.o(dArr, com.baidu.fsg.base.statistics.b.j);
        this.qmb = dArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qmb.length;
    }

    @Override // kotlin.collections.u
    public double eCs() {
        try {
            double[] dArr = this.qmb;
            int i = this.index;
            this.index = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
