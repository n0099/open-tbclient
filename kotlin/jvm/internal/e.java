package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ab;
@kotlin.h
/* loaded from: classes7.dex */
final class e extends ab {
    private int index;
    private final float[] nCi;

    public e(float[] fArr) {
        q.j(fArr, "array");
        this.nCi = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nCi.length;
    }

    @Override // kotlin.collections.ab
    public float nextFloat() {
        try {
            float[] fArr = this.nCi;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
