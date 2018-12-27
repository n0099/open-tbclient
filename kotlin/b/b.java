package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int iBI;
    private boolean iBJ;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.iBI = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.iBJ = z;
        this.next = this.iBJ ? i : this.iBI;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iBJ;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        int i = this.next;
        if (i == this.iBI) {
            if (!this.iBJ) {
                throw new NoSuchElementException();
            }
            this.iBJ = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
