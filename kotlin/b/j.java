package kotlin.b;

import java.util.NoSuchElementException;
import kotlin.collections.z;
@kotlin.e
/* loaded from: classes5.dex */
public final class j extends z {
    private boolean hasNext;
    private final long qoj;
    private final long qol;
    private long qom;

    public j(long j, long j2, long j3) {
        boolean z = true;
        this.qoj = j3;
        this.qol = j2;
        if (this.qoj > 0) {
            if (j > j2) {
                z = false;
            }
        } else if (j < j2) {
            z = false;
        }
        this.hasNext = z;
        this.qom = this.hasNext ? j : this.qol;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.z
    public long eCX() {
        long j = this.qom;
        if (j == this.qol) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.qom += this.qoj;
        }
        return j;
    }
}
