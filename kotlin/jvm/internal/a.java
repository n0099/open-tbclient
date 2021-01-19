package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes5.dex */
final class a extends kotlin.collections.k {
    private int index;
    private final boolean[] qjf;

    public a(boolean[] zArr) {
        p.o(zArr, com.baidu.fsg.base.statistics.b.j);
        this.qjf = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qjf.length;
    }

    @Override // kotlin.collections.k
    public boolean ezc() {
        try {
            boolean[] zArr = this.qjf;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
