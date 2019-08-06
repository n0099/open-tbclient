package kotlin.collections;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class y implements Iterator<Integer> {
    public abstract int cNW();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: cNV */
    public final Integer next() {
        return Integer.valueOf(cNW());
    }
}
