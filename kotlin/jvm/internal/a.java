package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes20.dex */
final class a extends kotlin.collections.l {
    private int index;
    private final boolean[] osr;

    public a(boolean[] zArr) {
        q.m(zArr, com.baidu.fsg.base.statistics.b.j);
        this.osr = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.osr.length;
    }

    @Override // kotlin.collections.l
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.osr;
            int i = this.index;
            this.index = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
