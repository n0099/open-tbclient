package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ag;
/* loaded from: classes2.dex */
final class k extends ag {
    private int index;
    private final short[] ipu;

    public k(short[] sArr) {
        p.i(sArr, com.baidu.fsg.base.statistics.b.j);
        this.ipu = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.ipu.length;
    }

    @Override // kotlin.collections.ag
    public short nextShort() {
        try {
            short[] sArr = this.ipu;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
