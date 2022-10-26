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
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes8.dex */
public final class SpscLinkedArrayQueue implements SimplePlainQueue {
    public static /* synthetic */ Interceptable $ic;
    public static final Object HAS_NEXT;
    public static final int MAX_LOOK_AHEAD_STEP;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicReferenceArray consumerBuffer;
    public final AtomicLong consumerIndex;
    public final int consumerMask;
    public AtomicReferenceArray producerBuffer;
    public final AtomicLong producerIndex;
    public long producerLookAhead;
    public int producerLookAheadStep;
    public final int producerMask;

    public static int calcDirectOffset(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i : invokeI.intValue;
    }

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

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public Object poll() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AtomicReferenceArray atomicReferenceArray = this.consumerBuffer;
            long lpConsumerIndex = lpConsumerIndex();
            int i = this.consumerMask;
            int calcWrappedOffset = calcWrappedOffset(lpConsumerIndex, i);
            Object lvElement = lvElement(atomicReferenceArray, calcWrappedOffset);
            if (lvElement == HAS_NEXT) {
                z = true;
            } else {
                z = false;
            }
            if (lvElement != null && !z) {
                soElement(atomicReferenceArray, calcWrappedOffset, null);
                soConsumerIndex(lpConsumerIndex + 1);
                return lvElement;
            } else if (!z) {
                return null;
            } else {
                return newBufferPoll(lvNextBufferAndUnlink(atomicReferenceArray, i + 1), lpConsumerIndex, i);
            }
        }
        return invokeV.objValue;
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
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(roundToPowerOfTwo + 1);
        this.producerBuffer = atomicReferenceArray;
        this.producerMask = i4;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.consumerBuffer = atomicReferenceArray;
        this.consumerMask = i4;
        this.producerLookAhead = i4 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj != null) {
                AtomicReferenceArray atomicReferenceArray = this.producerBuffer;
                long lpProducerIndex = lpProducerIndex();
                int i = this.producerMask;
                int calcWrappedOffset = calcWrappedOffset(lpProducerIndex, i);
                if (lpProducerIndex < this.producerLookAhead) {
                    return writeToQueue(atomicReferenceArray, obj, lpProducerIndex, calcWrappedOffset);
                }
                long j = this.producerLookAheadStep + lpProducerIndex;
                if (lvElement(atomicReferenceArray, calcWrappedOffset(j, i)) == null) {
                    this.producerLookAhead = j - 1;
                    return writeToQueue(atomicReferenceArray, obj, lpProducerIndex, calcWrappedOffset);
                } else if (lvElement(atomicReferenceArray, calcWrappedOffset(1 + lpProducerIndex, i)) == null) {
                    return writeToQueue(atomicReferenceArray, obj, lpProducerIndex, calcWrappedOffset);
                } else {
                    resize(atomicReferenceArray, lpProducerIndex, calcWrappedOffset, obj, i);
                    return true;
                }
            }
            throw new NullPointerException("Null is not a valid element");
        }
        return invokeL.booleanValue;
    }

    private void adjustLookAheadStep(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i) == null) {
            this.producerLookAheadStep = Math.min(i / 4, MAX_LOOK_AHEAD_STEP);
        }
    }

    private void soConsumerIndex(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65550, this, j) == null) {
            this.consumerIndex.lazySet(j);
        }
    }

    private void soProducerIndex(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65553, this, j) == null) {
            this.producerIndex.lazySet(j);
        }
    }

    public static int calcWrappedOffset(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            return calcDirectOffset(((int) j) & i);
        }
        return invokeCommon.intValue;
    }

    public static Object lvElement(AtomicReferenceArray atomicReferenceArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, atomicReferenceArray, i)) == null) {
            return atomicReferenceArray.get(i);
        }
        return invokeLI.objValue;
    }

    private AtomicReferenceArray lvNextBufferAndUnlink(AtomicReferenceArray atomicReferenceArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, this, atomicReferenceArray, i)) == null) {
            int calcDirectOffset = calcDirectOffset(i);
            AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) lvElement(atomicReferenceArray, calcDirectOffset);
            soElement(atomicReferenceArray, calcDirectOffset, null);
            return atomicReferenceArray2;
        }
        return (AtomicReferenceArray) invokeLI.objValue;
    }

    private void soNext(AtomicReferenceArray atomicReferenceArray, AtomicReferenceArray atomicReferenceArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, this, atomicReferenceArray, atomicReferenceArray2) == null) {
            soElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1), atomicReferenceArray2);
        }
    }

    private long lpConsumerIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return this.consumerIndex.get();
        }
        return invokeV.longValue;
    }

    private long lpProducerIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            return this.producerIndex.get();
        }
        return invokeV.longValue;
    }

    private long lvConsumerIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            return this.consumerIndex.get();
        }
        return invokeV.longValue;
    }

    private long lvProducerIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            return this.producerIndex.get();
        }
        return invokeV.longValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (lvProducerIndex() == lvConsumerIndex()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Object peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AtomicReferenceArray atomicReferenceArray = this.consumerBuffer;
            long lpConsumerIndex = lpConsumerIndex();
            int i = this.consumerMask;
            Object lvElement = lvElement(atomicReferenceArray, calcWrappedOffset(lpConsumerIndex, i));
            if (lvElement == HAS_NEXT) {
                return newBufferPeek(lvNextBufferAndUnlink(atomicReferenceArray, i + 1), lpConsumerIndex, i);
            }
            return lvElement;
        }
        return invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long lvConsumerIndex = lvConsumerIndex();
            while (true) {
                long lvProducerIndex = lvProducerIndex();
                long lvConsumerIndex2 = lvConsumerIndex();
                if (lvConsumerIndex == lvConsumerIndex2) {
                    return (int) (lvProducerIndex - lvConsumerIndex2);
                }
                lvConsumerIndex = lvConsumerIndex2;
            }
        } else {
            return invokeV.intValue;
        }
    }

    private Object newBufferPeek(AtomicReferenceArray atomicReferenceArray, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{atomicReferenceArray, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            this.consumerBuffer = atomicReferenceArray;
            return lvElement(atomicReferenceArray, calcWrappedOffset(j, i));
        }
        return invokeCommon.objValue;
    }

    private Object newBufferPoll(AtomicReferenceArray atomicReferenceArray, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, this, new Object[]{atomicReferenceArray, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            this.consumerBuffer = atomicReferenceArray;
            int calcWrappedOffset = calcWrappedOffset(j, i);
            Object lvElement = lvElement(atomicReferenceArray, calcWrappedOffset);
            if (lvElement != null) {
                soElement(atomicReferenceArray, calcWrappedOffset, null);
                soConsumerIndex(j + 1);
            }
            return lvElement;
        }
        return invokeCommon.objValue;
    }

    private void resize(AtomicReferenceArray atomicReferenceArray, long j, int i, Object obj, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{atomicReferenceArray, Long.valueOf(j), Integer.valueOf(i), obj, Long.valueOf(j2)}) == null) {
            AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
            this.producerBuffer = atomicReferenceArray2;
            this.producerLookAhead = (j2 + j) - 1;
            soElement(atomicReferenceArray2, i, obj);
            soNext(atomicReferenceArray, atomicReferenceArray2);
            soElement(atomicReferenceArray, i, HAS_NEXT);
            soProducerIndex(j + 1);
        }
    }

    public static void soElement(AtomicReferenceArray atomicReferenceArray, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65551, null, atomicReferenceArray, i, obj) == null) {
            atomicReferenceArray.lazySet(i, obj);
        }
    }

    private boolean writeToQueue(AtomicReferenceArray atomicReferenceArray, Object obj, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, this, new Object[]{atomicReferenceArray, obj, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            soElement(atomicReferenceArray, i, obj);
            soProducerIndex(j + 1);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, obj, obj2)) == null) {
            AtomicReferenceArray atomicReferenceArray = this.producerBuffer;
            long lvProducerIndex = lvProducerIndex();
            int i = this.producerMask;
            long j = 2 + lvProducerIndex;
            if (lvElement(atomicReferenceArray, calcWrappedOffset(j, i)) == null) {
                int calcWrappedOffset = calcWrappedOffset(lvProducerIndex, i);
                soElement(atomicReferenceArray, calcWrappedOffset + 1, obj2);
                soElement(atomicReferenceArray, calcWrappedOffset, obj);
                soProducerIndex(j);
                return true;
            }
            AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
            this.producerBuffer = atomicReferenceArray2;
            int calcWrappedOffset2 = calcWrappedOffset(lvProducerIndex, i);
            soElement(atomicReferenceArray2, calcWrappedOffset2 + 1, obj2);
            soElement(atomicReferenceArray2, calcWrappedOffset2, obj);
            soNext(atomicReferenceArray, atomicReferenceArray2);
            soElement(atomicReferenceArray, calcWrappedOffset2, HAS_NEXT);
            soProducerIndex(j);
            return true;
        }
        return invokeLL.booleanValue;
    }
}
