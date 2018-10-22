package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int ipE;
    private boolean ipF;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.ipE = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.ipF = z;
        this.next = this.ipF ? i : this.ipE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.ipF;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        int i = this.next;
        if (i == this.ipE) {
            if (!this.ipF) {
                throw new NoSuchElementException();
            }
            this.ipF = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
