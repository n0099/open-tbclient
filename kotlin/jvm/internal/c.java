package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes5.dex */
final class c extends kotlin.collections.n {
    private int index;
    private final char[] nBz;

    public c(char[] cArr) {
        q.j(cArr, "array");
        this.nBz = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nBz.length;
    }

    @Override // kotlin.collections.n
    public char dIR() {
        try {
            char[] cArr = this.nBz;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
