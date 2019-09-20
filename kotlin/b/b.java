package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private boolean kvA;
    private final int kvz;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.kvz = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.kvA = z;
        this.next = this.kvA ? i : this.kvz;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.kvA;
    }

    @Override // kotlin.collections.y
    public int cOI() {
        int i = this.next;
        if (i == this.kvz) {
            if (!this.kvA) {
                throw new NoSuchElementException();
            }
            this.kvA = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
