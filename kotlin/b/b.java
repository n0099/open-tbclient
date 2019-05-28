package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int kky;
    private boolean kkz;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.kky = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.kkz = z;
        this.next = this.kkz ? i : this.kky;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.kkz;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        int i = this.next;
        if (i == this.kky) {
            if (!this.kkz) {
                throw new NoSuchElementException();
            }
            this.kkz = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
