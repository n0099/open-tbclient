package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class c extends kotlin.collections.m {
    private final char[] iBt;
    private int index;

    public c(char[] cArr) {
        p.j(cArr, com.baidu.fsg.base.statistics.b.j);
        this.iBt = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.iBt.length;
    }

    @Override // kotlin.collections.m
    public char ccv() {
        try {
            char[] cArr = this.iBt;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
