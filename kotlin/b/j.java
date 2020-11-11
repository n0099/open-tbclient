package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes10.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long pTf;
    private final long pTh;
    private long pTi;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.pTf = j3;
        this.pTh = j2;
        if (this.pTf > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.pTi = this.hasNext ? j : this.pTh;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.pTi;
        if (j == this.pTh) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.pTi += this.pTf;
        }
        return j;
    }
}
