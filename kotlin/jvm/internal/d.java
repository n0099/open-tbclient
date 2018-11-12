package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.u;
/* loaded from: classes2.dex */
final class d extends u {
    private int index;
    private final double[] ira;

    public d(double[] dArr) {
        p.h((Object) dArr, com.baidu.fsg.base.statistics.b.j);
        this.ira = dArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.ira.length;
    }

    @Override // kotlin.collections.u
    public double nextDouble() {
        try {
            double[] dArr = this.ira;
            int i = this.index;
            this.index = i + 1;
            return dArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
