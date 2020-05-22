package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long nts;
    private final long ntu;
    private long ntv;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.nts = j3;
        this.ntu = j2;
        if (this.nts > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.ntv = this.hasNext ? j : this.ntu;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.ntv;
        if (j == this.ntu) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.ntv += this.nts;
        }
        return j;
    }
}
