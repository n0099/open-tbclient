package kotlin.collections;

import java.util.Iterator;
@kotlin.h
/* loaded from: classes5.dex */
public abstract class ap implements Iterator<Short> {
    public abstract short ekg();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: ekf */
    public final Short next() {
        return Short.valueOf(ekg());
    }
}
