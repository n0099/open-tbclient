package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long nCO;
    private final long nCQ;
    private long nCR;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.nCO = j3;
        this.nCQ = j2;
        if (this.nCO > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.nCR = this.hasNext ? j : this.nCQ;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.nCR;
        if (j == this.nCQ) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.nCR += this.nCO;
        }
        return j;
    }
}
