package com.facebook.common.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
@Nullsafe(Nullsafe.Mode.STRICT)
/* loaded from: classes11.dex */
public class ImmutableMap<K, V> extends HashMap<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmutableMap(Map<? extends K, ? extends V> map) {
        super(map);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Map) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, map)) == null) ? new ImmutableMap<>(map) : (ImmutableMap) invokeL.objValue;
    }

    public static <K, V> Map<K, V> of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Collections.unmodifiableMap(new HashMap()) : (Map) invokeV.objValue;
    }

    public static <K, V> Map<K, V> of(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, k, v)) == null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put(k, v);
            return Collections.unmodifiableMap(hashMap);
        }
        return (Map) invokeLL.objValue;
    }

    public static <K, V> Map<K, V> of(K k, V v, K k2, V v2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, k, v, k2, v2)) == null) {
            HashMap hashMap = new HashMap(2);
            hashMap.put(k, v);
            hashMap.put(k2, v2);
            return Collections.unmodifiableMap(hashMap);
        }
        return (Map) invokeLLLL.objValue;
    }

    public static <K, V> Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{k, v, k2, v2, k3, v3})) == null) {
            HashMap hashMap = new HashMap(3);
            hashMap.put(k, v);
            hashMap.put(k2, v2);
            hashMap.put(k3, v3);
            return Collections.unmodifiableMap(hashMap);
        }
        return (Map) invokeCommon.objValue;
    }

    public static <K, V> Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{k, v, k2, v2, k3, v3, k4, v4})) == null) {
            HashMap hashMap = new HashMap(4);
            hashMap.put(k, v);
            hashMap.put(k2, v2);
            hashMap.put(k3, v3);
            hashMap.put(k4, v4);
            return Collections.unmodifiableMap(hashMap);
        }
        return (Map) invokeCommon.objValue;
    }

    public static <K, V> Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5})) == null) {
            HashMap hashMap = new HashMap(5);
            hashMap.put(k, v);
            hashMap.put(k2, v2);
            hashMap.put(k3, v3);
            hashMap.put(k4, v4);
            hashMap.put(k5, v5);
            return Collections.unmodifiableMap(hashMap);
        }
        return (Map) invokeCommon.objValue;
    }

    public static <K, V> Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6})) == null) {
            HashMap hashMap = new HashMap(6);
            hashMap.put(k, v);
            hashMap.put(k2, v2);
            hashMap.put(k3, v3);
            hashMap.put(k4, v4);
            hashMap.put(k5, v5);
            hashMap.put(k6, v6);
            return Collections.unmodifiableMap(hashMap);
        }
        return (Map) invokeCommon.objValue;
    }
}
