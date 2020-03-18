package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long nEO;
    private final long nEQ;
    private long nER;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.nEO = j3;
        this.nEQ = j2;
        if (this.nEO > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.nER = this.hasNext ? j : this.nEQ;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.nER;
        if (j == this.nEQ) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.nER += this.nEO;
        }
        return j;
    }
}
