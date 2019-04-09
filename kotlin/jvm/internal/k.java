package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ag;
/* loaded from: classes2.dex */
final class k extends ag {
    private int index;
    private final short[] jRV;

    public k(short[] sArr) {
        p.k(sArr, "array");
        this.jRV = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.jRV.length;
    }

    @Override // kotlin.collections.ag
    public short nextShort() {
        try {
            short[] sArr = this.jRV;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
