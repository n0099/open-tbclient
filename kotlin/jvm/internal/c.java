package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class c extends kotlin.collections.m {
    private int index;
    private final char[] jSF;

    public c(char[] cArr) {
        p.k(cArr, "array");
        this.jSF = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.jSF.length;
    }

    @Override // kotlin.collections.m
    public char cCs() {
        try {
            char[] cArr = this.jSF;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
