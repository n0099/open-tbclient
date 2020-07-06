package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes7.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long nQs;
    private final long nQu;
    private long nQv;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.nQs = j3;
        this.nQu = j2;
        if (this.nQs > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.nQv = this.hasNext ? j : this.nQu;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.nQv;
        if (j == this.nQu) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.nQv += this.nQs;
        }
        return j;
    }
}
