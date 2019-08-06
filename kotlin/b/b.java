package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int ktg;
    private boolean kth;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.ktg = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.kth = z;
        this.next = this.kth ? i : this.ktg;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.kth;
    }

    @Override // kotlin.collections.y
    public int cNW() {
        int i = this.next;
        if (i == this.ktg) {
            if (!this.kth) {
                throw new NoSuchElementException();
            }
            this.kth = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
