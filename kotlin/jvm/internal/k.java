package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ap;
@kotlin.h
/* loaded from: classes7.dex */
final class k extends ap {
    private int index;
    private final short[] nCl;

    public k(short[] sArr) {
        q.j(sArr, "array");
        this.nCl = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nCl.length;
    }

    @Override // kotlin.collections.ap
    public short dKk() {
        try {
            short[] sArr = this.nCl;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
