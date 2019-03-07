package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int jSB;
    private boolean jSC;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.jSB = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.jSC = z;
        this.next = this.jSC ? i : this.jSB;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.jSC;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        int i = this.next;
        if (i == this.jSB) {
            if (!this.jSC) {
                throw new NoSuchElementException();
            }
            this.jSC = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
