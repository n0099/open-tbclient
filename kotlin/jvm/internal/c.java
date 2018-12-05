package kotlin.jvm.internal;

import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
final class c extends kotlin.collections.m {
    private int index;
    private final char[] iyj;

    public c(char[] cArr) {
        p.h((Object) cArr, com.baidu.fsg.base.statistics.b.j);
        this.iyj = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.iyj.length;
    }

    @Override // kotlin.collections.m
    public char cbF() {
        try {
            char[] cArr = this.iyj;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
