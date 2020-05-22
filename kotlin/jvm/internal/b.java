package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
final class b extends kotlin.collections.m {
    private int index;
    private final byte[] nsJ;

    public b(byte[] bArr) {
        q.m(bArr, com.baidu.fsg.base.statistics.b.j);
        this.nsJ = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nsJ.length;
    }

    @Override // kotlin.collections.m
    public byte nextByte() {
        try {
            byte[] bArr = this.nsJ;
            int i = this.index;
            this.index = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
