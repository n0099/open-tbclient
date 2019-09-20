package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class a extends kotlin.collections.k {
    private int index;
    private final boolean[] kvi;

    public a(boolean[] zArr) {
        p.k(zArr, "array");
        this.kvi = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kvi.length;
    }

    @Override // kotlin.collections.k
    public boolean cOx() {
        try {
            boolean[] zArr = this.kvi;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
