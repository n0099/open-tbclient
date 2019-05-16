package kotlin.collections;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class k implements Iterator<Boolean> {
    public abstract boolean nextBoolean();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: cJO */
    public final Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }
}
