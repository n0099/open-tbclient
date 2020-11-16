package com.sdk.base.framework.a.c;

import android.support.v7.widget.ActivityChooserView;
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
/* loaded from: classes8.dex */
public final class l<E> extends AbstractQueue<E> implements Serializable, BlockingQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    transient a<E> f4471a;
    private final int b;
    private final AtomicInteger c;
    private transient a<E> d;
    private final ReentrantLock e;
    private final Condition f;
    private final ReentrantLock g;
    private final Condition h;

    public l() {
        this(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    private l(int i) {
        this.c = new AtomicInteger();
        this.e = new ReentrantLock();
        this.f = this.e.newCondition();
        this.g = new ReentrantLock();
        this.h = this.g.newCondition();
        this.b = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        a<E> aVar = new a<>(null);
        this.f4471a = aVar;
        this.d = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.sdk.base.framework.a.c.a<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private synchronized E a(a<E> aVar) {
        E e = null;
        synchronized (this) {
            if (aVar == 0) {
                a aVar2 = (a<E>) this.f4471a;
                a<E> aVar3 = (a<E>) aVar2.f4462a;
                aVar2.f4462a = aVar2;
                this.f4471a = aVar3;
                e = aVar3.b();
                aVar3.a(null);
            } else {
                boolean z = false;
                a aVar4 = this.f4471a;
                while (true) {
                    if (aVar4.f4462a == null) {
                        break;
                    }
                    a<T> aVar5 = aVar4.f4462a;
                    if (aVar5.a() - 1 > aVar.a() - 1) {
                        aVar4.f4462a = aVar;
                        aVar.f4462a = aVar5;
                        z = true;
                        break;
                    }
                    aVar4 = aVar4.f4462a;
                }
                if (!z) {
                    this.d.f4462a = aVar;
                    this.d = aVar;
                }
            }
        }
        return e;
    }

    private void c() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            this.f.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void d() {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            this.h.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.g.lock();
        this.e.lock();
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.sdk.base.framework.a.c.a<E>, com.sdk.base.framework.a.c.a<T> */
    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(a<E> aVar, a<E> aVar2) {
        aVar.a(null);
        aVar2.f4462a = (a<E>) aVar.f4462a;
        if (this.d == aVar) {
            this.d = aVar2;
        }
        if (this.c.getAndDecrement() == this.b) {
            this.h.signal();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        this.e.unlock();
        this.g.unlock();
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.sdk.base.framework.a.c.a, com.sdk.base.framework.a.c.a<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        a();
        try {
            a aVar = (a<E>) this.f4471a;
            while (true) {
                a aVar2 = aVar.f4462a;
                if (aVar2 == null) {
                    break;
                }
                aVar.f4462a = aVar;
                aVar2.a(null);
                aVar = (a<E>) aVar2;
            }
            this.f4471a = this.d;
            if (this.c.getAndSet(0) == this.b) {
                this.h.signal();
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
            for (a aVar = this.f4471a.f4462a; aVar != null; aVar = aVar.f4462a) {
                if (obj.equals(aVar.b())) {
                    b();
                    return true;
                }
            }
            return false;
        } finally {
            b();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection<? super E> collection) {
        return drainTo(collection, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection<? super E> collection, int i) {
        boolean z = true;
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        if (i <= 0) {
            return 0;
        }
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            int min = Math.min(i, this.c.get());
            a<E> aVar = this.f4471a;
            int i2 = 0;
            while (i2 < min) {
                a<E> aVar2 = aVar.f4462a;
                collection.add((Object) aVar2.b());
                aVar2.a(null);
                aVar.f4462a = (a<T>) aVar;
                i2++;
                aVar = aVar2;
            }
            if (i2 > 0) {
                this.f4471a = aVar;
                if (this.c.getAndAdd(-i2) != this.b) {
                    z = false;
                }
            } else {
                z = false;
            }
            reentrantLock.unlock();
            if (z) {
                d();
            }
            return min;
        } catch (Throwable th) {
            reentrantLock.unlock();
            if (0 != 0) {
                d();
            }
            throw th;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return new m(this);
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public final boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger.get() == this.b) {
            return false;
        }
        int i = -1;
        a<E> aVar = new a<>(e);
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() < this.b) {
                a(aVar);
                i = atomicInteger.getAndIncrement();
                if (i + 1 < this.b) {
                    this.h.signal();
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

    @Override // java.util.concurrent.BlockingQueue
    public final boolean offer(E e, long j, TimeUnit timeUnit) {
        if (e == null) {
            throw new NullPointerException();
        }
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.g;
        AtomicInteger atomicInteger = this.c;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.b) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.h.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        a(new a<>(e));
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.b) {
            this.h.signal();
        }
        if (andIncrement == 0) {
            c();
        }
        return true;
    }

    @Override // java.util.Queue
    public final E peek() {
        E e = null;
        if (this.c.get() != 0) {
            ReentrantLock reentrantLock = this.e;
            reentrantLock.lock();
            try {
                a<E> aVar = this.f4471a.f4462a;
                if (aVar != null) {
                    e = aVar.b();
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return e;
    }

    @Override // java.util.Queue
    public final E poll() {
        E e = null;
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger.get() != 0) {
            int i = -1;
            ReentrantLock reentrantLock = this.e;
            reentrantLock.lock();
            try {
                if (atomicInteger.get() > 0) {
                    e = a(null);
                    i = atomicInteger.getAndDecrement();
                    if (i > 1) {
                        this.f.signal();
                    }
                }
                reentrantLock.unlock();
                if (i == this.b) {
                    d();
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        return e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
        r0 = a(null);
        r1 = r1.getAndDecrement();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r1 <= 1) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
        r9.f.signal();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
        r4.unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r1 != r9.b) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
        d();
     */
    @Override // java.util.concurrent.BlockingQueue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final E poll(long j, TimeUnit timeUnit) {
        E e = null;
        long nanos = timeUnit.toNanos(j);
        AtomicInteger atomicInteger = this.c;
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                if (atomicInteger.get() != 0) {
                    break;
                } else if (nanos <= 0) {
                    break;
                } else {
                    nanos = this.f.awaitNanos(nanos);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return e;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final void put(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        a<E> aVar = new a<>(e);
        ReentrantLock reentrantLock = this.g;
        AtomicInteger atomicInteger = this.c;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.b) {
            try {
                this.h.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        a(aVar);
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.b) {
            this.h.signal();
        }
        if (andIncrement == 0) {
            c();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int remainingCapacity() {
        return this.b - this.c.get();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public final boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        a();
        try {
            a<E> aVar = this.f4471a;
            for (a<E> aVar2 = aVar.f4462a; aVar2 != null; aVar2 = aVar2.f4462a) {
                if (obj.equals(aVar2.b())) {
                    a(aVar2, aVar);
                    b();
                    return true;
                }
                aVar = aVar2;
            }
            return false;
        } finally {
            b();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.c.get();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final E take() {
        AtomicInteger atomicInteger = this.c;
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                this.f.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        E a2 = a(null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.f.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.b) {
            d();
        }
        return a2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        a();
        try {
            Object[] objArr = new Object[this.c.get()];
            int i = 0;
            a aVar = this.f4471a.f4462a;
            while (aVar != null) {
                int i2 = i + 1;
                objArr[i] = aVar.b();
                aVar = aVar.f4462a;
                i = i2;
            }
            return objArr;
        } finally {
            b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v6 */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        a();
        try {
            int i = this.c.get();
            if (tArr.length < i) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
            }
            int i2 = 0;
            a aVar = this.f4471a.f4462a;
            while (aVar != null) {
                tArr[i2] = aVar.b();
                aVar = aVar.f4462a;
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
