package kotlin.collections;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class m implements Iterator<Character> {
    public abstract char cME();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: cMD */
    public final Character next() {
        return Character.valueOf(cME());
    }
}
