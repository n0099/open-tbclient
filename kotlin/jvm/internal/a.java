package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
final class a extends kotlin.collections.l {
    private int index;
    private final boolean[] nEe;

    public a(boolean[] zArr) {
        q.j(zArr, "array");
        this.nEe = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nEe.length;
    }

    @Override // kotlin.collections.l
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.nEe;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
