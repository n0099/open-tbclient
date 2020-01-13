package kotlin.collections;

import java.util.Iterator;
/* loaded from: classes5.dex */
public abstract class n implements Iterator<Character> {
    public abstract char dIR();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: dIQ */
    public final Character next() {
        return Character.valueOf(dIR());
    }
}
