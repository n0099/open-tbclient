package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes5.dex */
final class b extends kotlin.collections.m {
    private int index;
    private final byte[] nBD;

    public b(byte[] bArr) {
        q.j(bArr, "array");
        this.nBD = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.nBD.length;
    }

    @Override // kotlin.collections.m
    public byte nextByte() {
        try {
            byte[] bArr = this.nBD;
            int i = this.index;
            this.index = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
