package kotlin.collections;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class z implements Iterator<Long> {
    public abstract long cMP();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: cMO */
    public final Long next() {
        return Long.valueOf(cMP());
    }
}
