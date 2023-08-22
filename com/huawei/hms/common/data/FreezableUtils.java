package com.huawei.hms.common.data;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes10.dex */
public final class FreezableUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FreezableUtils() {
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

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, arrayList)) == null) {
            return freezeIterable(arrayList);
        }
        return (ArrayList) invokeL.objValue;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eArr)) == null) {
            return freezeIterable(Arrays.asList(eArr));
        }
        return (ArrayList) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.ArrayList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            ArrayList<T> arrayList = (ArrayList<T>) new ArrayList();
            for (E e : iterable) {
                arrayList.add(e.freeze());
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }
}
