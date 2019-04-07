package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int jSe;
    private boolean jSf;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.jSe = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.jSf = z;
        this.next = this.jSf ? i : this.jSe;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.jSf;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        int i = this.next;
        if (i == this.jSe) {
            if (!this.jSf) {
                throw new NoSuchElementException();
            }
            this.jSf = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
