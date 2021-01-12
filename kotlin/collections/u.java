package kotlin.collections;

import java.util.Iterator;
@kotlin.e
/* loaded from: classes5.dex */
public abstract class u implements Iterator<Double> {
    public abstract double eze();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: eIH */
    public final Double next() {
        return Double.valueOf(eze());
    }
}
