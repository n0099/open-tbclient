package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ap;
/* loaded from: classes5.dex */
final class k extends ap {
    private int index;
    private final short[] nBJ;

    public k(short[] sArr) {
        q.j(sArr, "array");
        this.nBJ = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nBJ.length;
    }

    @Override // kotlin.collections.ap
    public short dJd() {
        try {
            short[] sArr = this.nBJ;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
