package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ad;
/* loaded from: classes5.dex */
final class f extends ad {
    private int index;
    private final int[] nBC;

    public f(int[] iArr) {
        q.j(iArr, "array");
        this.nBC = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nBC.length;
    }

    @Override // kotlin.collections.ad
    public int nextInt() {
        try {
            int[] iArr = this.nBC;
            int i = this.index;
            this.index = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
