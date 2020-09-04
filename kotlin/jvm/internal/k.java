package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ap;
@kotlin.h
/* loaded from: classes20.dex */
final class k extends ap {
    private int index;
    private final short[] osQ;

    public k(short[] sArr) {
        q.m(sArr, com.baidu.fsg.base.statistics.b.j);
        this.osQ = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.osQ.length;
    }

    @Override // kotlin.collections.ap
    public short egj() {
        try {
            short[] sArr = this.osQ;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
