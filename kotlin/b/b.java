package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int ksa;
    private boolean ksb;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.ksa = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.ksb = z;
        this.next = this.ksb ? i : this.ksa;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.ksb;
    }

    @Override // kotlin.collections.y
    public int cNB() {
        int i = this.next;
        if (i == this.ksa) {
            if (!this.ksb) {
                throw new NoSuchElementException();
            }
            this.ksb = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
