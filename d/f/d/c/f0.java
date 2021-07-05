package d.f.d.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public abstract class f0<K, V> extends h0 implements q0<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f0() {
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

    public abstract Map<K, Collection<V>> asMap();

    public abstract void clear();

    @Override // d.f.d.c.q0
    public boolean containsEntry(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, obj2)) == null) ? delegate().containsEntry(obj, obj2) : invokeLL.booleanValue;
    }

    @Override // d.f.d.c.q0
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? delegate().containsKey(obj) : invokeL.booleanValue;
    }

    @Override // d.f.d.c.q0
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) ? delegate().containsValue(obj) : invokeL.booleanValue;
    }

    @Override // d.f.d.c.h0
    public abstract q0<K, V> delegate();

    @Override // d.f.d.c.h0
    public abstract /* bridge */ /* synthetic */ Object delegate();

    public abstract Collection<Map.Entry<K, V>> entries();

    @Override // d.f.d.c.q0
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) ? obj == this || delegate().equals(obj) : invokeL.booleanValue;
    }

    public abstract Collection<V> get(K k);

    @Override // d.f.d.c.q0
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? delegate().hashCode() : invokeV.intValue;
    }

    @Override // d.f.d.c.q0
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? delegate().isEmpty() : invokeV.booleanValue;
    }

    public abstract Set<K> keySet();

    public abstract s0<K> keys();

    public abstract boolean put(K k, V v);

    public abstract boolean putAll(q0<? extends K, ? extends V> q0Var);

    public abstract boolean putAll(K k, Iterable<? extends V> iterable);

    public abstract boolean remove(Object obj, Object obj2);

    public abstract Collection<V> removeAll(Object obj);

    public abstract Collection<V> replaceValues(K k, Iterable<? extends V> iterable);

    @Override // d.f.d.c.q0
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? delegate().size() : invokeV.intValue;
    }

    public abstract Collection<V> values();
}
