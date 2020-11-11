package kotlin.b;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes10.dex */
public final class b extends kotlin.collections.n {
    private boolean hasNext;
    private int next;
    private final int pSS;
    private final int step;

    public b(char c, char c2, int i) {
        boolean z = true;
        this.step = i;
        this.pSS = c2;
        if (this.step > 0) {
            if (c > c2) {
                z = false;
            }
        } else if (c < c2) {
            z = false;
        }
        this.hasNext = z;
        this.next = this.hasNext ? c : this.pSS;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.n
    public char eBw() {
        int i = this.next;
        if (i == this.pSS) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.next += this.step;
        }
        return (char) i;
    }
}
