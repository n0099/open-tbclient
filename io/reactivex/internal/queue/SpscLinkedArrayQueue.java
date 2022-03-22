package io.reactivex.internal.queue;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes8.dex */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final Object HAS_NEXT;
    public static final int MAX_LOOK_AHEAD_STEP;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicReferenceArray<Object> consumerBuffer;
    public final AtomicLong consumerIndex;
    public final int consumerMask;
    public AtomicReferenceArray<Object> producerBuffer;
    public final AtomicLong producerIndex;
    public long producerLookAhead;
    public int producerLookAheadStep;
    public final int producerMask;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(661015802, "Lio/reactivex/internal/queue/SpscLinkedArrayQueue;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(661015802, "Lio/reactivex/internal/queue/SpscLinkedArrayQueue;");
                return;
            }
        }
        MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
        HAS_NEXT = new Object();
    }

    public SpscLinkedArrayQueue(int i) {
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
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(Math.max(8, i));
        int i4 = roundToPowerOfTwo - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(roundToPowerOfTwo + 1);
        this.producerBuffer = atomicReferenceArray;
        this.producerMask = i4;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.consumerBuffer = atomicReferenceArray;
        this.consumerMask = i4;
        this.producerLookAhead = i4 - 1;
        soProducerIndex(0L);
    }

    private void adjustLookAheadStep(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i) == null) {
            this.producerLookAheadStep = Math.min(i / 4, MAX_LOOK_AHEAD_STEP);
        }
    }

    public static int calcDirectOffset(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i : invokeI.intValue;
    }

    public static int calcWrappedOffset(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) ? calcDirectOffset(((int) j) & i) : invokeCommon.intValue;
    }

    private long lpConsumerIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? this.consumerIndex.get() : invokeV.longValue;
    }

    private long lpProducerIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? this.producerIndex.get() : invokeV.longValue;
    }

    private long lvConsumerIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? this.consumerIndex.get() : invokeV.longValue;
    }

    public static <E> Object lvElement(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, atomicReferenceArray, i)) == null) ? atomicReferenceArray.get(i) : invokeLI.objValue;
    }

    private AtomicReferenceArray<Object> lvNextBufferAndUnlink(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, this, atomicReferenceArray, i)) == null) {
            int calcDirectOffset = calcDirectOffset(i);
            AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) lvElement(atomicReferenceArray, calcDirectOffset);
            soElement(atomicReferenceArray, calcDirectOffset, null);
            return atomicReferenceArray2;
        }
        return (AtomicReferenceArray) invokeLI.objValue;
    }

    private long lvProducerIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.producerIndex.get() : invokeV.longValue;
    }

    private T newBufferPeek(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{atomicReferenceArray, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            this.consumerBuffer = atomicReferenceArray;
            return (T) lvElement(atomicReferenceArray, calcWrappedOffset(j, i));
        }
        return (T) invokeCommon.objValue;
    }

    private T newBufferPoll(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, this, new Object[]{atomicReferenceArray, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            this.consumerBuffer = atomicReferenceArray;
            int calcWrappedOffset = calcWrappedOffset(j, i);
            T t = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
            if (t != null) {
                soElement(atomicReferenceArray, calcWrappedOffset, null);
                soConsumerIndex(j + 1);
            }
            return t;
        }
        return (T) invokeCommon.objValue;
    }

    private void resize(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{atomicReferenceArray, Long.valueOf(j), Integer.valueOf(i), t, Long.valueOf(j2)}) == null) {
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
            this.producerBuffer = atomicReferenceArray2;
            this.producerLookAhead = (j2 + j) - 1;
            soElement(atomicReferenceArray2, i, t);
            soNext(atomicReferenceArray, atomicReferenceArray2);
            soElement(atomicReferenceArray, i, HAS_NEXT);
            soProducerIndex(j + 1);
        }
    }

    private void soConsumerIndex(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65550, this, j) == null) {
            this.consumerIndex.lazySet(j);
        }
    }

    public static void soElement(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65551, null, atomicReferenceArray, i, obj) == null) {
            atomicReferenceArray.lazySet(i, obj);
        }
    }

    private void soNext(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, this, atomicReferenceArray, atomicReferenceArray2) == null) {
            soElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1), atomicReferenceArray2);
        }
    }

    private void soProducerIndex(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65553, this, j) == null) {
            this.producerIndex.lazySet(j);
        }
    }

    private boolean writeToQueue(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, this, new Object[]{atomicReferenceArray, t, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            soElement(atomicReferenceArray, i, t);
            soProducerIndex(j + 1);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? lvProducerIndex() == lvConsumerIndex() : invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            if (t != null) {
                AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
                long lpProducerIndex = lpProducerIndex();
                int i = this.producerMask;
                int calcWrappedOffset = calcWrappedOffset(lpProducerIndex, i);
                if (lpProducerIndex < this.producerLookAhead) {
                    return writeToQueue(atomicReferenceArray, t, lpProducerIndex, calcWrappedOffset);
                }
                long j = this.producerLookAheadStep + lpProducerIndex;
                if (lvElement(atomicReferenceArray, calcWrappedOffset(j, i)) == null) {
                    this.producerLookAhead = j - 1;
                    return writeToQueue(atomicReferenceArray, t, lpProducerIndex, calcWrappedOffset);
                } else if (lvElement(atomicReferenceArray, calcWrappedOffset(1 + lpProducerIndex, i)) == null) {
                    return writeToQueue(atomicReferenceArray, t, lpProducerIndex, calcWrappedOffset);
                } else {
                    resize(atomicReferenceArray, lpProducerIndex, calcWrappedOffset, t, i);
                    return true;
                }
            }
            throw new NullPointerException("Null is not a valid element");
        }
        return invokeL.booleanValue;
    }

    public T peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
            long lpConsumerIndex = lpConsumerIndex();
            int i = this.consumerMask;
            T t = (T) lvElement(atomicReferenceArray, calcWrappedOffset(lpConsumerIndex, i));
            return t == HAS_NEXT ? newBufferPeek(lvNextBufferAndUnlink(atomicReferenceArray, i + 1), lpConsumerIndex, i) : t;
        }
        return (T) invokeV.objValue;
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
            long lpConsumerIndex = lpConsumerIndex();
            int i = this.consumerMask;
            int calcWrappedOffset = calcWrappedOffset(lpConsumerIndex, i);
            T t = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
            boolean z = t == HAS_NEXT;
            if (t == null || z) {
                if (z) {
                    return newBufferPoll(lvNextBufferAndUnlink(atomicReferenceArray, i + 1), lpConsumerIndex, i);
                }
                return null;
            }
            soElement(atomicReferenceArray, calcWrappedOffset, null);
            soConsumerIndex(lpConsumerIndex + 1);
            return t;
        }
        return (T) invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048582, this)) != null) {
            return invokeV.intValue;
        }
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return (int) (lvProducerIndex - lvConsumerIndex2);
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t, T t2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, t, t2)) == null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
            long lvProducerIndex = lvProducerIndex();
            int i = this.producerMask;
            long j = 2 + lvProducerIndex;
            if (lvElement(atomicReferenceArray, calcWrappedOffset(j, i)) == null) {
                int calcWrappedOffset = calcWrappedOffset(lvProducerIndex, i);
                soElement(atomicReferenceArray, calcWrappedOffset + 1, t2);
                soElement(atomicReferenceArray, calcWrappedOffset, t);
                soProducerIndex(j);
                return true;
            }
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
            this.producerBuffer = atomicReferenceArray2;
            int calcWrappedOffset2 = calcWrappedOffset(lvProducerIndex, i);
            soElement(atomicReferenceArray2, calcWrappedOffset2 + 1, t2);
            soElement(atomicReferenceArray2, calcWrappedOffset2, t);
            soNext(atomicReferenceArray, atomicReferenceArray2);
            soElement(atomicReferenceArray, calcWrappedOffset2, HAS_NEXT);
            soProducerIndex(j);
            return true;
        }
        return invokeLL.booleanValue;
    }
}
