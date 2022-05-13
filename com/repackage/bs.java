package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class bs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<zr> a;
    public final Set<Pair<Class<? extends xr>, yr<? extends xr>>> b;
    public TaskInfo c;

    public bs(TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = taskInfo;
        this.a = new HashSet();
        this.b = new HashSet();
    }

    public final Set<zr> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? CollectionsKt___CollectionsKt.toSet(this.a) : (Set) invokeV.objValue;
    }

    public final void b(yr<? extends xr> yrVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yrVar) == null) || yrVar == null) {
            return;
        }
        Iterator<Pair<Class<? extends xr>, yr<? extends xr>>> it = this.b.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getSecond(), yrVar)) {
                it.remove();
            }
        }
    }

    public final void c(zr zrVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zrVar) == null) || zrVar == null) {
            return;
        }
        this.a.add(zrVar);
    }

    public final void d(TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, taskInfo) == null) {
            this.c = taskInfo;
        }
    }

    public final <T extends xr> void e(Class<T> cls, yr<T> yrVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, cls, yrVar) == null) || yrVar == null) {
            return;
        }
        this.b.add(new Pair<>(cls, yrVar));
    }

    public final Set<Pair<Class<? extends xr>, yr<? extends xr>>> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? CollectionsKt___CollectionsKt.toSet(this.b) : (Set) invokeV.objValue;
    }

    public final void g(zr zrVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, zrVar) == null) || zrVar == null) {
            return;
        }
        this.a.remove(zrVar);
    }

    public final TaskInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : (TaskInfo) invokeV.objValue;
    }
}
