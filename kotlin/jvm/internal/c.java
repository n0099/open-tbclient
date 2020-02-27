package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
final class c extends kotlin.collections.n {
    private int index;
    private final char[] nCg;

    public c(char[] cArr) {
        q.j(cArr, "array");
        this.nCg = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nCg.length;
    }

    @Override // kotlin.collections.n
    public char dKa() {
        try {
            char[] cArr = this.nCg;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
