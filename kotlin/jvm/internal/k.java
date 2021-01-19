package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.aj;
@kotlin.e
/* loaded from: classes5.dex */
final class k extends aj {
    private int index;
    private final short[] qjm;

    public k(short[] sArr) {
        p.o(sArr, com.baidu.fsg.base.statistics.b.j);
        this.qjm = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qjm.length;
    }

    @Override // kotlin.collections.aj
    public short eIQ() {
        try {
            short[] sArr = this.qjm;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
