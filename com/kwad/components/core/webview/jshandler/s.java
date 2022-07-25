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
public class s implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.b Lk;
    public int Ml;
    public a hb;

    /* loaded from: classes5.dex */
    public interface a {
        void onAdShow();
    }

    /* loaded from: classes5.dex */
    public static final class b implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int Mm;
        public String Mn;
        public int Mo;
        public AdTemplate adTemplate;

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
            this.Mm = jSONObject.optInt("actionType");
            this.Mo = jSONObject.optInt("refreshType");
            this.Mn = jSONObject.optString("payload");
            try {
                String string = jSONObject.getString("adTemplate");
                if (this.adTemplate == null) {
                    this.adTemplate = new AdTemplate();
                }
                this.adTemplate.parseJson(new JSONObject(string));
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.utils.r.putValue(jSONObject, "actionType", this.Mm);
                com.kwad.sdk.utils.r.putValue(jSONObject, "payload", this.Mn);
                com.kwad.sdk.utils.r.putValue(jSONObject, "refreshType", this.Mo);
                com.kwad.sdk.utils.r.a(jSONObject, "adTemplate", this.adTemplate);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public s(com.kwad.sdk.core.webview.b bVar) {
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
        this.Ml = 0;
        this.Lk = bVar;
    }

    @SuppressLint({"SwitchIntDef"})
    private void a(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, bVar) == null) {
            com.kwad.sdk.core.e.b.d("WebCardLogHandler", "handleH5Log actionType actionType" + bVar.Mm);
            if (bVar.Mm == 1) {
                com.kwad.sdk.core.report.f cr = new com.kwad.sdk.core.report.f().cr(bVar.Mn);
                a aVar = this.hb;
                if (aVar != null) {
                    aVar.onAdShow();
                }
                if (bVar.adTemplate == null) {
                    com.kwad.components.core.m.c.ox().a(this.Lk.getAdTemplate(), null, cr);
                    return;
                }
                cr.aL(this.Ml);
                com.kwad.components.core.m.c.ox().a(bVar.adTemplate, null, cr);
            } else if (bVar.Mm != 2) {
                if (bVar.Mm == 12006) {
                    com.kwad.components.core.j.a.og().a(b(bVar), bVar.Mo, this.Ml);
                } else {
                    com.kwad.sdk.core.report.a.a(b(bVar), bVar.Mm, this.Lk.mReportExtData, bVar.Mn);
                }
            } else {
                com.kwad.sdk.widget.e eVar = this.Lk.agd;
                com.kwad.sdk.core.report.f cr2 = new com.kwad.sdk.core.report.f().aL(this.Ml).cr(bVar.Mn);
                if (eVar != null) {
                    cr2.b(eVar.getTouchCoords());
                }
                a(cr2);
                com.kwad.sdk.core.report.a.a(b(bVar), cr2, this.Lk.mReportExtData);
            }
        }
    }

    private AdTemplate b(@NonNull b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bVar)) == null) ? bVar.adTemplate != null ? bVar.adTemplate : this.Lk.getAdTemplate() : (AdTemplate) invokeL.objValue;
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.hb = aVar;
        }
    }

    public void a(com.kwad.sdk.core.report.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) {
            if (this.Lk.wh()) {
                cVar.onError(-1, "native adTemplate is null");
            }
            try {
                b bVar = new b();
                bVar.parseJson(new JSONObject(str));
                a(bVar);
                cVar.a(null);
            } catch (JSONException e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
                cVar.onError(-1, e.getMessage());
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TbConfig.TMP_LOG_DIR_NAME : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }
}
