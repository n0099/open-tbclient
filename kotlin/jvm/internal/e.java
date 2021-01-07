package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.w;
@kotlin.e
/* loaded from: classes5.dex */
final class e extends w {
    private int index;
    private final float[] qnK;

    public e(float[] fArr) {
        p.o(fArr, com.baidu.fsg.base.statistics.b.j);
        this.qnK = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qnK.length;
    }

    @Override // kotlin.collections.w
    public float eMB() {
        try {
            float[] fArr = this.qnK;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
