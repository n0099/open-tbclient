package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.component.buoy.TaskBuoyViewModel;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class wq extends TaskBuoyViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int g;
    public cr h;
    public final long i;
    public br j;

    /* loaded from: classes7.dex */
    public static final class a implements br {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wq a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(wq wqVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wqVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wqVar;
        }

        @Override // com.repackage.br
        public void a(long j, long j2) {
            br h;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (h = this.a.h()) == null) {
                return;
            }
            h.a(j, j2);
        }

        @Override // com.repackage.br
        public void onCancel() {
            br h;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (h = this.a.h()) == null) {
                return;
            }
            h.onCancel();
        }

        @Override // com.repackage.br
        public void onFinish() {
            br h;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (h = this.a.h()) == null) {
                return;
            }
            h.onFinish();
        }

        @Override // com.repackage.br
        public void onPause() {
            br h;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (h = this.a.h()) == null) {
                return;
            }
            h.onPause();
        }

        @Override // com.repackage.br
        public void onResume() {
            br h;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (h = this.a.h()) == null) {
                return;
            }
            h.onResume();
        }

        @Override // com.repackage.br
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.a.k()) {
                    br h = this.a.h();
                    if (h != null) {
                        h.onResume();
                        return;
                    }
                    return;
                }
                br h2 = this.a.h();
                if (h2 != null) {
                    h2.onStart();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964023701, "Lcom/repackage/wq;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964023701, "Lcom/repackage/wq;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wq(TaskInfo taskInfo) {
        super(taskInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TaskInfo) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = 8;
        this.i = taskInfo.getTaskRule().getStay();
    }

    public final br h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (br) invokeV.objValue;
    }

    public final long i() {
        InterceptResult invokeV;
        TaskStatus taskStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TaskState m = BDPTask.m.m(c().getActionId());
            TaskProcess process = (m == null || (taskStatus = m.getTaskStatus()) == null) ? null : taskStatus.getProcess();
            long stayDurTimeMs = this.i - (process != null ? process.getStayDurTimeMs() : 0L);
            if (stayDurTimeMs < 0) {
                return 0L;
            }
            return stayDurTimeMs;
        }
        return invokeV.longValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.g & 4) == 4 : invokeV.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.g & 2) == 2 : invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (this.g & 1) == 1 : invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && l()) {
            this.g |= 4;
            cr crVar = this.h;
            if (crVar != null) {
                crVar.e();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && j()) {
            this.g |= 2;
            r();
        }
    }

    public final void o(br brVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, brVar) == null) {
            this.j = brVar;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.g = 1;
            r();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.g = 8;
            cr crVar = this.h;
            if (crVar != null) {
                crVar.h();
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            cr crVar = this.h;
            if (crVar != null) {
                crVar.j();
            }
            cr crVar2 = new cr(i(), 200L, new a(this));
            this.h = crVar2;
            if (crVar2 != null) {
                crVar2.b();
            }
        }
    }
}
