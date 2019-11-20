package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.z;
/* loaded from: classes2.dex */
final class j extends z {
    private int index;
    private final long[] kvf;

    public j(long[] jArr) {
        p.i(jArr, "array");
        this.kvf = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kvf.length;
    }

    @Override // kotlin.collections.z
    public long cMP() {
        try {
            long[] jArr = this.kvf;
            int i = this.index;
            this.index = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
