package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes10.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long pJL;
    private final long pJN;
    private long pJO;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.pJL = j3;
        this.pJN = j2;
        if (this.pJL > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.pJO = this.hasNext ? j : this.pJN;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.pJO;
        if (j == this.pJN) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.pJO += this.pJL;
        }
        return j;
    }
}
