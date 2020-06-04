package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long nuD;
    private final long nuF;
    private long nuG;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.nuD = j3;
        this.nuF = j2;
        if (this.nuD > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.nuG = this.hasNext ? j : this.nuF;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.nuG;
        if (j == this.nuF) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.nuG += this.nuD;
        }
        return j;
    }
}
