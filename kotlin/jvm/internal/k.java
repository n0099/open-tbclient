package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ag;
/* loaded from: classes2.dex */
final class k extends ag {
    private final short[] iBy;
    private int index;

    public k(short[] sArr) {
        p.j(sArr, com.baidu.fsg.base.statistics.b.j);
        this.iBy = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.iBy.length;
    }

    @Override // kotlin.collections.ag
    public short nextShort() {
        try {
            short[] sArr = this.iBy;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
