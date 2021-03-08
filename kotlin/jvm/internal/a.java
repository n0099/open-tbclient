package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes14.dex */
final class a extends kotlin.collections.k {
    private int index;
    private final boolean[] qul;

    public a(boolean[] zArr) {
        p.p(zArr, com.baidu.fsg.base.statistics.b.j);
        this.qul = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qul.length;
    }

    @Override // kotlin.collections.k
    public boolean eBI() {
        try {
            boolean[] zArr = this.qul;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
