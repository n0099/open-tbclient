package kotlin.collections;

import java.util.Iterator;
@kotlin.h
/* loaded from: classes7.dex */
public abstract class n implements Iterator<Character> {
    public abstract char dLt();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: dLs */
    public final Character next() {
        return Character.valueOf(dLt());
    }
}
