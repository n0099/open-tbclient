package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.e
/* loaded from: classes17.dex */
public final class j extends z {
    private boolean hasNext;
    private final long pKW;
    private final long pKY;
    private long pKZ;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.pKW = j3;
        this.pKY = j2;
        if (this.pKW > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.pKZ = this.hasNext ? j : this.pKY;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.z
    public long eyG() {
        long j = this.pKZ;
        if (j == this.pKY) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.pKZ += this.pKW;
        }
        return j;
    }
}
