package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ap;
@kotlin.h
/* loaded from: classes7.dex */
final class k extends ap {
    private int index;
    private final short[] nPP;

    public k(short[] sArr) {
        q.m(sArr, com.baidu.fsg.base.statistics.b.j);
        this.nPP = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nPP.length;
    }

    @Override // kotlin.collections.ap
    public short dQB() {
        try {
            short[] sArr = this.nPP;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
