package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes20.dex */
final class c extends kotlin.collections.n {
    private int index;
    private final char[] osL;

    public c(char[] cArr) {
        q.m(cArr, com.baidu.fsg.base.statistics.b.j);
        this.osL = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.osL.length;
    }

    @Override // kotlin.collections.n
    public char efZ() {
        try {
            char[] cArr = this.osL;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
