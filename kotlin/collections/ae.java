package kotlin.collections;

import java.util.Iterator;
@kotlin.h
/* loaded from: classes20.dex */
public abstract class ae implements Iterator<Long> {
    public abstract long nextLong();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: efX */
    public final Long next() {
        return Long.valueOf(nextLong());
    }
}
