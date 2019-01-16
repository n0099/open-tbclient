package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int iCP;
    private boolean iCQ;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.iCP = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.iCQ = z;
        this.next = this.iCQ ? i : this.iCP;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iCQ;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        int i = this.next;
        if (i == this.iCP) {
            if (!this.iCQ) {
                throw new NoSuchElementException();
            }
            this.iCQ = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
