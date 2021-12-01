package com.kwad.sdk.core.video.kwai.kwai;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.utils.t;
import java.util.UUID;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends com.kwad.sdk.core.report.c implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f57861b;

    /* renamed from: c  reason: collision with root package name */
    public String f57862c;

    /* renamed from: d  reason: collision with root package name */
    public long f57863d;

    /* renamed from: e  reason: collision with root package name */
    public String f57864e;

    /* renamed from: f  reason: collision with root package name */
    public long f57865f;

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
        this.a = UUID.randomUUID().toString();
        this.f57863d = System.currentTimeMillis();
        this.f57864e = n.b();
        this.f57865f = n.d();
        this.f57861b = str;
        this.f57862c = str2;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.parseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            try {
                this.f57863d = jSONObject.optLong("timestamp");
                if (jSONObject.has("actionId")) {
                    this.a = jSONObject.optString("actionId");
                }
                if (jSONObject.has("sessionId")) {
                    this.f57864e = jSONObject.optString("sessionId");
                }
                this.f57865f = jSONObject.optLong("seq");
                if (jSONObject.has("mediaPlayerAction")) {
                    this.f57861b = jSONObject.optString("mediaPlayerAction");
                }
                if (jSONObject.has("mediaPlayerMsg")) {
                    this.f57862c = jSONObject.optString("mediaPlayerMsg");
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject json = super.toJson();
            t.a(json, "actionId", this.a);
            t.a(json, "timestamp", this.f57863d);
            t.a(json, "sessionId", this.f57864e);
            t.a(json, "seq", this.f57865f);
            t.a(json, "mediaPlayerAction", this.f57861b);
            t.a(json, "mediaPlayerMsg", this.f57862c);
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "MediaPlayerReportAction{actionId='" + this.a + ExtendedMessageFormat.QUOTE + ", timestamp=" + this.f57863d + ", sessionId='" + this.f57864e + ExtendedMessageFormat.QUOTE + ", seq=" + this.f57865f + ", mediaPlayerAction='" + this.f57861b + ExtendedMessageFormat.QUOTE + ", mediaPlayerMsg='" + this.f57862c + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
