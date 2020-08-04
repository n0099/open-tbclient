package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
final class j extends ae {
    private int index;
    private final long[] nYz;

    public j(long[] jArr) {
        q.m(jArr, com.baidu.fsg.base.statistics.b.j);
        this.nYz = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nYz.length;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        try {
            long[] jArr = this.nYz;
            int i = this.index;
            this.index = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
