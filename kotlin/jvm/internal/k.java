package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ag;
/* loaded from: classes2.dex */
final class k extends ag {
    private final short[] iCG;
    private int index;

    public k(short[] sArr) {
        p.j(sArr, com.baidu.fsg.base.statistics.b.j);
        this.iCG = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.iCG.length;
    }

    @Override // kotlin.collections.ag
    public short nextShort() {
        try {
            short[] sArr = this.iCG;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
