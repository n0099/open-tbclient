package com.sdk.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes9.dex */
public class i<E> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -6903933977591709194L;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final AtomicInteger b;
    public transient com.sdk.d.a<E> c;
    public transient com.sdk.d.a<E> d;
    public final ReentrantLock e;
    public final Condition f;
    public final ReentrantLock g;
    public final Condition h;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.sdk.d.i<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65537, this, objectInputStream) != null) {
            return;
        }
        objectInputStream.defaultReadObject();
        this.b.set(0);
        com.sdk.d.a<E> aVar = new com.sdk.d.a<>(null);
        this.c = aVar;
        this.d = aVar;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            }
            add(readObject);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65538, this, objectOutputStream) != null) {
            return;
        }
        a();
        try {
            objectOutputStream.defaultWriteObject();
            com.sdk.d.a aVar = this.c;
            while (true) {
                aVar = aVar.c;
                if (aVar == null) {
                    objectOutputStream.writeObject(null);
                    return;
                }
                objectOutputStream.writeObject(aVar.b());
            }
        } finally {
            b();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.g.lock();
            this.e.lock();
        }
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: com.sdk.d.a<E>, com.sdk.d.a<T> */
    public void a(com.sdk.d.a<E> aVar, com.sdk.d.a<E> aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, aVar2) == null) {
            aVar.a(null);
            aVar2.c = (com.sdk.d.a<E>) aVar.c;
            if (this.d == aVar) {
                this.d = aVar2;
            }
            if (this.b.getAndDecrement() == this.a) {
                this.h.signal();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e.unlock();
            this.g.unlock();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ReentrantLock reentrantLock = this.e;
            reentrantLock.lock();
            try {
                this.f.signal();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* JADX DEBUG: Type inference failed for r0v4. Raw type applied. Possible types: com.sdk.d.a, com.sdk.d.a<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a();
            try {
                com.sdk.d.a aVar = (com.sdk.d.a<E>) this.c;
                while (true) {
                    com.sdk.d.a aVar2 = aVar.c;
                    if (aVar2 == null) {
                        break;
                    }
                    aVar.c = aVar;
                    aVar2.a(null);
                    aVar = (com.sdk.d.a<E>) aVar2;
                }
                this.c = this.d;
                if (this.b.getAndSet(0) == this.a) {
                    this.h.signal();
                }
            } finally {
                b();
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            a();
            try {
                com.sdk.d.a aVar = this.c;
                do {
                    aVar = aVar.c;
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

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ReentrantLock reentrantLock = this.g;
            reentrantLock.lock();
            try {
                this.h.signal();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, collection)) == null) ? drainTo(collection, Integer.MAX_VALUE) : invokeL.intValue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, collection, i)) == null) {
            if (collection != null) {
                if (collection != this) {
                    boolean z = false;
                    if (i <= 0) {
                        return 0;
                    }
                    ReentrantLock reentrantLock = this.e;
                    reentrantLock.lock();
                    try {
                        int min = Math.min(i, this.b.get());
                        com.sdk.d.a<E> aVar = this.c;
                        int i2 = 0;
                        while (i2 < min) {
                            com.sdk.d.a<E> aVar2 = aVar.c;
                            collection.add((Object) aVar2.b());
                            aVar2.a(null);
                            aVar.c = (com.sdk.d.a<T>) aVar;
                            i2++;
                            aVar = aVar2;
                        }
                        if (i2 > 0) {
                            this.c = aVar;
                            if (this.b.getAndAdd(-i2) == this.a) {
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
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new a(this) : (Iterator) invokeV.objValue;
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, e)) == null) {
            if (e != null) {
                AtomicInteger atomicInteger = this.b;
                if (atomicInteger.get() == this.a) {
                    return false;
                }
                int i = -1;
                com.sdk.d.a<E> aVar = new com.sdk.d.a<>(e);
                ReentrantLock reentrantLock = this.g;
                reentrantLock.lock();
                try {
                    if (atomicInteger.get() < this.a) {
                        a(aVar);
                        i = atomicInteger.getAndIncrement();
                        if (i + 1 < this.a) {
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
    public boolean offer(E e, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{e, Long.valueOf(j), timeUnit})) == null) {
            if (e != null) {
                long nanos = timeUnit.toNanos(j);
                ReentrantLock reentrantLock = this.g;
                AtomicInteger atomicInteger = this.b;
                reentrantLock.lockInterruptibly();
                while (atomicInteger.get() == this.a) {
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
                a(new com.sdk.d.a<>(e));
                int andIncrement = atomicInteger.getAndIncrement();
                if (andIncrement + 1 < this.a) {
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
    public E peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.b.get() == 0) {
                return null;
            }
            ReentrantLock reentrantLock = this.e;
            reentrantLock.lock();
            try {
                com.sdk.d.a<E> aVar = this.c.c;
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
    public E poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            AtomicInteger atomicInteger = this.b;
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
                if (i == this.a) {
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
    public E poll(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048591, this, j, timeUnit)) == null) {
            long nanos = timeUnit.toNanos(j);
            AtomicInteger atomicInteger = this.b;
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
            E a2 = a(null);
            int andDecrement = atomicInteger.getAndDecrement();
            if (andDecrement > 1) {
                this.f.signal();
            }
            reentrantLock.unlock();
            if (andDecrement == this.a) {
                d();
            }
            return a2;
        }
        return (E) invokeJL.objValue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, e) == null) {
            if (e == null) {
                throw null;
            }
            com.sdk.d.a<E> aVar = new com.sdk.d.a<>(e);
            ReentrantLock reentrantLock = this.g;
            AtomicInteger atomicInteger = this.b;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == this.a) {
                try {
                    this.h.await();
                } finally {
                    reentrantLock.unlock();
                }
            }
            a(aVar);
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement + 1 < this.a) {
                this.h.signal();
            }
            if (andIncrement == 0) {
                c();
            }
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.a - this.b.get() : invokeV.intValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean remove(Object obj) {
        InterceptResult invokeL;
        com.sdk.d.a<E> aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            a();
            try {
                com.sdk.d.a<E> aVar2 = this.c;
                do {
                    aVar = aVar2;
                    aVar2 = aVar2.c;
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
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.b.get() : invokeV.intValue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            AtomicInteger atomicInteger = this.b;
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
            if (andDecrement == this.a) {
                d();
            }
            return a2;
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048597, this)) != null) {
            return (Object[]) invokeV.objValue;
        }
        a();
        try {
            Object[] objArr = new Object[this.b.get()];
            int i = 0;
            com.sdk.d.a aVar = this.c;
            while (true) {
                aVar = aVar.c;
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
    public <T> T[] toArray(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, tArr)) == null) {
            a();
            try {
                int i = this.b.get();
                if (tArr.length < i) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
                }
                int i2 = 0;
                com.sdk.d.a aVar = this.c;
                while (true) {
                    aVar = aVar.c;
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

    /* loaded from: classes9.dex */
    public class a implements Iterator<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public com.sdk.d.a<E> a;
        public com.sdk.d.a<E> b;
        public E c;
        public final /* synthetic */ i d;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = iVar;
            iVar.a();
            try {
                com.sdk.d.a<E> aVar = iVar.c.c;
                this.a = aVar;
                if (aVar != null) {
                    this.c = aVar.b();
                }
            } finally {
                iVar.b();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a != null : invokeV.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
            r4.d.a(r1, r2);
         */
        @Override // java.util.Iterator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.b == null) {
                    throw new IllegalStateException();
                }
                this.d.a();
                try {
                    com.sdk.d.a<E> aVar = this.b;
                    this.b = null;
                    com.sdk.d.a<E> aVar2 = this.d.c;
                    while (true) {
                        com.sdk.d.a<E> aVar3 = aVar2;
                        aVar2 = aVar2.c;
                        if (aVar2 == null) {
                            break;
                        } else if (aVar2 == aVar) {
                            break;
                        }
                    }
                } finally {
                    this.d.b();
                }
            }
        }

        @Override // java.util.Iterator
        public E next() {
            InterceptResult invokeV;
            com.sdk.d.a<E> aVar;
            E b;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.d.a();
                try {
                    if (this.a != null) {
                        E e = this.c;
                        this.b = this.a;
                        com.sdk.d.a<E> aVar2 = this.a;
                        while (true) {
                            aVar = aVar2.c;
                            if (aVar == aVar2) {
                                aVar = this.d.c.c;
                                break;
                            } else if (aVar == null || aVar.b() != null) {
                                break;
                            } else {
                                aVar2 = aVar;
                            }
                        }
                        this.a = aVar;
                        if (aVar == null) {
                            b = null;
                        } else {
                            b = aVar.b();
                        }
                        this.c = b;
                        return e;
                    }
                    throw new NoSuchElementException();
                } finally {
                    this.d.b();
                }
            }
            return (E) invokeV.objValue;
        }
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new AtomicInteger();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.e = reentrantLock;
        this.f = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.g = reentrantLock2;
        this.h = reentrantLock2.newCondition();
        this.a = Integer.MAX_VALUE;
        com.sdk.d.a<E> aVar = new com.sdk.d.a<>(null);
        this.c = aVar;
        this.d = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.sdk.d.a<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized E a(com.sdk.d.a<E> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            synchronized (this) {
                if (aVar == 0) {
                    com.sdk.d.a aVar2 = (com.sdk.d.a<E>) this.c;
                    com.sdk.d.a<E> aVar3 = (com.sdk.d.a<E>) aVar2.c;
                    aVar2.c = aVar2;
                    this.c = aVar3;
                    E b = aVar3.b();
                    aVar3.a(null);
                    return b;
                }
                boolean z = false;
                com.sdk.d.a aVar4 = this.c;
                while (true) {
                    com.sdk.d.a<T> aVar5 = aVar4.c;
                    if (aVar5 == 0) {
                        break;
                    } else if (aVar5.a().ordinal() > aVar.a().ordinal()) {
                        aVar4.c = aVar;
                        aVar.c = aVar5;
                        z = true;
                        break;
                    } else {
                        aVar4 = aVar4.c;
                    }
                }
                if (!z) {
                    this.d.c = aVar;
                    this.d = aVar;
                }
                return null;
            }
        }
        return (E) invokeL.objValue;
    }
}
