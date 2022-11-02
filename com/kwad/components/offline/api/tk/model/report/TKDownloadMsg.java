package com.kwad.components.offline.api.tk.model.report;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TKDownloadMsg extends BaseOfflineCompoJsonParse<TKDownloadMsg> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FAIL = 2;
    public static final int INVALID_DOWNLOAD_STATE = -1;
    public static final int START = 0;
    public static final int SUCCESS = 1;
    public static final long serialVersionUID = -8872909341685100922L;
    public transient /* synthetic */ FieldHolder $fh;
    public int downloadState;
    public long downloadTime;
    public String errorDetail;
    public String errorReason;
    public int loadingTimes;
    public int preload;
    public int retryCount;
    public String templateId;
    public String versionCode;

    public TKDownloadMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.downloadState = -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(TKDownloadMsg tKDownloadMsg, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tKDownloadMsg, jSONObject) == null) || jSONObject == null) {
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
        tKDownloadMsg.retryCount = jSONObject.optInt("retry_count");
        tKDownloadMsg.loadingTimes = jSONObject.optInt("loading_times");
        tKDownloadMsg.errorDetail = jSONObject.optString("error_detail");
        if (jSONObject.opt("error_detail") == JSONObject.NULL) {
            tKDownloadMsg.errorDetail = "";
        }
    }

    public TKDownloadMsg setDownloadState(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            this.downloadState = i;
            return this;
        }
        return (TKDownloadMsg) invokeI.objValue;
    }

    public TKDownloadMsg setDownloadTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            this.downloadTime = j;
            return this;
        }
        return (TKDownloadMsg) invokeJ.objValue;
    }

    public TKDownloadMsg setErrorDetail(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.errorDetail = str;
            return this;
        }
        return (TKDownloadMsg) invokeL.objValue;
    }

    public TKDownloadMsg setErrorReason(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.errorReason = str;
            return this;
        }
        return (TKDownloadMsg) invokeL.objValue;
    }

    public TKDownloadMsg setLoadingTimes(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.loadingTimes = i;
            return this;
        }
        return (TKDownloadMsg) invokeI.objValue;
    }

    public TKDownloadMsg setPreload(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.preload = i;
            return this;
        }
        return (TKDownloadMsg) invokeI.objValue;
    }

    public TKDownloadMsg setRetryCount(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.retryCount = i;
            return this;
        }
        return (TKDownloadMsg) invokeI.objValue;
    }

    public TKDownloadMsg setTemplateId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.templateId = str;
            return this;
        }
        return (TKDownloadMsg) invokeL.objValue;
    }

    public TKDownloadMsg setVersionCode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.versionCode = str;
            return this;
        }
        return (TKDownloadMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKDownloadMsg tKDownloadMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, tKDownloadMsg)) == null) ? toJson(tKDownloadMsg, (JSONObject) null) : (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKDownloadMsg tKDownloadMsg, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, tKDownloadMsg, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            JsonHelper.putValue(jSONObject, "download_state", tKDownloadMsg.downloadState);
            long j = tKDownloadMsg.downloadTime;
            if (j != 0) {
                JsonHelper.putValue(jSONObject, "download_time", j);
            }
            int i = tKDownloadMsg.preload;
            if (i != 0) {
                JsonHelper.putValue(jSONObject, "preload", i);
            }
            String str = tKDownloadMsg.errorReason;
            if (str != null && !str.equals("")) {
                JsonHelper.putValue(jSONObject, LoadErrorCode.Statistics.KEY_ERROR_REASON, tKDownloadMsg.errorReason);
            }
            String str2 = tKDownloadMsg.templateId;
            if (str2 != null && !str2.equals("")) {
                JsonHelper.putValue(jSONObject, "template_id", tKDownloadMsg.templateId);
            }
            String str3 = tKDownloadMsg.versionCode;
            if (str3 != null && !str3.equals("")) {
                JsonHelper.putValue(jSONObject, "version_code", tKDownloadMsg.versionCode);
            }
            int i2 = tKDownloadMsg.retryCount;
            if (i2 != 0) {
                JsonHelper.putValue(jSONObject, "retry_count", i2);
            }
            int i3 = tKDownloadMsg.loadingTimes;
            if (i3 != 0) {
                JsonHelper.putValue(jSONObject, "loading_times", i3);
            }
            String str4 = tKDownloadMsg.errorDetail;
            if (str4 != null && !str4.equals("")) {
                JsonHelper.putValue(jSONObject, "error_detail", tKDownloadMsg.errorDetail);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
