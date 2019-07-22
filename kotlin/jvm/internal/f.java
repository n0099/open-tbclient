package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
final class f extends y {
    private int index;
    private final int[] krO;

    public f(int[] iArr) {
        p.k(iArr, "array");
        this.krO = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.krO.length;
    }

    @Override // kotlin.collections.y
    public int cNB() {
        try {
            int[] iArr = this.krO;
            int i = this.index;
            this.index = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
