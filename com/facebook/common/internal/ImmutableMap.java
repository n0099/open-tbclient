package com.facebook.common.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class ImmutableMap extends HashMap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmutableMap(Map map) {
        super(map);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Map) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static ImmutableMap copyOf(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, map)) == null) {
            return new ImmutableMap(map);
        }
        return (ImmutableMap) invokeL.objValue;
    }

    public static Map of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return Collections.unmodifiableMap(new HashMap());
        }
        return (Map) invokeV.objValue;
    }

    public static Map of(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, obj, obj2)) == null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put(obj, obj2);
            return Collections.unmodifiableMap(hashMap);
        }
        return (Map) invokeLL.objValue;
    }

    public static Map of(Object obj, Object obj2, Object obj3, Object obj4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, obj2, obj3, obj4)) == null) {
            HashMap hashMap = new HashMap(2);
            hashMap.put(obj, obj2);
            hashMap.put(obj3, obj4);
            return Collections.unmodifiableMap(hashMap);
        }
        return (Map) invokeLLLL.objValue;
    }

    public static Map of(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{obj, obj2, obj3, obj4, obj5, obj6})) == null) {
            HashMap hashMap = new HashMap(3);
            hashMap.put(obj, obj2);
            hashMap.put(obj3, obj4);
            hashMap.put(obj5, obj6);
            return Collections.unmodifiableMap(hashMap);
        }
        return (Map) invokeCommon.objValue;
    }

    public static Map of(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8})) == null) {
            HashMap hashMap = new HashMap(4);
            hashMap.put(obj, obj2);
            hashMap.put(obj3, obj4);
            hashMap.put(obj5, obj6);
            hashMap.put(obj7, obj8);
            return Collections.unmodifiableMap(hashMap);
        }
        return (Map) invokeCommon.objValue;
    }

    public static Map of(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10})) == null) {
            HashMap hashMap = new HashMap(5);
            hashMap.put(obj, obj2);
            hashMap.put(obj3, obj4);
            hashMap.put(obj5, obj6);
            hashMap.put(obj7, obj8);
            hashMap.put(obj9, obj10);
            return Collections.unmodifiableMap(hashMap);
        }
        return (Map) invokeCommon.objValue;
    }

    public static Map of(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12})) == null) {
            HashMap hashMap = new HashMap(6);
            hashMap.put(obj, obj2);
            hashMap.put(obj3, obj4);
            hashMap.put(obj5, obj6);
            hashMap.put(obj7, obj8);
            hashMap.put(obj9, obj10);
            hashMap.put(obj11, obj12);
            return Collections.unmodifiableMap(hashMap);
        }
        return (Map) invokeCommon.objValue;
    }
}
