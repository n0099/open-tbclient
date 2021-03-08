package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.e
/* loaded from: classes14.dex */
public final class j extends z {
    private boolean hasNext;
    private final long quO;
    private final long quQ;
    private long quR;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.quO = j3;
        this.quQ = j2;
        if (this.quO > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.quR = this.hasNext ? j : this.quQ;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.z
    public long eBL() {
        long j = this.quR;
        if (j == this.quQ) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.quR += this.quO;
        }
        return j;
    }
}
