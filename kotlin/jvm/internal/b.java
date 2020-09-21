package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes5.dex */
final class b extends kotlin.collections.m {
    private int index;
    private final byte[] oCr;

    public b(byte[] bArr) {
        q.m(bArr, com.baidu.fsg.base.statistics.b.j);
        this.oCr = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.oCr.length;
    }

    @Override // kotlin.collections.m
    public byte nextByte() {
        try {
            byte[] bArr = this.oCr;
            int i = this.index;
            this.index = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
