package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes4.dex */
final class f extends y {
    private int index;
    private final int[] mZa;

    public f(int[] iArr) {
        p.j(iArr, "array");
        this.mZa = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.mZa.length;
    }

    @Override // kotlin.collections.y
    public int dyJ() {
        try {
            int[] iArr = this.mZa;
            int i = this.index;
            this.index = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
