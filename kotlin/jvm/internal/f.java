package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes7.dex */
final class f extends ad {
    private int index;
    private final int[] nsN;

    public f(int[] iArr) {
        q.m(iArr, com.baidu.fsg.base.statistics.b.j);
        this.nsN = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nsN.length;
    }

    @Override // kotlin.collections.ad
    public int nextInt() {
        try {
            int[] iArr = this.nsN;
            int i = this.index;
            this.index = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
