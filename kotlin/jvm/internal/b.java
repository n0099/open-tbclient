package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
final class b extends kotlin.collections.m {
    private int index;
    private final byte[] nEf;

    public b(byte[] bArr) {
        q.j(bArr, "array");
        this.nEf = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nEf.length;
    }

    @Override // kotlin.collections.m
    public byte nextByte() {
        try {
            byte[] bArr = this.nEf;
            int i = this.index;
            this.index = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
