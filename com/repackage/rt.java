package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.meter.TaskMeterData;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class rt extends kt<TaskMeterData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final mt a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rt(mt mtVar) {
        super(mtVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mtVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mt) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mtVar;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TaskMeterData.key : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.kt
    /* renamed from: c */
    public TaskMeterData a(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        int optInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                jSONObject = new JSONObject(str);
                optInt = jSONObject.optInt(TaskResponseData.keyUiType);
            } catch (Exception e) {
                e = e;
            }
            try {
                kt a = this.a.a("ui");
                String optString = jSONObject.optString("ui");
                Intrinsics.checkExpressionValueIsNotNull(optString, "guide.optString(TaskUIData.key)");
                TaskUIData taskUIData = (TaskUIData) a.a(optString);
                if (taskUIData == null) {
                    taskUIData = new TaskUIData(null, null, 0, null, null, null, null, null, null, 0, null, null, 4095, null);
                }
                return new TaskMeterData(optInt, taskUIData);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return new TaskMeterData(0, null, 3, null);
            }
        }
        return (TaskMeterData) invokeL.objValue;
    }
}
