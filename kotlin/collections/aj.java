package kotlin.collections;

import java.util.Iterator;
@kotlin.e
/* loaded from: classes5.dex */
public abstract class aj implements Iterator<Short> {
    public abstract short eMc();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: eMb */
    public final Short next() {
        return Short.valueOf(eMc());
    }
}
