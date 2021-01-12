package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.e
/* loaded from: classes5.dex */
public final class j extends z {
    private boolean hasNext;
    private final long qjH;
    private final long qjJ;
    private long qjK;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.qjH = j3;
        this.qjJ = j2;
        if (this.qjH > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.qjK = this.hasNext ? j : this.qjJ;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.z
    public long ezf() {
        long j = this.qjK;
        if (j == this.qjJ) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.qjK += this.qjH;
        }
        return j;
    }
}
