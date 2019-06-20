package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class c extends kotlin.collections.m {
    private int index;
    private final char[] kkm;

    public c(char[] cArr) {
        p.k(cArr, "array");
        this.kkm = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kkm.length;
    }

    @Override // kotlin.collections.m
    public char cJR() {
        try {
            char[] cArr = this.kkm;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
