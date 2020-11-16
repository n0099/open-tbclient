package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes9.dex */
final class j extends ae {
    private int index;
    private final long[] pUf;

    public j(long[] jArr) {
        q.n(jArr, com.baidu.fsg.base.statistics.b.j);
        this.pUf = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pUf.length;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        try {
            long[] jArr = this.pUf;
            int i = this.index;
            this.index = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
