package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ui.TaskUIBtn;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.bdtask.model.ui.TaskUIProgress;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class cv extends su<TaskUIData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cv(uu uuVar) {
        super(uuVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uuVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((uu) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final TaskUIProgress b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new TaskUIProgress(null, null, 3, null);
            }
            String optString = jSONObject.optString(TaskUIData.keyForeColor);
            Intrinsics.checkExpressionValueIsNotNull(optString, "raw.optString(keyForeColor)");
            String optString2 = jSONObject.optString(TaskUIData.keyBackColor);
            Intrinsics.checkExpressionValueIsNotNull(optString2, "raw.optString(keyBackColor)");
            return new TaskUIProgress(optString, optString2);
        }
        return (TaskUIProgress) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "ui" : (String) invokeV.objValue;
    }

    public final TaskUIBtn d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new TaskUIBtn(null, null, null, null, null, 31, null);
            }
            String optString = jSONObject.optString("txt");
            Intrinsics.checkExpressionValueIsNotNull(optString, "raw.optString(keyTxt)");
            String optString2 = jSONObject.optString("color");
            Intrinsics.checkExpressionValueIsNotNull(optString2, "raw.optString(keyColor)");
            String optString3 = jSONObject.optString(TaskUIData.keyBgUrl);
            Intrinsics.checkExpressionValueIsNotNull(optString3, "raw.optString(keyBgUrl)");
            String optString4 = jSONObject.optString(TaskUIData.keyTxtColor);
            Intrinsics.checkExpressionValueIsNotNull(optString4, "raw.optString(keyTxtColor)");
            String optString5 = jSONObject.optString("schema");
            Intrinsics.checkExpressionValueIsNotNull(optString5, "raw.optString(keySchema)");
            return new TaskUIBtn(optString, optString2, optString3, optString4, optString5);
        }
        return (TaskUIBtn) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.su
    /* renamed from: e */
    public TaskUIData a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String uiBackColor = jSONObject.optString(TaskUIData.keyBackColor);
                String uiMessage = jSONObject.optString("message");
                int optInt = jSONObject.optInt("duration");
                String uiForeColor = jSONObject.optString(TaskUIData.keyForeColor);
                String uiBgUrl = jSONObject.optString(TaskUIData.keyBgUrl);
                String closeBg = jSONObject.optString(TaskUIData.keyCloseBg);
                String uiTxtColor = jSONObject.optString(TaskUIData.keyTxtColor);
                String extra = jSONObject.optString("extra");
                TaskUIProgress b = b(jSONObject.optJSONObject("progress"));
                TaskUIBtn d = d(jSONObject.optJSONObject(TaskUIData.keyBackBtn));
                TaskUIBtn d2 = d(jSONObject.optJSONObject(TaskUIData.keyCancelBtn));
                int optInt2 = jSONObject.optInt(TaskUIData.keyModalType);
                Intrinsics.checkExpressionValueIsNotNull(uiBackColor, "uiBackColor");
                Intrinsics.checkExpressionValueIsNotNull(uiMessage, "uiMessage");
                Intrinsics.checkExpressionValueIsNotNull(uiForeColor, "uiForeColor");
                Intrinsics.checkExpressionValueIsNotNull(uiBgUrl, "uiBgUrl");
                Intrinsics.checkExpressionValueIsNotNull(uiTxtColor, "uiTxtColor");
                Intrinsics.checkExpressionValueIsNotNull(closeBg, "closeBg");
                Intrinsics.checkExpressionValueIsNotNull(extra, "extra");
                return new TaskUIData(uiBackColor, uiMessage, optInt, uiForeColor, uiBgUrl, uiTxtColor, b, d, d2, optInt2, closeBg, extra);
            } catch (Exception unused) {
                return new TaskUIData(null, null, 0, null, null, null, null, null, null, 0, null, null, 4095, null);
            }
        }
        return (TaskUIData) invokeL.objValue;
    }
}
