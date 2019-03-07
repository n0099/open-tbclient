package kotlin.collections;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class ag implements Iterator<Short> {
    public abstract short nextShort();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: cCm */
    public final Short next() {
        return Short.valueOf(nextShort());
    }
}
