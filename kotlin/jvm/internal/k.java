package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ap;
@kotlin.h
/* loaded from: classes7.dex */
final class k extends ap {
    private int index;
    private final short[] nEl;

    public k(short[] sArr) {
        q.j(sArr, "array");
        this.nEl = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nEl.length;
    }

    @Override // kotlin.collections.ap
    public short dKN() {
        try {
            short[] sArr = this.nEl;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
