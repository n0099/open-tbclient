package kotlin.collections;

import java.util.Iterator;
@kotlin.e
/* loaded from: classes17.dex */
public abstract class z implements Iterator<Long> {
    public abstract long eyH();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: eDR */
    public final Long next() {
        return Long.valueOf(eyH());
    }
}
