package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes6.dex */
final class c extends kotlin.collections.m {
    private int index;
    private final char[] qtl;

    public c(char[] cArr) {
        p.o(cArr, com.baidu.fsg.base.statistics.b.j);
        this.qtl = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qtl.length;
    }

    @Override // kotlin.collections.m
    public char eKV() {
        try {
            char[] cArr = this.qtl;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
