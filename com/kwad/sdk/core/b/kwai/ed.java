package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.request.model.TaskStat;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ed implements com.kwad.sdk.core.d<TaskStat> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ed() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(TaskStat taskStat, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, taskStat, jSONObject) == null) || jSONObject == null) {
            return;
        }
        taskStat.adStyle = jSONObject.optInt("adStyle");
        taskStat.taskType = jSONObject.optInt("taskType");
        taskStat.count = jSONObject.optInt("count");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(TaskStat taskStat, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, taskStat, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "adStyle", taskStat.adStyle);
            com.kwad.sdk.utils.t.a(jSONObject, "taskType", taskStat.taskType);
            com.kwad.sdk.utils.t.a(jSONObject, "count", taskStat.count);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
