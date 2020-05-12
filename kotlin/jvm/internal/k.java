package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ap;
@kotlin.h
/* loaded from: classes7.dex */
final class k extends ap {
    private int index;
    private final short[] mXN;

    public k(short[] sArr) {
        q.j(sArr, com.baidu.fsg.base.statistics.b.j);
        this.mXN = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.mXN.length;
    }

    @Override // kotlin.collections.ap
    public short dDJ() {
        try {
            short[] sArr = this.mXN;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
