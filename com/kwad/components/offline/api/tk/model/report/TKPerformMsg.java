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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TKPerformMsg extends BaseOfflineCompoJsonParse implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ENTER_SCENE = -1;
    public static final int OTHER_FAIL = 3;
    public static final int PAGE_STATUS_FAIL = 2;
    public static final int START = 0;
    public static final int SUCCESS = 1;
    public static final int TK_NOT_READY = 4;
    public static final long serialVersionUID = -5293371882532982729L;
    public transient /* synthetic */ FieldHolder $fh;
    public String errorReason;
    public long initTime;
    public long loadTime;
    public int renderState;
    public long renderTime;
    public int source;
    public String templateId;
    public String versionCode;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface ERROR_REASON {
        public static final String KSAD_TK_JS_EMPTY = "js_empty";
        public static final String KSAD_TK_NO_FILE = "no_file";
        public static final String KSAD_TK_NO_TEMPLATE = "no_template";
        public static final String KSAD_TK_OFFLINE_FAILED = "offline_failed";
        public static final String KSAD_TK_SO_FAIL = "so_fail";
    }

    public TKPerformMsg(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setSource(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(TKPerformMsg tKPerformMsg, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tKPerformMsg, jSONObject) == null) || jSONObject == null) {
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
        tKPerformMsg.loadTime = jSONObject.optLong("load_time");
        tKPerformMsg.initTime = jSONObject.optLong("init_time");
    }

    public TKPerformMsg setErrorReason(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.errorReason = str;
            return this;
        }
        return (TKPerformMsg) invokeL.objValue;
    }

    public TKPerformMsg setInitTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            this.initTime = j;
            return this;
        }
        return (TKPerformMsg) invokeJ.objValue;
    }

    public TKPerformMsg setLoadTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            this.loadTime = j;
            return this;
        }
        return (TKPerformMsg) invokeJ.objValue;
    }

    public TKPerformMsg setRenderState(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.renderState = i;
            return this;
        }
        return (TKPerformMsg) invokeI.objValue;
    }

    public TKPerformMsg setRenderTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            this.renderTime = j;
            return this;
        }
        return (TKPerformMsg) invokeJ.objValue;
    }

    public TKPerformMsg setSource(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.source = i;
            return this;
        }
        return (TKPerformMsg) invokeI.objValue;
    }

    public TKPerformMsg setTemplateId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.templateId = str;
            return this;
        }
        return (TKPerformMsg) invokeL.objValue;
    }

    public TKPerformMsg setVersionCode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.versionCode = str;
            return this;
        }
        return (TKPerformMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKPerformMsg tKPerformMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, tKPerformMsg)) == null) ? toJson(tKPerformMsg, (JSONObject) null) : (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKPerformMsg tKPerformMsg, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, tKPerformMsg, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            JsonHelper.putValue(jSONObject, "render_state", tKPerformMsg.renderState);
            int i = tKPerformMsg.source;
            if (i != 0) {
                JsonHelper.putValue(jSONObject, "source", i);
            }
            String str = tKPerformMsg.errorReason;
            if (str != null && !str.equals("")) {
                JsonHelper.putValue(jSONObject, LoadErrorCode.Statistics.KEY_ERROR_REASON, tKPerformMsg.errorReason);
            }
            long j = tKPerformMsg.renderTime;
            if (j != 0) {
                JsonHelper.putValue(jSONObject, "render_time", j);
            }
            String str2 = tKPerformMsg.templateId;
            if (str2 != null && !str2.equals("")) {
                JsonHelper.putValue(jSONObject, "template_id", tKPerformMsg.templateId);
            }
            String str3 = tKPerformMsg.versionCode;
            if (str3 != null && !str3.equals("")) {
                JsonHelper.putValue(jSONObject, "version_code", tKPerformMsg.versionCode);
            }
            long j2 = tKPerformMsg.loadTime;
            if (j2 != 0) {
                JsonHelper.putValue(jSONObject, "load_time", j2);
            }
            long j3 = tKPerformMsg.initTime;
            if (j3 != 0) {
                JsonHelper.putValue(jSONObject, "init_time", j3);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
