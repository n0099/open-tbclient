package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes10.dex */
final class c extends kotlin.collections.n {
    private int index;
    private final char[] pSy;

    public c(char[] cArr) {
        q.n(cArr, com.baidu.fsg.base.statistics.b.j);
        this.pSy = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pSy.length;
    }

    @Override // kotlin.collections.n
    public char eBw() {
        try {
            char[] cArr = this.pSy;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
