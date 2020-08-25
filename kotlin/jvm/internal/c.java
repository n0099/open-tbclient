package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes20.dex */
final class c extends kotlin.collections.n {
    private int index;
    private final char[] ost;

    public c(char[] cArr) {
        q.m(cArr, com.baidu.fsg.base.statistics.b.j);
        this.ost = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.ost.length;
    }

    @Override // kotlin.collections.n
    public char efQ() {
        try {
            char[] cArr = this.ost;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
