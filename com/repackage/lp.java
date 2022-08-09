package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.guide.TaskGuideData;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class lp {
    public static /* synthetic */ Interceptable $ic;
    public static final lp a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964034303, "Lcom/repackage/lp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964034303, "Lcom/repackage/lp;");
                return;
            }
        }
        a = new lp();
    }

    public lp() {
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

    public final void a(int i, TaskInfo taskInfo, TaskStatus taskStatus) {
        iu f;
        au d;
        au d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, taskInfo, taskStatus) == null) {
            zt v = BDPTask.m.v();
            if (v != null && (d2 = v.d()) != null) {
                d2.b(taskInfo.getSingleKey(), vq.c.a());
            }
            zt v2 = BDPTask.m.v();
            if (v2 != null && (d = v2.d()) != null) {
                d.a(taskInfo.getSingleKey());
            }
            String str = TaskGuideData.Companion.c(i) ? "y_task_diyicon" : "y_task_icon";
            String c = ju.a.c(taskStatus);
            zt v3 = BDPTask.m.v();
            if (v3 == null || (f = v3.f()) == null) {
                return;
            }
            f.a(str, "icon_clk", ju.a.a(taskInfo.getId(), taskInfo.getActTaskId(), c));
        }
    }

    public final void b(int i, TaskInfo taskInfo, TaskStatus taskStatus) {
        iu f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, taskInfo, taskStatus) == null) {
            String str = TaskGuideData.Companion.c(i) ? "y_task_diyicon" : "y_task_icon";
            String c = ju.a.c(taskStatus);
            zt v = BDPTask.m.v();
            if (v == null || (f = v.f()) == null) {
                return;
            }
            f.a(str, "close_clk", ju.a.a(taskInfo.getId(), taskInfo.getActTaskId(), c));
        }
    }
}
