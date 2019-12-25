package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.w;
/* loaded from: classes4.dex */
final class e extends w {
    private int index;
    private final float[] mYZ;

    public e(float[] fArr) {
        p.j(fArr, "array");
        this.mYZ = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.mYZ.length;
    }

    @Override // kotlin.collections.w
    public float dgN() {
        try {
            float[] fArr = this.mYZ;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
