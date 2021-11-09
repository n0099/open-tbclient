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
    public final com.kwad.sdk.core.webview.a f65345a;

    /* renamed from: b  reason: collision with root package name */
    public int f65346b;

    /* loaded from: classes2.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f65347a;

        /* renamed from: b  reason: collision with root package name */
        public String f65348b;

        /* renamed from: c  reason: collision with root package name */
        public AdTemplate f65349c;

        /* renamed from: d  reason: collision with root package name */
        public int f65350d;

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
            this.f65347a = jSONObject.optInt(LightInvokerImpl.VOICE_ACTIONTYPE);
            this.f65350d = jSONObject.optInt("refreshType");
            this.f65348b = jSONObject.optString("payload");
            try {
                String string = jSONObject.getString("adTemplate");
                if (this.f65349c == null) {
                    this.f65349c = new AdTemplate();
                }
                this.f65349c.parseJson(new JSONObject(string));
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
                com.kwad.sdk.utils.q.a(jSONObject, LightInvokerImpl.VOICE_ACTIONTYPE, this.f65347a);
                com.kwad.sdk.utils.q.a(jSONObject, "payload", this.f65348b);
                com.kwad.sdk.utils.q.a(jSONObject, "refreshType", this.f65350d);
                com.kwad.sdk.utils.q.a(jSONObject, "adTemplate", this.f65349c);
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
        this.f65346b = 0;
        this.f65345a = aVar;
    }

    @SuppressLint({"SwitchIntDef"})
    private void a(@NonNull a aVar) {
        n.a aVar2;
        AdTemplate adTemplate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, aVar) == null) {
            com.kwad.sdk.core.d.a.a("WebCardLogHandler", "handleH5Log actionType actionType" + aVar.f65347a);
            if (aVar.f65347a == 1) {
                if (aVar.f65349c != null) {
                    aVar2 = new n.a();
                    aVar2.f65029f = aVar.f65348b;
                    aVar2.m = this.f65346b;
                    adTemplate = aVar.f65349c;
                } else {
                    aVar2 = new n.a();
                    aVar2.f65029f = aVar.f65348b;
                    adTemplate = this.f65345a.f65226b;
                }
                com.kwad.sdk.core.report.a.a(adTemplate, (JSONObject) null, aVar2);
            } else if (aVar.f65347a != 2) {
                if (aVar.f65347a == 12006) {
                    com.kwad.sdk.core.report.d.a(b(aVar), aVar.f65350d, this.f65346b);
                } else {
                    com.kwad.sdk.core.report.a.a(b(aVar), aVar.f65347a, this.f65345a.f65228d, aVar.f65348b);
                }
            } else {
                AdBaseFrameLayout adBaseFrameLayout = this.f65345a.f65227c;
                if (adBaseFrameLayout != null) {
                    n.a aVar3 = new n.a();
                    aVar3.m = this.f65346b;
                    com.kwad.sdk.core.report.a.a(b(aVar), this.f65345a.f65228d, aVar3, adBaseFrameLayout.getTouchCoords(), aVar.f65348b);
                    return;
                }
                n.a aVar4 = new n.a();
                aVar4.m = this.f65346b;
                com.kwad.sdk.core.report.a.a(b(aVar), this.f65345a.f65228d, aVar4, aVar.f65348b);
            }
        }
    }

    private AdTemplate b(@NonNull a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) ? aVar.f65349c != null ? aVar.f65349c : this.f65345a.f65226b : (AdTemplate) invokeL.objValue;
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
            if (this.f65345a.f65226b == null) {
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
