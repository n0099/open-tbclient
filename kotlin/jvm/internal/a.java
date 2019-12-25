package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes4.dex */
final class a extends kotlin.collections.k {
    private int index;
    private final boolean[] mYV;

    public a(boolean[] zArr) {
        p.j(zArr, "array");
        this.mYV = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.mYV.length;
    }

    @Override // kotlin.collections.k
    public boolean dyF() {
        try {
            boolean[] zArr = this.mYV;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
