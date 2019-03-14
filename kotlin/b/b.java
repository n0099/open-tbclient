package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int jSM;
    private boolean jSN;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.jSM = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.jSN = z;
        this.next = this.jSN ? i : this.jSM;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.jSN;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        int i = this.next;
        if (i == this.jSM) {
            if (!this.jSN) {
                throw new NoSuchElementException();
            }
            this.jSN = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
