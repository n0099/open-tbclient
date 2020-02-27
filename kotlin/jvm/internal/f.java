package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ad;
@kotlin.h
/* loaded from: classes7.dex */
final class f extends ad {
    private int index;
    private final int[] nCj;

    public f(int[] iArr) {
        q.j(iArr, "array");
        this.nCj = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nCj.length;
    }

    @Override // kotlin.collections.ad
    public int nextInt() {
        try {
            int[] iArr = this.nCj;
            int i = this.index;
            this.index = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
