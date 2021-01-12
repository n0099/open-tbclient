package kotlin.collections;

import java.util.Iterator;
@kotlin.e
/* loaded from: classes5.dex */
public abstract class k implements Iterator<Boolean> {
    public abstract boolean ezc();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: eID */
    public final Boolean next() {
        return Boolean.valueOf(ezc());
    }
}
