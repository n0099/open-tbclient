package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class a extends kotlin.collections.k {
    private int index;
    private final boolean[] kvQ;

    public a(boolean[] zArr) {
        p.i(zArr, "array");
        this.kvQ = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kvQ.length;
    }

    @Override // kotlin.collections.k
    public boolean cME() {
        try {
            boolean[] zArr = this.kvQ;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
