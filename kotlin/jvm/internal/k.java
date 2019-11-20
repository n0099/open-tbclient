package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ag;
/* loaded from: classes2.dex */
final class k extends ag {
    private int index;
    private final short[] kvg;

    public k(short[] sArr) {
        p.i(sArr, "array");
        this.kvg = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kvg.length;
    }

    @Override // kotlin.collections.ag
    public short cMR() {
        try {
            short[] sArr = this.kvg;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
