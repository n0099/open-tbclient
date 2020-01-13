package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ab;
/* loaded from: classes5.dex */
final class e extends ab {
    private int index;
    private final float[] nBB;

    public e(float[] fArr) {
        q.j(fArr, "array");
        this.nBB = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nBB.length;
    }

    @Override // kotlin.collections.ab
    public float nextFloat() {
        try {
            float[] fArr = this.nBB;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
