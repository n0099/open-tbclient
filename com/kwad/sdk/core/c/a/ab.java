package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.n;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ab implements com.kwad.sdk.core.d<n.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ab() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(n.a aVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        aVar.f72569a = jSONObject.optInt("photoPlaySecond");
        aVar.f72570b = jSONObject.optInt("itemClickType");
        aVar.f72571c = jSONObject.optInt("itemCloseType");
        aVar.f72572d = jSONObject.optInt("elementType");
        aVar.f72574f = jSONObject.optString("payload");
        aVar.f72575g = jSONObject.optInt("deeplinkType");
        aVar.f72576h = jSONObject.optInt("downloadSource");
        aVar.f72577i = jSONObject.optInt("isPackageChanged");
        aVar.f72578j = jSONObject.optString("installedFrom");
        aVar.k = jSONObject.optString("downloadFailedReason");
        aVar.l = jSONObject.optInt("isChangedEndcard");
        aVar.m = jSONObject.optInt("adAggPageSource");
        aVar.n = jSONObject.optString("serverPackageName");
        aVar.o = jSONObject.optString("installedPackageName");
        aVar.p = jSONObject.optInt("closeButtonImpressionTime");
        aVar.q = jSONObject.optInt("closeButtonClickTime");
        aVar.r = jSONObject.optLong("landingPageLoadedDuration");
        aVar.s = jSONObject.optInt("downloadStatus");
        aVar.t = jSONObject.optInt("downloadCardType");
        aVar.u = jSONObject.optInt("landingPageType");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(n.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "photoPlaySecond", aVar.f72569a);
            com.kwad.sdk.utils.q.a(jSONObject, "itemClickType", aVar.f72570b);
            com.kwad.sdk.utils.q.a(jSONObject, "itemCloseType", aVar.f72571c);
            com.kwad.sdk.utils.q.a(jSONObject, "elementType", aVar.f72572d);
            com.kwad.sdk.utils.q.a(jSONObject, "payload", aVar.f72574f);
            com.kwad.sdk.utils.q.a(jSONObject, "deeplinkType", aVar.f72575g);
            com.kwad.sdk.utils.q.a(jSONObject, "downloadSource", aVar.f72576h);
            com.kwad.sdk.utils.q.a(jSONObject, "isPackageChanged", aVar.f72577i);
            com.kwad.sdk.utils.q.a(jSONObject, "installedFrom", aVar.f72578j);
            com.kwad.sdk.utils.q.a(jSONObject, "downloadFailedReason", aVar.k);
            com.kwad.sdk.utils.q.a(jSONObject, "isChangedEndcard", aVar.l);
            com.kwad.sdk.utils.q.a(jSONObject, "adAggPageSource", aVar.m);
            com.kwad.sdk.utils.q.a(jSONObject, "serverPackageName", aVar.n);
            com.kwad.sdk.utils.q.a(jSONObject, "installedPackageName", aVar.o);
            com.kwad.sdk.utils.q.a(jSONObject, "closeButtonImpressionTime", aVar.p);
            com.kwad.sdk.utils.q.a(jSONObject, "closeButtonClickTime", aVar.q);
            com.kwad.sdk.utils.q.a(jSONObject, "landingPageLoadedDuration", aVar.r);
            com.kwad.sdk.utils.q.a(jSONObject, "downloadStatus", aVar.s);
            com.kwad.sdk.utils.q.a(jSONObject, "downloadCardType", aVar.t);
            com.kwad.sdk.utils.q.a(jSONObject, "landingPageType", aVar.u);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
