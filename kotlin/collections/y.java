package kotlin.collections;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class y implements Iterator<Integer> {
    public abstract int cMP();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: cMO */
    public final Integer next() {
        return Integer.valueOf(cMP());
    }
}
