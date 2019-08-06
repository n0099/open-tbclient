package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.z;
/* loaded from: classes2.dex */
final class j extends z {
    private int index;
    private final long[] ksV;

    public j(long[] jArr) {
        p.k(jArr, "array");
        this.ksV = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.ksV.length;
    }

    @Override // kotlin.collections.z
    public long cNY() {
        try {
            long[] jArr = this.ksV;
            int i = this.index;
            this.index = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
