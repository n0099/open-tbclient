package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.y;
@kotlin.e
/* loaded from: classes5.dex */
public final class g extends y {
    private boolean hasNext;
    private int next;
    private final int qju;
    private final int step;

    public g(int i, int i2, int i3) {
        boolean z = true;
        this.step = i3;
        this.qju = i2;
        if (this.step > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.hasNext = z;
        this.next = this.hasNext ? i : this.qju;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.y
    public int ezg() {
        int i = this.next;
        if (i == this.qju) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.next += this.step;
        }
        return i;
    }
}
