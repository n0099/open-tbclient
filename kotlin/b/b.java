package kotlin.b;

import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes5.dex */
public final class b extends kotlin.collections.m {
    private boolean hasNext;
    private int next;
    private final int qju;
    private final int step;

    public b(char c, char c2, int i) {
        boolean z = true;
        this.step = i;
        this.qju = c2;
        if (this.step > 0) {
            if (c > c2) {
                z = false;
            }
        } else if (c < c2) {
            z = false;
        }
        this.hasNext = z;
        this.next = this.hasNext ? c : this.qju;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.m
    public char eIF() {
        int i = this.next;
        if (i == this.qju) {
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
