package kotlin.collections;

import java.util.Iterator;
@kotlin.e
/* loaded from: classes6.dex */
public abstract class w implements Iterator<Float> {
    public abstract float eLj();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: eLi */
    public final Float next() {
        return Float.valueOf(eLj());
    }
}
