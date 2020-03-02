package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long nCQ;
    private final long nCS;
    private long nCT;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.nCQ = j3;
        this.nCS = j2;
        if (this.nCQ > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.nCT = this.hasNext ? j : this.nCS;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.nCT;
        if (j == this.nCS) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.nCT += this.nCQ;
        }
        return j;
    }
}
