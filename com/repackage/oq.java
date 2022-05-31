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
/* loaded from: classes6.dex */
public final class oq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<mq> a;
    public final Set<Pair<Class<? extends kq>, lq<? extends kq>>> b;
    public TaskInfo c;

    public oq(TaskInfo taskInfo) {
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

    public final Set<mq> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? CollectionsKt___CollectionsKt.toSet(this.a) : (Set) invokeV.objValue;
    }

    public final void b(lq<? extends kq> lqVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lqVar) == null) || lqVar == null) {
            return;
        }
        Iterator<Pair<Class<? extends kq>, lq<? extends kq>>> it = this.b.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getSecond(), lqVar)) {
                it.remove();
            }
        }
    }

    public final void c(mq mqVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mqVar) == null) || mqVar == null) {
            return;
        }
        this.a.add(mqVar);
    }

    public final void d(TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, taskInfo) == null) {
            this.c = taskInfo;
        }
    }

    public final <T extends kq> void e(Class<T> cls, lq<T> lqVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, cls, lqVar) == null) || lqVar == null) {
            return;
        }
        this.b.add(new Pair<>(cls, lqVar));
    }

    public final Set<Pair<Class<? extends kq>, lq<? extends kq>>> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? CollectionsKt___CollectionsKt.toSet(this.b) : (Set) invokeV.objValue;
    }

    public final void g(mq mqVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, mqVar) == null) || mqVar == null) {
            return;
        }
        this.a.remove(mqVar);
    }

    public final TaskInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : (TaskInfo) invokeV.objValue;
    }
}
