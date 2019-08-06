package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ag;
/* loaded from: classes2.dex */
final class k extends ag {
    private int index;
    private final short[] ksW;

    public k(short[] sArr) {
        p.k(sArr, "array");
        this.ksW = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.ksW.length;
    }

    @Override // kotlin.collections.ag
    public short cOa() {
        try {
            short[] sArr = this.ksW;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
