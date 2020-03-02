package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
final class c extends kotlin.collections.n {
    private int index;
    private final char[] nCi;

    public c(char[] cArr) {
        q.j(cArr, "array");
        this.nCi = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nCi.length;
    }

    @Override // kotlin.collections.n
    public char dKc() {
        try {
            char[] cArr = this.nCi;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
