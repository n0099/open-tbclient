package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
final class f extends y {
    private int index;
    private final int[] kve;

    public f(int[] iArr) {
        p.i(iArr, "array");
        this.kve = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kve.length;
    }

    @Override // kotlin.collections.y
    public int cMN() {
        try {
            int[] iArr = this.kve;
            int i = this.index;
            this.index = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
