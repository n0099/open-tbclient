package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.aj;
@kotlin.e
/* loaded from: classes17.dex */
final class k extends aj {
    private int index;
    private final short[] pKA;

    public k(short[] sArr) {
        p.o(sArr, com.baidu.fsg.base.statistics.b.j);
        this.pKA = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pKA.length;
    }

    @Override // kotlin.collections.aj
    public short eDT() {
        try {
            short[] sArr = this.pKA;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
