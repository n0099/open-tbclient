package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes4.dex */
final class b extends kotlin.collections.l {
    private int index;
    private final byte[] mYW;

    public b(byte[] bArr) {
        p.j(bArr, "array");
        this.mYW = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.mYW.length;
    }

    @Override // kotlin.collections.l
    public byte nextByte() {
        try {
            byte[] bArr = this.mYW;
            int i = this.index;
            this.index = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
