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
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public int f58034b;

    /* loaded from: classes2.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f58035b;

        /* renamed from: c  reason: collision with root package name */
        public AdTemplate f58036c;

        /* renamed from: d  reason: collision with root package name */
        public int f58037d;

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
            this.a = jSONObject.optInt(LightInvokerImpl.VOICE_ACTIONTYPE);
            this.f58037d = jSONObject.optInt("refreshType");
            this.f58035b = jSONObject.optString("payload");
            try {
                String string = jSONObject.getString("adTemplate");
                if (this.f58036c == null) {
                    this.f58036c = new AdTemplate();
                }
                this.f58036c.parseJson(new JSONObject(string));
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
                com.kwad.sdk.utils.t.a(jSONObject, LightInvokerImpl.VOICE_ACTIONTYPE, this.a);
                com.kwad.sdk.utils.t.a(jSONObject, "payload", this.f58035b);
                com.kwad.sdk.utils.t.a(jSONObject, "refreshType", this.f58037d);
                com.kwad.sdk.utils.t.a(jSONObject, "adTemplate", this.f58036c);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public k(com.kwad.sdk.core.webview.a aVar) {
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
        this.f58034b = 0;
        this.a = aVar;
    }

    private AdTemplate b(@NonNull a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, aVar)) == null) ? aVar.f58036c != null ? aVar.f58036c : this.a.a() : (AdTemplate) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbConfig.TMP_LOG_DIR_NAME : (String) invokeV.objValue;
    }

    @SuppressLint({"SwitchIntDef"})
    public void a(@NonNull a aVar) {
        p.a aVar2;
        AdTemplate a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            com.kwad.sdk.core.d.a.a("WebCardLogHandler", "handleH5Log actionType actionType" + aVar.a);
            if (aVar.a == 1) {
                if (aVar.f58036c != null) {
                    aVar2 = new p.a();
                    aVar2.f57687h = aVar.f58035b;
                    aVar2.o = this.f58034b;
                    a2 = aVar.f58036c;
                } else {
                    aVar2 = new p.a();
                    aVar2.f57687h = aVar.f58035b;
                    a2 = this.a.a();
                }
                com.kwad.sdk.core.report.a.a(a2, (JSONObject) null, aVar2);
            } else if (aVar.a != 2) {
                if (aVar.a == 12006) {
                    com.kwad.sdk.core.report.d.a(b(aVar), aVar.f58037d, this.f58034b);
                } else {
                    com.kwad.sdk.core.report.a.a(b(aVar), aVar.a, this.a.f57956c, aVar.f58035b);
                }
            } else {
                AdBaseFrameLayout adBaseFrameLayout = this.a.f57955b;
                p.a aVar3 = new p.a();
                aVar3.o = this.f58034b;
                if (adBaseFrameLayout != null) {
                    com.kwad.sdk.core.report.a.a(b(aVar), this.a.f57956c, aVar3, adBaseFrameLayout.getTouchCoords(), aVar.f58035b);
                } else {
                    com.kwad.sdk.core.report.a.a(b(aVar), this.a.f57956c, aVar3, aVar.f58035b);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) {
            if (this.a.c()) {
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

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }
}
