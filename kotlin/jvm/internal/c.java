package kotlin.jvm.internal;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes14.dex */
final class c extends kotlin.collections.m {
    private int index;
    private final char[] qun;

    public c(char[] cArr) {
        p.p(cArr, com.baidu.fsg.base.statistics.b.j);
        this.qun = cArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.qun.length;
    }

    @Override // kotlin.collections.m
    public char eKL() {
        try {
            char[] cArr = this.qun;
            int i = this.index;
            this.index = i + 1;
            return cArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
