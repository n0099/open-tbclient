package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int iyy;
    private boolean iyz;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.iyy = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.iyz = z;
        this.next = this.iyz ? i : this.iyy;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iyz;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        int i = this.next;
        if (i == this.iyy) {
            if (!this.iyz) {
                throw new NoSuchElementException();
            }
            this.iyz = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
