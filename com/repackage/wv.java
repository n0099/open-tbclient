package com.repackage;

import androidx.annotation.CallSuper;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public interface wv {

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(wv wvVar, SubTaskState subTaskState) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, wvVar, subTaskState) == null) || wvVar.b(subTaskState.getTaskInfo(), subTaskState.getTaskStatus().getCurStatusCode())) {
                return;
            }
            wvVar.a(subTaskState);
        }

        public static boolean b(wv wvVar, TaskInfo taskInfo, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, wvVar, taskInfo, i)) == null) ? i == 304 : invokeLLI.booleanValue;
        }

        @CallSuper
        public static void c(wv wvVar, SubTaskState subTaskState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, wvVar, subTaskState) == null) {
                zv.c.b(subTaskState);
            }
        }
    }

    @CallSuper
    void a(SubTaskState subTaskState);

    boolean b(TaskInfo taskInfo, int i);
}
