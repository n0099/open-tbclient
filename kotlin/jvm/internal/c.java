package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes5.dex */
final class c extends kotlin.collections.m {
    private int index;
    private final char[] qma;

    public c(char[] cArr) {
        p.o(cArr, com.baidu.fsg.base.statistics.b.j);
        this.qma = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qma.length;
    }

    @Override // kotlin.collections.m
    public char eLR() {
        try {
            char[] cArr = this.qma;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
