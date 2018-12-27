package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
final class f extends y {
    private final int[] iBw;
    private int index;

    public f(int[] iArr) {
        p.j(iArr, com.baidu.fsg.base.statistics.b.j);
        this.iBw = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.iBw.length;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        try {
            int[] iArr = this.iBw;
            int i = this.index;
            this.index = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
