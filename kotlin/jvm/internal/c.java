package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
final class c extends kotlin.collections.n {
    private int index;
    private final char[] mXF;

    public c(char[] cArr) {
        q.j(cArr, com.baidu.fsg.base.statistics.b.j);
        this.mXF = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.mXF.length;
    }

    @Override // kotlin.collections.n
    public char dDC() {
        try {
            char[] cArr = this.mXF;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
