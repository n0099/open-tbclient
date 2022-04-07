package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.component.buoy.BuoyComponent;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.component.buoy.TaskBuoyViewModel;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.sr;
import kotlin.ranges.RangesKt___RangesKt;
/* loaded from: classes6.dex */
public class mr extends BuoyComponent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean i;
    public sr j;
    public String k;
    public volatile long l;
    public final nr m;
    public final TaskInfo n;

    /* loaded from: classes6.dex */
    public static final class a extends sr.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mr a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(mr mrVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mrVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mrVar;
        }

        @Override // com.repackage.sr.a, com.repackage.sr
        public void a(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.a.C(j2);
                mr mrVar = this.a;
                mrVar.update(mrVar.n, null);
                sr D = this.a.D();
                if (D != null) {
                    D.a(j, j2);
                }
            }
        }

        @Override // com.repackage.sr.a, com.repackage.sr
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.L(true);
                sr D = this.a.D();
                if (D != null) {
                    D.onCancel();
                }
            }
        }

        @Override // com.repackage.sr.a, com.repackage.sr
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                mr.M(this.a, false, 1, null);
                sr D = this.a.D();
                if (D != null) {
                    D.onFinish();
                }
            }
        }

        @Override // com.repackage.sr.a, com.repackage.sr
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.L(true);
                sr D = this.a.D();
                if (D != null) {
                    D.onPause();
                }
            }
        }

        @Override // com.repackage.sr.a, com.repackage.sr
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                mr.M(this.a, false, 1, null);
                sr D = this.a.D();
                if (D != null) {
                    D.onResume();
                }
            }
        }

        @Override // com.repackage.sr.a, com.repackage.sr
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                mr.M(this.a, false, 1, null);
                sr D = this.a.D();
                if (D != null) {
                    D.onStart();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mr(iu<TaskBuoyViewData, TaskBuoyViewModel> iuVar, nr nrVar, TaskInfo taskInfo) {
        super(iuVar, nrVar, taskInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iuVar, nrVar, taskInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((iu) objArr2[0], (TaskBuoyViewModel) objArr2[1], (TaskInfo) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = nrVar;
        this.n = taskInfo;
        this.i = true;
        this.k = "";
        nrVar.o(new a(this));
    }

    public static /* synthetic */ void M(mr mrVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            mrVar.L(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncVisitTime");
    }

    public final synchronized void C(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            synchronized (this) {
                this.l += j;
            }
        }
    }

    public final sr D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : (sr) invokeV.objValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TaskState m = BDPTask.m.m(this.n.getActionId());
            return m != null && m.getTaskStatus().isEnable() && u();
        }
        return invokeV.booleanValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            G(true);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.i = z;
            this.m.m();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            I("");
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && E()) {
            if (BDPTask.m.l(this.n.getActionId(), str)) {
                BDPTask.m.i(this.n.getActionId(), 0L, str);
                return;
            }
            this.k = str;
            this.i = true;
            this.m.n();
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            K("");
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && E()) {
            if (BDPTask.m.l(this.n.getActionId(), str)) {
                this.m.m();
                BDPTask.m.i(this.n.getActionId(), 0L, str);
                return;
            }
            this.k = str;
            this.i = true;
            L(true);
            this.m.p();
        }
    }

    public final synchronized void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            synchronized (this) {
                if (z) {
                    if (this.l == 0) {
                        return;
                    }
                }
                if (this.i) {
                    long j = this.l;
                    this.l = 0L;
                    BDPTask.m.i(this.n.getActionId(), j, this.k);
                }
            }
        }
    }

    @Override // com.repackage.dr
    public void b(TaskInfo taskInfo, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048586, this, taskInfo, i, str) == null) {
            if (i == 304) {
                update(taskInfo, null);
            } else {
                o(false);
            }
        }
    }

    @Override // com.baidu.bdtask.component.buoy.BuoyComponent
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.i = z;
            super.o(z);
            this.m.q();
        }
    }

    @Override // com.baidu.bdtask.component.buoy.BuoyComponent
    public float q(TaskInfo taskInfo, TaskStatus taskStatus) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, taskInfo, taskStatus)) == null) {
            if (taskInfo.isVisitAction()) {
                long stay = taskInfo.getTaskRule().getStay();
                if (stay == 0) {
                    return 0.0f;
                }
                return RangesKt___RangesKt.coerceAtMost(((float) (taskStatus.getProcess().getStayDurTimeMs() + this.l)) / ((float) stay), 1.0f);
            }
            return 0.0f;
        }
        return invokeLL.floatValue;
    }

    @Override // com.baidu.bdtask.component.buoy.BuoyComponent
    public long r(TaskInfo taskInfo, TaskStatus taskStatus) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, taskInfo, taskStatus)) == null) {
            if (taskInfo.isVisitAction()) {
                return taskInfo.getTaskRule().getFormatStay();
            }
            return 0L;
        }
        return invokeLL.longValue;
    }

    @Override // com.baidu.bdtask.component.buoy.BuoyComponent
    public float s(TaskInfo taskInfo, TaskStatus taskStatus) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, taskInfo, taskStatus)) == null) {
            return 1.0f;
        }
        return invokeLL.floatValue;
    }

    @Override // com.baidu.bdtask.component.buoy.BuoyComponent
    public boolean t(TaskStatus taskStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, taskStatus)) == null) ? taskStatus.isDuplicated() : invokeL.booleanValue;
    }

    @Override // com.baidu.bdtask.component.buoy.BuoyComponent
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.m.m();
        }
    }
}
