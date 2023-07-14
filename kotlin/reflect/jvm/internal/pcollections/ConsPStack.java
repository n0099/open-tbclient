package kotlin.reflect.jvm.internal.pcollections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public final class ConsPStack<E> implements Iterable<E> {
    public static final ConsPStack<Object> EMPTY = new ConsPStack<>();
    public final E first;
    public final ConsPStack<E> rest;
    public final int size;

    /* loaded from: classes2.dex */
    public static class Itr<E> implements Iterator<E> {
        public ConsPStack<E> next;

        public Itr(ConsPStack<E> consPStack) {
            this.next = consPStack;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next.size > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            ConsPStack<E> consPStack = this.next;
            E e = consPStack.first;
            this.next = consPStack.rest;
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public ConsPStack() {
        this.size = 0;
        this.first = null;
        this.rest = null;
    }

    public static <E> ConsPStack<E> empty() {
        return (ConsPStack<E>) EMPTY;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return iterator(0);
    }

    public int size() {
        return this.size;
    }

    public ConsPStack(E e, ConsPStack<E> consPStack) {
        this.first = e;
        this.rest = consPStack;
        this.size = consPStack.size + 1;
    }

    private Iterator<E> iterator(int i) {
        return new Itr(subList(i));
    }

    private ConsPStack<E> minus(Object obj) {
        if (this.size == 0) {
            return this;
        }
        if (this.first.equals(obj)) {
            return this.rest;
        }
        ConsPStack<E> minus = this.rest.minus(obj);
        if (minus == this.rest) {
            return this;
        }
        return new ConsPStack<>(this.first, minus);
    }

    private ConsPStack<E> subList(int i) {
        if (i >= 0 && i <= this.size) {
            if (i == 0) {
                return this;
            }
            return this.rest.subList(i - 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public E get(int i) {
        if (i >= 0 && i <= this.size) {
            try {
                return iterator(i).next();
            } catch (NoSuchElementException unused) {
                throw new IndexOutOfBoundsException("Index: " + i);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public ConsPStack<E> plus(E e) {
        return new ConsPStack<>(e, this);
    }

    public ConsPStack<E> minus(int i) {
        return minus(get(i));
    }
}
