package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableSortedMap;
/* loaded from: classes6.dex */
public abstract class ImmutableSortedMapFauxverideShim<K, V> extends ImmutableMap<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ImmutableSortedMapFauxverideShim() {
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

    @Deprecated
    public static <K, V> ImmutableSortedMap.b<K, V> builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedMap.b) invokeV.objValue;
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap.b<K, V> builderWithExpectedSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedMap.b) invokeI.objValue;
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, k, v)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedMap) invokeLL.objValue;
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, k, v, k2, v2)) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedMap) invokeLLLL.objValue;
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{k, v, k2, v2, k3, v3})) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedMap) invokeCommon.objValue;
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{k, v, k2, v2, k3, v3, k4, v4})) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedMap) invokeCommon.objValue;
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5})) == null) {
            throw new UnsupportedOperationException();
        }
        return (ImmutableSortedMap) invokeCommon.objValue;
    }
}
