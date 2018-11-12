package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int iro;
    private boolean irp;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.iro = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.irp = z;
        this.next = this.irp ? i : this.iro;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.irp;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        int i = this.next;
        if (i == this.iro) {
            if (!this.irp) {
                throw new NoSuchElementException();
            }
            this.irp = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
