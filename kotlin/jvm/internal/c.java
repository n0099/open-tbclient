package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes5.dex */
final class c extends kotlin.collections.n {
    private int index;
    private final char[] oCs;

    public c(char[] cArr) {
        q.m(cArr, com.baidu.fsg.base.statistics.b.j);
        this.oCs = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.oCs.length;
    }

    @Override // kotlin.collections.n
    public char ejW() {
        try {
            char[] cArr = this.oCs;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
