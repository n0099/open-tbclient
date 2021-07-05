package com.kwad.sdk.lib.widget.recycler.a;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
/* loaded from: classes7.dex */
public class c<T> implements List<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d<T> f38551a;

    public c(d<T> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38551a = dVar;
    }

    @Override // java.util.List
    public void add(int i2, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, t) == null) {
            this.f38551a.a().add(i2, t);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) ? this.f38551a.a().add(t) : invokeL.booleanValue;
    }

    @Override // java.util.List
    public boolean addAll(int i2, @NonNull Collection<? extends T> collection) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, collection)) == null) ? this.f38551a.a().addAll(i2, collection) : invokeIL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NonNull Collection<? extends T> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, collection)) == null) ? this.f38551a.a().addAll(collection) : invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f38551a.a().clear();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? this.f38551a.a().contains(obj) : invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, collection)) == null) ? this.f38551a.a().containsAll(collection) : invokeL.booleanValue;
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super T> consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, consumer) == null) {
            this.f38551a.a().forEach(consumer);
        }
    }

    @Override // java.util.List
    public T get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? this.f38551a.a().get(i2) : (T) invokeI.objValue;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) ? this.f38551a.a().indexOf(obj) : invokeL.intValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f38551a.a().isEmpty() : invokeV.booleanValue;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NonNull
    public Iterator<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f38551a.a().iterator() : (Iterator) invokeV.objValue;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) ? this.f38551a.a().lastIndexOf(obj) : invokeL.intValue;
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<T> listIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f38551a.a().listIterator() : (ListIterator) invokeV.objValue;
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<T> listIterator(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? this.f38551a.a().listIterator(i2) : (ListIterator) invokeI.objValue;
    }

    @Override // java.util.List
    public T remove(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? this.f38551a.a().remove(i2) : (T) invokeI.objValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) ? this.f38551a.a().remove(obj) : invokeL.booleanValue;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, collection)) == null) ? this.f38551a.a().removeAll(collection) : invokeL.booleanValue;
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<T> unaryOperator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, unaryOperator) == null) {
            this.f38551a.a().replaceAll(unaryOperator);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, collection)) == null) ? this.f38551a.a().retainAll(collection) : invokeL.booleanValue;
    }

    @Override // java.util.List
    public T set(int i2, T t) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048596, this, i2, t)) == null) ? this.f38551a.a().set(i2, t) : (T) invokeIL.objValue;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f38551a.a().size() : invokeV.intValue;
    }

    @Override // java.util.List
    public void sort(Comparator<? super T> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, comparator) == null) {
            this.f38551a.a().sort(comparator);
        }
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Spliterator<T> spliterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f38551a.a().spliterator() : (Spliterator) invokeV.objValue;
    }

    @Override // java.util.List
    @NonNull
    public List<T> subList(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048600, this, i2, i3)) == null) ? this.f38551a.a().subList(i2, i3) : (List) invokeII.objValue;
    }

    @Override // java.util.List, java.util.Collection
    @NonNull
    public Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f38551a.a().toArray() : (Object[]) invokeV.objValue;
    }

    @Override // java.util.List, java.util.Collection
    @NonNull
    public <T1> T1[] toArray(@NonNull T1[] t1Arr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, t1Arr)) == null) ? (T1[]) this.f38551a.a().toArray(t1Arr) : (T1[]) ((Object[]) invokeL.objValue);
    }
}
