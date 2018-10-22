package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class a extends kotlin.collections.k {
    private int index;
    private final boolean[] ipn;

    public a(boolean[] zArr) {
        p.i(zArr, com.baidu.fsg.base.statistics.b.j);
        this.ipn = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.ipn.length;
    }

    @Override // kotlin.collections.k
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.ipn;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
