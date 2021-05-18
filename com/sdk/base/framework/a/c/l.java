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
/* loaded from: classes7.dex */
public final class l<E> extends AbstractQueue<E> implements Serializable, BlockingQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    public transient a<E> f35656a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35657b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f35658c;

    /* renamed from: d  reason: collision with root package name */
    public transient a<E> f35659d;

    /* renamed from: e  reason: collision with root package name */
    public final ReentrantLock f35660e;

    /* renamed from: f  reason: collision with root package name */
    public final Condition f35661f;

    /* renamed from: g  reason: collision with root package name */
    public final ReentrantLock f35662g;

    /* renamed from: h  reason: collision with root package name */
    public final Condition f35663h;

    public l() {
        this(Integer.MAX_VALUE);
    }

    public l(int i2) {
        this.f35658c = new AtomicInteger();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f35660e = reentrantLock;
        this.f35661f = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.f35662g = reentrantLock2;
        this.f35663h = reentrantLock2.newCondition();
        this.f35657b = Integer.MAX_VALUE;
        a<E> aVar = new a<>(null);
        this.f35656a = aVar;
        this.f35659d = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.sdk.base.framework.a.c.a<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private synchronized E a(a<E> aVar) {
        if (aVar == 0) {
            a aVar2 = (a<E>) this.f35656a;
            a<E> aVar3 = (a<E>) aVar2.f35627a;
            aVar2.f35627a = aVar2;
            this.f35656a = aVar3;
            E b2 = aVar3.b();
            aVar3.a(null);
            return b2;
        }
        boolean z = false;
        a aVar4 = this.f35656a;
        while (true) {
            a<T> aVar5 = aVar4.f35627a;
            if (aVar5 == 0) {
                break;
            } else if (aVar5.a() - 1 > aVar.a() - 1) {
                aVar4.f35627a = aVar;
                aVar.f35627a = aVar5;
                z = true;
                break;
            } else {
                aVar4 = aVar4.f35627a;
            }
        }
        if (!z) {
            this.f35659d.f35627a = aVar;
            this.f35659d = aVar;
        }
        return null;
    }

    private void c() {
        ReentrantLock reentrantLock = this.f35660e;
        reentrantLock.lock();
        try {
            this.f35661f.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void d() {
        ReentrantLock reentrantLock = this.f35662g;
        reentrantLock.lock();
        try {
            this.f35663h.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void a() {
        this.f35662g.lock();
        this.f35660e.lock();
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.sdk.base.framework.a.c.a<E>, com.sdk.base.framework.a.c.a<T> */
    public final void a(a<E> aVar, a<E> aVar2) {
        aVar.a(null);
        aVar2.f35627a = (a<E>) aVar.f35627a;
        if (this.f35659d == aVar) {
            this.f35659d = aVar2;
        }
        if (this.f35658c.getAndDecrement() == this.f35657b) {
            this.f35663h.signal();
        }
    }

    public final void b() {
        this.f35660e.unlock();
        this.f35662g.unlock();
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.sdk.base.framework.a.c.a, com.sdk.base.framework.a.c.a<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        a();
        try {
            a aVar = (a<E>) this.f35656a;
            while (true) {
                a aVar2 = aVar.f35627a;
                if (aVar2 == null) {
                    break;
                }
                aVar.f35627a = aVar;
                aVar2.a(null);
                aVar = (a<E>) aVar2;
            }
            this.f35656a = this.f35659d;
            if (this.f35658c.getAndSet(0) == this.f35657b) {
                this.f35663h.signal();
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
            a aVar = this.f35656a;
            do {
                aVar = aVar.f35627a;
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
    public final int drainTo(Collection<? super E> collection, int i2) {
        if (collection != null) {
            if (collection != this) {
                boolean z = false;
                if (i2 <= 0) {
                    return 0;
                }
                ReentrantLock reentrantLock = this.f35660e;
                reentrantLock.lock();
                try {
                    int min = Math.min(i2, this.f35658c.get());
                    a<E> aVar = this.f35656a;
                    int i3 = 0;
                    while (i3 < min) {
                        a<E> aVar2 = aVar.f35627a;
                        collection.add((Object) aVar2.b());
                        aVar2.a(null);
                        aVar.f35627a = (a<T>) aVar;
                        i3++;
                        aVar = aVar2;
                    }
                    if (i3 > 0) {
                        this.f35656a = aVar;
                        if (this.f35658c.getAndAdd(-i3) == this.f35657b) {
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
            AtomicInteger atomicInteger = this.f35658c;
            if (atomicInteger.get() == this.f35657b) {
                return false;
            }
            int i2 = -1;
            a<E> aVar = new a<>(e2);
            ReentrantLock reentrantLock = this.f35662g;
            reentrantLock.lock();
            try {
                if (atomicInteger.get() < this.f35657b) {
                    a(aVar);
                    i2 = atomicInteger.getAndIncrement();
                    if (i2 + 1 < this.f35657b) {
                        this.f35663h.signal();
                    }
                }
                if (i2 == 0) {
                    c();
                }
                return i2 >= 0;
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
            ReentrantLock reentrantLock = this.f35662g;
            AtomicInteger atomicInteger = this.f35658c;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == this.f35657b) {
                try {
                    if (nanos <= 0) {
                        reentrantLock.unlock();
                        return false;
                    }
                    nanos = this.f35663h.awaitNanos(nanos);
                } finally {
                    reentrantLock.unlock();
                }
            }
            a(new a<>(e2));
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement + 1 < this.f35657b) {
                this.f35663h.signal();
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
        if (this.f35658c.get() == 0) {
            return null;
        }
        ReentrantLock reentrantLock = this.f35660e;
        reentrantLock.lock();
        try {
            a<E> aVar = this.f35656a.f35627a;
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
        AtomicInteger atomicInteger = this.f35658c;
        E e2 = null;
        if (atomicInteger.get() == 0) {
            return null;
        }
        int i2 = -1;
        ReentrantLock reentrantLock = this.f35660e;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() > 0) {
                e2 = a(null);
                i2 = atomicInteger.getAndDecrement();
                if (i2 > 1) {
                    this.f35661f.signal();
                }
            }
            reentrantLock.unlock();
            if (i2 == this.f35657b) {
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
        AtomicInteger atomicInteger = this.f35658c;
        ReentrantLock reentrantLock = this.f35660e;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.f35661f.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        E a2 = a(null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.f35661f.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.f35657b) {
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
        ReentrantLock reentrantLock = this.f35662g;
        AtomicInteger atomicInteger = this.f35658c;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.f35657b) {
            try {
                this.f35663h.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        a(aVar);
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.f35657b) {
            this.f35663h.signal();
        }
        if (andIncrement == 0) {
            c();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int remainingCapacity() {
        return this.f35657b - this.f35658c.get();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public final boolean remove(Object obj) {
        a<E> aVar;
        if (obj == null) {
            return false;
        }
        a();
        try {
            a<E> aVar2 = this.f35656a;
            do {
                aVar = aVar2;
                aVar2 = aVar2.f35627a;
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
        return this.f35658c.get();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final E take() {
        AtomicInteger atomicInteger = this.f35658c;
        ReentrantLock reentrantLock = this.f35660e;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                this.f35661f.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        E a2 = a(null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.f35661f.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.f35657b) {
            d();
        }
        return a2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        a();
        try {
            Object[] objArr = new Object[this.f35658c.get()];
            int i2 = 0;
            a aVar = this.f35656a;
            while (true) {
                aVar = aVar.f35627a;
                if (aVar == null) {
                    return objArr;
                }
                int i3 = i2 + 1;
                objArr[i2] = aVar.b();
                i2 = i3;
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
            int i2 = this.f35658c.get();
            if (tArr.length < i2) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2));
            }
            int i3 = 0;
            a aVar = this.f35656a;
            while (true) {
                aVar = aVar.f35627a;
                if (aVar == null) {
                    break;
                }
                tArr[i3] = aVar.b();
                i3++;
            }
            if (tArr.length > i3) {
                tArr[i3] = null;
            }
            return tArr;
        } finally {
            b();
        }
    }
}
