package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ad;
/* loaded from: classes5.dex */
public final class b extends ad {
    private boolean hasNext;
    private final int nBT;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.nBT = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.hasNext = z;
        this.next = this.hasNext ? i : this.nBT;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ad
    public int nextInt() {
        int i = this.next;
        if (i == this.nBT) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
