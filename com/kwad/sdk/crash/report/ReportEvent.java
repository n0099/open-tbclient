package com.kwad.sdk.crash.report;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.q;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ReportEvent implements com.kwad.sdk.core.b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 8652448382850235426L;
    public transient /* synthetic */ FieldHolder $fh;
    public long clientIncrementId;
    public long clientTimeStamp;
    public String sessionId;
    public StatPackage statPackage;
    public String timeZone;

    /* loaded from: classes6.dex */
    public static class ExceptionEvent implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 5177557263564436344L;
        public transient /* synthetic */ FieldHolder $fh;
        public String flag;
        public String message;
        public int type;
        public UrlPackage urlPackage;

        public ExceptionEvent() {
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

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.message = jSONObject.optString("message");
            this.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
            this.flag = jSONObject.optString("flag");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                q.a(jSONObject, "type", this.type);
                q.a(jSONObject, "message", this.message);
                q.a(jSONObject, "urlPackage", this.urlPackage);
                q.a(jSONObject, "flag", this.flag);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class StatPackage implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -6225392281821567840L;
        public transient /* synthetic */ FieldHolder $fh;
        public ExceptionEvent exceptionEvent;

        public StatPackage() {
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

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.exceptionEvent.parseJson(jSONObject.optJSONObject("exceptionEvent"));
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                q.a(jSONObject, "exceptionEvent", this.exceptionEvent);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class UrlPackage implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2535768638193007414L;
        public transient /* synthetic */ FieldHolder $fh;
        public String identity;
        public String page;
        public int pageType;
        public String params;

        public UrlPackage() {
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

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.page = jSONObject.optString("page");
            this.params = jSONObject.optString("params");
            this.identity = jSONObject.optString("identity");
            this.pageType = jSONObject.optInt("pageType");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                q.a(jSONObject, "page", this.page);
                q.a(jSONObject, "params", this.params);
                q.a(jSONObject, "identity", this.identity);
                q.a(jSONObject, "pageType", this.pageType);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public ReportEvent() {
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

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.clientTimeStamp = jSONObject.optLong("clientTimeStamp");
        this.clientIncrementId = jSONObject.optLong("clientIncrementId");
        this.sessionId = jSONObject.optString("sessionId");
        this.statPackage.parseJson(jSONObject.optJSONObject("statPackage"));
        this.timeZone = jSONObject.optString("timeZone");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            q.a(jSONObject, "clientTimeStamp", this.clientTimeStamp);
            q.a(jSONObject, "clientIncrementId", this.clientIncrementId);
            q.a(jSONObject, "sessionId", this.sessionId);
            q.a(jSONObject, "statPackage", this.statPackage);
            q.a(jSONObject, "timeZone", this.timeZone);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
