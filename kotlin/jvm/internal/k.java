package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ap;
@kotlin.h
/* loaded from: classes7.dex */
final class k extends ap {
    private int index;
    private final short[] nCn;

    public k(short[] sArr) {
        q.j(sArr, "array");
        this.nCn = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nCn.length;
    }

    @Override // kotlin.collections.ap
    public short dKm() {
        try {
            short[] sArr = this.nCn;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
