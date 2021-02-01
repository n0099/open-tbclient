package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.w;
@kotlin.e
/* loaded from: classes6.dex */
final class e extends w {
    private int index;
    private final float[] qtn;

    public e(float[] fArr) {
        p.o(fArr, com.baidu.fsg.base.statistics.b.j);
        this.qtn = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qtn.length;
    }

    @Override // kotlin.collections.w
    public float eLb() {
        try {
            float[] fArr = this.qtn;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
