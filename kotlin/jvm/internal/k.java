package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.aj;
@kotlin.e
/* loaded from: classes14.dex */
final class k extends aj {
    private int index;
    private final short[] qus;

    public k(short[] sArr) {
        p.p(sArr, com.baidu.fsg.base.statistics.b.j);
        this.qus = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qus.length;
    }

    @Override // kotlin.collections.aj
    public short eKW() {
        try {
            short[] sArr = this.qus;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
