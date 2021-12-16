package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.kwad.sdk.core.report.CommercialAction;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class eb implements com.kwad.sdk.core.d<CommercialAction.TKPerformMsg> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public eb() {
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
    public void a(CommercialAction.TKPerformMsg tKPerformMsg, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, tKPerformMsg, jSONObject) == null) || jSONObject == null) {
            return;
        }
        tKPerformMsg.source = jSONObject.optInt("source");
        tKPerformMsg.renderState = jSONObject.optInt("render_state");
        tKPerformMsg.errorReason = jSONObject.optString(LoadErrorCode.Statistics.KEY_ERROR_REASON);
        if (jSONObject.opt(LoadErrorCode.Statistics.KEY_ERROR_REASON) == JSONObject.NULL) {
            tKPerformMsg.errorReason = "";
        }
        tKPerformMsg.renderTime = jSONObject.optLong("render_time");
        tKPerformMsg.templateId = jSONObject.optString("template_id");
        if (jSONObject.opt("template_id") == JSONObject.NULL) {
            tKPerformMsg.templateId = "";
        }
        tKPerformMsg.versionCode = jSONObject.optString("version_code");
        if (jSONObject.opt("version_code") == JSONObject.NULL) {
            tKPerformMsg.versionCode = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(CommercialAction.TKPerformMsg tKPerformMsg, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tKPerformMsg, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "source", tKPerformMsg.source);
            com.kwad.sdk.utils.t.a(jSONObject, "render_state", tKPerformMsg.renderState);
            com.kwad.sdk.utils.t.a(jSONObject, LoadErrorCode.Statistics.KEY_ERROR_REASON, tKPerformMsg.errorReason);
            com.kwad.sdk.utils.t.a(jSONObject, "render_time", tKPerformMsg.renderTime);
            com.kwad.sdk.utils.t.a(jSONObject, "template_id", tKPerformMsg.templateId);
            com.kwad.sdk.utils.t.a(jSONObject, "version_code", tKPerformMsg.versionCode);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
