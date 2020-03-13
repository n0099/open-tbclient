package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long nDb;
    private final long nDd;
    private long nDe;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.nDb = j3;
        this.nDd = j2;
        if (this.nDb > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.nDe = this.hasNext ? j : this.nDd;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.nDe;
        if (j == this.nDd) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.nDe += this.nDb;
        }
        return j;
    }
}
