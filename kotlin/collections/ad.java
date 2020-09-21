package kotlin.collections;

import java.util.Iterator;
@kotlin.h
/* loaded from: classes5.dex */
public abstract class ad implements Iterator<Integer> {
    public abstract int nextInt();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: ekc */
    public final Integer next() {
        return Integer.valueOf(nextInt());
    }
}
