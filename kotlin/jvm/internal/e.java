package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.w;
/* loaded from: classes2.dex */
final class e extends w {
    private int index;
    private final float[] ipq;

    public e(float[] fArr) {
        p.i(fArr, com.baidu.fsg.base.statistics.b.j);
        this.ipq = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.ipq.length;
    }

    @Override // kotlin.collections.w
    public float nextFloat() {
        try {
            float[] fArr = this.ipq;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
