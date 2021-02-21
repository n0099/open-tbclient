package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.e
/* loaded from: classes6.dex */
public final class j extends z {
    private boolean hasNext;
    private final long qum;
    private final long quo;
    private long qup;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.qum = j3;
        this.quo = j2;
        if (this.qum > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.qup = this.hasNext ? j : this.quo;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.z
    public long eBF() {
        long j = this.qup;
        if (j == this.quo) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.qup += this.qum;
        }
        return j;
    }
}
