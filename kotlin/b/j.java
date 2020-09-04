package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes20.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long ott;
    private final long otv;
    private long otw;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.ott = j3;
        this.otv = j2;
        if (this.ott > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.otw = this.hasNext ? j : this.otv;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.otw;
        if (j == this.otv) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.otw += this.ott;
        }
        return j;
    }
}
