package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.ae;
@kotlin.h
/* loaded from: classes5.dex */
public final class j extends ae {
    private boolean hasNext;
    private final long oDa;
    private final long oDc;
    private long oDd;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.oDa = j3;
        this.oDc = j2;
        if (this.oDa > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.oDd = this.hasNext ? j : this.oDc;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ae
    public long nextLong() {
        long j = this.oDd;
        if (j == this.oDc) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.oDd += this.oDa;
        }
        return j;
    }
}
