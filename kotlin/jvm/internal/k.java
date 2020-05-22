package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ap;
@kotlin.h
/* loaded from: classes7.dex */
final class k extends ap {
    private int index;
    private final short[] nsP;

    public k(short[] sArr) {
        q.m(sArr, com.baidu.fsg.base.statistics.b.j);
        this.nsP = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nsP.length;
    }

    @Override // kotlin.collections.ap
    public short dLD() {
        try {
            short[] sArr = this.nsP;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
