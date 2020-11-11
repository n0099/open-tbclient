package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes10.dex */
final class f extends ad {
    private int index;
    private final int[] pSB;

    public f(int[] iArr) {
        q.n(iArr, com.baidu.fsg.base.statistics.b.j);
        this.pSB = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pSB.length;
    }

    @Override // kotlin.collections.ad
    public int nextInt() {
        try {
            int[] iArr = this.pSB;
            int i = this.index;
            this.index = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
