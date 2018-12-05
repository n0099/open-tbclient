package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.w;
/* loaded from: classes2.dex */
final class e extends w {
    private int index;
    private final float[] iyl;

    public e(float[] fArr) {
        p.h((Object) fArr, com.baidu.fsg.base.statistics.b.j);
        this.iyl = fArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.iyl.length;
    }

    @Override // kotlin.collections.w
    public float nextFloat() {
        try {
            float[] fArr = this.iyl;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
