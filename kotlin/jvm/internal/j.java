package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.e
/* loaded from: classes14.dex */
final class j extends z {
    private int index;
    private final long[] qur;

    public j(long[] jArr) {
        p.p(jArr, com.baidu.fsg.base.statistics.b.j);
        this.qur = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qur.length;
    }

    @Override // kotlin.collections.z
    public long eBL() {
        try {
            long[] jArr = this.qur;
            int i = this.index;
            this.index = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
