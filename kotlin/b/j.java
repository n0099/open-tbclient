package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long nQp;
    private final long nQr;
    private long nQs;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.nQp = j3;
        this.nQr = j2;
        if (this.nQp > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.nQs = this.hasNext ? j : this.nQr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.nQs;
        if (j == this.nQr) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.nQs += this.nQp;
        }
        return j;
    }
}
