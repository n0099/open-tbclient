package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.e
/* loaded from: classes17.dex */
final class j extends z {
    private int index;
    private final long[] pKB;

    public j(long[] jArr) {
        p.o(jArr, com.baidu.fsg.base.statistics.b.j);
        this.pKB = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pKB.length;
    }

    @Override // kotlin.collections.z
    public long eyH() {
        try {
            long[] jArr = this.pKB;
            int i = this.index;
            this.index = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
