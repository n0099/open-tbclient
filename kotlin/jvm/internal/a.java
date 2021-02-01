package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes6.dex */
final class a extends kotlin.collections.k {
    private int index;
    private final boolean[] qtj;

    public a(boolean[] zArr) {
        p.o(zArr, com.baidu.fsg.base.statistics.b.j);
        this.qtj = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qtj.length;
    }

    @Override // kotlin.collections.k
    public boolean eBu() {
        try {
            boolean[] zArr = this.qtj;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
