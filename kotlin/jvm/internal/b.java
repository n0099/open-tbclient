package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
final class b extends kotlin.collections.m {
    private int index;
    private final byte[] mXE;

    public b(byte[] bArr) {
        q.j(bArr, com.baidu.fsg.base.statistics.b.j);
        this.mXE = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.mXE.length;
    }

    @Override // kotlin.collections.m
    public byte nextByte() {
        try {
            byte[] bArr = this.mXE;
            int i = this.index;
            this.index = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
