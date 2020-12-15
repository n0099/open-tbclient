package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes17.dex */
final class a extends kotlin.collections.k {
    private int index;
    private final boolean[] pKv;

    public a(boolean[] zArr) {
        p.o(zArr, com.baidu.fsg.base.statistics.b.j);
        this.pKv = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pKv.length;
    }

    @Override // kotlin.collections.k
    public boolean eyE() {
        try {
            boolean[] zArr = this.pKv;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
