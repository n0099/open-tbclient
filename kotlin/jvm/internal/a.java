package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes5.dex */
final class a extends kotlin.collections.k {
    private int index;
    private final boolean[] qlY;

    public a(boolean[] zArr) {
        p.o(zArr, com.baidu.fsg.base.statistics.b.j);
        this.qlY = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qlY.length;
    }

    @Override // kotlin.collections.k
    public boolean eCq() {
        try {
            boolean[] zArr = this.qlY;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
