package com.google.common.base;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.g;
import c.i.d.a.n;
import c.i.d.a.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Set;
/* loaded from: classes2.dex */
public final class Present<T> extends Optional<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final T reference;

    public Present(T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.reference = t;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Collections.singleton(this.reference) : (Set) invokeV.objValue;
    }

    @Override // com.google.common.base.Optional
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof Present) {
                return this.reference.equals(((Present) obj).reference);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.reference : (T) invokeV.objValue;
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.reference.hashCode() + 1502476572 : invokeV.intValue;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.common.base.Optional
    public T or(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, t)) == null) {
            n.q(t, "use Optional.orNull() instead of Optional.or(null)");
            return this.reference;
        }
        return (T) invokeL.objValue;
    }

    @Override // com.google.common.base.Optional
    public T orNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.reference : (T) invokeV.objValue;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "Optional.of(" + this.reference + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: T, ? super T */
    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(g<? super T, V> gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, gVar)) == null) {
            V apply = gVar.apply((T) this.reference);
            n.q(apply, "the Function passed to Optional.transform() must not return null.");
            return new Present(apply);
        }
        return (Optional) invokeL.objValue;
    }

    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> optional) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, optional)) == null) {
            n.p(optional);
            return this;
        }
        return (Optional) invokeL.objValue;
    }

    @Override // com.google.common.base.Optional
    public T or(r<? extends T> rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rVar)) == null) {
            n.p(rVar);
            return this.reference;
        }
        return (T) invokeL.objValue;
    }
}
