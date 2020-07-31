package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
final class c extends kotlin.collections.n {
    private int index;
    private final char[] nYt;

    public c(char[] cArr) {
        q.m(cArr, com.baidu.fsg.base.statistics.b.j);
        this.nYt = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nYt.length;
    }

    @Override // kotlin.collections.n
    public char dTN() {
        try {
            char[] cArr = this.nYt;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
