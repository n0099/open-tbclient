package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class c extends kotlin.collections.m {
    private int index;
    private final char[] iqZ;

    public c(char[] cArr) {
        p.h((Object) cArr, com.baidu.fsg.base.statistics.b.j);
        this.iqZ = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.iqZ.length;
    }

    @Override // kotlin.collections.m
    public char bZz() {
        try {
            char[] cArr = this.iqZ;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
