package kotlin.b;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes6.dex */
public final class b extends kotlin.collections.m {
    private boolean hasNext;
    private int next;
    private final int qtz;
    private final int step;

    public b(char c, char c2, int i) {
        boolean z = true;
        this.step = i;
        this.qtz = c2;
        if (this.step > 0) {
            if (c > c2) {
                z = false;
            }
        } else if (c < c2) {
            z = false;
        }
        this.hasNext = z;
        this.next = this.hasNext ? c : this.qtz;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.m
    public char eKV() {
        int i = this.next;
        if (i == this.qtz) {
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
