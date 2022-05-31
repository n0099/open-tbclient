package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class eu {
    public static /* synthetic */ Interceptable $ic;
    public static final eu a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964040875, "Lcom/repackage/eu;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964040875, "Lcom/repackage/eu;");
                return;
            }
        }
        a = new eu();
    }

    public eu() {
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

    public static /* synthetic */ JSONObject b(eu euVar, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        return euVar.a(str, str2, str3);
    }

    public final JSONObject a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("taskId", str);
            jSONObject.put(TaskInfo.keyActTaskId, str2);
            if (str3 != null) {
                jSONObject.put("phase", str3);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public final String c(TaskStatus taskStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskStatus)) == null) ? taskStatus.isFinished() ? "finish" : taskStatus.isRegistered() ? "guide" : "doing" : (String) invokeL.objValue;
    }

    public final String d(TaskStatus taskStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, taskStatus)) == null) ? taskStatus.isUnRegistered() ? "y_task_unregister" : taskStatus.isFinished() ? "y_task_done" : taskStatus.isRegistered() ? "y_task_active" : (taskStatus.isRunning() && taskStatus.isLocalCompleted()) ? "y_task_local_done" : "y_task_start" : (String) invokeL.objValue;
    }
}
