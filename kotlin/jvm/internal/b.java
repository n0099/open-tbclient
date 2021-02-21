package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes6.dex */
final class b extends kotlin.collections.l {
    private int index;
    private final byte[] qtK;

    public b(byte[] bArr) {
        p.o(bArr, com.baidu.fsg.base.statistics.b.j);
        this.qtK = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qtK.length;
    }

    @Override // kotlin.collections.l
    public byte nextByte() {
        try {
            byte[] bArr = this.qtK;
            int i = this.index;
            this.index = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
