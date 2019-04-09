package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int jSf;
    private boolean jSg;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.jSf = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.jSg = z;
        this.next = this.jSg ? i : this.jSf;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.jSg;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        int i = this.next;
        if (i == this.jSf) {
            if (!this.jSg) {
                throw new NoSuchElementException();
            }
            this.jSg = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
