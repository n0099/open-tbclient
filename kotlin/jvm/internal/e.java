package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.w;
/* loaded from: classes2.dex */
final class e extends w {
    private final float[] iCC;
    private int index;

    public e(float[] fArr) {
        p.j(fArr, com.baidu.fsg.base.statistics.b.j);
        this.iCC = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.iCC.length;
    }

    @Override // kotlin.collections.w
    public float nextFloat() {
        try {
            float[] fArr = this.iCC;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
