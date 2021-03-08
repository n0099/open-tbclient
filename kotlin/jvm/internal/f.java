package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.y;
@kotlin.e
/* loaded from: classes14.dex */
final class f extends y {
    private int index;
    private final int[] quq;

    public f(int[] iArr) {
        p.p(iArr, com.baidu.fsg.base.statistics.b.j);
        this.quq = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.quq.length;
    }

    @Override // kotlin.collections.y
    public int eBM() {
        try {
            int[] iArr = this.quq;
            int i = this.index;
            this.index = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
