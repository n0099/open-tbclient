package kotlin.collections;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class w implements Iterator<Float> {
    public abstract float cML();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: cMK */
    public final Float next() {
        return Float.valueOf(cML());
    }
}
