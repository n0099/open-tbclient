package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long nZb;
    private final long nZd;
    private long nZe;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.nZb = j3;
        this.nZd = j2;
        if (this.nZb > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.nZe = this.hasNext ? j : this.nZd;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.nZe;
        if (j == this.nZd) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.nZe += this.nZb;
        }
        return j;
    }
}
