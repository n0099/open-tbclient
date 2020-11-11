package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes10.dex */
final class b extends kotlin.collections.m {
    private int index;
    private final byte[] pSx;

    public b(byte[] bArr) {
        q.n(bArr, com.baidu.fsg.base.statistics.b.j);
        this.pSx = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pSx.length;
    }

    @Override // kotlin.collections.m
    public byte nextByte() {
        try {
            byte[] bArr = this.pSx;
            int i = this.index;
            this.index = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
