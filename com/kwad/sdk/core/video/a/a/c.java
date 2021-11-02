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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends com.kwad.sdk.core.report.c implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f65073b;

    /* renamed from: c  reason: collision with root package name */
    public String f65074c;

    /* renamed from: d  reason: collision with root package name */
    public long f65075d;

    /* renamed from: e  reason: collision with root package name */
    public String f65076e;

    /* renamed from: f  reason: collision with root package name */
    public long f65077f;

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
        this.f65006a = UUID.randomUUID().toString();
        this.f65075d = System.currentTimeMillis();
        this.f65076e = l.b();
        this.f65077f = l.d();
        this.f65073b = str;
        this.f65074c = str2;
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
                this.f65075d = jSONObject.optLong("timestamp");
                if (jSONObject.has("actionId")) {
                    this.f65006a = jSONObject.optString("actionId");
                }
                if (jSONObject.has("sessionId")) {
                    this.f65076e = jSONObject.optString("sessionId");
                }
                this.f65077f = jSONObject.optLong(IAdRequestParam.SEQ);
                if (jSONObject.has("mediaPlayerAction")) {
                    this.f65073b = jSONObject.optString("mediaPlayerAction");
                }
                if (jSONObject.has("mediaPlayerMsg")) {
                    this.f65074c = jSONObject.optString("mediaPlayerMsg");
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
            q.a(json, "actionId", this.f65006a);
            q.a(json, "timestamp", this.f65075d);
            q.a(json, "sessionId", this.f65076e);
            q.a(json, IAdRequestParam.SEQ, this.f65077f);
            q.a(json, "mediaPlayerAction", this.f65073b);
            q.a(json, "mediaPlayerMsg", this.f65074c);
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "MediaPlayerReportAction{actionId='" + this.f65006a + ExtendedMessageFormat.QUOTE + ", timestamp=" + this.f65075d + ", sessionId='" + this.f65076e + ExtendedMessageFormat.QUOTE + ", seq=" + this.f65077f + ", mediaPlayerAction='" + this.f65073b + ExtendedMessageFormat.QUOTE + ", mediaPlayerMsg='" + this.f65074c + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
