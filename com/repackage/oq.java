package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.component.buoy.TaskBuoyViewModel;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes6.dex */
public final class oq {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @JvmStatic
        public final vq a(rt<TaskBuoyViewData, TaskBuoyViewModel> rtVar, wq wqVar, TaskInfo taskInfo) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, rtVar, wqVar, taskInfo)) == null) ? new vq(rtVar, wqVar, taskInfo) : (vq) invokeLLL.objValue;
        }

        @JvmStatic
        public final yq b(rt<TaskBuoyViewData, TaskBuoyViewModel> rtVar, TaskBuoyViewModel taskBuoyViewModel, TaskInfo taskInfo) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rtVar, taskBuoyViewModel, taskInfo)) == null) ? new yq(rtVar, taskBuoyViewModel, taskInfo) : (yq) invokeLLL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964031389, "Lcom/repackage/oq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964031389, "Lcom/repackage/oq;");
                return;
            }
        }
        a = new a(null);
    }

    @JvmStatic
    public static final vq a(rt<TaskBuoyViewData, TaskBuoyViewModel> rtVar, wq wqVar, TaskInfo taskInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, rtVar, wqVar, taskInfo)) == null) ? a.a(rtVar, wqVar, taskInfo) : (vq) invokeLLL.objValue;
    }

    @JvmStatic
    public static final yq b(rt<TaskBuoyViewData, TaskBuoyViewModel> rtVar, TaskBuoyViewModel taskBuoyViewModel, TaskInfo taskInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, rtVar, taskBuoyViewModel, taskInfo)) == null) ? a.b(rtVar, taskBuoyViewModel, taskInfo) : (yq) invokeLLL.objValue;
    }
}
