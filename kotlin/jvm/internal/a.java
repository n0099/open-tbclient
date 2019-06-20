package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class a extends kotlin.collections.k {
    private int index;
    private final boolean[] kkk;

    public a(boolean[] zArr) {
        p.k(zArr, "array");
        this.kkk = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kkk.length;
    }

    @Override // kotlin.collections.k
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.kkk;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
