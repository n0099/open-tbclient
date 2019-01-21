package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class c extends kotlin.collections.m {
    private final char[] iCB;
    private int index;

    public c(char[] cArr) {
        p.j(cArr, com.baidu.fsg.base.statistics.b.j);
        this.iCB = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.iCB.length;
    }

    @Override // kotlin.collections.m
    public char cdd() {
        try {
            char[] cArr = this.iCB;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
