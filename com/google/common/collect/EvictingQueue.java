package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.a.n;
import d.f.d.c.i0;
import d.f.d.c.o0;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;
/* loaded from: classes7.dex */
public final class EvictingQueue<E> extends i0<E> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final Queue<E> delegate;
    public final int maxSize;

    public EvictingQueue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.f(i2 >= 0, "maxSize (%s) must >= 0", i2);
        this.delegate = new ArrayDeque(i2);
        this.maxSize = i2;
    }

    public static <E> EvictingQueue<E> create(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? new EvictingQueue<>(i2) : (EvictingQueue) invokeI.objValue;
    }

    @Override // d.f.d.c.y, java.util.Collection, java.util.Queue
    public boolean add(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) {
            n.p(e2);
            if (this.maxSize == 0) {
                return true;
            }
            if (size() == this.maxSize) {
                this.delegate.remove();
            }
            this.delegate.add(e2);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.d.c.y, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
            int size = collection.size();
            if (size >= this.maxSize) {
                clear();
                return o0.a(this, o0.m(collection, size - this.maxSize));
            }
            return standardAddAll(collection);
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.d.c.y, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            Queue<E> delegate = delegate();
            n.p(obj);
            return delegate.contains(obj);
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.d.c.i0, java.util.Queue
    public boolean offer(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, e2)) == null) ? add(e2) : invokeL.booleanValue;
    }

    public int remainingCapacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.maxSize - size() : invokeV.intValue;
    }

    @Override // d.f.d.c.y, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            Queue<E> delegate = delegate();
            n.p(obj);
            return delegate.remove(obj);
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.d.c.i0, d.f.d.c.y, d.f.d.c.h0
    public Queue<E> delegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.delegate : (Queue) invokeV.objValue;
    }
}
