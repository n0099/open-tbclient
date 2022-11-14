package rx.internal.util.atomic;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.r2a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes9.dex */
public final class SpscExactAtomicArrayQueue<T> extends AtomicReferenceArray<T> implements Queue<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 6210984603741293445L;
    public transient /* synthetic */ FieldHolder $fh;
    public final int capacitySkip;
    public final AtomicLong consumerIndex;
    public final int mask;
    public final AtomicLong producerIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpscExactAtomicArrayQueue(int i) {
        super(r2a.b(i));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int length = length();
        this.mask = length - 1;
        this.capacitySkip = length - i;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, collection)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, eArr)) == null) {
            throw new UnsupportedOperationException();
        }
        return (E[]) ((Object[]) invokeL.objValue);
    }

    @Override // java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.Queue
    public T element() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (T) invokeV.objValue;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.producerIndex == this.consumerIndex) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Iterator) invokeV.objValue;
    }

    @Override // java.util.Queue
    public T peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return get(this.mask & ((int) this.consumerIndex.get()));
        }
        return (T) invokeV.objValue;
    }

    @Override // java.util.Queue
    public T poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            long j = this.consumerIndex.get();
            int i = ((int) j) & this.mask;
            T t = get(i);
            if (t == null) {
                return null;
            }
            this.consumerIndex.lazySet(j + 1);
            lazySet(i, null);
            return t;
        }
        return (T) invokeV.objValue;
    }

    @Override // java.util.Queue
    public T remove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (T) invokeV.objValue;
    }

    @Override // java.util.Collection
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            long j = this.consumerIndex.get();
            while (true) {
                long j2 = this.producerIndex.get();
                long j3 = this.consumerIndex.get();
                if (j == j3) {
                    return (int) (j2 - j3);
                }
                j = j3;
            }
        } else {
            return invokeV.intValue;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Object[]) invokeV.objValue;
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t)) == null) {
            if (t != null) {
                long j = this.producerIndex.get();
                int i = this.mask;
                if (get(((int) (this.capacitySkip + j)) & i) != null) {
                    return false;
                }
                this.producerIndex.lazySet(j + 1);
                lazySet(i & ((int) j), t);
                return true;
            }
            throw null;
        }
        return invokeL.booleanValue;
    }
}
