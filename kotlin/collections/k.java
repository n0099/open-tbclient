package kotlin.collections;

import java.util.Iterator;
/* loaded from: classes4.dex */
public abstract class k implements Iterator<Boolean> {
    public abstract boolean dyF();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: dEz */
    public final Boolean next() {
        return Boolean.valueOf(dyF());
    }
}
