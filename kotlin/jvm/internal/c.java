package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class c extends kotlin.collections.m {
    private int index;
    private final char[] kvk;

    public c(char[] cArr) {
        p.k(cArr, "array");
        this.kvk = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kvk.length;
    }

    @Override // kotlin.collections.m
    public char cOz() {
        try {
            char[] cArr = this.kvk;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
