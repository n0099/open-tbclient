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
/* loaded from: classes7.dex */
public final class l<E> extends AbstractQueue<E> implements Serializable, BlockingQueue<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public transient a<E> a;
    public final int b;
    public final AtomicInteger c;
    public transient a<E> d;
    public final ReentrantLock e;
    public final Condition f;
    public final ReentrantLock g;
    public final Condition h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l() {
        this(Integer.MAX_VALUE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new AtomicInteger();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.e = reentrantLock;
        this.f = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.g = reentrantLock2;
        this.h = reentrantLock2.newCondition();
        this.b = Integer.MAX_VALUE;
        a<E> aVar = new a<>(null);
        this.a = aVar;
        this.d = aVar;
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
                    E b = aVar3.b();
                    aVar3.a(null);
                    return b;
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
                    this.d.a = aVar;
                    this.d = aVar;
                }
                return null;
            }
        }
        return (E) invokeL.objValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            ReentrantLock reentrantLock = this.e;
            reentrantLock.lock();
            try {
                this.f.signal();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            ReentrantLock reentrantLock = this.g;
            reentrantLock.lock();
            try {
                this.h.signal();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g.lock();
            this.e.lock();
        }
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: com.sdk.base.framework.a.c.a<E>, com.sdk.base.framework.a.c.a<T> */
    public final void a(a<E> aVar, a<E> aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, aVar2) == null) {
            aVar.a(null);
            aVar2.a = (a<E>) aVar.a;
            if (this.d == aVar) {
                this.d = aVar2;
            }
            if (this.c.getAndDecrement() == this.b) {
                this.h.signal();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.unlock();
            this.g.unlock();
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
                this.a = this.d;
                if (this.c.getAndSet(0) == this.b) {
                    this.h.signal();
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
    public final int drainTo(Collection<? super E> collection, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, collection, i)) == null) {
            if (collection != null) {
                if (collection != this) {
                    boolean z = false;
                    if (i <= 0) {
                        return 0;
                    }
                    ReentrantLock reentrantLock = this.e;
                    reentrantLock.lock();
                    try {
                        int min = Math.min(i, this.c.get());
                        a<E> aVar = this.a;
                        int i2 = 0;
                        while (i2 < min) {
                            a<E> aVar2 = aVar.a;
                            collection.add((Object) aVar2.b());
                            aVar2.a(null);
                            aVar.a = (a<T>) aVar;
                            i2++;
                            aVar = aVar2;
                        }
                        if (i2 > 0) {
                            this.a = aVar;
                            if (this.c.getAndAdd(-i2) == this.b) {
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
    public final boolean offer(E e) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e)) == null) {
            if (e != null) {
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
            throw null;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final boolean offer(E e, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{e, Long.valueOf(j), timeUnit})) == null) {
            if (e != null) {
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
            if (this.c.get() == 0) {
                return null;
            }
            ReentrantLock reentrantLock = this.e;
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
            AtomicInteger atomicInteger = this.c;
            E e = null;
            if (atomicInteger.get() == 0) {
                return null;
            }
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
                return e;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final E poll(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048588, this, j, timeUnit)) == null) {
            long nanos = timeUnit.toNanos(j);
            AtomicInteger atomicInteger = this.c;
            ReentrantLock reentrantLock = this.e;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == 0) {
                try {
                    if (nanos <= 0) {
                        return null;
                    }
                    nanos = this.f.awaitNanos(nanos);
                } finally {
                    reentrantLock.unlock();
                }
            }
            E a = a(null);
            int andDecrement = atomicInteger.getAndDecrement();
            if (andDecrement > 1) {
                this.f.signal();
            }
            reentrantLock.unlock();
            if (andDecrement == this.b) {
                d();
            }
            return a;
        }
        return (E) invokeJL.objValue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final void put(E e) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, e) == null) {
            if (e == null) {
                throw null;
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
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int remainingCapacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.b - this.c.get() : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.c.get() : invokeV.intValue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final E take() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
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
            E a = a(null);
            int andDecrement = atomicInteger.getAndDecrement();
            if (andDecrement > 1) {
                this.f.signal();
            }
            reentrantLock.unlock();
            if (andDecrement == this.b) {
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
            Object[] objArr = new Object[this.c.get()];
            int i = 0;
            a aVar = this.a;
            while (true) {
                aVar = aVar.a;
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, tArr)) == null) {
            a();
            try {
                int i = this.c.get();
                if (tArr.length < i) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
                }
                int i2 = 0;
                a aVar = this.a;
                while (true) {
                    aVar = aVar.a;
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
        return (T[]) ((Object[]) invokeL.objValue);
    }
}
