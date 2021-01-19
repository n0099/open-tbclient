package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.e
/* loaded from: classes5.dex */
public final class j extends z {
    private boolean hasNext;
    private final long qjI;
    private final long qjK;
    private long qjL;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.qjI = j3;
        this.qjK = j2;
        if (this.qjI > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.qjL = this.hasNext ? j : this.qjK;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.z
    public long ezf() {
        long j = this.qjL;
        if (j == this.qjK) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.qjL += this.qjI;
        }
        return j;
    }
}
