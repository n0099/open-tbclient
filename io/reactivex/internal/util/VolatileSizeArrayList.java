package io.reactivex.internal.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3972397474470203923L;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<T> list;

    public VolatileSizeArrayList() {
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
        this.list = new ArrayList<>();
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.list.clear();
            lazySet(0);
        }
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.list.hashCode();
        }
        return invokeV.intValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (get() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.list.iterator();
        }
        return (Iterator) invokeV.objValue;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.list.listIterator();
        }
        return (ListIterator) invokeV.objValue;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return get();
        }
        return invokeV.intValue;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.list.toArray();
        }
        return (Object[]) invokeV.objValue;
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.list.toString();
        }
        return (String) invokeV.objValue;
    }

    public VolatileSizeArrayList(int i) {
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
        this.list = new ArrayList<>(i);
    }

    @Override // java.util.List
    public void add(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, t) == null) {
            this.list.add(i, t);
            lazySet(this.list.size());
        }
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, collection)) == null) {
            boolean addAll = this.list.addAll(i, collection);
            lazySet(this.list.size());
            return addAll;
        }
        return invokeIL.booleanValue;
    }

    @Override // java.util.List
    public T set(int i, T t) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048596, this, i, t)) == null) {
            return this.list.set(i, t);
        }
        return (T) invokeIL.objValue;
    }

    @Override // java.util.List
    public List<T> subList(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i, i2)) == null) {
            return this.list.subList(i, i2);
        }
        return (List) invokeII.objValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
            boolean add = this.list.add(t);
            lazySet(this.list.size());
            return add;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, collection)) == null) {
            boolean addAll = this.list.addAll(collection);
            lazySet(this.list.size());
            return addAll;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            return this.list.contains(obj);
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, collection)) == null) {
            return this.list.containsAll(collection);
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj instanceof VolatileSizeArrayList) {
                return this.list.equals(((VolatileSizeArrayList) obj).list);
            }
            return this.list.equals(obj);
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.List
    public T get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return this.list.get(i);
        }
        return (T) invokeI.objValue;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            return this.list.indexOf(obj);
        }
        return invokeL.intValue;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, obj)) == null) {
            return this.list.lastIndexOf(obj);
        }
        return invokeL.intValue;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            return this.list.listIterator(i);
        }
        return (ListIterator) invokeI.objValue;
    }

    @Override // java.util.List
    public T remove(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            T remove = this.list.remove(i);
            lazySet(this.list.size());
            return remove;
        }
        return (T) invokeI.objValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, collection)) == null) {
            boolean removeAll = this.list.removeAll(collection);
            lazySet(this.list.size());
            return removeAll;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, collection)) == null) {
            boolean retainAll = this.list.retainAll(collection);
            lazySet(this.list.size());
            return retainAll;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, eArr)) == null) {
            return (E[]) this.list.toArray(eArr);
        }
        return (E[]) ((Object[]) invokeL.objValue);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, obj)) == null) {
            boolean remove = this.list.remove(obj);
            lazySet(this.list.size());
            return remove;
        }
        return invokeL.booleanValue;
    }
}
