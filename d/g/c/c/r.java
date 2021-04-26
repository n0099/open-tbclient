package d.g.c.c;

import com.google.common.collect.Iterators;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class r<E> extends y implements Collection<E> {
    public boolean add(E e2) {
        return delegate().add(e2);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return delegate().addAll(collection);
    }

    public void clear() {
        delegate().clear();
    }

    public boolean contains(Object obj) {
        return delegate().contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return delegate().containsAll(collection);
    }

    @Override // d.g.c.c.y
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // d.g.c.c.y
    public abstract Collection<E> delegate();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Iterator<E> iterator() {
        return delegate().iterator();
    }

    public boolean remove(Object obj) {
        return delegate().remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        return delegate().removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return delegate().retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return delegate().size();
    }

    public boolean standardAddAll(Collection<? extends E> collection) {
        return Iterators.a(this, collection.iterator());
    }

    public void standardClear() {
        Iterators.d(iterator());
    }

    public boolean standardContains(Object obj) {
        return Iterators.f(iterator(), obj);
    }

    public boolean standardContainsAll(Collection<?> collection) {
        return n.b(this, collection);
    }

    public boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    public boolean standardRemove(Object obj) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (d.g.c.a.k.a(it.next(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean standardRemoveAll(Collection<?> collection) {
        return Iterators.r(iterator(), collection);
    }

    public boolean standardRetainAll(Collection<?> collection) {
        return Iterators.s(iterator(), collection);
    }

    public Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    public String standardToString() {
        return n.f(this);
    }

    public Object[] toArray() {
        return delegate().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return (T[]) delegate().toArray(tArr);
    }

    public <T> T[] standardToArray(T[] tArr) {
        return (T[]) j0.g(this, tArr);
    }
}
