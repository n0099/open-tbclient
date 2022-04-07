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
public final class fr {
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
        public final mr a(iu<TaskBuoyViewData, TaskBuoyViewModel> iuVar, nr nrVar, TaskInfo taskInfo) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, iuVar, nrVar, taskInfo)) == null) ? new mr(iuVar, nrVar, taskInfo) : (mr) invokeLLL.objValue;
        }

        @JvmStatic
        public final pr b(iu<TaskBuoyViewData, TaskBuoyViewModel> iuVar, TaskBuoyViewModel taskBuoyViewModel, TaskInfo taskInfo) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iuVar, taskBuoyViewModel, taskInfo)) == null) ? new pr(iuVar, taskBuoyViewModel, taskInfo) : (pr) invokeLLL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964040007, "Lcom/repackage/fr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964040007, "Lcom/repackage/fr;");
                return;
            }
        }
        a = new a(null);
    }

    @JvmStatic
    public static final mr a(iu<TaskBuoyViewData, TaskBuoyViewModel> iuVar, nr nrVar, TaskInfo taskInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, iuVar, nrVar, taskInfo)) == null) ? a.a(iuVar, nrVar, taskInfo) : (mr) invokeLLL.objValue;
    }

    @JvmStatic
    public static final pr b(iu<TaskBuoyViewData, TaskBuoyViewModel> iuVar, TaskBuoyViewModel taskBuoyViewModel, TaskInfo taskInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, iuVar, taskBuoyViewModel, taskInfo)) == null) ? a.b(iuVar, taskBuoyViewModel, taskInfo) : (pr) invokeLLL.objValue;
    }
}
