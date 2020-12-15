package kotlin.collections;

import java.util.Iterator;
@kotlin.e
/* loaded from: classes17.dex */
public abstract class w implements Iterator<Float> {
    public abstract float eDP();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: eDO */
    public final Float next() {
        return Float.valueOf(eDP());
    }
}
