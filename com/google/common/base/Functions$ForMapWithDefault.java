package com.google.common.base;

import b.i.d.a.g;
import b.i.d.a.k;
import b.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes2.dex */
public class Functions$ForMapWithDefault<K, V> implements g<K, V>, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final V defaultValue;
    public final Map<K, ? extends V> map;

    public Functions$ForMapWithDefault(Map<K, ? extends V> map, V v) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, v};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.p(map);
        this.map = map;
        this.defaultValue = v;
    }

    @Override // b.i.d.a.g
    public V apply(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) {
            V v = this.map.get(k);
            return (v != null || this.map.containsKey(k)) ? v : this.defaultValue;
        }
        return (V) invokeL.objValue;
    }

    @Override // b.i.d.a.g
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof Functions$ForMapWithDefault) {
                Functions$ForMapWithDefault functions$ForMapWithDefault = (Functions$ForMapWithDefault) obj;
                return this.map.equals(functions$ForMapWithDefault.map) && k.a(this.defaultValue, functions$ForMapWithDefault.defaultValue);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k.b(this.map, this.defaultValue) : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "Functions.forMap(" + this.map + ", defaultValue=" + this.defaultValue + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
