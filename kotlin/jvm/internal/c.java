package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes17.dex */
final class c extends kotlin.collections.m {
    private int index;
    private final char[] pKx;

    public c(char[] cArr) {
        p.o(cArr, com.baidu.fsg.base.statistics.b.j);
        this.pKx = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pKx.length;
    }

    @Override // kotlin.collections.m
    public char eDJ() {
        try {
            char[] cArr = this.pKx;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
