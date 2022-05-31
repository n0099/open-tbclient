package com.repackage;

import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.utils.UniqueId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class nq {
    public static /* synthetic */ Interceptable $ic;
    public static final nq a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964032350, "Lcom/repackage/nq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964032350, "Lcom/repackage/nq;");
                return;
            }
        }
        a = new nq();
    }

    public nq() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final kq a(TaskInfo taskInfo, UniqueId uniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, taskInfo, uniqueId)) == null) {
            if (Intrinsics.areEqual(uniqueId, pq.c.a())) {
                return new pq(taskInfo);
            }
            if (Intrinsics.areEqual(uniqueId, qq.c.a())) {
                return new qq(taskInfo);
            }
            if (Intrinsics.areEqual(uniqueId, rq.c.a())) {
                return new rq(taskInfo);
            }
            return null;
        }
        return (kq) invokeLL.objValue;
    }
}
