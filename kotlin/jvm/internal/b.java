package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes5.dex */
final class b extends kotlin.collections.l {
    private int index;
    private final byte[] qjg;

    public b(byte[] bArr) {
        p.o(bArr, com.baidu.fsg.base.statistics.b.j);
        this.qjg = bArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qjg.length;
    }

    @Override // kotlin.collections.l
    public byte nextByte() {
        try {
            byte[] bArr = this.qjg;
            int i = this.index;
            this.index = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
