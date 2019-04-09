package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
final class f extends y {
    private int index;
    private final int[] jRT;

    public f(int[] iArr) {
        p.k(iArr, "array");
        this.jRT = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.jRT.length;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        try {
            int[] iArr = this.jRT;
            int i = this.index;
            this.index = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
