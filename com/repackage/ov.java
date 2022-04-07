package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.guide.TaskGuideData;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class ov extends jv<TaskGuideData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final lv a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ov(lv lvVar) {
        super(lvVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lvVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((lv) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = lvVar;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "guide" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jv
    /* renamed from: c */
    public TaskGuideData a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(TaskResponseData.keyUiType);
                jv a = this.a.a("ui");
                String optString = jSONObject.optString("ui");
                Intrinsics.checkExpressionValueIsNotNull(optString, "guide.optString(TaskUIData.key)");
                TaskUIData taskUIData = (TaskUIData) a.a(optString);
                if (taskUIData != null) {
                    return new TaskGuideData(optInt, taskUIData);
                }
                return new TaskGuideData(0, null, 3, null);
            } catch (Exception e) {
                e.printStackTrace();
                return new TaskGuideData(0, null, 3, null);
            }
        }
        return (TaskGuideData) invokeL.objValue;
    }
}
