package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.e
/* loaded from: classes17.dex */
final class j extends z {
    private int index;
    private final long[] pKz;

    public j(long[] jArr) {
        p.o(jArr, com.baidu.fsg.base.statistics.b.j);
        this.pKz = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pKz.length;
    }

    @Override // kotlin.collections.z
    public long eyG() {
        try {
            long[] jArr = this.pKz;
            int i = this.index;
            this.index = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
