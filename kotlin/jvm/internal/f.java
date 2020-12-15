package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.y;
@kotlin.e
/* loaded from: classes17.dex */
final class f extends y {
    private int index;
    private final int[] pKA;

    public f(int[] iArr) {
        p.o(iArr, com.baidu.fsg.base.statistics.b.j);
        this.pKA = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pKA.length;
    }

    @Override // kotlin.collections.y
    public int eyI() {
        try {
            int[] iArr = this.pKA;
            int i = this.index;
            this.index = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
