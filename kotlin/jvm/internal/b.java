package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes10.dex */
final class b extends kotlin.collections.m {
    private int index;
    private final byte[] oRG;

    public b(byte[] bArr) {
        q.n(bArr, com.baidu.fsg.base.statistics.b.j);
        this.oRG = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.oRG.length;
    }

    @Override // kotlin.collections.m
    public byte nextByte() {
        try {
            byte[] bArr = this.oRG;
            int i = this.index;
            this.index = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
