package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.w;
/* loaded from: classes2.dex */
final class e extends w {
    private int index;
    private final float[] jRR;

    public e(float[] fArr) {
        p.k(fArr, "array");
        this.jRR = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.jRR.length;
    }

    @Override // kotlin.collections.w
    public float nextFloat() {
        try {
            float[] fArr = this.jRR;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
