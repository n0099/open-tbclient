package kotlin.collections;

import java.util.Iterator;
@kotlin.e
/* loaded from: classes6.dex */
public abstract class z implements Iterator<Long> {
    public abstract long eBF();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: eLl */
    public final Long next() {
        return Long.valueOf(eBF());
    }
}
