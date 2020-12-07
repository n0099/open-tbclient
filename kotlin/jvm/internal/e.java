package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.w;
@kotlin.e
/* loaded from: classes17.dex */
final class e extends w {
    private int index;
    private final float[] pKx;

    public e(float[] fArr) {
        p.o(fArr, com.baidu.fsg.base.statistics.b.j);
        this.pKx = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pKx.length;
    }

    @Override // kotlin.collections.w
    public float eDO() {
        try {
            float[] fArr = this.pKx;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
