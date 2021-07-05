package com.kwad.sdk.core.video.a.a;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.utils.o;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends d implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f36599b;

    /* renamed from: c  reason: collision with root package name */
    public String f36600c;

    /* renamed from: d  reason: collision with root package name */
    public long f36601d;

    /* renamed from: e  reason: collision with root package name */
    public String f36602e;

    /* renamed from: f  reason: collision with root package name */
    public long f36603f;

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
        this.f36535a = UUID.randomUUID().toString();
        this.f36601d = System.currentTimeMillis();
        this.f36602e = m.b();
        this.f36603f = m.d();
        this.f36599b = str;
        this.f36600c = str2;
    }

    @Override // com.kwad.sdk.core.report.d
    public void a(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.a(jSONObject);
            if (jSONObject == null) {
                return;
            }
            try {
                this.f36601d = jSONObject.optLong("timestamp");
                if (jSONObject.has("sessionId")) {
                    this.f36602e = jSONObject.optString("sessionId");
                }
                this.f36603f = jSONObject.optLong(IAdRequestParam.SEQ);
                if (jSONObject.has("mediaPlayerAction")) {
                    this.f36599b = jSONObject.optString("mediaPlayerAction");
                }
                if (jSONObject.has("mediaPlayerMsg")) {
                    this.f36600c = jSONObject.optString("mediaPlayerMsg");
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    @Override // com.kwad.sdk.core.report.d, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject json = super.toJson();
            o.a(json, "timestamp", this.f36601d);
            o.a(json, "sessionId", this.f36602e);
            o.a(json, IAdRequestParam.SEQ, this.f36603f);
            o.a(json, "mediaPlayerAction", this.f36599b);
            o.a(json, "mediaPlayerMsg", this.f36600c);
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "MediaPlayerReportAction{actionId='" + this.f36535a + "', timestamp=" + this.f36601d + ", sessionId='" + this.f36602e + "', seq=" + this.f36603f + ", mediaPlayerAction='" + this.f36599b + "', mediaPlayerMsg='" + this.f36600c + "'}";
        }
        return (String) invokeV.objValue;
    }
}
