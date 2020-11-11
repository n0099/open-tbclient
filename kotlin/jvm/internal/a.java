package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes10.dex */
final class a extends kotlin.collections.l {
    private int index;
    private final boolean[] pSw;

    public a(boolean[] zArr) {
        q.n(zArr, com.baidu.fsg.base.statistics.b.j);
        this.pSw = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pSw.length;
    }

    @Override // kotlin.collections.l
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.pSw;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
