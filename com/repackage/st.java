package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.rule.TaskRuleData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class st extends jt<TaskRuleData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public st(lt ltVar) {
        super(ltVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ltVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((lt) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "rule" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jt
    /* renamed from: c */
    public TaskRuleData a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String version = jSONObject.optString("ver");
                String upgrade = jSONObject.optString("url");
                long optLong = jSONObject.optLong("expire");
                int optInt = jSONObject.optInt("stay", Integer.MAX_VALUE);
                int optInt2 = jSONObject.optInt("repeat", Integer.MAX_VALUE);
                boolean optBoolean = jSONObject.optBoolean(TaskRuleData.keyUniq);
                boolean optBoolean2 = jSONObject.optBoolean(TaskRuleData.keyPersist);
                int optInt3 = jSONObject.optInt(TaskRuleData.keyNoClickTimes, -1);
                boolean optBoolean3 = jSONObject.optBoolean("auto", true);
                int optInt4 = jSONObject.optInt(TaskRuleData.keyPersistOnFail, 0);
                Intrinsics.checkExpressionValueIsNotNull(version, "version");
                Intrinsics.checkExpressionValueIsNotNull(upgrade, "upgrade");
                return new TaskRuleData(version, upgrade, optLong, optInt, optInt2, optBoolean, optBoolean2, optBoolean3, optInt3, optInt4);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (TaskRuleData) invokeL.objValue;
    }
}
