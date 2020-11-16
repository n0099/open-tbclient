package kotlin.b;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes9.dex */
public final class b extends kotlin.collections.n {
    private boolean hasNext;
    private int next;
    private final int pUv;
    private final int step;

    public b(char c, char c2, int i) {
        boolean z = true;
        this.step = i;
        this.pUv = c2;
        if (this.step > 0) {
            if (c > c2) {
                z = false;
            }
        } else if (c < c2) {
            z = false;
        }
        this.hasNext = z;
        this.next = this.hasNext ? c : this.pUv;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.n
    public char eBx() {
        int i = this.next;
        if (i == this.pUv) {
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
