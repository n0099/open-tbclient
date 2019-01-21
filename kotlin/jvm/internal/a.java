package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class a extends kotlin.collections.k {
    private final boolean[] iCz;
    private int index;

    public a(boolean[] zArr) {
        p.j(zArr, com.baidu.fsg.base.statistics.b.j);
        this.iCz = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.iCz.length;
    }

    @Override // kotlin.collections.k
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.iCz;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
