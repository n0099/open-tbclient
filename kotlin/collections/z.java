package kotlin.collections;

import java.util.Iterator;
@kotlin.h
/* loaded from: classes20.dex */
public abstract class z implements Iterator<Double> {
    public abstract double nextDouble();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: egb */
    public final Double next() {
        return Double.valueOf(nextDouble());
    }
}
