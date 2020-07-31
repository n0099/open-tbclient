package kotlin.collections;

import java.util.Iterator;
@kotlin.h
/* loaded from: classes7.dex */
public abstract class l implements Iterator<Boolean> {
    public abstract boolean nextBoolean();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: dTL */
    public final Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }
}
