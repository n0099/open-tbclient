package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.z;
/* loaded from: classes2.dex */
final class j extends z {
    private int index;
    private final long[] jRT;

    public j(long[] jArr) {
        p.k(jArr, "array");
        this.jRT = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.jRT.length;
    }

    @Override // kotlin.collections.z
    public long nextLong() {
        try {
            long[] jArr = this.jRT;
            int i = this.index;
            this.index = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
