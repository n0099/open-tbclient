package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.u;
/* loaded from: classes2.dex */
final class d extends u {
    private final double[] iCC;
    private int index;

    public d(double[] dArr) {
        p.j(dArr, com.baidu.fsg.base.statistics.b.j);
        this.iCC = dArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.iCC.length;
    }

    @Override // kotlin.collections.u
    public double nextDouble() {
        try {
            double[] dArr = this.iCC;
            int i = this.index;
            this.index = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
