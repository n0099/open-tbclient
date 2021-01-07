package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.e
/* loaded from: classes5.dex */
final class j extends z {
    private int index;
    private final long[] qnM;

    public j(long[] jArr) {
        p.o(jArr, com.baidu.fsg.base.statistics.b.j);
        this.qnM = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qnM.length;
    }

    @Override // kotlin.collections.z
    public long eCX() {
        try {
            long[] jArr = this.qnM;
            int i = this.index;
            this.index = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
