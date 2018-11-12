package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ag;
/* loaded from: classes2.dex */
final class k extends ag {
    private int index;
    private final short[] ire;

    public k(short[] sArr) {
        p.h((Object) sArr, com.baidu.fsg.base.statistics.b.j);
        this.ire = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.ire.length;
    }

    @Override // kotlin.collections.ag
    public short nextShort() {
        try {
            short[] sArr = this.ire;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
