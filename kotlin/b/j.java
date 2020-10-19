package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes10.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long oSp;
    private final long oSr;
    private long oSs;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.oSp = j3;
        this.oSr = j2;
        if (this.oSp > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.oSs = this.hasNext ? j : this.oSr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.oSs;
        if (j == this.oSr) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.oSs += this.oSp;
        }
        return j;
    }
}
