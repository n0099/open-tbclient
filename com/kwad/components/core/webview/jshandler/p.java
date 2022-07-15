package com.kwad.components.core.webview.jshandler;

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
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class p implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.b a;
    public int b;
    public a c;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes5.dex */
    public static final class b implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;
        public AdTemplate c;
        public int d;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.a = jSONObject.optInt("actionType");
            this.d = jSONObject.optInt("refreshType");
            this.b = jSONObject.optString("payload");
            try {
                String string = jSONObject.getString("adTemplate");
                if (this.c == null) {
                    this.c = new AdTemplate();
                }
                this.c.parseJson(new JSONObject(string));
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.b(e);
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.utils.r.a(jSONObject, "actionType", this.a);
                com.kwad.sdk.utils.r.a(jSONObject, "payload", this.b);
                com.kwad.sdk.utils.r.a(jSONObject, "refreshType", this.d);
                com.kwad.sdk.utils.r.a(jSONObject, "adTemplate", this.c);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public p(com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.a = bVar;
    }

    @SuppressLint({"SwitchIntDef"})
    private void a(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, bVar) == null) {
            com.kwad.sdk.core.d.b.a("WebCardLogHandler", "handleH5Log actionType actionType" + bVar.a);
            if (bVar.a == 1) {
                com.kwad.sdk.core.report.f a2 = new com.kwad.sdk.core.report.f().a(bVar.b);
                a aVar = this.c;
                if (aVar != null) {
                    aVar.a();
                }
                if (bVar.c == null) {
                    com.kwad.components.core.l.c.a().a(this.a.a(), null, a2);
                    return;
                }
                a2.d(this.b);
                com.kwad.components.core.l.c.a().a(bVar.c, null, a2);
            } else if (bVar.a != 2) {
                if (bVar.a == 12006) {
                    com.kwad.components.core.i.a.a().a(b(bVar), bVar.d, this.b);
                } else {
                    com.kwad.sdk.core.report.a.a(b(bVar), bVar.a, this.a.c, bVar.b);
                }
            } else {
                com.kwad.sdk.widget.e eVar = this.a.b;
                com.kwad.sdk.core.report.f a3 = new com.kwad.sdk.core.report.f().d(this.b).a(bVar.b);
                if (eVar != null) {
                    a3.a(eVar.getTouchCoords());
                }
                com.kwad.sdk.core.report.a.a(b(bVar), a3, this.a.c);
            }
        }
    }

    private AdTemplate b(@NonNull b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bVar)) == null) ? bVar.c != null ? bVar.c : this.a.a() : (AdTemplate) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbConfig.TMP_LOG_DIR_NAME : (String) invokeV.objValue;
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.c = aVar;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) {
            if (this.a.c()) {
                cVar.a(-1, "native adTemplate is null");
            }
            try {
                b bVar = new b();
                bVar.parseJson(new JSONObject(str));
                a(bVar);
                cVar.a(null);
            } catch (JSONException e) {
                com.kwad.sdk.core.d.b.a(e);
                cVar.a(-1, e.getMessage());
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }
}
