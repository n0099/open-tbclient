package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.e
/* loaded from: classes6.dex */
final class j extends z {
    private int index;
    private final long[] qtP;

    public j(long[] jArr) {
        p.o(jArr, com.baidu.fsg.base.statistics.b.j);
        this.qtP = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qtP.length;
    }

    @Override // kotlin.collections.z
    public long eBF() {
        try {
            long[] jArr = this.qtP;
            int i = this.index;
            this.index = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
