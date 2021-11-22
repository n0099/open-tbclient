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
    public final com.kwad.sdk.core.webview.a f66258a;

    /* renamed from: b  reason: collision with root package name */
    public int f66259b;

    /* loaded from: classes2.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f66260a;

        /* renamed from: b  reason: collision with root package name */
        public String f66261b;

        /* renamed from: c  reason: collision with root package name */
        public AdTemplate f66262c;

        /* renamed from: d  reason: collision with root package name */
        public int f66263d;

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
            this.f66260a = jSONObject.optInt(LightInvokerImpl.VOICE_ACTIONTYPE);
            this.f66263d = jSONObject.optInt("refreshType");
            this.f66261b = jSONObject.optString("payload");
            try {
                String string = jSONObject.getString("adTemplate");
                if (this.f66262c == null) {
                    this.f66262c = new AdTemplate();
                }
                this.f66262c.parseJson(new JSONObject(string));
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
                com.kwad.sdk.utils.q.a(jSONObject, LightInvokerImpl.VOICE_ACTIONTYPE, this.f66260a);
                com.kwad.sdk.utils.q.a(jSONObject, "payload", this.f66261b);
                com.kwad.sdk.utils.q.a(jSONObject, "refreshType", this.f66263d);
                com.kwad.sdk.utils.q.a(jSONObject, "adTemplate", this.f66262c);
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
        this.f66259b = 0;
        this.f66258a = aVar;
    }

    @SuppressLint({"SwitchIntDef"})
    private void a(@NonNull a aVar) {
        n.a aVar2;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, aVar) == null) {
            com.kwad.sdk.core.d.a.a("WebCardLogHandler", "handleH5Log actionType actionType" + aVar.f66260a);
            if (aVar.f66260a == 1) {
                if (aVar.f66262c != null) {
                    aVar2 = new n.a();
                    aVar2.f65942f = aVar.f66261b;
                    aVar2.m = this.f66259b;
                    adTemplate = aVar.f66262c;
                } else {
                    aVar2 = new n.a();
                    aVar2.f65942f = aVar.f66261b;
                    adTemplate = this.f66258a.f66139b;
                }
                com.kwad.sdk.core.report.a.a(adTemplate, (JSONObject) null, aVar2);
            } else if (aVar.f66260a != 2) {
                if (aVar.f66260a == 12006) {
                    com.kwad.sdk.core.report.d.a(b(aVar), aVar.f66263d, this.f66259b);
                } else {
                    com.kwad.sdk.core.report.a.a(b(aVar), aVar.f66260a, this.f66258a.f66141d, aVar.f66261b);
                }
            } else {
                AdBaseFrameLayout adBaseFrameLayout = this.f66258a.f66140c;
                if (adBaseFrameLayout != null) {
                    n.a aVar3 = new n.a();
                    aVar3.m = this.f66259b;
                    com.kwad.sdk.core.report.a.a(b(aVar), this.f66258a.f66141d, aVar3, adBaseFrameLayout.getTouchCoords(), aVar.f66261b);
                    return;
                }
                n.a aVar4 = new n.a();
                aVar4.m = this.f66259b;
                com.kwad.sdk.core.report.a.a(b(aVar), this.f66258a.f66141d, aVar4, aVar.f66261b);
            }
        }
    }

    private AdTemplate b(@NonNull a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) ? aVar.f66262c != null ? aVar.f66262c : this.f66258a.f66139b : (AdTemplate) invokeL.objValue;
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
            if (this.f66258a.f66139b == null) {
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
