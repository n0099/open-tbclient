package kotlin.collections;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class l implements Iterator<Byte> {
    public abstract byte nextByte();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: bZx */
    public final Byte next() {
        return Byte.valueOf(nextByte());
    }
}
