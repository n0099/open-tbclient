package d.f.d.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableMap;
import d.f.d.c.h0;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
/* loaded from: classes10.dex */
public abstract class e<K, V> extends h0 implements c<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    @Override // d.f.d.b.c
    public ConcurrentMap<K, V> asMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? delegate().asMap() : (ConcurrentMap) invokeV.objValue;
    }

    @Override // d.f.d.b.c
    public void cleanUp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            delegate().cleanUp();
        }
    }

    @Override // d.f.d.c.h0
    public abstract c<K, V> delegate();

    @Override // d.f.d.c.h0
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // d.f.d.b.c
    public V get(K k, Callable<? extends V> callable) throws ExecutionException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, k, callable)) == null) ? delegate().get(k, callable) : (V) invokeLL.objValue;
    }

    @Override // d.f.d.b.c
    public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iterable)) == null) ? delegate().getAllPresent(iterable) : (ImmutableMap) invokeL.objValue;
    }

    @Override // d.f.d.b.c
    public V getIfPresent(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) ? delegate().getIfPresent(obj) : (V) invokeL.objValue;
    }

    @Override // d.f.d.b.c
    public void invalidate(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            delegate().invalidate(obj);
        }
    }

    @Override // d.f.d.b.c
    public void invalidateAll(Iterable<?> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iterable) == null) {
            delegate().invalidateAll(iterable);
        }
    }

    @Override // d.f.d.b.c
    public void put(K k, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, k, v) == null) {
            delegate().put(k, v);
        }
    }

    @Override // d.f.d.b.c
    public void putAll(Map<? extends K, ? extends V> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, map) == null) {
            delegate().putAll(map);
        }
    }

    @Override // d.f.d.b.c
    public long size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? delegate().size() : invokeV.longValue;
    }

    @Override // d.f.d.b.c
    public d stats() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? delegate().stats() : (d) invokeV.objValue;
    }

    @Override // d.f.d.b.c
    public void invalidateAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            delegate().invalidateAll();
        }
    }
}
