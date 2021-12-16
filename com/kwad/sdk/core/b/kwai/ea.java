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
public class ea implements com.kwad.sdk.core.d<CommercialAction.TKDownloadMsg> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ea() {
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
    public void a(CommercialAction.TKDownloadMsg tKDownloadMsg, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, tKDownloadMsg, jSONObject) == null) || jSONObject == null) {
            return;
        }
        tKDownloadMsg.downloadState = jSONObject.optInt("download_state");
        tKDownloadMsg.downloadTime = jSONObject.optLong("download_time");
        tKDownloadMsg.preload = jSONObject.optInt("preload");
        tKDownloadMsg.errorReason = jSONObject.optString(LoadErrorCode.Statistics.KEY_ERROR_REASON);
        if (jSONObject.opt(LoadErrorCode.Statistics.KEY_ERROR_REASON) == JSONObject.NULL) {
            tKDownloadMsg.errorReason = "";
        }
        tKDownloadMsg.templateId = jSONObject.optString("template_id");
        if (jSONObject.opt("template_id") == JSONObject.NULL) {
            tKDownloadMsg.templateId = "";
        }
        tKDownloadMsg.versionCode = jSONObject.optString("version_code");
        if (jSONObject.opt("version_code") == JSONObject.NULL) {
            tKDownloadMsg.versionCode = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(CommercialAction.TKDownloadMsg tKDownloadMsg, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tKDownloadMsg, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "download_state", tKDownloadMsg.downloadState);
            com.kwad.sdk.utils.t.a(jSONObject, "download_time", tKDownloadMsg.downloadTime);
            com.kwad.sdk.utils.t.a(jSONObject, "preload", tKDownloadMsg.preload);
            com.kwad.sdk.utils.t.a(jSONObject, LoadErrorCode.Statistics.KEY_ERROR_REASON, tKDownloadMsg.errorReason);
            com.kwad.sdk.utils.t.a(jSONObject, "template_id", tKDownloadMsg.templateId);
            com.kwad.sdk.utils.t.a(jSONObject, "version_code", tKDownloadMsg.versionCode);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
