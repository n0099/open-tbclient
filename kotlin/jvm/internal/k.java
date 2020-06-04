package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ap;
@kotlin.h
/* loaded from: classes7.dex */
final class k extends ap {
    private int index;
    private final short[] ntZ;

    public k(short[] sArr) {
        q.m(sArr, com.baidu.fsg.base.statistics.b.j);
        this.ntZ = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.ntZ.length;
    }

    @Override // kotlin.collections.ap
    public short dLR() {
        try {
            short[] sArr = this.ntZ;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
