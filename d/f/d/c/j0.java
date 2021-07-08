package d.f.d.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;
/* loaded from: classes8.dex */
public abstract class j0<E> extends y<E> implements Set<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j0() {
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

    @Override // d.f.d.c.y, d.f.d.c.h0
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // d.f.d.c.y, d.f.d.c.h0
    public abstract /* bridge */ /* synthetic */ Collection delegate();

    @Override // d.f.d.c.y, d.f.d.c.h0
    public abstract Set<E> delegate();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? obj == this || delegate().equals(obj) : invokeL.booleanValue;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? delegate().hashCode() : invokeV.intValue;
    }

    public boolean standardEquals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? Sets.a(this, obj) : invokeL.booleanValue;
    }

    public int standardHashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Sets.d(this) : invokeV.intValue;
    }

    @Override // d.f.d.c.y
    public boolean standardRemoveAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, collection)) == null) {
            d.f.d.a.n.p(collection);
            return Sets.k(this, collection);
        }
        return invokeL.booleanValue;
    }
}
