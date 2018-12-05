package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class a extends kotlin.collections.k {
    private int index;
    private final boolean[] iyh;

    public a(boolean[] zArr) {
        p.h((Object) zArr, com.baidu.fsg.base.statistics.b.j);
        this.iyh = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.iyh.length;
    }

    @Override // kotlin.collections.k
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.iyh;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
