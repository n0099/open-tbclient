package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int kkx;
    private boolean kky;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.kkx = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.kky = z;
        this.next = this.kky ? i : this.kkx;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.kky;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        int i = this.next;
        if (i == this.kkx) {
            if (!this.kky) {
                throw new NoSuchElementException();
            }
            this.kky = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
