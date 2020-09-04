package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes20.dex */
final class b extends kotlin.collections.m {
    private int index;
    private final byte[] osK;

    public b(byte[] bArr) {
        q.m(bArr, com.baidu.fsg.base.statistics.b.j);
        this.osK = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.osK.length;
    }

    @Override // kotlin.collections.m
    public byte nextByte() {
        try {
            byte[] bArr = this.osK;
            int i = this.index;
            this.index = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
