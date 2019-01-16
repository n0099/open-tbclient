package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class b extends kotlin.collections.l {
    private final byte[] iCz;
    private int index;

    public b(byte[] bArr) {
        p.j(bArr, com.baidu.fsg.base.statistics.b.j);
        this.iCz = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.iCz.length;
    }

    @Override // kotlin.collections.l
    public byte nextByte() {
        try {
            byte[] bArr = this.iCz;
            int i = this.index;
            this.index = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
