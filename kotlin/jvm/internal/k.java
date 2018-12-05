package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ag;
/* loaded from: classes2.dex */
final class k extends ag {
    private int index;
    private final short[] iyo;

    public k(short[] sArr) {
        p.h((Object) sArr, com.baidu.fsg.base.statistics.b.j);
        this.iyo = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.iyo.length;
    }

    @Override // kotlin.collections.ag
    public short nextShort() {
        try {
            short[] sArr = this.iyo;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
