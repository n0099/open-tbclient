package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ap;
@kotlin.h
/* loaded from: classes5.dex */
final class k extends ap {
    private int index;
    private final short[] oCx;

    public k(short[] sArr) {
        q.m(sArr, com.baidu.fsg.base.statistics.b.j);
        this.oCx = sArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.oCx.length;
    }

    @Override // kotlin.collections.ap
    public short ekg() {
        try {
            short[] sArr = this.oCx;
            int i = this.index;
            this.index = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
