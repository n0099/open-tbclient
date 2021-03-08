package kotlin.collections;

import java.util.Iterator;
@kotlin.e
/* loaded from: classes14.dex */
public abstract class y implements Iterator<Integer> {
    public abstract int eBM();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: eKS */
    public final Integer next() {
        return Integer.valueOf(eBM());
    }
}
