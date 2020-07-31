package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ab;
@kotlin.h
/* loaded from: classes7.dex */
final class e extends ab {
    private int index;
    private final float[] nYv;

    public e(float[] fArr) {
        q.m(fArr, com.baidu.fsg.base.statistics.b.j);
        this.nYv = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nYv.length;
    }

    @Override // kotlin.collections.ab
    public float nextFloat() {
        try {
            float[] fArr = this.nYv;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
