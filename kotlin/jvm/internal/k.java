package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ap;
/* loaded from: classes5.dex */
final class k extends ap {
    private int index;
    private final short[] nBE;

    public k(short[] sArr) {
        q.j(sArr, "array");
        this.nBE = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nBE.length;
    }

    @Override // kotlin.collections.ap
    public short dJb() {
        try {
            short[] sArr = this.nBE;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
