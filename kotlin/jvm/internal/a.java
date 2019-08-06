package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class a extends kotlin.collections.k {
    private int index;
    private final boolean[] ksP;

    public a(boolean[] zArr) {
        p.k(zArr, "array");
        this.ksP = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.ksP.length;
    }

    @Override // kotlin.collections.k
    public boolean cNL() {
        try {
            boolean[] zArr = this.ksP;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
