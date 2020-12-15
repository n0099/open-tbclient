package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.e
/* loaded from: classes17.dex */
public final class j extends z {
    private boolean hasNext;
    private final long pKY;
    private final long pLa;
    private long pLb;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.pKY = j3;
        this.pLa = j2;
        if (this.pKY > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.pLb = this.hasNext ? j : this.pLa;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.z
    public long eyH() {
        long j = this.pLb;
        if (j == this.pLa) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.pLb += this.pKY;
        }
        return j;
    }
}
