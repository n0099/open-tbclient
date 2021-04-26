package com.google.common.collect;

import d.g.c.a.n;
import d.g.c.c.f0;
import d.g.c.c.z;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;
/* loaded from: classes6.dex */
public final class EvictingQueue<E> extends z<E> implements Serializable {
    public static final long serialVersionUID = 0;
    public final Queue<E> delegate;
    public final int maxSize;

    public EvictingQueue(int i2) {
        n.f(i2 >= 0, "maxSize (%s) must >= 0", i2);
        this.delegate = new ArrayDeque(i2);
        this.maxSize = i2;
    }

    public static <E> EvictingQueue<E> create(int i2) {
        return new EvictingQueue<>(i2);
    }

    @Override // d.g.c.c.r, java.util.Collection, java.util.Queue
    public boolean add(E e2) {
        n.p(e2);
        if (this.maxSize == 0) {
            return true;
        }
        if (size() == this.maxSize) {
            this.delegate.remove();
        }
        this.delegate.add(e2);
        return true;
    }

    @Override // d.g.c.c.r, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        if (size >= this.maxSize) {
            clear();
            return f0.a(this, f0.j(collection, size - this.maxSize));
        }
        return standardAddAll(collection);
    }

    @Override // d.g.c.c.r, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Queue<E> delegate = delegate();
        n.p(obj);
        return delegate.contains(obj);
    }

    @Override // d.g.c.c.z, java.util.Queue
    public boolean offer(E e2) {
        return add(e2);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @Override // d.g.c.c.r, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        Queue<E> delegate = delegate();
        n.p(obj);
        return delegate.remove(obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.z, d.g.c.c.r, d.g.c.c.y
    public Queue<E> delegate() {
        return this.delegate;
    }
}
