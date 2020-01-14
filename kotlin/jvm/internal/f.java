package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ad;
/* loaded from: classes5.dex */
final class f extends ad {
    private int index;
    private final int[] nBH;

    public f(int[] iArr) {
        q.j(iArr, "array");
        this.nBH = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nBH.length;
    }

    @Override // kotlin.collections.ad
    public int nextInt() {
        try {
            int[] iArr = this.nBH;
            int i = this.index;
            this.index = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
