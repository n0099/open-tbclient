package kotlin.b;

import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
public final class b extends kotlin.collections.n {
    private boolean hasNext;
    private int next;
    private final int nte;
    private final int step;

    public b(char c, char c2, int i) {
        boolean z = true;
        this.step = i;
        this.nte = c2;
        if (this.step > 0) {
            if (c > c2) {
                z = false;
            }
        } else if (c < c2) {
            z = false;
        }
        this.hasNext = z;
        this.next = this.hasNext ? c : this.nte;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.n
    public char dLt() {
        int i = this.next;
        if (i == this.nte) {
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
