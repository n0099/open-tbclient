package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes5.dex */
final class c extends kotlin.collections.n {
    private int index;
    private final char[] nBE;

    public c(char[] cArr) {
        q.j(cArr, "array");
        this.nBE = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nBE.length;
    }

    @Override // kotlin.collections.n
    public char dIT() {
        try {
            char[] cArr = this.nBE;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
