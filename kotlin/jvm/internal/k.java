package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ag;
/* loaded from: classes2.dex */
final class k extends ag {
    private int index;
    private final short[] kvp;

    public k(short[] sArr) {
        p.k(sArr, "array");
        this.kvp = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kvp.length;
    }

    @Override // kotlin.collections.ag
    public short cOM() {
        try {
            short[] sArr = this.kvp;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
