package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class c extends kotlin.collections.m {
    private int index;
    private final char[] jRQ;

    public c(char[] cArr) {
        p.k(cArr, "array");
        this.jRQ = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.jRQ.length;
    }

    @Override // kotlin.collections.m
    public char cCk() {
        try {
            char[] cArr = this.jRQ;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
