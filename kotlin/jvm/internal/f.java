package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
final class f extends y {
    private int index;
    private final int[] iym;

    public f(int[] iArr) {
        p.h((Object) iArr, com.baidu.fsg.base.statistics.b.j);
        this.iym = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.iym.length;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        try {
            int[] iArr = this.iym;
            int i = this.index;
            this.index = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
