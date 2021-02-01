package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.e
/* loaded from: classes6.dex */
public final class j extends z {
    private boolean hasNext;
    private final long qtM;
    private final long qtO;
    private long qtP;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.qtM = j3;
        this.qtO = j2;
        if (this.qtM > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.qtP = this.hasNext ? j : this.qtO;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.z
    public long eBx() {
        long j = this.qtP;
        if (j == this.qtO) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.qtP += this.qtM;
        }
        return j;
    }
}
