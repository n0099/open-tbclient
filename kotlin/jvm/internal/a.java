package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes5.dex */
final class a extends kotlin.collections.l {
    private int index;
    private final boolean[] nBx;

    public a(boolean[] zArr) {
        q.j(zArr, "array");
        this.nBx = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nBx.length;
    }

    @Override // kotlin.collections.l
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.nBx;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
