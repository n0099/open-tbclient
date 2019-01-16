package kotlin.collections;

import java.util.ListIterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public final class v implements ListIterator {
    public static final v iCn = new v();

    @Override // java.util.ListIterator
    public /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private v() {
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return false;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return 0;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.ListIterator, java.util.Iterator
    /* renamed from: cde */
    public Void next() {
        throw new NoSuchElementException();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.ListIterator
    /* renamed from: cdf */
    public Void previous() {
        throw new NoSuchElementException();
    }
}
