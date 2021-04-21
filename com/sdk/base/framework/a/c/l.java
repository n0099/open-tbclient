package com.sdk.base.framework.a.c;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public final class l<E> extends AbstractQueue<E> implements Serializable, BlockingQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    public transient a<E> f38830a;

    /* renamed from: b  reason: collision with root package name */
    public final int f38831b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f38832c;

    /* renamed from: d  reason: collision with root package name */
    public transient a<E> f38833d;

    /* renamed from: e  reason: collision with root package name */
    public final ReentrantLock f38834e;

    /* renamed from: f  reason: collision with root package name */
    public final Condition f38835f;

    /* renamed from: g  reason: collision with root package name */
    public final ReentrantLock f38836g;

    /* renamed from: h  reason: collision with root package name */
    public final Condition f38837h;

    public l() {
        this(Integer.MAX_VALUE);
    }

    public l(int i) {
        this.f38832c = new AtomicInteger();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f38834e = reentrantLock;
        this.f38835f = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.f38836g = reentrantLock2;
        this.f38837h = reentrantLock2.newCondition();
        this.f38831b = Integer.MAX_VALUE;
        a<E> aVar = new a<>(null);
        this.f38830a = aVar;
        this.f38833d = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.sdk.base.framework.a.c.a<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private synchronized E a(a<E> aVar) {
        if (aVar == 0) {
            a aVar2 = (a<E>) this.f38830a;
            a<E> aVar3 = (a<E>) aVar2.f38801a;
            aVar2.f38801a = aVar2;
            this.f38830a = aVar3;
            E b2 = aVar3.b();
            aVar3.a(null);
            return b2;
        }
        boolean z = false;
        a aVar4 = this.f38830a;
        while (true) {
            a<T> aVar5 = aVar4.f38801a;
            if (aVar5 == 0) {
                break;
            } else if (aVar5.a() - 1 > aVar.a() - 1) {
                aVar4.f38801a = aVar;
                aVar.f38801a = aVar5;
                z = true;
                break;
            } else {
                aVar4 = aVar4.f38801a;
            }
        }
        if (!z) {
            this.f38833d.f38801a = aVar;
            this.f38833d = aVar;
        }
        return null;
    }

    private void c() {
        ReentrantLock reentrantLock = this.f38834e;
        reentrantLock.lock();
        try {
            this.f38835f.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void d() {
        ReentrantLock reentrantLock = this.f38836g;
        reentrantLock.lock();
        try {
            this.f38837h.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void a() {
        this.f38836g.lock();
        this.f38834e.lock();
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.sdk.base.framework.a.c.a<E>, com.sdk.base.framework.a.c.a<T> */
    public final void a(a<E> aVar, a<E> aVar2) {
        aVar.a(null);
        aVar2.f38801a = (a<E>) aVar.f38801a;
        if (this.f38833d == aVar) {
            this.f38833d = aVar2;
        }
        if (this.f38832c.getAndDecrement() == this.f38831b) {
            this.f38837h.signal();
        }
    }

    public final void b() {
        this.f38834e.unlock();
        this.f38836g.unlock();
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.sdk.base.framework.a.c.a, com.sdk.base.framework.a.c.a<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        a();
        try {
            a aVar = (a<E>) this.f38830a;
            while (true) {
                a aVar2 = aVar.f38801a;
                if (aVar2 == null) {
                    break;
                }
                aVar.f38801a = aVar;
                aVar2.a(null);
                aVar = (a<E>) aVar2;
            }
            this.f38830a = this.f38833d;
            if (this.f38832c.getAndSet(0) == this.f38831b) {
                this.f38837h.signal();
            }
        } finally {
            b();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        a();
        try {
            a aVar = this.f38830a;
            do {
                aVar = aVar.f38801a;
                if (aVar == null) {
                    return false;
                }
            } while (!obj.equals(aVar.b()));
            b();
            return true;
        } finally {
            b();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection<? super E> collection, int i) {
        if (collection != null) {
            if (collection != this) {
                boolean z = false;
                if (i <= 0) {
                    return 0;
                }
                ReentrantLock reentrantLock = this.f38834e;
                reentrantLock.lock();
                try {
                    int min = Math.min(i, this.f38832c.get());
                    a<E> aVar = this.f38830a;
                    int i2 = 0;
                    while (i2 < min) {
                        a<E> aVar2 = aVar.f38801a;
                        collection.add((Object) aVar2.b());
                        aVar2.a(null);
                        aVar.f38801a = (a<T>) aVar;
                        i2++;
                        aVar = aVar2;
                    }
                    if (i2 > 0) {
                        this.f38830a = aVar;
                        if (this.f38832c.getAndAdd(-i2) == this.f38831b) {
                            z = true;
                        }
                    }
                    return min;
                } finally {
                    reentrantLock.unlock();
                    if (0 != 0) {
                        d();
                    }
                }
            }
            throw new IllegalArgumentException();
        }
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return new m(this);
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public final boolean offer(E e2) {
        if (e2 != null) {
            AtomicInteger atomicInteger = this.f38832c;
            if (atomicInteger.get() == this.f38831b) {
                return false;
            }
            int i = -1;
            a<E> aVar = new a<>(e2);
            ReentrantLock reentrantLock = this.f38836g;
            reentrantLock.lock();
            try {
                if (atomicInteger.get() < this.f38831b) {
                    a(aVar);
                    i = atomicInteger.getAndIncrement();
                    if (i + 1 < this.f38831b) {
                        this.f38837h.signal();
                    }
                }
                if (i == 0) {
                    c();
                }
                return i >= 0;
            } finally {
                reentrantLock.unlock();
            }
        }
        throw null;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final boolean offer(E e2, long j, TimeUnit timeUnit) {
        if (e2 != null) {
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.f38836g;
            AtomicInteger atomicInteger = this.f38832c;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == this.f38831b) {
                try {
                    if (nanos <= 0) {
                        reentrantLock.unlock();
                        return false;
                    }
                    nanos = this.f38837h.awaitNanos(nanos);
                } finally {
                    reentrantLock.unlock();
                }
            }
            a(new a<>(e2));
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement + 1 < this.f38831b) {
                this.f38837h.signal();
            }
            if (andIncrement == 0) {
                c();
                return true;
            }
            return true;
        }
        throw null;
    }

    @Override // java.util.Queue
    public final E peek() {
        if (this.f38832c.get() == 0) {
            return null;
        }
        ReentrantLock reentrantLock = this.f38834e;
        reentrantLock.lock();
        try {
            a<E> aVar = this.f38830a.f38801a;
            if (aVar == null) {
                return null;
            }
            return aVar.b();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue
    public final E poll() {
        AtomicInteger atomicInteger = this.f38832c;
        E e2 = null;
        if (atomicInteger.get() == 0) {
            return null;
        }
        int i = -1;
        ReentrantLock reentrantLock = this.f38834e;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() > 0) {
                e2 = a(null);
                i = atomicInteger.getAndDecrement();
                if (i > 1) {
                    this.f38835f.signal();
                }
            }
            reentrantLock.unlock();
            if (i == this.f38831b) {
                d();
            }
            return e2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public final E poll(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        AtomicInteger atomicInteger = this.f38832c;
        ReentrantLock reentrantLock = this.f38834e;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.f38835f.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        E a2 = a(null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.f38835f.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.f38831b) {
            d();
        }
        return a2;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final void put(E e2) {
        if (e2 == null) {
            throw null;
        }
        a<E> aVar = new a<>(e2);
        ReentrantLock reentrantLock = this.f38836g;
        AtomicInteger atomicInteger = this.f38832c;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.f38831b) {
            try {
                this.f38837h.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        a(aVar);
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.f38831b) {
            this.f38837h.signal();
        }
        if (andIncrement == 0) {
            c();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int remainingCapacity() {
        return this.f38831b - this.f38832c.get();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public final boolean remove(Object obj) {
        a<E> aVar;
        if (obj == null) {
            return false;
        }
        a();
        try {
            a<E> aVar2 = this.f38830a;
            do {
                aVar = aVar2;
                aVar2 = aVar2.f38801a;
                if (aVar2 == null) {
                    return false;
                }
            } while (!obj.equals(aVar2.b()));
            a(aVar2, aVar);
            b();
            return true;
        } finally {
            b();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f38832c.get();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final E take() {
        AtomicInteger atomicInteger = this.f38832c;
        ReentrantLock reentrantLock = this.f38834e;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                this.f38835f.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        E a2 = a(null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.f38835f.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.f38831b) {
            d();
        }
        return a2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        a();
        try {
            Object[] objArr = new Object[this.f38832c.get()];
            int i = 0;
            a aVar = this.f38830a;
            while (true) {
                aVar = aVar.f38801a;
                if (aVar == null) {
                    return objArr;
                }
                int i2 = i + 1;
                objArr[i] = aVar.b();
                i = i2;
            }
        } finally {
            b();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        a();
        try {
            int i = this.f38832c.get();
            if (tArr.length < i) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
            }
            int i2 = 0;
            a aVar = this.f38830a;
            while (true) {
                aVar = aVar.f38801a;
                if (aVar == null) {
                    break;
                }
                tArr[i2] = aVar.b();
                i2++;
            }
            if (tArr.length > i2) {
                tArr[i2] = null;
            }
            return tArr;
        } finally {
            b();
        }
    }
}
