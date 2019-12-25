package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes4.dex */
final class c extends kotlin.collections.m {
    private int index;
    private final char[] mYX;

    public c(char[] cArr) {
        p.j(cArr, "array");
        this.mYX = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.mYX.length;
    }

    @Override // kotlin.collections.m
    public char dEB() {
        try {
            char[] cArr = this.mYX;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
