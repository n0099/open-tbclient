package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ag;
/* loaded from: classes2.dex */
final class k extends ag {
    private int index;
    private final short[] kvX;

    public k(short[] sArr) {
        p.i(sArr, "array");
        this.kvX = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kvX.length;
    }

    @Override // kotlin.collections.ag
    public short cMT() {
        try {
            short[] sArr = this.kvX;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
