package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes9.dex */
final class b extends kotlin.collections.m {
    private int index;
    private final byte[] pUa;

    public b(byte[] bArr) {
        q.n(bArr, com.baidu.fsg.base.statistics.b.j);
        this.pUa = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.pUa.length;
    }

    @Override // kotlin.collections.m
    public byte nextByte() {
        try {
            byte[] bArr = this.pUa;
            int i = this.index;
            this.index = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
