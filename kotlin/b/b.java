package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int kvq;
    private boolean kvr;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.kvq = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.kvr = z;
        this.next = this.kvr ? i : this.kvq;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.kvr;
    }

    @Override // kotlin.collections.y
    public int cMN() {
        int i = this.next;
        if (i == this.kvq) {
            if (!this.kvr) {
                throw new NoSuchElementException();
            }
            this.kvr = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
