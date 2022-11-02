package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
@KeepForSdk
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

    @KeepForSdk
    public static boolean isEmpty(@Nullable Collection<?> collection) {
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

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return Collections.singletonList(t);
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    @KeepForSdk
    public static <T> Set<T> mutableSetOfWithSize(int i) {
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

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return Collections.emptyList();
        }
        return (List) invokeV.objValue;
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(@NonNull T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tArr)) == null) {
            int length = tArr.length;
            if (length != 0) {
                if (length != 1) {
                    return Collections.unmodifiableList(Arrays.asList(tArr));
                }
                return listOf(tArr[0]);
            }
            return listOf();
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(@NonNull K k, @NonNull V v, @NonNull K k2, @NonNull V v2, @NonNull K k3, @NonNull V v3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{k, v, k2, v2, k3, v3})) == null) {
            Map zza = zza(3, false);
            zza.put(k, v);
            zza.put(k2, v2);
            zza.put(k3, v3);
            return Collections.unmodifiableMap(zza);
        }
        return (Map) invokeCommon.objValue;
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(@NonNull K k, @NonNull V v, @NonNull K k2, @NonNull V v2, @NonNull K k3, @NonNull V v3, @NonNull K k4, @NonNull V v4, @NonNull K k5, @NonNull V v5, @NonNull K k6, @NonNull V v6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6})) == null) {
            Map zza = zza(6, false);
            zza.put(k, v);
            zza.put(k2, v2);
            zza.put(k3, v3);
            zza.put(k4, v4);
            zza.put(k5, v5);
            zza.put(k6, v6);
            return Collections.unmodifiableMap(zza);
        }
        return (Map) invokeCommon.objValue;
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOfKeyValueArrays(@NonNull K[] kArr, @NonNull V[] vArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, kArr, vArr)) == null) {
            int length = kArr.length;
            int length2 = vArr.length;
            if (length == length2) {
                if (length != 0) {
                    if (length != 1) {
                        Map zza = zza(length, false);
                        for (int i = 0; i < kArr.length; i++) {
                            zza.put(kArr[i], vArr[i]);
                        }
                        return Collections.unmodifiableMap(zza);
                    }
                    return Collections.singletonMap(kArr[0], vArr[0]);
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

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(@NonNull T t, @NonNull T t2, @NonNull T t3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, t, t2, t3)) == null) {
            Set zzb = zzb(3, false);
            zzb.add(t);
            zzb.add(t2);
            zzb.add(t3);
            return Collections.unmodifiableSet(zzb);
        }
        return (Set) invokeLLL.objValue;
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(@NonNull T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tArr)) == null) {
            int length = tArr.length;
            if (length != 0) {
                if (length != 1) {
                    if (length != 2) {
                        if (length != 3) {
                            if (length != 4) {
                                Set zzb = zzb(length, false);
                                Collections.addAll(zzb, tArr);
                                return Collections.unmodifiableSet(zzb);
                            }
                            T t = tArr[0];
                            T t2 = tArr[1];
                            T t3 = tArr[2];
                            T t4 = tArr[3];
                            Set zzb2 = zzb(4, false);
                            zzb2.add(t);
                            zzb2.add(t2);
                            zzb2.add(t3);
                            zzb2.add(t4);
                            return Collections.unmodifiableSet(zzb2);
                        }
                        return setOf(tArr[0], tArr[1], tArr[2]);
                    }
                    T t5 = tArr[0];
                    T t6 = tArr[1];
                    Set zzb3 = zzb(2, false);
                    zzb3.add(t5);
                    zzb3.add(t6);
                    return Collections.unmodifiableSet(zzb3);
                }
                return Collections.singleton(tArr[0]);
            }
            return Collections.emptySet();
        }
        return (Set) invokeL.objValue;
    }

    public static <K, V> Map<K, V> zza(int i, boolean z) {
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

    public static <T> Set<T> zzb(int i, boolean z) {
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
