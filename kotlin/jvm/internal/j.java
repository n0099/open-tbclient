package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.z;
/* loaded from: classes4.dex */
final class j extends z {
    private int index;
    private final long[] mZb;

    public j(long[] jArr) {
        p.j(jArr, "array");
        this.mZb = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.mZb.length;
    }

    @Override // kotlin.collections.z
    public long dyI() {
        try {
            long[] jArr = this.mZb;
            int i = this.index;
            this.index = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
