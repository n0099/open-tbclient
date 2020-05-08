package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long mYq;
    private final long mYs;
    private long mYt;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.mYq = j3;
        this.mYs = j2;
        if (this.mYq > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.mYt = this.hasNext ? j : this.mYs;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.mYt;
        if (j == this.mYs) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.mYt += this.mYq;
        }
        return j;
    }
}
