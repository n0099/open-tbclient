package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes20.dex */
final class b extends kotlin.collections.m {
    private int index;
    private final byte[] oss;

    public b(byte[] bArr) {
        q.m(bArr, com.baidu.fsg.base.statistics.b.j);
        this.oss = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.oss.length;
    }

    @Override // kotlin.collections.m
    public byte nextByte() {
        try {
            byte[] bArr = this.oss;
            int i = this.index;
            this.index = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
