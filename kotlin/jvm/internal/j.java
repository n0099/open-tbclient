package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.e
/* loaded from: classes6.dex */
final class j extends z {
    private int index;
    private final long[] qtp;

    public j(long[] jArr) {
        p.o(jArr, com.baidu.fsg.base.statistics.b.j);
        this.qtp = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qtp.length;
    }

    @Override // kotlin.collections.z
    public long eBx() {
        try {
            long[] jArr = this.qtp;
            int i = this.index;
            this.index = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
