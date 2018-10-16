package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int ipD;
    private boolean ipE;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.ipD = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.ipE = z;
        this.next = this.ipE ? i : this.ipD;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.ipE;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        int i = this.next;
        if (i == this.ipD) {
            if (!this.ipE) {
                throw new NoSuchElementException();
            }
            this.ipE = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
