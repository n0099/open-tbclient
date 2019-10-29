package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class b extends kotlin.collections.l {
    private int index;
    private final byte[] kvR;

    public b(byte[] bArr) {
        p.i(bArr, "array");
        this.kvR = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.kvR.length;
    }

    @Override // kotlin.collections.l
    public byte nextByte() {
        try {
            byte[] bArr = this.kvR;
            int i = this.index;
            this.index = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
