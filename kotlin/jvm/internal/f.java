package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
final class f extends y {
    private int index;
    private final int[] kvV;

    public f(int[] iArr) {
        p.i(iArr, "array");
        this.kvV = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kvV.length;
    }

    @Override // kotlin.collections.y
    public int cMP() {
        try {
            int[] iArr = this.kvV;
            int i = this.index;
            this.index = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
