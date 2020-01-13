package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
/* loaded from: classes5.dex */
final class j extends ae {
    private int index;
    private final long[] nBD;

    public j(long[] jArr) {
        q.j(jArr, "array");
        this.nBD = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nBD.length;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        try {
            long[] jArr = this.nBD;
            int i = this.index;
            this.index = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
