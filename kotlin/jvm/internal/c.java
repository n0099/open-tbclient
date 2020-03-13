package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
final class c extends kotlin.collections.n {
    private int index;
    private final char[] nCt;

    public c(char[] cArr) {
        q.j(cArr, "array");
        this.nCt = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nCt.length;
    }

    @Override // kotlin.collections.n
    public char dKd() {
        try {
            char[] cArr = this.nCt;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
