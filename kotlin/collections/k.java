package kotlin.collections;

import java.util.Iterator;
@kotlin.e
/* loaded from: classes6.dex */
public abstract class k implements Iterator<Boolean> {
    public abstract boolean eBC();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: eLb */
    public final Boolean next() {
        return Boolean.valueOf(eBC());
    }
}
