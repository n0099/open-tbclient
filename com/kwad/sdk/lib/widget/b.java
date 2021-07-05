package com.kwad.sdk.lib.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes7.dex */
public class b<T> implements List<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<T> f38535a;

    public b(@NonNull List<T> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38535a = list;
    }

    @Override // java.util.List
    public void add(int i2, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, t) == null) {
            this.f38535a.add(i2, t);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) ? this.f38535a.add(t) : invokeL.booleanValue;
    }

    @Override // java.util.List
    public boolean addAll(int i2, Collection<? extends T> collection) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, collection)) == null) ? this.f38535a.addAll(i2, collection) : invokeIL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, collection)) == null) ? this.f38535a.addAll(collection) : invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f38535a.clear();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? this.f38535a.contains(obj) : invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, collection)) == null) ? this.f38535a.containsAll(collection) : invokeL.booleanValue;
    }

    @Override // java.util.List
    public T get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            T t = this.f38535a.get(i2);
            if (t instanceof AdTemplate) {
                ((AdTemplate) t).setShowPosition(i2);
            }
            return t;
        }
        return (T) invokeI.objValue;
    }

    @Override // java.util.List
    public int indexOf(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) ? this.f38535a.indexOf(obj) : invokeL.intValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f38535a.isEmpty() : invokeV.booleanValue;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NonNull
    public Iterator<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f38535a.iterator() : (Iterator) invokeV.objValue;
    }

    @Override // java.util.List
    public int lastIndexOf(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) ? this.f38535a.lastIndexOf(obj) : invokeL.intValue;
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<T> listIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f38535a.listIterator() : (ListIterator) invokeV.objValue;
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<T> listIterator(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) ? this.f38535a.listIterator(i2) : (ListIterator) invokeI.objValue;
    }

    @Override // java.util.List
    public T remove(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? this.f38535a.remove(i2) : (T) invokeI.objValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) ? this.f38535a.remove(obj) : invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, collection)) == null) ? this.f38535a.removeAll(collection) : invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, collection)) == null) ? this.f38535a.retainAll(collection) : invokeL.booleanValue;
    }

    @Override // java.util.List
    public T set(int i2, T t) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i2, t)) == null) ? this.f38535a.set(i2, t) : (T) invokeIL.objValue;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f38535a.size() : invokeV.intValue;
    }

    @Override // java.util.List
    @NonNull
    public List<T> subList(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) ? this.f38535a.subList(i2, i3) : (List) invokeII.objValue;
    }

    @Override // java.util.List, java.util.Collection
    @NonNull
    public Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f38535a.toArray() : (Object[]) invokeV.objValue;
    }

    @Override // java.util.List, java.util.Collection
    @NonNull
    public <T1> T1[] toArray(@NonNull T1[] t1Arr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, t1Arr)) == null) ? (T1[]) this.f38535a.toArray(t1Arr) : (T1[]) ((Object[]) invokeL.objValue);
    }
}
