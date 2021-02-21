package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.w;
@kotlin.e
/* loaded from: classes6.dex */
final class e extends w {
    private int index;
    private final float[] qtN;

    public e(float[] fArr) {
        p.o(fArr, com.baidu.fsg.base.statistics.b.j);
        this.qtN = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qtN.length;
    }

    @Override // kotlin.collections.w
    public float eLj() {
        try {
            float[] fArr = this.qtN;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
