package com.sdk.base.framework.a.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public transient a<E> a;

    /* renamed from: b  reason: collision with root package name */
    public final int f57733b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f57734c;

    /* renamed from: d  reason: collision with root package name */
    public transient a<E> f57735d;

    /* renamed from: e  reason: collision with root package name */
    public final ReentrantLock f57736e;

    /* renamed from: f  reason: collision with root package name */
    public final Condition f57737f;

    /* renamed from: g  reason: collision with root package name */
    public final ReentrantLock f57738g;

    /* renamed from: h  reason: collision with root package name */
    public final Condition f57739h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l() {
        this(Integer.MAX_VALUE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57734c = new AtomicInteger();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f57736e = reentrantLock;
        this.f57737f = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.f57738g = reentrantLock2;
        this.f57739h = reentrantLock2.newCondition();
        this.f57733b = Integer.MAX_VALUE;
        a<E> aVar = new a<>(null);
        this.a = aVar;
        this.f57735d = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.sdk.base.framework.a.c.a<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private synchronized E a(a<E> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) {
            synchronized (this) {
                if (aVar == 0) {
                    a aVar2 = (a<E>) this.a;
                    a<E> aVar3 = (a<E>) aVar2.a;
                    aVar2.a = aVar2;
                    this.a = aVar3;
                    E b2 = aVar3.b();
                    aVar3.a(null);
                    return b2;
                }
                boolean z = false;
                a aVar4 = this.a;
                while (true) {
                    a<T> aVar5 = aVar4.a;
                    if (aVar5 == 0) {
                        break;
                    } else if (aVar5.a() - 1 > aVar.a() - 1) {
                        aVar4.a = aVar;
                        aVar.a = aVar5;
                        z = true;
                        break;
                    } else {
                        aVar4 = aVar4.a;
                    }
                }
                if (!z) {
                    this.f57735d.a = aVar;
                    this.f57735d = aVar;
                }
                return null;
            }
        }
        return (E) invokeL.objValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            ReentrantLock reentrantLock = this.f57736e;
            reentrantLock.lock();
            try {
                this.f57737f.signal();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            ReentrantLock reentrantLock = this.f57738g;
            reentrantLock.lock();
            try {
                this.f57739h.signal();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f57738g.lock();
            this.f57736e.lock();
        }
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: com.sdk.base.framework.a.c.a<E>, com.sdk.base.framework.a.c.a<T> */
    public final void a(a<E> aVar, a<E> aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, aVar2) == null) {
            aVar.a(null);
            aVar2.a = (a<E>) aVar.a;
            if (this.f57735d == aVar) {
                this.f57735d = aVar2;
            }
            if (this.f57734c.getAndDecrement() == this.f57733b) {
                this.f57739h.signal();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f57736e.unlock();
            this.f57738g.unlock();
        }
    }

    /* JADX DEBUG: Type inference failed for r0v4. Raw type applied. Possible types: com.sdk.base.framework.a.c.a, com.sdk.base.framework.a.c.a<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a();
            try {
                a aVar = (a<E>) this.a;
                while (true) {
                    a aVar2 = aVar.a;
                    if (aVar2 == null) {
                        break;
                    }
                    aVar.a = aVar;
                    aVar2.a(null);
                    aVar = (a<E>) aVar2;
                }
                this.a = this.f57735d;
                if (this.f57734c.getAndSet(0) == this.f57733b) {
                    this.f57739h.signal();
                }
            } finally {
                b();
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public final boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            a();
            try {
                a aVar = this.a;
                do {
                    aVar = aVar.a;
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
        return invokeL.booleanValue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection<? super E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, collection)) == null) ? drainTo(collection, Integer.MAX_VALUE) : invokeL.intValue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection<? super E> collection, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, collection, i2)) == null) {
            if (collection != null) {
                if (collection != this) {
                    boolean z = false;
                    if (i2 <= 0) {
                        return 0;
                    }
                    ReentrantLock reentrantLock = this.f57736e;
                    reentrantLock.lock();
                    try {
                        int min = Math.min(i2, this.f57734c.get());
                        a<E> aVar = this.a;
                        int i3 = 0;
                        while (i3 < min) {
                            a<E> aVar2 = aVar.a;
                            collection.add((Object) aVar2.b());
                            aVar2.a(null);
                            aVar.a = (a<T>) aVar;
                            i3++;
                            aVar = aVar2;
                        }
                        if (i3 > 0) {
                            this.a = aVar;
                            if (this.f57734c.getAndAdd(-i3) == this.f57733b) {
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
        return invokeLI.intValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new m(this) : (Iterator) invokeV.objValue;
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public final boolean offer(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e2)) == null) {
            if (e2 != null) {
                AtomicInteger atomicInteger = this.f57734c;
                if (atomicInteger.get() == this.f57733b) {
                    return false;
                }
                int i2 = -1;
                a<E> aVar = new a<>(e2);
                ReentrantLock reentrantLock = this.f57738g;
                reentrantLock.lock();
                try {
                    if (atomicInteger.get() < this.f57733b) {
                        a(aVar);
                        i2 = atomicInteger.getAndIncrement();
                        if (i2 + 1 < this.f57733b) {
                            this.f57739h.signal();
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
        return invokeL.booleanValue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final boolean offer(E e2, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{e2, Long.valueOf(j2), timeUnit})) == null) {
            if (e2 != null) {
                long nanos = timeUnit.toNanos(j2);
                ReentrantLock reentrantLock = this.f57738g;
                AtomicInteger atomicInteger = this.f57734c;
                reentrantLock.lockInterruptibly();
                while (atomicInteger.get() == this.f57733b) {
                    try {
                        if (nanos <= 0) {
                            reentrantLock.unlock();
                            return false;
                        }
                        nanos = this.f57739h.awaitNanos(nanos);
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                a(new a<>(e2));
                int andIncrement = atomicInteger.getAndIncrement();
                if (andIncrement + 1 < this.f57733b) {
                    this.f57739h.signal();
                }
                if (andIncrement == 0) {
                    c();
                    return true;
                }
                return true;
            }
            throw null;
        }
        return invokeCommon.booleanValue;
    }

    @Override // java.util.Queue
    public final E peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f57734c.get() == 0) {
                return null;
            }
            ReentrantLock reentrantLock = this.f57736e;
            reentrantLock.lock();
            try {
                a<E> aVar = this.a.a;
                if (aVar == null) {
                    return null;
                }
                return aVar.b();
            } finally {
                reentrantLock.unlock();
            }
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.Queue
    public final E poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            AtomicInteger atomicInteger = this.f57734c;
            E e2 = null;
            if (atomicInteger.get() == 0) {
                return null;
            }
            int i2 = -1;
            ReentrantLock reentrantLock = this.f57736e;
            reentrantLock.lock();
            try {
                if (atomicInteger.get() > 0) {
                    e2 = a(null);
                    i2 = atomicInteger.getAndDecrement();
                    if (i2 > 1) {
                        this.f57737f.signal();
                    }
                }
                reentrantLock.unlock();
                if (i2 == this.f57733b) {
                    d();
                }
                return e2;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final E poll(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048588, this, j2, timeUnit)) == null) {
            long nanos = timeUnit.toNanos(j2);
            AtomicInteger atomicInteger = this.f57734c;
            ReentrantLock reentrantLock = this.f57736e;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == 0) {
                try {
                    if (nanos <= 0) {
                        return null;
                    }
                    nanos = this.f57737f.awaitNanos(nanos);
                } finally {
                    reentrantLock.unlock();
                }
            }
            E a = a(null);
            int andDecrement = atomicInteger.getAndDecrement();
            if (andDecrement > 1) {
                this.f57737f.signal();
            }
            reentrantLock.unlock();
            if (andDecrement == this.f57733b) {
                d();
            }
            return a;
        }
        return (E) invokeJL.objValue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final void put(E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, e2) == null) {
            if (e2 == null) {
                throw null;
            }
            a<E> aVar = new a<>(e2);
            ReentrantLock reentrantLock = this.f57738g;
            AtomicInteger atomicInteger = this.f57734c;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == this.f57733b) {
                try {
                    this.f57739h.await();
                } finally {
                    reentrantLock.unlock();
                }
            }
            a(aVar);
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement + 1 < this.f57733b) {
                this.f57739h.signal();
            }
            if (andIncrement == 0) {
                c();
            }
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int remainingCapacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f57733b - this.f57734c.get() : invokeV.intValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public final boolean remove(Object obj) {
        InterceptResult invokeL;
        a<E> aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            a();
            try {
                a<E> aVar2 = this.a;
                do {
                    aVar = aVar2;
                    aVar2 = aVar2.a;
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
        return invokeL.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f57734c.get() : invokeV.intValue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final E take() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            AtomicInteger atomicInteger = this.f57734c;
            ReentrantLock reentrantLock = this.f57736e;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == 0) {
                try {
                    this.f57737f.await();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            E a = a(null);
            int andDecrement = atomicInteger.getAndDecrement();
            if (andDecrement > 1) {
                this.f57737f.signal();
            }
            reentrantLock.unlock();
            if (andDecrement == this.f57733b) {
                d();
            }
            return a;
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048594, this)) != null) {
            return (Object[]) invokeV.objValue;
        }
        a();
        try {
            Object[] objArr = new Object[this.f57734c.get()];
            int i2 = 0;
            a aVar = this.a;
            while (true) {
                aVar = aVar.a;
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, tArr)) == null) {
            a();
            try {
                int i2 = this.f57734c.get();
                if (tArr.length < i2) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2));
                }
                int i3 = 0;
                a aVar = this.a;
                while (true) {
                    aVar = aVar.a;
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
        return (T[]) ((Object[]) invokeL.objValue);
    }
}
