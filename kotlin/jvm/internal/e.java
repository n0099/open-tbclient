package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ab;
@kotlin.h
/* loaded from: classes7.dex */
final class e extends ab {
    private int index;
    private final float[] mXK;

    public e(float[] fArr) {
        q.j(fArr, com.baidu.fsg.base.statistics.b.j);
        this.mXK = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.mXK.length;
    }

    @Override // kotlin.collections.ab
    public float nextFloat() {
        try {
            float[] fArr = this.mXK;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
