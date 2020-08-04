package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long nZd;
    private final long nZf;
    private long nZg;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.nZd = j3;
        this.nZf = j2;
        if (this.nZd > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.nZg = this.hasNext ? j : this.nZf;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.nZg;
        if (j == this.nZf) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.nZg += this.nZd;
        }
        return j;
    }
}
