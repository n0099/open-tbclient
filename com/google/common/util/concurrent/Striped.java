package com.google.common.util.concurrent;

import b.h.d.a.j;
import b.h.d.a.n;
import b.h.d.a.r;
import b.h.d.c.o0;
import b.h.d.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.MapMaker;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes11.dex */
public abstract class Striped<L> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALL_SET = -1;
    public static final int LARGE_LAZY_CUTOFF = 1024;
    public static final r<ReadWriteLock> READ_WRITE_LOCK_SUPPLIER;
    public static final r<ReadWriteLock> WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static class CompactStriped<L> extends PowerOfTwoStriped<L> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object[] array;

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (L) this.array[i2] : (L) invokeI.objValue;
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.array.length : invokeV.intValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CompactStriped(int i2, r<L> rVar) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            int i5 = 0;
            n.e(i2 <= 1073741824, "Stripes must be <= 2^30)");
            this.array = new Object[this.mask + 1];
            while (true) {
                Object[] objArr2 = this.array;
                if (i5 >= objArr2.length) {
                    return;
                }
                objArr2[i5] = rVar.get();
                i5++;
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConcurrentMap<Integer, L> locks;
        public final int size;
        public final r<L> supplier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LargeLazyStriped(int i2, r<L> rVar) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            int i5 = this.mask;
            this.size = i5 == -1 ? Integer.MAX_VALUE : i5 + 1;
            this.supplier = rVar;
            MapMaker mapMaker = new MapMaker();
            mapMaker.m();
            this.locks = mapMaker.i();
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.size != Integer.MAX_VALUE) {
                    n.n(i2, size());
                }
                L l = this.locks.get(Integer.valueOf(i2));
                if (l != null) {
                    return l;
                }
                L l2 = this.supplier.get();
                return (L) j.a(this.locks.putIfAbsent(Integer.valueOf(i2), l2), l2);
            }
            return (L) invokeI.objValue;
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.size : invokeV.intValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class PaddedLock extends ReentrantLock {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long unused1;
        public long unused2;
        public long unused3;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaddedLock() {
            super(false);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class PaddedSemaphore extends Semaphore {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long unused1;
        public long unused2;
        public long unused3;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaddedSemaphore(int i2) {
            super(i2, false);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static abstract class PowerOfTwoStriped<L> extends Striped<L> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mask;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PowerOfTwoStriped(int i2) {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.e(i2 > 0, "Stripes must be positive");
            this.mask = i2 > 1073741824 ? -1 : Striped.ceilToPowerOfTwo(i2) - 1;
        }

        @Override // com.google.common.util.concurrent.Striped
        public final L get(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? getAt(indexFor(obj)) : (L) invokeL.objValue;
        }

        @Override // com.google.common.util.concurrent.Striped
        public final int indexFor(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? Striped.smear(obj.hashCode()) & this.mask : invokeL.intValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicReferenceArray<ArrayReference<? extends L>> locks;
        public final ReferenceQueue<L> queue;
        public final int size;
        public final r<L> supplier;

        /* loaded from: classes11.dex */
        public static final class ArrayReference<L> extends WeakReference<L> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final int index;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ArrayReference(L l, int i2, ReferenceQueue<L> referenceQueue) {
                super(l, referenceQueue);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l, Integer.valueOf(i2), referenceQueue};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super(objArr2[0], (ReferenceQueue) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.index = i2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SmallLazyStriped(int i2, r<L> rVar) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.queue = new ReferenceQueue<>();
            int i5 = this.mask;
            this.size = i5 == -1 ? Integer.MAX_VALUE : i5 + 1;
            this.locks = new AtomicReferenceArray<>(this.size);
            this.supplier = rVar;
        }

        private void drainQueue() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(65537, this) != null) {
                return;
            }
            while (true) {
                Reference<? extends L> poll = this.queue.poll();
                if (poll == null) {
                    return;
                }
                ArrayReference<? extends L> arrayReference = (ArrayReference) poll;
                this.locks.compareAndSet(arrayReference.index, arrayReference, null);
            }
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i2) {
            InterceptResult invokeI;
            L l;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.size != Integer.MAX_VALUE) {
                    n.n(i2, size());
                }
                ArrayReference<? extends L> arrayReference = this.locks.get(i2);
                L l2 = arrayReference == null ? null : arrayReference.get();
                if (l2 != null) {
                    return l2;
                }
                L l3 = this.supplier.get();
                ArrayReference<? extends L> arrayReference2 = new ArrayReference<>(l3, i2, this.queue);
                while (!this.locks.compareAndSet(i2, arrayReference, arrayReference2)) {
                    arrayReference = this.locks.get(i2);
                    if (arrayReference == null) {
                        l = null;
                        continue;
                    } else {
                        l = arrayReference.get();
                        continue;
                    }
                    if (l != null) {
                        return l;
                    }
                }
                drainQueue();
                return l3;
            }
            return (L) invokeI.objValue;
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.size : invokeV.intValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class WeakSafeCondition extends ForwardingCondition {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Condition delegate;
        public final WeakSafeReadWriteLock strongReference;

        public WeakSafeCondition(Condition condition, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {condition, weakSafeReadWriteLock};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.delegate = condition;
            this.strongReference = weakSafeReadWriteLock;
        }

        @Override // com.google.common.util.concurrent.ForwardingCondition
        public Condition delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.delegate : (Condition) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class WeakSafeLock extends ForwardingLock {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Lock delegate;
        public final WeakSafeReadWriteLock strongReference;

        public WeakSafeLock(Lock lock, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lock, weakSafeReadWriteLock};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.delegate = lock;
            this.strongReference = weakSafeReadWriteLock;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock
        public Lock delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.delegate : (Lock) invokeV.objValue;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock, java.util.concurrent.locks.Lock
        public Condition newCondition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new WeakSafeCondition(this.delegate.newCondition(), this.strongReference) : (Condition) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class WeakSafeReadWriteLock implements ReadWriteLock {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ReadWriteLock delegate;

        public WeakSafeReadWriteLock() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.delegate = new ReentrantReadWriteLock();
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new WeakSafeLock(this.delegate.readLock(), this) : (Lock) invokeV.objValue;
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new WeakSafeLock(this.delegate.writeLock(), this) : (Lock) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-427785545, "Lcom/google/common/util/concurrent/Striped;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-427785545, "Lcom/google/common/util/concurrent/Striped;");
                return;
            }
        }
        READ_WRITE_LOCK_SUPPLIER = new r<ReadWriteLock>() { // from class: com.google.common.util.concurrent.Striped.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.h.d.a.r
            public ReadWriteLock get() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new ReentrantReadWriteLock() : (ReadWriteLock) invokeV.objValue;
            }
        };
        WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER = new r<ReadWriteLock>() { // from class: com.google.common.util.concurrent.Striped.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.h.d.a.r
            public ReadWriteLock get() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new WeakSafeReadWriteLock() : (ReadWriteLock) invokeV.objValue;
            }
        };
    }

    public static int ceilToPowerOfTwo(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? 1 << c.d(i2, RoundingMode.CEILING) : invokeI.intValue;
    }

    public static <L> Striped<L> custom(int i2, r<L> rVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.BAIDU_LOGO_ID, null, i2, rVar)) == null) ? new CompactStriped(i2, rVar) : (Striped) invokeIL.objValue;
    }

    public static <L> Striped<L> lazy(int i2, r<L> rVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65543, null, i2, rVar)) == null) ? i2 < 1024 ? new SmallLazyStriped(i2, rVar) : new LargeLazyStriped(i2, rVar) : (Striped) invokeIL.objValue;
    }

    public static Striped<Lock> lazyWeakLock(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) ? lazy(i2, new r<Lock>() { // from class: com.google.common.util.concurrent.Striped.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.h.d.a.r
            public Lock get() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new ReentrantLock(false) : (Lock) invokeV.objValue;
            }
        }) : (Striped) invokeI.objValue;
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? lazy(i2, WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER) : (Striped) invokeI.objValue;
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65546, null, i2, i3)) == null) ? lazy(i2, new r<Semaphore>(i3) { // from class: com.google.common.util.concurrent.Striped.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int val$permits;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i3)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$permits = i3;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.h.d.a.r
            public Semaphore get() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new Semaphore(this.val$permits, false) : (Semaphore) invokeV.objValue;
            }
        }) : (Striped) invokeII.objValue;
    }

    public static Striped<Lock> lock(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) ? custom(i2, new r<Lock>() { // from class: com.google.common.util.concurrent.Striped.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.h.d.a.r
            public Lock get() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new PaddedLock() : (Lock) invokeV.objValue;
            }
        }) : (Striped) invokeI.objValue;
    }

    public static Striped<ReadWriteLock> readWriteLock(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) ? custom(i2, READ_WRITE_LOCK_SUPPLIER) : (Striped) invokeI.objValue;
    }

    public static Striped<Semaphore> semaphore(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65549, null, i2, i3)) == null) ? custom(i2, new r<Semaphore>(i3) { // from class: com.google.common.util.concurrent.Striped.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int val$permits;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i3)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$permits = i3;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.h.d.a.r
            public Semaphore get() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new PaddedSemaphore(this.val$permits) : (Semaphore) invokeV.objValue;
            }
        }) : (Striped) invokeII.objValue;
    }

    public static int smear(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i2)) == null) {
            int i3 = i2 ^ ((i2 >>> 20) ^ (i2 >>> 12));
            return (i3 >>> 4) ^ ((i3 >>> 7) ^ i3);
        }
        return invokeI.intValue;
    }

    public Iterable<L> bulkGet(Iterable<?> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iterable)) == null) {
            Object[] p = o0.p(iterable, Object.class);
            if (p.length == 0) {
                return ImmutableList.of();
            }
            int[] iArr = new int[p.length];
            for (int i2 = 0; i2 < p.length; i2++) {
                iArr[i2] = indexFor(p[i2]);
            }
            Arrays.sort(iArr);
            int i3 = iArr[0];
            p[0] = getAt(i3);
            for (int i4 = 1; i4 < p.length; i4++) {
                int i5 = iArr[i4];
                if (i5 == i3) {
                    p[i4] = p[i4 - 1];
                } else {
                    p[i4] = getAt(i5);
                    i3 = i5;
                }
            }
            return Collections.unmodifiableList(Arrays.asList(p));
        }
        return (Iterable) invokeL.objValue;
    }

    public abstract L get(Object obj);

    public abstract L getAt(int i2);

    public abstract int indexFor(Object obj);

    public abstract int size();

    public Striped() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
