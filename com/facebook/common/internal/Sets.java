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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static CopyOnWriteArraySet newCopyOnWriteArraySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new CopyOnWriteArraySet();
        }
        return (CopyOnWriteArraySet) invokeV.objValue;
    }

    public static HashSet newHashSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new HashSet();
        }
        return (HashSet) invokeV.objValue;
    }

    public static Set newIdentityHashSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return newSetFromMap(new IdentityHashMap());
        }
        return (Set) invokeV.objValue;
    }

    public static LinkedHashSet newLinkedHashSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return new LinkedHashSet();
        }
        return (LinkedHashSet) invokeV.objValue;
    }

    public static HashSet newHashSet(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            if (iterable instanceof Collection) {
                return new HashSet((Collection) iterable);
            }
            return newHashSet(iterable.iterator());
        }
        return (HashSet) invokeL.objValue;
    }

    public static HashSet newHashSetWithCapacity(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            return new HashSet(i);
        }
        return (HashSet) invokeI.objValue;
    }

    public static Set newSetFromMap(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, map)) == null) {
            return Collections.newSetFromMap(map);
        }
        return (Set) invokeL.objValue;
    }

    public static HashSet newHashSet(Iterator it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, it)) == null) {
            HashSet newHashSet = newHashSet();
            while (it.hasNext()) {
                newHashSet.add(it.next());
            }
            return newHashSet;
        }
        return (HashSet) invokeL.objValue;
    }

    public static HashSet newHashSet(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, objArr)) == null) {
            HashSet newHashSetWithCapacity = newHashSetWithCapacity(objArr.length);
            Collections.addAll(newHashSetWithCapacity, objArr);
            return newHashSetWithCapacity;
        }
        return (HashSet) invokeL.objValue;
    }
}
