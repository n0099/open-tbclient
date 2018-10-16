package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class c extends kotlin.collections.m {
    private int index;
    private final char[] ipo;

    public c(char[] cArr) {
        p.i(cArr, com.baidu.fsg.base.statistics.b.j);
        this.ipo = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.ipo.length;
    }

    @Override // kotlin.collections.m
    public char cac() {
        try {
            char[] cArr = this.ipo;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
