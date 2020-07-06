package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
final class c extends kotlin.collections.n {
    private int index;
    private final char[] nPK;

    public c(char[] cArr) {
        q.m(cArr, com.baidu.fsg.base.statistics.b.j);
        this.nPK = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nPK.length;
    }

    @Override // kotlin.collections.n
    public char dQr() {
        try {
            char[] cArr = this.nPK;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
