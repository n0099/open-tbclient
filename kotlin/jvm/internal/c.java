package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
final class c extends kotlin.collections.n {
    private int index;
    private final char[] ntU;

    public c(char[] cArr) {
        q.m(cArr, com.baidu.fsg.base.statistics.b.j);
        this.ntU = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.ntU.length;
    }

    @Override // kotlin.collections.n
    public char dLH() {
        try {
            char[] cArr = this.ntU;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
