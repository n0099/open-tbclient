package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.h
/* loaded from: classes10.dex */
final class d extends z {
    private int index;
    private final double[] pJf;

    public d(double[] dArr) {
        q.n(dArr, com.baidu.fsg.base.statistics.b.j);
        this.pJf = dArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pJf.length;
    }

    @Override // kotlin.collections.z
    public double nextDouble() {
        try {
            double[] dArr = this.pJf;
            int i = this.index;
            this.index = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
