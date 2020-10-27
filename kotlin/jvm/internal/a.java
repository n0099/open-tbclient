package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes10.dex */
final class a extends kotlin.collections.l {
    private int index;
    private final boolean[] pJc;

    public a(boolean[] zArr) {
        q.n(zArr, com.baidu.fsg.base.statistics.b.j);
        this.pJc = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pJc.length;
    }

    @Override // kotlin.collections.l
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.pJc;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
