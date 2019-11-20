package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class a extends kotlin.collections.k {
    private int index;
    private final boolean[] kuZ;

    public a(boolean[] zArr) {
        p.i(zArr, "array");
        this.kuZ = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kuZ.length;
    }

    @Override // kotlin.collections.k
    public boolean cMC() {
        try {
            boolean[] zArr = this.kuZ;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
