package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.w;
@kotlin.e
/* loaded from: classes14.dex */
final class e extends w {
    private int index;
    private final float[] qup;

    public e(float[] fArr) {
        p.p(fArr, com.baidu.fsg.base.statistics.b.j);
        this.qup = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qup.length;
    }

    @Override // kotlin.collections.w
    public float eKR() {
        try {
            float[] fArr = this.qup;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
