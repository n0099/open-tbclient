package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int iCQ;
    private boolean iCR;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.iCQ = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.iCR = z;
        this.next = this.iCR ? i : this.iCQ;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iCR;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        int i = this.next;
        if (i == this.iCQ) {
            if (!this.iCR) {
                throw new NoSuchElementException();
            }
            this.iCR = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
