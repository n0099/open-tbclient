package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
final class c extends kotlin.collections.n {
    private int index;
    private final char[] nEg;

    public c(char[] cArr) {
        q.j(cArr, "array");
        this.nEg = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nEg.length;
    }

    @Override // kotlin.collections.n
    public char dKD() {
        try {
            char[] cArr = this.nEg;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
