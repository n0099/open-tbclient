package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes20.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long otb;
    private final long otd;
    private long ote;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.otb = j3;
        this.otd = j2;
        if (this.otb > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.ote = this.hasNext ? j : this.otd;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.ote;
        if (j == this.otd) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.ote += this.otb;
        }
        return j;
    }
}
