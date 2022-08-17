package com.facebook.common.internal;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
@Nullsafe(Nullsafe.Mode.STRICT)
/* loaded from: classes4.dex */
public class ImmutableSet<E> extends HashSet<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmutableSet(Set<E> set) {
        super(set);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {set};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Collection) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static <E> ImmutableSet<E> copyOf(Set<E> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, set)) == null) ? new ImmutableSet<>(set) : (ImmutableSet) invokeL.objValue;
    }

    public static <E> ImmutableSet<E> of(E... eArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eArr)) == null) {
            HashSet hashSet = new HashSet(eArr.length);
            Collections.addAll(hashSet, eArr);
            return new ImmutableSet<>(hashSet);
        }
        return (ImmutableSet) invokeL.objValue;
    }
}
