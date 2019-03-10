package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int jSU;
    private boolean jSV;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.jSU = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.jSV = z;
        this.next = this.jSV ? i : this.jSU;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.jSV;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        int i = this.next;
        if (i == this.jSU) {
            if (!this.jSV) {
                throw new NoSuchElementException();
            }
            this.jSV = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
