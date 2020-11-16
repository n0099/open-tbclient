package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes9.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long pUI;
    private final long pUK;
    private long pUL;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.pUI = j3;
        this.pUK = j2;
        if (this.pUI > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.pUL = this.hasNext ? j : this.pUK;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.pUL;
        if (j == this.pUK) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.pUL += this.pUI;
        }
        return j;
    }
}
