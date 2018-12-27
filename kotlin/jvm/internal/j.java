package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.z;
/* loaded from: classes2.dex */
final class j extends z {
    private final long[] iBx;
    private int index;

    public j(long[] jArr) {
        p.j(jArr, com.baidu.fsg.base.statistics.b.j);
        this.iBx = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.iBx.length;
    }

    @Override // kotlin.collections.z
    public long nextLong() {
        try {
            long[] jArr = this.iBx;
            int i = this.index;
            this.index = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
