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
/* loaded from: classes10.dex */
public class j implements com.kwad.sdk.core.webview.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f72544a;

    /* renamed from: b  reason: collision with root package name */
    public int f72545b;

    /* loaded from: classes10.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f72546a;

        /* renamed from: b  reason: collision with root package name */
        public String f72547b;

        /* renamed from: c  reason: collision with root package name */
        public AdTemplate f72548c;

        /* renamed from: d  reason: collision with root package name */
        public int f72549d;

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
            this.f72546a = jSONObject.optInt(LightInvokerImpl.VOICE_ACTIONTYPE);
            this.f72549d = jSONObject.optInt("refreshType");
            this.f72547b = jSONObject.optString("payload");
            try {
                String string = jSONObject.getString("adTemplate");
                if (this.f72548c == null) {
                    this.f72548c = new AdTemplate();
                }
                this.f72548c.parseJson(new JSONObject(string));
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
                com.kwad.sdk.utils.q.a(jSONObject, LightInvokerImpl.VOICE_ACTIONTYPE, this.f72546a);
                com.kwad.sdk.utils.q.a(jSONObject, "payload", this.f72547b);
                com.kwad.sdk.utils.q.a(jSONObject, "refreshType", this.f72549d);
                com.kwad.sdk.utils.q.a(jSONObject, "adTemplate", this.f72548c);
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
        this.f72545b = 0;
        this.f72544a = aVar;
    }

    @SuppressLint({"SwitchIntDef"})
    private void a(@NonNull a aVar) {
        n.a aVar2;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, aVar) == null) {
            com.kwad.sdk.core.d.a.a("WebCardLogHandler", "handleH5Log actionType actionType" + aVar.f72546a);
            if (aVar.f72546a == 1) {
                if (aVar.f72548c != null) {
                    aVar2 = new n.a();
                    aVar2.f72220f = aVar.f72547b;
                    aVar2.m = this.f72545b;
                    adTemplate = aVar.f72548c;
                } else {
                    aVar2 = new n.a();
                    aVar2.f72220f = aVar.f72547b;
                    adTemplate = this.f72544a.f72423b;
                }
                com.kwad.sdk.core.report.a.a(adTemplate, (JSONObject) null, aVar2);
            } else if (aVar.f72546a != 2) {
                if (aVar.f72546a == 12006) {
                    com.kwad.sdk.core.report.d.a(b(aVar), aVar.f72549d, this.f72545b);
                } else {
                    com.kwad.sdk.core.report.a.a(b(aVar), aVar.f72546a, this.f72544a.f72425d, aVar.f72547b);
                }
            } else {
                AdBaseFrameLayout adBaseFrameLayout = this.f72544a.f72424c;
                if (adBaseFrameLayout != null) {
                    n.a aVar3 = new n.a();
                    aVar3.m = this.f72545b;
                    com.kwad.sdk.core.report.a.a(b(aVar), this.f72544a.f72425d, aVar3, adBaseFrameLayout.getTouchCoords(), aVar.f72547b);
                    return;
                }
                n.a aVar4 = new n.a();
                aVar4.m = this.f72545b;
                com.kwad.sdk.core.report.a.a(b(aVar), this.f72544a.f72425d, aVar4, aVar.f72547b);
            }
        }
    }

    private AdTemplate b(@NonNull a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) ? aVar.f72548c != null ? aVar.f72548c : this.f72544a.f72423b : (AdTemplate) invokeL.objValue;
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
            if (this.f72544a.f72423b == null) {
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
