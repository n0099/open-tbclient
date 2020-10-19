package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ap;
@kotlin.h
/* loaded from: classes10.dex */
final class k extends ap {
    private int index;
    private final short[] oRM;

    public k(short[] sArr) {
        q.n(sArr, com.baidu.fsg.base.statistics.b.j);
        this.oRM = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.oRM.length;
    }

    @Override // kotlin.collections.ap
    public short enS() {
        try {
            short[] sArr = this.oRM;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
