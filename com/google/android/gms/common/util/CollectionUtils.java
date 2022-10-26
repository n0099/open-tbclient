package com.google.android.gms.common.util;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public final class CollectionUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CollectionUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean isEmpty(Collection collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, collection)) == null) {
            if (collection == null) {
                return true;
            }
            return collection.isEmpty();
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static List listOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            return Collections.singletonList(obj);
        }
        return (List) invokeL.objValue;
    }

    public static Set mutableSetOfWithSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            if (i == 0) {
                return new ArraySet();
            }
            return zzb(i, true);
        }
        return (Set) invokeI.objValue;
    }

    @Deprecated
    public static List listOf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return Collections.emptyList();
        }
        return (List) invokeV.objValue;
    }

    @Deprecated
    public static List listOf(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, objArr)) == null) {
            int length = objArr.length;
            if (length != 0) {
                if (length != 1) {
                    return Collections.unmodifiableList(Arrays.asList(objArr));
                }
                return listOf(objArr[0]);
            }
            return listOf();
        }
        return (List) invokeL.objValue;
    }

    public static Map mapOf(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{obj, obj2, obj3, obj4, obj5, obj6})) == null) {
            Map zza = zza(3, false);
            zza.put(obj, obj2);
            zza.put(obj3, obj4);
            zza.put(obj5, obj6);
            return Collections.unmodifiableMap(zza);
        }
        return (Map) invokeCommon.objValue;
    }

    public static Map mapOf(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12})) == null) {
            Map zza = zza(6, false);
            zza.put(obj, obj2);
            zza.put(obj3, obj4);
            zza.put(obj5, obj6);
            zza.put(obj7, obj8);
            zza.put(obj9, obj10);
            zza.put(obj11, obj12);
            return Collections.unmodifiableMap(zza);
        }
        return (Map) invokeCommon.objValue;
    }

    public static Map mapOfKeyValueArrays(Object[] objArr, Object[] objArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, objArr, objArr2)) == null) {
            int length = objArr.length;
            int length2 = objArr2.length;
            if (length == length2) {
                if (length != 0) {
                    if (length != 1) {
                        Map zza = zza(length, false);
                        for (int i = 0; i < objArr.length; i++) {
                            zza.put(objArr[i], objArr2[i]);
                        }
                        return Collections.unmodifiableMap(zza);
                    }
                    return Collections.singletonMap(objArr[0], objArr2[0]);
                }
                return Collections.emptyMap();
            }
            StringBuilder sb = new StringBuilder(66);
            sb.append("Key and values array lengths not equal: ");
            sb.append(length);
            sb.append(" != ");
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
        return (Map) invokeLL.objValue;
    }

    @Deprecated
    public static Set setOf(Object obj, Object obj2, Object obj3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, obj, obj2, obj3)) == null) {
            Set zzb = zzb(3, false);
            zzb.add(obj);
            zzb.add(obj2);
            zzb.add(obj3);
            return Collections.unmodifiableSet(zzb);
        }
        return (Set) invokeLLL.objValue;
    }

    @Deprecated
    public static Set setOf(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, objArr)) == null) {
            int length = objArr.length;
            if (length != 0) {
                if (length != 1) {
                    if (length != 2) {
                        if (length != 3) {
                            if (length != 4) {
                                Set zzb = zzb(length, false);
                                Collections.addAll(zzb, objArr);
                                return Collections.unmodifiableSet(zzb);
                            }
                            Object obj = objArr[0];
                            Object obj2 = objArr[1];
                            Object obj3 = objArr[2];
                            Object obj4 = objArr[3];
                            Set zzb2 = zzb(4, false);
                            zzb2.add(obj);
                            zzb2.add(obj2);
                            zzb2.add(obj3);
                            zzb2.add(obj4);
                            return Collections.unmodifiableSet(zzb2);
                        }
                        return setOf(objArr[0], objArr[1], objArr[2]);
                    }
                    Object obj5 = objArr[0];
                    Object obj6 = objArr[1];
                    Set zzb3 = zzb(2, false);
                    zzb3.add(obj5);
                    zzb3.add(obj6);
                    return Collections.unmodifiableSet(zzb3);
                }
                return Collections.singleton(objArr[0]);
            }
            return Collections.emptySet();
        }
        return (Set) invokeL.objValue;
    }

    public static Map zza(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i <= 256) {
                return new ArrayMap(i);
            }
            return new HashMap(i, 1.0f);
        }
        return (Map) invokeCommon.objValue;
    }

    public static Set zzb(int i, boolean z) {
        InterceptResult invokeCommon;
        float f;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (true != z) {
                f = 1.0f;
            } else {
                f = 0.75f;
            }
            if (true != z) {
                i2 = 256;
            } else {
                i2 = 128;
            }
            if (i <= i2) {
                return new ArraySet(i);
            }
            return new HashSet(i, f);
        }
        return (Set) invokeCommon.objValue;
    }
}
