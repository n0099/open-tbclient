package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes9.dex */
final class c extends kotlin.collections.n {
    private int index;
    private final char[] pUb;

    public c(char[] cArr) {
        q.n(cArr, com.baidu.fsg.base.statistics.b.j);
        this.pUb = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pUb.length;
    }

    @Override // kotlin.collections.n
    public char eBx() {
        try {
            char[] cArr = this.pUb;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
