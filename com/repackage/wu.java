package com.repackage;

import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class wu {
    public static /* synthetic */ Interceptable $ic;
    public static final wu a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964023577, "Lcom/repackage/wu;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964023577, "Lcom/repackage/wu;");
                return;
            }
        }
        a = new wu();
    }

    public wu() {
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

    public final vu a(TaskStatus taskStatus, TaskInfo taskInfo) {
        InterceptResult invokeLL;
        int i;
        TaskUIData taskUIData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, taskStatus, taskInfo)) == null) {
            if (taskStatus.isFinished()) {
                taskUIData = taskInfo.getResponse().getUi();
                i = taskInfo.getResponse().getUiType();
            } else if (taskStatus.isRunning()) {
                taskUIData = taskInfo.getTaskMeter().getUi();
                i = taskInfo.getTaskMeter().getUiType();
            } else if (taskStatus.isInited() || taskStatus.isRegistered()) {
                taskUIData = taskInfo.getTaskGuide().getUi();
                i = taskInfo.getTaskGuide().getUiType();
            } else {
                i = -1;
                taskUIData = null;
            }
            return new vu(i, taskUIData);
        }
        return (vu) invokeLL.objValue;
    }
}
