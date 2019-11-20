package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.w;
/* loaded from: classes2.dex */
final class e extends w {
    private int index;
    private final float[] kvd;

    public e(float[] fArr) {
        p.i(fArr, "array");
        this.kvd = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kvd.length;
    }

    @Override // kotlin.collections.w
    public float cML() {
        try {
            float[] fArr = this.kvd;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
