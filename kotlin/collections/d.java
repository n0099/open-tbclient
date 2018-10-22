package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
/* loaded from: classes2.dex */
public abstract class d<E> extends kotlin.collections.a<E> implements List<E> {
    public static final a ioV = new a(null);

    @Override // java.util.List
    public void add(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract E get(int i);

    @Override // java.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new b();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return new c(i);
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return new C0357d(this, i, i2);
    }

    /* renamed from: kotlin.collections.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class C0357d<E> extends d<E> implements RandomAccess {
        private int ioX;
        private final d<E> ioY;
        private final int ioZ;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.collections.d<? extends E> */
        /* JADX WARN: Multi-variable type inference failed */
        public C0357d(d<? extends E> dVar, int i, int i2) {
            kotlin.jvm.internal.p.i(dVar, "list");
            this.ioY = dVar;
            this.ioZ = i;
            d.ioV.af(this.ioZ, i2, this.ioY.size());
            this.ioX = i2 - this.ioZ;
        }

        @Override // kotlin.collections.d, java.util.List
        public E get(int i) {
            d.ioV.ci(i, this.ioX);
            return this.ioY.get(this.ioZ + i);
        }

        @Override // kotlin.collections.a
        public int getSize() {
            return this.ioX;
        }
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return ioV.a(this, (Collection) obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return ioV.e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Iterator<E> {
        private int index;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        protected final int getIndex() {
            return this.index;
        }

        protected final void setIndex(int i) {
            this.index = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < d.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                d dVar = d.this;
                int i = this.index;
                this.index = i + 1;
                return (E) dVar.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: classes2.dex */
    private class c extends d<E>.b implements ListIterator<E> {
        @Override // java.util.ListIterator
        public void add(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public c(int i) {
            super();
            d.ioV.cj(i, d.this.size());
            setIndex(i);
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return getIndex() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return getIndex();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                d dVar = d.this;
                setIndex(getIndex() - 1);
                return (E) dVar.get(getIndex());
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return getIndex() - 1;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final void ci(int i, int i2) {
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        public final void cj(int i, int i2) {
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        public final void af(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
            }
            if (i > i2) {
                throw new IllegalArgumentException("fromIndex: " + i + " > toIndex: " + i2);
            }
        }

        public final int e(Collection<?> collection) {
            kotlin.jvm.internal.p.i(collection, "c");
            int i = 1;
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                i = (next != null ? next.hashCode() : 0) + (i * 31);
            }
            return i;
        }

        public final boolean a(Collection<?> collection, Collection<?> collection2) {
            kotlin.jvm.internal.p.i(collection, "c");
            kotlin.jvm.internal.p.i(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.p.h(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int i = 0;
        for (E e : this) {
            if (kotlin.jvm.internal.p.h(e, obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.p.h(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }
}
