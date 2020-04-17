package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long mYn;
    private final long mYp;
    private long mYq;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.mYn = j3;
        this.mYp = j2;
        if (this.mYn > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.mYq = this.hasNext ? j : this.mYp;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.mYq;
        if (j == this.mYp) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.mYq += this.mYn;
        }
        return j;
    }
}
