package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
final class c extends kotlin.collections.n {
    private int index;
    private final char[] nsK;

    public c(char[] cArr) {
        q.m(cArr, com.baidu.fsg.base.statistics.b.j);
        this.nsK = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nsK.length;
    }

    @Override // kotlin.collections.n
    public char dLt() {
        try {
            char[] cArr = this.nsK;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
