package kotlin.collections;

import java.util.Iterator;
@kotlin.h
/* loaded from: classes7.dex */
public abstract class ap implements Iterator<Short> {
    public abstract short dLR();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: dLQ */
    public final Short next() {
        return Short.valueOf(dLR());
    }
}
