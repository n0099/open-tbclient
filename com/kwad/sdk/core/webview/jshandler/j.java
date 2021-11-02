package com.kwad.sdk.core.webview.jshandler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.walletfacesdk.LightInvokerImpl;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j implements com.kwad.sdk.core.webview.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f65346a;

    /* renamed from: b  reason: collision with root package name */
    public int f65347b;

    /* loaded from: classes2.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f65348a;

        /* renamed from: b  reason: collision with root package name */
        public String f65349b;

        /* renamed from: c  reason: collision with root package name */
        public AdTemplate f65350c;

        /* renamed from: d  reason: collision with root package name */
        public int f65351d;

        public a() {
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
            this.f65348a = jSONObject.optInt(LightInvokerImpl.VOICE_ACTIONTYPE);
            this.f65351d = jSONObject.optInt("refreshType");
            this.f65349b = jSONObject.optString("payload");
            try {
                String string = jSONObject.getString("adTemplate");
                if (this.f65350c == null) {
                    this.f65350c = new AdTemplate();
                }
                this.f65350c.parseJson(new JSONObject(string));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.utils.q.a(jSONObject, LightInvokerImpl.VOICE_ACTIONTYPE, this.f65348a);
                com.kwad.sdk.utils.q.a(jSONObject, "payload", this.f65349b);
                com.kwad.sdk.utils.q.a(jSONObject, "refreshType", this.f65351d);
                com.kwad.sdk.utils.q.a(jSONObject, "adTemplate", this.f65350c);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public j(com.kwad.sdk.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65347b = 0;
        this.f65346a = aVar;
    }

    @SuppressLint({"SwitchIntDef"})
    private void a(@NonNull a aVar) {
        n.a aVar2;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, aVar) == null) {
            com.kwad.sdk.core.d.a.a("WebCardLogHandler", "handleH5Log actionType actionType" + aVar.f65348a);
            if (aVar.f65348a == 1) {
                if (aVar.f65350c != null) {
                    aVar2 = new n.a();
                    aVar2.f65030f = aVar.f65349b;
                    aVar2.m = this.f65347b;
                    adTemplate = aVar.f65350c;
                } else {
                    aVar2 = new n.a();
                    aVar2.f65030f = aVar.f65349b;
                    adTemplate = this.f65346a.f65227b;
                }
                com.kwad.sdk.core.report.a.a(adTemplate, (JSONObject) null, aVar2);
            } else if (aVar.f65348a != 2) {
                if (aVar.f65348a == 12006) {
                    com.kwad.sdk.core.report.d.a(b(aVar), aVar.f65351d, this.f65347b);
                } else {
                    com.kwad.sdk.core.report.a.a(b(aVar), aVar.f65348a, this.f65346a.f65229d, aVar.f65349b);
                }
            } else {
                AdBaseFrameLayout adBaseFrameLayout = this.f65346a.f65228c;
                if (adBaseFrameLayout != null) {
                    n.a aVar3 = new n.a();
                    aVar3.m = this.f65347b;
                    com.kwad.sdk.core.report.a.a(b(aVar), this.f65346a.f65229d, aVar3, adBaseFrameLayout.getTouchCoords(), aVar.f65349b);
                    return;
                }
                n.a aVar4 = new n.a();
                aVar4.m = this.f65347b;
                com.kwad.sdk.core.report.a.a(b(aVar), this.f65346a.f65229d, aVar4, aVar.f65349b);
            }
        }
    }

    private AdTemplate b(@NonNull a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) ? aVar.f65350c != null ? aVar.f65350c : this.f65346a.f65227b : (AdTemplate) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbConfig.TMP_LOG_DIR_NAME : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            if (this.f65346a.f65227b == null) {
                cVar.a(-1, "native adTemplate is null");
            }
            try {
                a aVar = new a();
                aVar.parseJson(new JSONObject(str));
                a(aVar);
                cVar.a(null);
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
                cVar.a(-1, e2.getMessage());
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
