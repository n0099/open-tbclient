package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.e
/* loaded from: classes5.dex */
public final class j extends z {
    private boolean hasNext;
    private final long qmB;
    private final long qmD;
    private long qmE;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.qmB = j3;
        this.qmD = j2;
        if (this.qmB > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.qmE = this.hasNext ? j : this.qmD;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.z
    public long eCt() {
        long j = this.qmE;
        if (j == this.qmD) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.qmE += this.qmB;
        }
        return j;
    }
}
