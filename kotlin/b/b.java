package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int kkB;
    private boolean kkC;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.kkB = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.kkC = z;
        this.next = this.kkC ? i : this.kkB;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.kkC;
    }

    @Override // kotlin.collections.y
    public int nextInt() {
        int i = this.next;
        if (i == this.kkB) {
            if (!this.kkC) {
                throw new NoSuchElementException();
            }
            this.kkC = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
