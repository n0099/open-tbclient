package com.kwad.sdk.core.video.a.a;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.l;
import com.kwad.sdk.utils.q;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.core.report.c implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f35134b;

    /* renamed from: c  reason: collision with root package name */
    public String f35135c;

    /* renamed from: d  reason: collision with root package name */
    public long f35136d;

    /* renamed from: e  reason: collision with root package name */
    public String f35137e;

    /* renamed from: f  reason: collision with root package name */
    public long f35138f;

    public c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35067a = UUID.randomUUID().toString();
        this.f35136d = System.currentTimeMillis();
        this.f35137e = l.b();
        this.f35138f = l.d();
        this.f35134b = str;
        this.f35135c = str2;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.parseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            try {
                this.f35136d = jSONObject.optLong("timestamp");
                if (jSONObject.has("actionId")) {
                    this.f35067a = jSONObject.optString("actionId");
                }
                if (jSONObject.has("sessionId")) {
                    this.f35137e = jSONObject.optString("sessionId");
                }
                this.f35138f = jSONObject.optLong(IAdRequestParam.SEQ);
                if (jSONObject.has("mediaPlayerAction")) {
                    this.f35134b = jSONObject.optString("mediaPlayerAction");
                }
                if (jSONObject.has("mediaPlayerMsg")) {
                    this.f35135c = jSONObject.optString("mediaPlayerMsg");
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject json = super.toJson();
            q.a(json, "actionId", this.f35067a);
            q.a(json, "timestamp", this.f35136d);
            q.a(json, "sessionId", this.f35137e);
            q.a(json, IAdRequestParam.SEQ, this.f35138f);
            q.a(json, "mediaPlayerAction", this.f35134b);
            q.a(json, "mediaPlayerMsg", this.f35135c);
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "MediaPlayerReportAction{actionId='" + this.f35067a + "', timestamp=" + this.f35136d + ", sessionId='" + this.f35137e + "', seq=" + this.f35138f + ", mediaPlayerAction='" + this.f35134b + "', mediaPlayerMsg='" + this.f35135c + "'}";
        }
        return (String) invokeV.objValue;
    }
}
