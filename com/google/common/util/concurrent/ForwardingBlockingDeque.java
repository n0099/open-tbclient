package com.google.common.util.concurrent;

import androidx.core.view.InputDeviceCompat;
import c.i.d.c.a0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public abstract class ForwardingBlockingDeque<E> extends a0<E> implements BlockingDeque<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ForwardingBlockingDeque() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.a0, c.i.d.c.i0, c.i.d.c.y, c.i.d.c.h0
    public abstract BlockingDeque<E> delegate();

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, collection)) == null) ? delegate().drainTo(collection) : invokeL.intValue;
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(E e2, long j2, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{e2, Long.valueOf(j2), timeUnit})) == null) ? delegate().offer(e2, j2, timeUnit) : invokeCommon.booleanValue;
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerFirst(E e2, long j2, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{e2, Long.valueOf(j2), timeUnit})) == null) ? delegate().offerFirst(e2, j2, timeUnit) : invokeCommon.booleanValue;
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerLast(E e2, long j2, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{e2, Long.valueOf(j2), timeUnit})) == null) ? delegate().offerLast(e2, j2, timeUnit) : invokeCommon.booleanValue;
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public E poll(long j2, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048586, this, j2, timeUnit)) == null) ? delegate().poll(j2, timeUnit) : (E) invokeJL.objValue;
    }

    @Override // java.util.concurrent.BlockingDeque
    public E pollFirst(long j2, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048587, this, j2, timeUnit)) == null) ? delegate().pollFirst(j2, timeUnit) : (E) invokeJL.objValue;
    }

    @Override // java.util.concurrent.BlockingDeque
    public E pollLast(long j2, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048588, this, j2, timeUnit)) == null) ? delegate().pollLast(j2, timeUnit) : (E) invokeJL.objValue;
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(E e2) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, e2) == null) {
            delegate().put(e2);
        }
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putFirst(E e2) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, e2) == null) {
            delegate().putFirst(e2);
        }
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putLast(E e2) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, e2) == null) {
            delegate().putLast(e2);
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? delegate().remainingCapacity() : invokeV.intValue;
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? delegate().take() : (E) invokeV.objValue;
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeFirst() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? delegate().takeFirst() : (E) invokeV.objValue;
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeLast() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? delegate().takeLast() : (E) invokeV.objValue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, collection, i2)) == null) ? delegate().drainTo(collection, i2) : invokeLI.intValue;
    }
}
