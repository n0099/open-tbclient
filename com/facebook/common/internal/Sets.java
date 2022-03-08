package com.facebook.common.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes7.dex */
public final class Sets {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Sets() {
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

    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new CopyOnWriteArraySet<>() : (CopyOnWriteArraySet) invokeV.objValue;
    }

    public static <E> HashSet<E> newHashSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new HashSet<>() : (HashSet) invokeV.objValue;
    }

    public static <E> HashSet<E> newHashSetWithCapacity(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i2)) == null) ? new HashSet<>(i2) : (HashSet) invokeI.objValue;
    }

    public static <E> Set<E> newIdentityHashSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? newSetFromMap(new IdentityHashMap()) : (Set) invokeV.objValue;
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new LinkedHashSet<>() : (LinkedHashSet) invokeV.objValue;
    }

    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, map)) == null) ? Collections.newSetFromMap(map) : (Set) invokeL.objValue;
    }

    public static <E> HashSet<E> newHashSet(E... eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, eArr)) == null) {
            HashSet<E> newHashSetWithCapacity = newHashSetWithCapacity(eArr.length);
            Collections.addAll(newHashSetWithCapacity, eArr);
            return newHashSetWithCapacity;
        }
        return (HashSet) invokeL.objValue;
    }

    public static <E> HashSet<E> newHashSet(Iterable<? extends E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) ? iterable instanceof Collection ? new HashSet<>((Collection) iterable) : newHashSet(iterable.iterator()) : (HashSet) invokeL.objValue;
    }

    public static <E> HashSet<E> newHashSet(Iterator<? extends E> it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, it)) == null) {
            HashSet<E> newHashSet = newHashSet();
            while (it.hasNext()) {
                newHashSet.add(it.next());
            }
            return newHashSet;
        }
        return (HashSet) invokeL.objValue;
    }
}
