package d.f.d.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.c.k1;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public abstract class m0<R, C, V> extends h0 implements k1<R, C, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m0() {
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

    public Set<k1.a<R, C, V>> cellSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? delegate().cellSet() : (Set) invokeV.objValue;
    }

    public abstract void clear();

    public Map<R, V> column(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2)) == null) ? delegate().column(c2) : (Map) invokeL.objValue;
    }

    public Set<C> columnKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? delegate().columnKeySet() : (Set) invokeV.objValue;
    }

    public Map<C, Map<R, V>> columnMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? delegate().columnMap() : (Map) invokeV.objValue;
    }

    @Override // d.f.d.c.k1
    public boolean contains(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, obj, obj2)) == null) ? delegate().contains(obj, obj2) : invokeLL.booleanValue;
    }

    @Override // d.f.d.c.k1
    public boolean containsColumn(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) ? delegate().containsColumn(obj) : invokeL.booleanValue;
    }

    @Override // d.f.d.c.k1
    public boolean containsRow(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) ? delegate().containsRow(obj) : invokeL.booleanValue;
    }

    @Override // d.f.d.c.k1
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) ? delegate().containsValue(obj) : invokeL.booleanValue;
    }

    @Override // d.f.d.c.h0
    public abstract k1<R, C, V> delegate();

    @Override // d.f.d.c.h0
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // d.f.d.c.k1
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) ? obj == this || delegate().equals(obj) : invokeL.booleanValue;
    }

    @Override // d.f.d.c.k1
    public V get(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, obj, obj2)) == null) ? delegate().get(obj, obj2) : (V) invokeLL.objValue;
    }

    @Override // d.f.d.c.k1
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? delegate().hashCode() : invokeV.intValue;
    }

    @Override // d.f.d.c.k1
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? delegate().isEmpty() : invokeV.booleanValue;
    }

    public abstract V put(R r, C c2, V v);

    public abstract void putAll(k1<? extends R, ? extends C, ? extends V> k1Var);

    public abstract V remove(Object obj, Object obj2);

    public Map<C, V> row(R r) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, r)) == null) ? delegate().row(r) : (Map) invokeL.objValue;
    }

    public Set<R> rowKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? delegate().rowKeySet() : (Set) invokeV.objValue;
    }

    public Map<R, Map<C, V>> rowMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? delegate().rowMap() : (Map) invokeV.objValue;
    }

    @Override // d.f.d.c.k1
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? delegate().size() : invokeV.intValue;
    }

    public Collection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? delegate().values() : (Collection) invokeV.objValue;
    }
}
