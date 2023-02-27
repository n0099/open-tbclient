package com.huawei.hms.framework.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes8.dex */
public class LimitQueue<E> extends ConcurrentLinkedQueue<E> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "LimitQueue";
    public static final long serialVersionUID = -4636313759149307798L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean deduplication;
    public int limit;

    public LimitQueue(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.deduplication = false;
        this.limit = i;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
            if (collection.size() > this.limit) {
                return false;
            }
            if (this.deduplication) {
                super.removeAll(collection);
            }
            for (int size = (collection.size() + super.size()) - this.limit; size > 0; size--) {
                super.poll();
            }
            return super.addAll(collection);
        }
        return invokeL.booleanValue;
    }

    public LimitQueue(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.deduplication = false;
        this.limit = i;
        this.deduplication = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LimitQueue(Collection<? extends E> collection, boolean z) {
        this(collection.size(), z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collection, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        addAll(collection);
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e)) == null) {
            if (this.deduplication) {
                super.remove(e);
            }
            if (super.size() >= this.limit) {
                super.poll();
            }
            return super.add(e);
        }
        return invokeL.booleanValue;
    }

    public E get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            Iterator<E> it = iterator();
            E e = null;
            for (int i2 = 0; i2 <= i && it.hasNext(); i2++) {
                e = it.next();
            }
            return e;
        }
        return (E) invokeI.objValue;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public boolean offer(E e) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, e)) == null) {
            if (this.deduplication) {
                super.remove(e);
            }
            if (super.size() >= this.limit) {
                super.poll();
            }
            return super.offer(e);
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.clear();
        }
    }

    public int getLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.limit;
        }
        return invokeV.intValue;
    }

    public E peekLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Iterator<E> it = iterator();
            E e = null;
            while (it.hasNext()) {
                e = it.next();
            }
            return e;
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public E poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (E) super.poll();
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                return (E) super.remove();
            } catch (NoSuchElementException unused) {
                Logger.w(TAG, "remove failed, limitQueue is empty");
                return null;
            }
        }
        return (E) invokeV.objValue;
    }
}
