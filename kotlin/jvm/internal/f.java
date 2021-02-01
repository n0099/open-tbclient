package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.y;
@kotlin.e
/* loaded from: classes6.dex */
final class f extends y {
    private int index;
    private final int[] qto;

    public f(int[] iArr) {
        p.o(iArr, com.baidu.fsg.base.statistics.b.j);
        this.qto = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qto.length;
    }

    @Override // kotlin.collections.y
    public int eBy() {
        try {
            int[] iArr = this.qto;
            int i = this.index;
            this.index = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
