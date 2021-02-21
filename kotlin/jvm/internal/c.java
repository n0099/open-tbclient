package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes6.dex */
final class c extends kotlin.collections.m {
    private int index;
    private final char[] qtL;

    public c(char[] cArr) {
        p.o(cArr, com.baidu.fsg.base.statistics.b.j);
        this.qtL = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qtL.length;
    }

    @Override // kotlin.collections.m
    public char eLd() {
        try {
            char[] cArr = this.qtL;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
