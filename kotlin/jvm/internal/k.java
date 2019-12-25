package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.aj;
/* loaded from: classes4.dex */
final class k extends aj {
    private int index;
    private final short[] mZc;

    public k(short[] sArr) {
        p.j(sArr, "array");
        this.mZc = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.mZc.length;
    }

    @Override // kotlin.collections.aj
    public short dEL() {
        try {
            short[] sArr = this.mZc;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
