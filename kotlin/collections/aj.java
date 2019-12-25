package kotlin.collections;

import java.util.Iterator;
/* loaded from: classes4.dex */
public abstract class aj implements Iterator<Short> {
    public abstract short dEL();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: dEK */
    public final Short next() {
        return Short.valueOf(dEL());
    }
}
