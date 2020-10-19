package kotlin.collections;

import java.util.Iterator;
@kotlin.h
/* loaded from: classes10.dex */
public abstract class n implements Iterator<Character> {
    public abstract char enI();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: enH */
    public final Character next() {
        return Character.valueOf(enI());
    }
}
