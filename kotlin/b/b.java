package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
/* loaded from: classes2.dex */
public final class b extends y {
    private final int kwh;
    private boolean kwi;
    private int next;
    private final int step;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.kwh = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.kwi = z;
        this.next = this.kwi ? i : this.kwh;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.kwi;
    }

    @Override // kotlin.collections.y
    public int cMP() {
        int i = this.next;
        if (i == this.kwh) {
            if (!this.kwi) {
                throw new NoSuchElementException();
            }
            this.kwi = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
