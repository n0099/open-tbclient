package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.n;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
        aVar.f65937a = jSONObject.optInt("photoPlaySecond");
        aVar.f65938b = jSONObject.optInt("itemClickType");
        aVar.f65939c = jSONObject.optInt("itemCloseType");
        aVar.f65940d = jSONObject.optInt("elementType");
        aVar.f65942f = jSONObject.optString("payload");
        aVar.f65943g = jSONObject.optInt("deeplinkType");
        aVar.f65944h = jSONObject.optInt("downloadSource");
        aVar.f65945i = jSONObject.optInt("isPackageChanged");
        aVar.j = jSONObject.optString("installedFrom");
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
            com.kwad.sdk.utils.q.a(jSONObject, "photoPlaySecond", aVar.f65937a);
            com.kwad.sdk.utils.q.a(jSONObject, "itemClickType", aVar.f65938b);
            com.kwad.sdk.utils.q.a(jSONObject, "itemCloseType", aVar.f65939c);
            com.kwad.sdk.utils.q.a(jSONObject, "elementType", aVar.f65940d);
            com.kwad.sdk.utils.q.a(jSONObject, "payload", aVar.f65942f);
            com.kwad.sdk.utils.q.a(jSONObject, "deeplinkType", aVar.f65943g);
            com.kwad.sdk.utils.q.a(jSONObject, "downloadSource", aVar.f65944h);
            com.kwad.sdk.utils.q.a(jSONObject, "isPackageChanged", aVar.f65945i);
            com.kwad.sdk.utils.q.a(jSONObject, "installedFrom", aVar.j);
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
