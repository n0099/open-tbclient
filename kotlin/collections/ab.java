package kotlin.collections;

import java.util.Iterator;
@kotlin.h
/* loaded from: classes10.dex */
public abstract class ab implements Iterator<Float> {
    public abstract float nextFloat();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: exM */
    public final Float next() {
        return Float.valueOf(nextFloat());
    }
}
