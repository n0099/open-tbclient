package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.wv;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes7.dex */
public final class vv implements wv {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    public transient /* synthetic */ FieldHolder $fh;
    public final xv a;
    public final com.baidu.bdtask.strategy.e b;

    /* loaded from: classes7.dex */
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

        public final vv a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new vv(null) : (vv) invokeV.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964024507, "Lcom/repackage/vv;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964024507, "Lcom/repackage/vv;");
                return;
            }
        }
        c = new a(null);
    }

    public vv() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new xv();
        this.b = new com.baidu.bdtask.strategy.e();
    }

    @Override // com.repackage.wv
    public void a(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subTaskState) == null) {
            wv.a.c(this, subTaskState);
            if (subTaskState.getTaskInfo().isInitiActiveTask()) {
                this.a.a(subTaskState);
            } else if (subTaskState.getTaskInfo().isPassiveTask()) {
                this.b.a(subTaskState);
            }
        }
    }

    @Override // com.repackage.wv
    public boolean b(TaskInfo taskInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskInfo, i)) == null) {
            if (taskInfo.isInitiActiveTask()) {
                return this.a.b(taskInfo, i);
            }
            if (taskInfo.isPassiveTask()) {
                return this.b.b(taskInfo, i);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void c(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, subTaskState) == null) {
            if (subTaskState.getTaskInfo().isInitiActiveTask()) {
                this.a.c(subTaskState);
            } else if (subTaskState.getTaskInfo().isPassiveTask()) {
                this.b.c(subTaskState);
            }
        }
    }

    public /* synthetic */ vv(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
