package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class c extends kotlin.collections.m {
    private int index;
    private final char[] kvS;

    public c(char[] cArr) {
        p.i(cArr, "array");
        this.kvS = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kvS.length;
    }

    @Override // kotlin.collections.m
    public char cMG() {
        try {
            char[] cArr = this.kvS;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
